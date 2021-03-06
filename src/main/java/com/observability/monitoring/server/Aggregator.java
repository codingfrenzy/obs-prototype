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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Aggregator is a process to aggregate metric data. It has the following
 * functionalities: 
 * 1. Read aggregation configuration and parameters from Model
 * configuration file (for now, the file will have the same format as
 * collectd.conf) 
 * 2. Read data from Whisper DB through MetricDatabaseHandler 
 * 3. Aggregate metric data 
 * 4. Send data to Whisper DB through MetricDatabaseHandler
 * 
 * @author Laila Alhmoud
 * 
 * History: 
 *         1. Created June 8 2015
 *         2. Modified June 15 2015
 */

public class Aggregator extends UnicastRemoteObject {

	/**
	 * Auto generated serial version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	protected Aggregator() throws RemoteException {
		super();
	}

	static IMetricDatabaseHandlerServer imdhs = null;	
	//static PrintWriter out;
	/**
	 * Path and name of the configuration file
	 */
	static String configFilePath = "/opt/collectd/etc/collectd.conf";

	/**
	 * 
	 * This class has the temporary hard coded data
	 * TODO: should be deleted before deploying the system
	 *
	 */
	private static class HardCodedValues {
		private String[] nodeListTemp = new String[2]; // Note: this is a temporary (hard coded) solution for the previous method
		
		private String ip1 = "128_2_204_246"; // "msesrv6h-vm.mse.cs.cmu.edu"
		private String ip2 = "45_55_240_162"; // "observabilityCassandra1"
		
		private HardCodedValues(){
			super();
			this.nodeListTemp[0] = ip1;
			this.nodeListTemp[1] = ip2;
		}
		
		
		private String[] getNodeListTemp() {
			return nodeListTemp;
		}	
	}
	
	/**
	 * Enumeration of the possible aggregation functions
	 */
	public enum AggFunc {
		NUM, SUM, AVERAGE, MAX, MIN, STDDEV
	}

	/**
	 * readConfigurationFile() reads aggregation configurations by:</br>
	 * 1. Reading collectd.conf file, capture aggregation section, and saves 
	 * it into an object of AggConfigElements. The object has the following keys and
	 * values: </br>
	 * 		- Fault Tolerance Time Window: the time period in seconds that
	 * allows the nodes of the under monitoring system to send the metric data
	 * to Observability, so the aggregator can have as much data possible to
	 * perform the aggregation. If no value is provided or if it is not a valid
	 * number, use the default value. </br>
	 * 		- Aggregation interval: the time in seconds that Observability
	 * aggregates the data and writes them to DB. If no value is provided
	 * or if it is not a valid number, use the default value. </br>
	 * 		- Metric to aggregate: captured from "plugin" key element of
	 * collectd.conf file. </br> 
	 * 		- Type of metric to aggregate: captured from "typeInstance" 
	 * key element of collectd.conf file. </br> 
	 * 		- Aggregation function to apply: captured from the status of 
	 * the relative key elements of collectd.conf file </br>
	 * 2. Reading xyz configuration file (TBD in release 2)
	 * to capture the IPs of the nodes of th monitoring system.
	 * 
	 * @return
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public static ArrayList<AggConfigElements> readConfigurationFile(String fileName) throws IOException,
			NotBoundException {

		int faultTolTimeWindow = 60; // Fault Tolerance Time Window. Default
										// value is set to 60 seconds
										// TODO: It is hard coded now, but we
										// need to find a place for it in the
										// collectd.conf file
		int interval = 30; // Aggregation interval. Default value is set to 60
							// seconds

		String intervalStr = getIntervalConf(fileName); // Get interval value from
												// collectd.conf file

		// Interval validation
		if ((intervalStr != null) && Integer.parseInt(intervalStr) > 0) {
			interval = Integer.parseInt(intervalStr);
		}

		//List<String[]> aggConfigurationsList = getAggConf(fileName); // Get configuration section from collectd.conf
															 // TODO: better to merge getIntervalConf() & getAggConf()
		ArrayList<List<String[]>> aggConfigurationsListArray = getAggConf2(fileName);
		
		//Debug purposes: TODO remove later
		/*List<String[]> test1 = null;
		String[] test2 =null;
		for(int i=0; i<aggConfigurationsListArray.size();i++){
			System.out.println("Array size inside the loop: " +aggConfigurationsListArray.size());
			test1 = aggConfigurationsListArray.get(i);
			for(int j=0; j < test1.size();j++){
				
				test2 = test1.get(j);	
				System.out.println("Key: "+test2[0]);
				System.out.println("Value: "+test2[1]);
			}
			System.out.println("List size inside the loop: " +test1.size());
		}*/
		
