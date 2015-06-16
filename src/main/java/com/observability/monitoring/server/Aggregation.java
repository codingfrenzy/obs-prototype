//**************************************************************************************************//
/* Observability Project
 * Copyright 2015 Master of Software Engineering team: Laila Alhmound, Ying (Joel) Gao, Caglayan Gem, Rajat Kapoor, Prasanth Nair, Varun Saravagi
 * Copyright 2015 Institute for Software Research | School of Computer Science | Carnegie Mellon University
 * Copyright 2015 Software Engineering Institute
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses/>.
 */
//**************************************************************************************************//

package com.observability.monitoring.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.observability.monitoring.server.IMetricDatabaseHandlerServer;
import com.observability.monitoring.server.MetricDatabaseHandler;


/**
 * Aggregation is a process to aggregate metric data. It has the following functionalities:
 * 1. Read aggregation configuration and parameters from Model configuration file (for now, 
 * the file will have the same format as collectd.conf)
 * 2. Read data from Whisper DB through DB handler 
 * 3. Aggregate metric data
 * 4. Send data to Whisper DB through DB handler
 * 
 * @author Laila Alhmoud,
 * 
 * History: 
 * 1. Created					June 8 2015
 */

public class Aggregation extends UnicastRemoteObject {
	
	/**
	 * Auto generated serial version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	protected Aggregation() throws RemoteException {
		super();
	}
	
	/**
	 * Path to and name of the configuration file 
	 */
	static String configFilePath = "/opt/collectd/etc/";
	static String configFileName = "collectd.conf";
	
	/**
	 * Enumeration of the possible aggregation functions
	 */
	public enum AggFunc {
	    NUM, SUM, AVG, MAX, MIN, STD
	}
	
