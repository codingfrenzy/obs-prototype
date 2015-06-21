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

import com.observability.monitoring.server.IMetricDatabaseHandlerServer;

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

	/**
	 * Path and name of the configuration file
	 */
	//static String configFilePath = "/opt/collectd/etc/collectd.conf";
	static String configFilePath = "Test.txt";

	/**
	 * Enumeration of the possible aggregation functions
	 */
	public enum AggFunc {
		NUM, SUM, AVG, MAX, MIN, STD
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
	public static AggConfigElements readConfigurationFile() throws IOException,
			NotBoundException {

		int faultTolTimeWindow = 60; // Fault Tolerance Time Window. Default
										// value is set to 60 seconds
										// TODO: It is hard coded now, but we
										// need to find a place for it in the
										// collectd.conf file
		int interval = 60; // Aggregation interval. Default value is set to 60
							// seconds

		String intervalStr = getIntervalConf(); // Get interval value from
												// collectd.conf file

		// Interval validation
		if (!intervalStr.equals(null) || Integer.parseInt(intervalStr) > 0) {
			interval = Integer.parseInt(intervalStr);
		}

		List<String[]> aggConfigurationsList = getAggConf(); // Get configuration section from collectd.conf
															 // TODO: better to merge getIntervalConf() & getAggConf()

		AggConfigElements aggConfigurationElements = setConfigurations(
				faultTolTimeWindow, interval, aggConfigurationsList); // Save configurations in an object

		return aggConfigurationElements;
	}

	/**
	 * Read the configuration file and get the interval value
	 * 
	 * @return string of the interval value
	 * @throws IOException
	 */
	protected static String getIntervalConf() throws IOException {
		// 1. Read the configuration file
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(
				new FileInputStream("Test.txt"), "UTF-8"));	//TODO: change the hard coded file name of the collectd.conf name and path
		String line = "";
		String[] intervalConfigItem = new String[2];	// The array has 2 elements: key and value of the interval. 
														// TODO: no need for array, just jump to the value
		do {
			try {
				line = bufferReader.readLine();
				// Collectd.conf file has 2 intervals. Use the one specified for aggregation 
				if (line != null && line.equalsIgnoreCase("<LoadPlugin aggregation>")) {	
					do {
						line = bufferReader.readLine();
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
					} while (!line.equalsIgnoreCase("</LoadPlugin>"));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (line != null);

		bufferReader.close();
		return intervalConfigItem[1];
	}

	/**
	 * Read the configuration file and get the aggregation configuration keys and values
	 * 
	 * @return list of array of string. The array has 2 elements: key and value. 
	 * 			The list has all keys and values
	 * @throws IOException
	 */
	protected static List<String[]> getAggConf() throws IOException {
		List<String[]> aggConfig = new ArrayList<String[]>();

		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(
				new FileInputStream("Test.txt"), "UTF-8"));
		String line = "";
		do {
			try {
				line = bufferReader.readLine();
				if (line != null && line.equals("<Aggregation>")) {	//go to aggregation configuration section
					do {
						line = bufferReader.readLine();
						//if (line == null)
							//break;
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
					} while (!line.equals("</Aggregation>"));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (line != null);
		bufferReader.close();
		return aggConfig;
	}

	/**
	 * TODO: Get the monitored nodes host names (or IPs)
	 * 
	 * @return list of strings of nodes' names
	 */
	protected static List<String> getNodeList() {
		List<String> nodesList = new ArrayList<String>();
		return nodesList;
	}

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
		Boolean calNum = false;
		Boolean calSum = false;
		Boolean calAvg = false;
		Boolean calMin = false;
		Boolean calMax = false;
		Boolean calStd = false;

		for (int i = 0; i < aggConfigurations.size(); i++) {
			str = aggConfigurations.get(i);
			String itemName = str[0].toLowerCase();	//Read the aggregation configuration key (plugin, typeInstance,etc..)
			// TODO: change indexOf to matches(str)
			if (itemName.matches("plugin")) {
				plugin = str[1].replaceAll("^\"|\"$", ""); //remove double quotations
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
		}
		// Save the elements in the object
		AggConfigElements aggConfigElements = new AggConfigElements(
				faultTolTimeWindow, interval, plugin, typeInst, calNum, calSum,
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
	public static void readData(String[] nodeListTemp, AggConfigElements aggConfig)
			throws MalformedURLException, RemoteException, NotBoundException {

		String str = "collectd/";
		String str2 = "/";
		String str3 = "-0";
		ArrayList<String> metricMeasurements = new ArrayList<String>();

		long currentTimeStamp = System.currentTimeMillis() / 1000L;	//The current time stamp of the server
		long aggTimeStampStart = currentTimeStamp - aggConfig.getFaultTolTimeWindow() - aggConfig.getInterval(); // Set the start time
		long aggTimeStampEnd = currentTimeStamp - aggConfig.getFaultTolTimeWindow();	// Set the end time

		String aggTimeStampStartStr = Long.toString(aggTimeStampStart);
		String aggTimeStampEndStr = Long.toString(aggTimeStampEnd);

		String metricPath = "";	// Set the metric path according to Whisper 
		IMetricDatabaseHandlerServer imdhs = null;
		
		try {
			imdhs = (IMetricDatabaseHandlerServer) Naming
					.lookup("rmi://" + "45.55.197.112" + ":" + "8100"
							+ "/MetricDatabaseHandler");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		for (int i = 0; i < nodeListTemp.length; i++) {
			String s = aggConfig.getPlugin();
			if (aggConfig.getPlugin() == s) {
				metricPath = str.concat(nodeListTemp[i]).concat(str2)
						.concat(aggConfig.getPlugin()).concat(str3)
						.concat(str2).concat(aggConfig.getTypeInst());
			} else {
				metricPath = str.concat(nodeListTemp[i]).concat(str2)
						.concat(aggConfig.getPlugin()).concat(str2)
						.concat(aggConfig.getTypeInst());
			}

			ArrayList<String> metricsArrayTemp = imdhs.getMetricsBtwEpochRange(
					aggTimeStampStartStr, aggTimeStampEndStr, metricPath);

			String metrics = metricsArrayTemp.get(0);

			String delimiter = "\t";
			String[] metricsArray = metrics.split(delimiter);

			////////////Debug: to be removed later/////////
			System.out.println("-------------Debug: Metric-----------------");
			System.out.println(metricsArray[1]);
			// ///////////////////

			metricMeasurements.add(metricsArray[1]);
			metricPath = "";
		}
		////////////Debug: to be removed later/////////
		System.out.println("\n-------------Debug: Measurements-----------------");
		System.out.println(metricMeasurements);

		aggregate(metricMeasurements, aggTimeStampStartStr,
				aggConfig.isCalSum(), aggConfig.isCalAvg(),
				aggConfig.isCalMin(), aggConfig.isCalMax(),
				aggConfig.isCalStd(), aggConfig.getPlugin(),
				aggConfig.getTypeInst());
	}


	/**
	 * aggregate the metric data.
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
	public static void aggregate(ArrayList<String> metricMeasurements,
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

		if (isCalSum == true) {
			for (int i = 0; i < metricMeasurements.size(); i++) {
				String str = metricMeasurements.get(i);
				if (str.equals("None")){
					measurementSum += 0;
				}
				else{
					measurementSum += Double.parseDouble(metricMeasurements
							.get(i));
				}
			}
			func = AggFunc.SUM;
			System.out.println("Measurement Sum: " + measurementSum); // Debug
			saveData(aggTimeStampStartStr, String.valueOf(measurementSum), func,
					metric, metricType);
		}

		if (isCalAvg == true) {
			measurementSum = 0;
			if (metricMeasurements.size() > 1) { // avoid dividing by zero
				for (int i = 0; i < metricMeasurements.size(); i++) {
					String str = metricMeasurements.get(i);
					if (str.equals("None")){
						measurementSum += 0;
					}
					else {
						measurementSum += Double.parseDouble(metricMeasurements.get(i));
					}
				}
				measurementAvg = measurementSum / metricMeasurements.size();
			}

			func = AggFunc.AVG;
			System.out.println("Measurement Avg: " + measurementAvg); // Debug
			saveData(aggTimeStampStartStr, String.valueOf(measurementAvg), func,
					metric, metricType);
		}

		if (isCalMin == true) {
			metricMeasurementsDouble = new ArrayList<Double>();
			for (int i = 0; i < metricMeasurements.size(); i++) {
				String str = metricMeasurements.get(i);
				if (str.equals("None")){
					metricMeasurementsDouble.add(i,0.0);
				}
				else {
				metricMeasurementsDouble.add(i,
						Double.parseDouble(metricMeasurements.get(i)));
				}
			}
			measurementMin = Collections.min(metricMeasurementsDouble);
			func = AggFunc.MIN;
			System.out.println("Measurement Min: " + measurementMin); // Debug
			saveData(aggTimeStampStartStr, String.valueOf(measurementMin), func,
					metric, metricType);
		}

		if (isCalMax == true) {
			metricMeasurementsDouble = new ArrayList<Double>();
			for (int i = 0; i < metricMeasurements.size(); i++) {
				String str = metricMeasurements.get(i);
				if (str.equals("None")){
					metricMeasurementsDouble.add(i,0.0);
				}
				else {
				metricMeasurementsDouble.add(i,
						Double.parseDouble(metricMeasurements.get(i)));
				}
			}
			measurementMax = Collections.max(metricMeasurementsDouble);
			func = AggFunc.MAX;
			System.out.println("Measurement Max: " + measurementMax); // Debug
			saveData(aggTimeStampStartStr, String.valueOf(measurementMax), func,
					metric, metricType);
		}

		if (isCalStd == true) {
			for (int i = 0; i < metricMeasurements.size(); i++) {
				String str = metricMeasurements.get(i);
				if (str.equals("None")){
					measurementSum += 0;
				}
				else {
					measurementSum += Double.parseDouble(metricMeasurements.get(i));
				}
			}
			measurementAvg = measurementSum / metricMeasurements.size();
			
			for (int i = 0; i < metricMeasurements.size(); i++) {
				String str = metricMeasurements.get(i);
				if (str.equals("None")){
					sumOfSquared += Math.pow((Double.parseDouble(metricMeasurements.get(i)) - measurementAvg), 2);
				}
				else {
					sumOfSquared +=0;
				}
			}
			measurementVariance = sumOfSquared / (metricMeasurements.size() - 1);
			measurementStd = Math.sqrt(measurementVariance);
			func = AggFunc.STD;
			System.out.println("Standard Dev: " + measurementStd); // Debug
			saveData(aggTimeStampStartStr, String.valueOf(measurementStd), func,
					metric, metricType);
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
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public static void saveData(String timeStampEndStr,
			String aggregatedMeasurement, AggFunc func, String metric,
			String metricType) throws MalformedURLException, RemoteException,
			NotBoundException {

		String[] timeStampEndStrArray = new String[1];
		timeStampEndStrArray[0] = timeStampEndStr;

		String[] aggregatedMeasurementArray = new String[1];
		aggregatedMeasurementArray[0] = aggregatedMeasurement;

		// "collectd/global/aggregation-cpu-sum/cpu-idle.wsp
		String str = "collectd/global/aggregation";
		String str2 = "/";
		String str3 = "-";
		String metricPath = str.concat(str3).concat(metric).concat(str3)
				.concat(String.valueOf(func).toLowerCase()).concat(str2)
				.concat(metricType);

		IMetricDatabaseHandlerServer imdhs = (IMetricDatabaseHandlerServer) Naming
				.lookup("rmi://" + "45.55.197.112" + ":" + "8100"
						+ "/MetricDatabaseHandler");
		boolean isSaved = imdhs.updateMetrics(timeStampEndStrArray,
				aggregatedMeasurementArray, metricPath);
		// TODO add to log file
		System.out.println("Time Stamp: " + timeStampEndStrArray[0]); // Debug: remove later
		System.out.println("Metric: " + aggregatedMeasurementArray[0]); // Debug:remove later
		System.out.println("Metric path: " + metricPath); // Debug: remove later
		System.out.println("Aggregation result: " + isSaved); // Debug: remove later
		System.out.println("***********************************"); // Debug:remove later
	}

	/**
	 * Main function
	 * 
	 * @param args
	 *            arguments - arg1: binding IP, arg2: binding port
	 * @throws NotBoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, NotBoundException {
		File file = new File(configFilePath);		
		Long lastModified = file.lastModified() / 1000;	
		
		AggConfigElements aggConfigurationElements = readConfigurationFile();

		// List<String> nodeList = getNodeList(); // Get Nodes list // TODO: after modeling team finalizes the configuration file				

		String[] nodeListTemp = new String[2]; // Note: this is a temporary (hard coded) solution for the previous method
		nodeListTemp[0] = "128_2_204_246"; // "msesrv6h-vm.mse.cs.cmu.edu"
		nodeListTemp[1] = "45_55_240_162"; // "observabilityCassandra1";
		
		while (true) {
			readData(nodeListTemp, aggConfigurationElements);	// Read, aggregate and save aggregated data
			
			if (!(lastModified.equals(file.lastModified() / 1000))){	// Check if the configuration file was modified 
				lastModified = file.lastModified() / 1000;
				aggConfigurationElements = readConfigurationFile();		// Re-read the configurations
			}
		}
	}
}