		ArrayList<AggConfigElements> aggConfigurationElementsArray = new ArrayList<AggConfigElements>();
		AggConfigElements aggConfigurationElements = null;
		
		for(int i=0; i<aggConfigurationsListArray.size();i++){
			aggConfigurationElements = setConfigurations(
					faultTolTimeWindow, interval, aggConfigurationsListArray.get(i)); // Save configurations to an object
			aggConfigurationElementsArray.add(i, aggConfigurationElements);
		}
		return aggConfigurationElementsArray;
	}

	/**
	 * Read the configuration file and get the interval value
	 * 
	 * @return string of the interval value
	 * @throws IOException
	 */
	protected static String getIntervalConf(String fileName) throws IOException, FileNotFoundException {
		BufferedReader bufferReader = null;
		boolean intervalFound = false;
		
		try{
			bufferReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();	
		}
		if (bufferReader == null)
			return null;
		
		String line = "";
		String[] intervalConfigItem = new String[2];	// The array has 2 elements: key and value of the interval. 
														// TODO: no need for array, just jump to the value
		do {
			try {
				line = bufferReader.readLine();
				if(line == null)
					break;
				/*// Collectd.conf file has 2 intervals. Use the one specified for aggregation 
				if (line.equalsIgnoreCase("<LoadPlugin aggregation>")) {	
					do {
						line = bufferReader.readLine();
						if (line == null)
							break;
						line = line.trim();	//Trim any spaces at the beginning of the line
						if (line.isEmpty() || line.trim().equals("")
									|| line.trim().equals("\n"))
							continue;	// Read the next line
						else if (line.startsWith("Interval")) {
							String str[] = line.trim().split("\\s+");
							if (str.length > 1) {
								intervalConfigItem[0] = str[0];
								intervalConfigItem[1] = str[1];		
								}
							}
					} while (!line.equalsIgnoreCase("</LoadPlugin>") && (line != null));
				}*/
				
				line = line.trim();	//Trim any spaces at the beginning of the line
				if (line.isEmpty() || line.trim().equals("")
							|| line.trim().equals("\n"))
					continue;	// Read the next line
				else if (line.startsWith("Interval")) {
					String str[] = line.trim().split("\\s+");
					if (str.length > 1) {
						intervalConfigItem[0] = str[0];
						intervalConfigItem[1] = str[1];		
						}
					}
				intervalFound = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (line != null && !intervalFound);
		try {
			bufferReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(intervalConfigItem[1]);
		return intervalConfigItem[1];
	}

	/**
	 * Read the configuration file and get the aggregation configuration keys and values
	 * Save them in an array of size 2, then add them to a list that has all configurations.
	 * 
	 * @return list of array of string. The array has 2 elements: key and value. 
	 * 			The list has all keys and values
	 * @throws IOException
	 */
	/*protected static List<String[]> getAggConf(String fileName) throws IOException {
		List<String[]> aggConfig = new ArrayList<String[]>();
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), "UTF-8"));
		String line = "";
		do {
			try {
				line = bufferReader.readLine();
				if (line != null && line.trim().equals("<Aggregation>")) {	//go to aggregation configuration section
					do {
						line = bufferReader.readLine();
						if (line == null)
							break;
						line = line.trim();		//Trim any spaces at the beginning of the line
						if (line.isEmpty() || line.trim().equals("")
									|| line.trim().equals("\n"))
							continue;	// Read the next line
						else {
							String str[] = line.trim().split("\\s+");	//split both key and value to save them in an array 
							if (str.length > 1) {
								String[] aggConfigItem = new String[2];										
								aggConfigItem[0] = str[0];	// Here we save the key (ex. "plugin")
								aggConfigItem[1] = str[1];	// Here we save the value (ex. "cpu")
								aggConfig.add(aggConfigItem);	// Add this configuration element to the list 
							}
						}
						
					} while (!line.trim().equals("</Aggregation>") && (line != null));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (line != null);
		try {
			if(bufferReader!=null)		// Close the BufferedReader
				bufferReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return aggConfig;
	}
	
*/	protected static ArrayList<List<String[]>> getAggConf2(String fileName) throws IOException {
		
		ArrayList<List<String[]>> aggConfigArray = new ArrayList<List<String[]>>();
		
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), "UTF-8"));
		String line = "";
		do {
			try {
				List<String[]> aggConfig = new ArrayList<String[]>();
				line = bufferReader.readLine();
				//do {
					if (line != null && line.trim().equals("<Aggregation>")) {	//go to aggregation configuration section
						do {						

							line = bufferReader.readLine();
							if (line == null)
								break;
							line = line.trim();		//Trim any spaces at the beginning of the line
							if (line.isEmpty() || line.trim().equals("")
										|| line.trim().equals("\n"))
								continue;	// Read the next line
							else {
								String str[] = line.trim().split("\\s+");	//split both key and value to save them in an array
								if (str.length > 1) {
									String[] aggConfigItem = new String[2];										
									aggConfigItem[0] = str[0];
									aggConfigItem[1] = str[1];	
									aggConfig.add(aggConfigItem);	// Add this configuration element to the list
								}
							}
							
						} while (!line.trim().equals("</Aggregation>") && (line != null) );
						aggConfigArray.add(aggConfig);
						line = bufferReader.readLine();
					}
				//} while (line != null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (line != null);
		try {
			if(bufferReader!=null)		// Close the BufferedReader
				bufferReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		System.out.println("aggConfigArray size: "+ aggConfigArray.size());
		return aggConfigArray;
	}


	/**
	 * TODO: Get the monitored nodes host names (or IPs)
	 * 
	 * @return list of strings of nodes' names
	 */
	/*protected static List<String> getNodeList() {
		List<String> nodesList = new ArrayList<String>();
		return nodesList;
	}*/

	/**
	 * Set the configurations to AggConfigItems object
	 * 
	 * @param faultTolTimeWindow which is the fault tolerance time window of receiving metric data
	 * @param interval of the aggregation
	 * @param aggConfigurations
	 * @return an object of class AggConfigElements
	 */
	protected static AggConfigElements setConfigurations(int faultTolTimeWindow, int interval,
			List<String[]> aggConfigurations) {
		String[] str = null;
		String plugin = null;
		String typeInst = null; //TODO: if typeInst preceded with #, then calculate everything
		Boolean calSum = false;
		Boolean calAvg = false;
		Boolean calMin = false;
		Boolean calMax = false;
		Boolean calStd = false;

		for (int i = 0; i < aggConfigurations.size(); i++) {
			str = aggConfigurations.get(i);
			String itemName = str[0].toLowerCase().trim();	//Read the aggregation configuration key (plugin, typeInstance,etc..)
			// TODO: change indexOf to matches(str)
			if (itemName.matches("plugin")) {
				plugin = str[1].replaceAll("^\"|\"$", ""); // To remove double quotations
			} else if (itemName.indexOf("typeinstance") >= 0) {
				typeInst = str[1].replaceAll("^\"|\"$", "");
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
		}
		// Save the elements in the object
		AggConfigElements aggConfigElements = new AggConfigElements(
				faultTolTimeWindow, interval, plugin, typeInst, calSum,
				calAvg, calMin, calMax, calStd);

		return aggConfigElements;
	}

	/**
	 * Read the metric data from the DB using MetricDatabaseHandler.java
	 * 
	 * @param faultTolTimeWindow which is the fault tolerance time window of receiving metric data
	 * @param interval of the aggregation
	 * @param nodeListTemp which is the nodes of the monitored system 
	 * @param aggConfig which is the object of aggregation configuration elements
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public static boolean readData(long currentTimeStamp, String[] nodeListTemp, AggConfigElements aggConfig)
			throws MalformedURLException, RemoteException, NotBoundException {

		String str = "collectd/";
		String str2 = "/";
		String str3 = "-0";
		ArrayList<String> metricMeasurements = new ArrayList<String>();

		if ((nodeListTemp == null) || (aggConfig ==null)){
			return false;
		}
		
		long aggTimeStampStart = currentTimeStamp - aggConfig.getFaultTolTimeWindow() - aggConfig.getInterval(); // Set the start time
		long aggTimeStampEnd = currentTimeStamp - aggConfig.getFaultTolTimeWindow();	// Set the end time

		String aggTimeStampStartStr = Long.toString(aggTimeStampStart);
		String aggTimeStampEndStr = Long.toString(aggTimeStampEnd);

		String metricPath = "";	// Set the metric path according to Whisper 

		// Generate the metric path to send it as a parameter to the database handler. The metric path generated
		// has to match the folder path in Whisper that has the metric data collected from the nodes.
		// This is done by concatenate a list of strings to form the metric path expected by the database handler
		// For example: collectd/10.0.0.0/cpu-0/cpu-system
		// This part is required by the MetricDatabaseHandler
		for (int i = 0; i < nodeListTemp.length; i++) {
			if (aggConfig.getPlugin().toLowerCase().equals("cpu")) {
				metricPath = str.concat(nodeListTemp[i]).concat(str2)
						.concat(aggConfig.getPlugin()).concat(str3)
						.concat(str2).concat(aggConfig.getTypeInst());
			} else {
				metricPath = str.concat(nodeListTemp[i]).concat(str2)
						.concat(aggConfig.getPlugin()).concat(str2)
						.concat(aggConfig.getTypeInst());
			}

			ArrayList<String> metricsArrayTemp = null;
			metricsArrayTemp = imdhs.getMetricsBtwEpochRange(
					aggTimeStampStartStr, aggTimeStampEndStr, metricPath);
 
			if (metricsArrayTemp == null)
			{
				return false;
			}
				
			String metrics = metricsArrayTemp.get(0);

			String delimiter = "\t";
			String[] metricsArray = metrics.split(delimiter);

			////////////Debug: to be removed later/////////
			System.out.println("** Value from Node "+ i +": "+ metricsArray[1]);
			// ///////////////////

			metricMeasurements.add(metricsArray[1]);
			metricPath = "";
		}		
		////////////Debug: to be removed later/////////
		System.out.println("*******************************");
		// ///////////////////
		boolean dataIsAggregated = aggregate(metricMeasurements, aggTimeStampStartStr,
				aggConfig.isCalSum(), aggConfig.isCalAvg(),
				aggConfig.isCalMin(), aggConfig.isCalMax(),
				aggConfig.isCalStd(), aggConfig.getPlugin(),
				aggConfig.getTypeInst());
		return dataIsAggregated;
	}


	/**
	 * Aggregate the metric data.
	 * 
	 * @param metricMeasurements
	 * @param aggTimeStampStartStr
	 * @param isCalNum
	 * @param isCalAvg
	 * @param isCalMin
	 * @param isCalMax
	 * @param isCalStd
	 * @param metric
	 * @param metricType
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * 
	 */
	public static boolean aggregate(ArrayList<String> metricMeasurements,
			String aggTimeStampStartStr, boolean isCalSum,
			boolean isCalAvg, boolean isCalMin, boolean isCalMax,
			boolean isCalStd, String metric, String metricType)
			throws MalformedURLException, RemoteException, NotBoundException {
		AggFunc func;
		double measurementSum = 0;
		double measurementAvg = 0;
		double measurementMin = 0;
		double measurementMax = 0;
		double sumOfSquared = 0;
		double measurementVariance = 0;
		double measurementStd = 0;
		ArrayList<Double> metricMeasurementsDouble = null;
		int counter = 0;
		boolean sumDataIsSaved = false;
		boolean avgDataIsSaved = false;
		boolean minDataIsSaved = false;
		boolean maxDataIsSaved = false;
		boolean stdDataIsSaved = false;

		if ((metricMeasurements == null) || (aggTimeStampStartStr == null) || (metric == null) || (metricType == null)){
			return false;
		}
			
		if (isCalSum == true) {
			for (int i = 0; i < metricMeasurements.size(); i++) {
				String str = metricMeasurements.get(i);
				if (!str.equals("None")){
					measurementSum += Double.parseDouble(metricMeasurements
							.get(i));
				}
				else{
					measurementSum += 0;
				}
			}
			func = AggFunc.SUM;
			System.out.println("Sum: " + measurementSum); // Debug
			sumDataIsSaved = saveData(aggTimeStampStartStr, String.valueOf(measurementSum), func,
					metric, metricType);
			measurementSum = 0;
		}

		if (isCalAvg == true) {
			counter = 0;
			measurementSum = 0;
			if (metricMeasurements.size() > 1) { // avoid dividing by zero
				for (int i = 0; i < metricMeasurements.size(); i++) {
					String str = metricMeasurements.get(i);
					if (!str.equals("None")){
						measurementSum += Double.parseDouble(metricMeasurements.get(i));
						counter +=1;
					}
					else {
						measurementSum += 0;
					}
				}
				if (counter != 0){
					measurementAvg = measurementSum / counter;
				}
			}

			func = AggFunc.AVERAGE;
			System.out.println("Avg: " + Math.abs(measurementAvg)); // Debug
			avgDataIsSaved = saveData(aggTimeStampStartStr, String.valueOf(Math.abs(measurementAvg)), func,
					metric, metricType);
			measurementAvg = 0;
		}

		if (isCalMin == true) {
			metricMeasurementsDouble = new ArrayList<Double>();
			for (int i = 0; i < metricMeasurements.size(); i++) {
				String str = metricMeasurements.get(i);
				if (!str.equals("None")){
					metricMeasurementsDouble.add(i,
							Double.parseDouble(metricMeasurements.get(i)));
				}
				else {
					metricMeasurementsDouble.add(i,0.0);
				}
			}
			measurementMin = Collections.min(metricMeasurementsDouble);
			func = AggFunc.MIN;
			System.out.println("Min: " + measurementMin); // Debug
			minDataIsSaved = saveData(aggTimeStampStartStr, String.valueOf(measurementMin), func,
					metric, metricType);
			measurementMin = 0;
		}

		if (isCalMax == true) {
			metricMeasurementsDouble = new ArrayList<Double>();
			for (int i = 0; i < metricMeasurements.size(); i++) {
				String str = metricMeasurements.get(i);
				if (!str.equals("None")){
					metricMeasurementsDouble.add(i,
							Double.parseDouble(metricMeasurements.get(i)));
				}
				else {
					metricMeasurementsDouble.add(i,0.0);

				}
			}
			measurementMax = Collections.max(metricMeasurementsDouble);
			func = AggFunc.MAX;
			System.out.println("Max: " + measurementMax); // Debug
			maxDataIsSaved = saveData(aggTimeStampStartStr, String.valueOf(measurementMax), func,
					metric, metricType);
			measurementMax = 0;
		}

		if (isCalStd == true) {
			counter = 0;
			measurementSum = 0;
			measurementAvg = 0;
			measurementStd = 0;
			sumOfSquared = 0;
			measurementVariance = 0;
			for (int i = 0; i < metricMeasurements.size(); i++) {
				String str = metricMeasurements.get(i);
				if (!str.equals("None")){
					measurementSum += Double.parseDouble(metricMeasurements.get(i));
					counter +=1;
				}
				else {
					measurementSum += 0;
				}
			}
			if (counter != 0){
				measurementAvg = measurementSum / counter;
			}
			
			for (int i = 0; i < metricMeasurements.size(); i++) {
				String str = metricMeasurements.get(i);
				if (!str.equals("None")){
					sumOfSquared += Math.pow((Double.parseDouble(metricMeasurements.get(i)) - Math.abs(measurementAvg)), 2);
				}
				else {
					sumOfSquared +=0;
				}
			}
			measurementVariance = sumOfSquared / (metricMeasurements.size() - 1);
			measurementStd = Math.sqrt(measurementVariance);
			func = AggFunc.STDDEV;
			System.out.println("Standard Dev: " + measurementStd); // Debug
			stdDataIsSaved = saveData(aggTimeStampStartStr, String.valueOf(measurementStd), func,
					metric, metricType);
		}
		if (sumDataIsSaved || avgDataIsSaved || minDataIsSaved || maxDataIsSaved || stdDataIsSaved){
			return true;
		}
		else{
			return false;
		}
		
	}

	/**
	 * Save the aggregated metrics to the DB using MetricDatabaseHandler.java
	 * 
	 * @param timeStampEndStr
	 * @param aggregatedMeasurement
	 * @param func
	 * @param metric
	 * @param metricType
	 * @return 
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public static boolean saveData(String timeStampStartStr,
			String aggregatedMeasurement, AggFunc func, String metric,
			String metricType) throws MalformedURLException, RemoteException,
			NotBoundException {

		boolean isSaved = false;
		
		if ((timeStampStartStr == null) || (timeStampStartStr.equals("0")) || (aggregatedMeasurement == null) 
				|| (func == null) || (metric == null) || (metricType == null)){
			System.out.println("Can't save data. Data is not valid or missing");
			return false;
		}
		else{
			String[] timeStampStartStrArray = new String[1];
			timeStampStartStrArray[0] = timeStampStartStr;

			String[] aggregatedMeasurementArray = new String[1];
			aggregatedMeasurementArray[0] = aggregatedMeasurement;
			
			// "collectd/global/aggregation-cpu-sum/cpu-idle.wsp
			String str = "collectd/global/aggregation";
			String str2 = "/";
			String str3 = "-"; //test
			String metricPath = str.concat(str3).concat(metric).concat(str3)
					.concat(String.valueOf(func).toLowerCase()).concat(str2)
					.concat(metricType);

			if (imdhs == null){
				return false;
			}
			
			isSaved = imdhs.updateMetrics(timeStampStartStrArray,
					aggregatedMeasurementArray, metricPath);
			// TODO add to log file
			System.out.println("Time Stamp: " + timeStampStartStrArray[0]); // Debug: remove later
			System.out.println("Metric path: " + metricPath); // Debug: remove later
			System.out.println("Aggregation completed? " + isSaved); // Debug: remove later
			System.out.println("***********************************"); // Debug:remove later
			
			//out.println("Metric Path: "+ metricPath);
			//out.println(timeStampStartStrArray[0]+ " " + aggregatedMeasurementArray[0]);
			//out.println();
			return isSaved;
		}
		
	}

	/**
	 * Main function
	 * 
	 * @param args
	 *            arguments - arg1: binding IP, arg2: binding port
	 * @throws NotBoundException
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, NotBoundException, InterruptedException {
		String configFilePath = "Test.txt"; //debug: to be deleted
		HardCodedValues hardCodedValues = new HardCodedValues();
		long startTime = 0;
		long endTime = 0;
		long totalTime = 0;
		File file = null;
		boolean dataIsRead = false;
		long currentTimeStamp = 0;
		
		try {
			file = new File(configFilePath);	

		}catch (Exception e) {
			e.printStackTrace();
		}
		if (file != null && !file.exists()){
			System.err.println("Collectd.conf wasn't found. Please place it in the correct directory.");
			Thread.sleep(30000);
		}
		else {
			Long lastModified = file.lastModified() / 1000;	
	
			System.out.println("------Start Aggregating -------");
			System.out.println("*******************************");
			ArrayList<AggConfigElements> aggConfigurationElementsArray = readConfigurationFile(configFilePath);
			// List<String> nodeList = getNodeList(); // Get Nodes list // TODO: after modeling team finalizes the configuration file	
			
			try {
				imdhs = (IMetricDatabaseHandlerServer) Naming
						.lookup("rmi://" + "45.55.197.112" + ":" + "8100"
								+ "/MetricDatabaseHandler");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (imdhs == null){
				System.out.println("MetricDatabaseHAndler is not working. Please start it");
			}
			
			while (true) {
				currentTimeStamp = System.currentTimeMillis() / 1000L;	//The current time stamp of the server
				startTime = System.currentTimeMillis(); //This to calculate the running time of readData()
				for (int i=0; i<aggConfigurationElementsArray.size(); i++){
					System.out.println("Plugin: " + aggConfigurationElementsArray.get(i).getPlugin());
					System.out.println("Metric: " + aggConfigurationElementsArray.get(i).getTypeInst());
					System.out.println("*******************************");
					dataIsRead = readData(currentTimeStamp, hardCodedValues.getNodeListTemp(), aggConfigurationElementsArray.get(i));	// Read, aggregate and save aggregated data
				}
				endTime = System.currentTimeMillis();	//This to calculate the running time of readData()
				totalTime = endTime - startTime;	//This to calculate the running time of readData()
				
				try {
				    Thread.sleep((aggConfigurationElementsArray.get(0).getInterval() * 1000) - totalTime);	//Sleep for a duration of aggregation interval minus the running time of readData(),
				    																	//before trying to read more data. 1 second = 1000 milliseconds
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				
				if (!dataIsRead){
					try {
					    Thread.sleep(aggConfigurationElementsArray.get(0).getInterval() - 5);	// Sleep before trying to read more data
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				
				if (!(lastModified.equals(file.lastModified() / 1000))){	// Check if the configuration file was modified 
					lastModified = file.lastModified() / 1000;
					aggConfigurationElementsArray = readConfigurationFile(configFilePath);		// Re-read the configurations
				}
			}
		}
	}
}