	/**
	 * Read aggregation configuration file and capture aggregation section that has the following keys and values:
	 *  - Aggregation interval: the time in seconds that Observability aggregates the data and writes them to DB
	 * Metric to aggregate
	 * Math to apply
	 * What interval (sample frequency)
	 * What is the fault tolerance time window
	 * What nodes
	 * 
	 * @return
	 * @throws IOException 
	 * @throws NotBoundException 
	 */
	public static void readConfigurationFile() throws IOException, NotBoundException{
		// Fault Tolerance Time Window
		// TODO: It is hard coded now, but we need to find a place for it
		int faultTolTimeWindow = 60;
		
		// Get interval value
		// TODO: is it better to combine both interval and configurations in 1 method? 
		//       I separated them since I might have multiple aggregations, however, 
		//       I can only have one interval 
		String intervalStr = getIntervalConf();
		int interval = Integer.parseInt(intervalStr);
		
		// Get configurations
		List<String[]> aggConfigurationsList = getAggConf();
		
		// Get Nodes list
		// TODO: after modeling team finalize the configuration file
		// Commented to suppress findbugs error
		//List<String> nodeList = getNodeList();
		
		// Save configurations in AggConfiguration object
		AggConfigItems aggConfigurations = setConfigurations(interval, aggConfigurationsList);
				
		///////////////// Debug Starts ///////////////////
		
		//Reading the size of the list
		System.out.println("list size: " + aggConfigurationsList.size());
		
		//Getting the first item of the list, it should be [#Host, "localhost"]
		String[] s = aggConfigurationsList.get(0);
    	System.out.println("Plugin: " + aggConfigurations.getPlugin()); //This should return "cpu", but it returns
    																	//null since it didn't assign any value in plugin

		/////////////////////Debug Ends//////////////////////

		
		// TODO: this is a temporary (hard coded) solution for the previous method
		String[] nodeListTemp = new String[2];
		//nodeListTemp[0] = "msesrv6h-vm.mse.cs.cmu.edu";
		//nodeListTemp[1] = "observabilityCassandra1";
		
		nodeListTemp[0] = "128_2_204_246";
		nodeListTemp[1] = "45_55_240_162";
		
		readData(faultTolTimeWindow,interval, nodeListTemp,aggConfigurations);
	}

	
	/**
	 * Read the configuration file and get the interval value
	 * @return string of the interval value
	 * @throws IOException
	 */
	protected static String getIntervalConf() throws IOException{
			
		//BufferedReader bufferReader = new BufferedReader(new FileReader("Test.txt"));
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream("Test.txt"), "UTF-8"));
		String line = "";
		String[] intervalConfigItem = new String[2]; 
		do {
			try {
				line = bufferReader.readLine();
				if(line != null && line.equalsIgnoreCase("<LoadPlugin aggregation>")) {
					do {
						line = bufferReader.readLine();
						if (line == null)
							break;
						line = line.trim();
						if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n"))
							continue;
						else if (line.startsWith("Interval")) {
							String str[] = line.trim().split("\\s+");//[Interval, 30]
								if(str.length > 1) {
									intervalConfigItem [0]= str[0]; 
									intervalConfigItem [1]= str[1];
									System.out.println(intervalConfigItem [0]+","+ intervalConfigItem[1]);
								}
							}
					} while(!line.equalsIgnoreCase("</LoadPlugin>"));
				}
			}catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (line != null);
		
		bufferReader.close();
		return intervalConfigItem[1];
	}

	
	/**
	 * Read the configuration file and get the aggregation configurations, including the metric, 
	 * metric type, and aggregation functions
	 * @return list of array of string that has all aggregation configurations in a 2 dimensional 
	 *         array of strings
	 * @throws IOException
	 */
	protected static List<String[]> getAggConf() throws IOException {
		List<String[]> aggConfig = new ArrayList<String[]>();
		//BufferedReader bufferReader = new BufferedReader(new FileReader("Test.txt"));
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream("Test.txt"), "UTF-8"));
		String line = "";	
		do {
			try {
				line = bufferReader.readLine();
				if(line != null && line.equals("<Aggregation>")){
					do {
						line = bufferReader.readLine();
						if (line == null)
							break;
						line = line.trim();
						if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n"))
							continue;
						else {		
							String str[] = line.trim().split("\\s+");
							if(str.length > 1){
								String[] aggConfigItem = new String[2]; 
								aggConfigItem [0]= str[0]; 
								aggConfigItem [1]= str[1];
								aggConfig.add(aggConfigItem);
								System.out.println(aggConfigItem [0]+","+ aggConfigItem[1]);
								}
							}
						} while(!line.equals("</Aggregation>")) ;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (line != null);
		bufferReader.close();
		
		//////////// Debug Starts ///////////////
		String str [] =null;
		for (int j =0; j < aggConfig.size(); j++){
			str = aggConfig.get(j);
			
			System.out.println("Test Value " + j +": "+ str[1]);
		}
	////////////// Debug Ends //////////////////
		return aggConfig;			
	}
		
		
	/**
	 * retrieve the monitored nodes host names (or IPs)
	 * @return list of strings of nodes' names
	 */
	protected static List<String> getNodeList(){
		
		List<String> nodesList = new ArrayList<String>();
		return nodesList;

	}
			
	
	/**
	 * Save the configurations in AggConfigItems object
	 * @param interval
	 * @param aggConfigurations
	 * @return
	 */
	protected static AggConfigItems setConfigurations(int interval, List<String[]> aggConfigurations){
		String [] str = null;//new String[2]; 
		String plugin = null;
		String typeInst = null; /////TODO: if typeInst preceded with #, then calculate everything
		Boolean calNum = false;
		Boolean calSum = false;
		Boolean calAvg = false;
		Boolean calMin = false;
		Boolean calMax = false;
		Boolean calStd = false;
		
		for (int i =0; i < aggConfigurations.size(); i++){
			str = aggConfigurations.get(i);
			String itemName = str[0].toLowerCase(); 
			//TODO: change index of to matches(str)
			if (itemName.indexOf("plugin") >= 0) {
				if (itemName.matches("plugin"))
					plugin = str[1].replaceAll("^\"|\"$", "");
			} else if (itemName.indexOf("typeinstance") >= 0) {
				typeInst = str[1].replaceAll("^\"|\"$", "");
			} else if (itemName.indexOf("calculatenum") >= 0) {
	        	calNum = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
			} else if (itemName.indexOf("calculatesum") >= 0) {
				calSum = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
			} else if (itemName.indexOf("calculateaverage") >= 0) {
				calAvg = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
			} else if (itemName.indexOf("calculateminimum") >= 0) {
				calMin = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
			} else if (itemName.indexOf("calculatemaximum") >= 0) {
				calMax = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
			} else if (itemName.indexOf("calculatestddev") >= 0) {
				calStd = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
			}
			/*
			switch (str[0].toLowerCase()) {
            	case "plugin": 
            		plugin = str[1].replaceAll("^\"|\"$", "");
                    break; 
            	case "typeinstance": 
            		typeInst = str[1].replaceAll("^\"|\"$", "");
                    break; 
            	case "calculatenum": 
            		calNum = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
            		break; 
            	case "calculatesum": 
            		calSum = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
            		break; 
            	case "calculateaverage": 
            		calAvg = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
            		break; 
            	case "calculateminimum": 
            		calMin = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
            		break;
            	case "calculatemaximum": 
            		calMax = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
            		break;
            	case "calculatestddev": 
            		calStd = Boolean.valueOf(str[1].replaceAll("^\"|\"$", ""));
            		break;
            	default:
            		break;
			}
			*/
		}
		AggConfigItems aggConfigItems = new AggConfigItems (interval, plugin, typeInst, calNum, calSum, calAvg, 
				calMin, calMax, calStd);
		
		return aggConfigItems;
	}
	
	/**
	 * Send the:
	 * 1. Fault tolerance time window
	 * 2. Aggregation parameters 
	 * getMetricsBtwEpochRange("1433641326.507", "1433641416.508", "collectd/observabilityCassandra1/memory/memory-used"
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void readData(int faultTolTimeWindow, int interval, 
		// List<String[]> nodesList
		String[] nodeListTemp, AggConfigItems aggConfig) throws MalformedURLException, RemoteException, NotBoundException{

		String str = "collectd/";
		String str2 = "/";
		String str3 = "-0";
		ArrayList<String> metricMeasurements = new ArrayList<String>();
		
        long currentTimeStamp = System.currentTimeMillis() / 1000L;
        long aggTimeStampStart = currentTimeStamp - faultTolTimeWindow - interval;
        long aggTimeStampEnd = currentTimeStamp - faultTolTimeWindow;
		
        String timeStampStartStr = Long.toString(aggTimeStampStart);
        String timeStampEndStr = Long.toString(aggTimeStampEnd);
        
       // List<String[]> nodesListWrapped = WrapDaemonsWithMetricFilesPath (nodeListTemp, aggConfig);
       // List<String[]> allMeasurements = new ArrayList<String[]>();
        String nodeWarpped= "";
        IMetricDatabaseHandlerServer imdhs = (IMetricDatabaseHandlerServer)Naming.lookup("rmi://"+"45.55.197.112"+":"+"8100"+"/MetricDatabaseHandler");
        for (int i=0; i < nodeListTemp.length;i++) {
        	//String nodeWarpped= wrapDaemonsWithMetricFilesPath (nodeListTemp[i], aggConfig.getPlugin(), aggConfig.getTypeInst());
        	String s = aggConfig.getPlugin();
        	if (aggConfig.getPlugin() == s){
            	nodeWarpped= str.concat(nodeListTemp[i]).concat(str2).concat(aggConfig.getPlugin()).concat(str3).concat(str2).concat(aggConfig.getTypeInst());
        	}
        	else {
            	nodeWarpped= str.concat(nodeListTemp[i]).concat(str2).concat(aggConfig.getPlugin()).concat(str2).concat(aggConfig.getTypeInst());
        	}
        		
        	ArrayList<String> metrics = imdhs.getMetricsBtwEpochRange(timeStampStartStr,timeStampEndStr, nodeWarpped);
        	
        	////////////Debug/////////
        	System.out.println("-------------Debug: Metric-----------------");
        	System.out.println(metrics);
        	metricMeasurements.addAll(metrics);
        	nodeWarpped ="";
        }
        ////////////Debug/////////
        System.out.println("\n-------------Debug: Measurements-----------------");
    	System.out.println(metricMeasurements);

        aggregate(metricMeasurements,timeStampEndStr, aggConfig.isCalNum(),aggConfig.isCalSum(),
        		aggConfig.isCalAvg(), aggConfig.isCalMin(), aggConfig.isCalMax(), aggConfig.isCalStd(), aggConfig.getPlugin(), aggConfig.getTypeInst());
	}
	
	
	/**
	 * Wrap the node host name with the path  "collectd/observabilityCassandra1/memory/memory-used"
	 * @return
	 */
	public String wrapDaemonsWithMetricFilesPath(
		//List<String> 
		String nodeName, String metric, String metricType){
		String str = "collectd/";
		String str2 = "/";
		return (str.concat(nodeName).concat(str2).concat(metric).concat(str2).concat(metricType));
	}
	
	/**
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 * 
	 */
	public static void aggregate(ArrayList<String> metricMeasurements, String timeStampEndStr, boolean isCalNum,
			boolean isCalSum, boolean isCalAvg, boolean isCalMin, boolean isCalMax, boolean isCalStd, String metric, String metricType) throws MalformedURLException, RemoteException, NotBoundException{ 
		long measurementSum = 0;
		AggFunc func;
		int counter = 0;
		long measurementAvg = 0;
		long num = 0;
		long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        long measurementMin = 0;
        long measurementMax = 0;
        double sd = 0;
        double measurementStd = 0;
        
		if (isCalNum == true){
			for (int i=0; i < metricMeasurements.size(); i++){
				
			}
		}
		
		if (isCalSum == true){
			for (int i=0; i < metricMeasurements.size(); i++){
				measurementSum+=Long.parseLong(metricMeasurements.get(i));
			}
			func = AggFunc.SUM;
			saveData(timeStampEndStr, String.valueOf(measurementSum), func, metric, metricType);
		}
 
		if (isCalAvg == true){
			//if (metricMeasurements.size() < 1) 					//avoid dividing by zero
					
			for (int i=0; i < metricMeasurements.size(); i++){
				measurementSum+=Long.parseLong(metricMeasurements.get(i));
				counter+=1;
			}
			measurementAvg = measurementSum / counter; 
			func = AggFunc.AVG;
			saveData(timeStampEndStr, String.valueOf(measurementAvg), func,  metric, metricType);
		}
		
		if (isCalMin == true){
			for (int i=0; i < metricMeasurements.size(); i++){
				num = Long.parseLong(metricMeasurements.get(i));
				measurementMax = min > num ? min : num;
			}
			func = AggFunc.MIN;
			saveData(timeStampEndStr, String.valueOf(measurementMin), func,  metric, metricType);
		}
		
		if (isCalMax == true){
			for (int i=0; i < metricMeasurements.size(); i++){
				num = Long.parseLong(metricMeasurements.get(i));
				measurementMax = max > num ? max : num;
			}
			func = AggFunc.MAX;
			saveData(timeStampEndStr, String.valueOf(measurementMax), func,  metric, metricType);
		}
		
		if (isCalStd == true){
			for (int i=0; i < metricMeasurements.size(); i++){
				measurementSum+=Long.parseLong(metricMeasurements.get(i));
				counter+=1;
			}
			measurementAvg = measurementSum / counter; 
			
			for (int i=0; i < metricMeasurements.size(); i++){	
				
				sd += (double) Math.pow((((double)Long.parseLong(metricMeasurements.get(i)) - measurementAvg) / metricMeasurements.size()), 2);
			}
			measurementStd = Math.sqrt(sd);
			func = AggFunc.STD;
			saveData(timeStampEndStr, String.valueOf(measurementStd), func,  metric, metricType);
		}
	}
	
	/**
	 * updateMetrics(String[] epoch, String[] values, String metricPath)
	 * @return
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void saveData( String timeStampEndStr, String aggregatedMeasurement, AggFunc func, String metric, String metricType) throws MalformedURLException, RemoteException, NotBoundException{
		
		String [] timeStampEndStrArray = null;
		timeStampEndStrArray[0] = timeStampEndStr;
		
		String [] aggregatedMeasurementArray = null;
		aggregatedMeasurementArray[0] = aggregatedMeasurement;
		
		//"collectd/global/aggregation-cpu-sum/cpu-idle.wsp
		String str = "collectd/global/aggregation";
		String str2 = "/";
		String str3 = "-";
    	String metricPath= str.concat(str3).concat(metric).concat(String.valueOf(func)).concat(str3).concat(metricType);
    	System.out.println("Metric Path: "+ metricPath);
    	
    	IMetricDatabaseHandlerServer imdhs = (IMetricDatabaseHandlerServer)Naming.lookup("rmi://"+"45.55.197.112"+":"+"8100"+"/MetricDatabaseHandler");
    	boolean isSaved = imdhs.updateMetrics(timeStampEndStrArray, aggregatedMeasurementArray, metricPath);
		
	}
	
	/**
	 * Main function
	 * @param args arguments - arg1: binding IP, arg2: binding port
	 * @throws NotBoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, NotBoundException {
		readConfigurationFile();
		/*
		// Get IP & port from arguments
		if(args.length  != 2){
			System.out.println("Aggregation - error - should be started with two parameters: IP + port.");
			return;
		}

		String rmiIP = args[0];
		String rmiPort = args[1];

		try {
			int port = Integer.parseInt(rmiPort);
			//create the RMI registry if it doesn't exist.
			LocateRegistry.createRegistry(port);
		}
		catch(RemoteException e) {
			System.out.println("Aggregation - error - Failed to create the RMI registry " + e);
		}

		Aggregation server = null;
		try{
			server = new Aggregation(); 
		}
		catch(RemoteException e) {
			System.out.println("Aggregation - error - Failed to create server " + e);
			System.exit(1);
		}
		try {
			Naming.rebind(String.format("//%s:%s/Aggregation", rmiIP, rmiPort), server);
			System.out.println("Aggregation started");
		} catch (RemoteException e) {
			System.out.println(e);
		} catch (MalformedURLException e) {
			System.out.println(e);
		}	
		*/		
	}
}
