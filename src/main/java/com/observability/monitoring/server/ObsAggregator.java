package com.observability.monitoring.server;

import java.io.File;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

import com.observability.monitoring.server.Aggregator.AggFunc;

public class ObsAggregator {
	

	/**
	 * Auto generated serial version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	protected ObsAggregator() throws RemoteException {
		super();
	}

	static IMetricDatabaseHandlerServer imdhs = null;	

	/**
	 * Path and name of the configuration file
	 */
	static String configFilePath = "/opt/collectd/etc/collectd.conf";

	/**
	 * Enumeration of the possible aggregation functions
	 */
	public enum AggFunc {
		NUM, SUM, AVERAGE, MAX, MIN, STDDEV
	}
		
	// Aggregate 
	public static AggInstance aggregate (AggConfigElements aggConfigElements, 
			ArrayList<String> metricMeasurements) {
		
		ArrayList<Double> metricMeasurementsDouble = new ArrayList<Double>();
		AggInstance aggInstance = null;	
		double measurementNum = 0;
		double measurementSum = 0;
		double measurementAvgSum = 0;
		double measurementAvg = 0;
		double measurementMin = 0;
		double measurementMax = 0;
		double sumOfSquared = 0;
		double measurementVariance = 0;
		double measurementSumStd = 0;
		double measurementAvgStd = 0;
		double measurementStd = 0;
		
		// If the method aggregate receives any null value, then return null 
		if ((metricMeasurements == null) || (aggConfigElements == null)) {
			return null;
		}
		
		// Convert the metric measurements from String to double and replace the value of None with zero
		for (int i = 0; i < metricMeasurements.size(); i++) {
			String str = metricMeasurements.get(i);
			if (!str.equals("None")){
				metricMeasurementsDouble.add(i,Double.parseDouble(metricMeasurements.get(i)));
			}
			else {
				metricMeasurementsDouble.add(i,0.0);
			}
		}
		
		// Number of all metrics
		if (aggConfigElements.isCalNum() == true) {
			for (int i = 0; i < metricMeasurementsDouble.size(); i++) {
				///////////////
				}
			System.out.println("Num: " + measurementNum); // Debug, remove later
		}
		
		// Sum all the metrics
		if (aggConfigElements.isCalSum() == true) {
			for (int i = 0; i < metricMeasurementsDouble.size(); i++) {
				measurementSum += metricMeasurementsDouble.get(i);
			}
			System.out.println("Sum: " + measurementSum); // Debug, remove later
		}
		
		// Average all the metrics
		if (aggConfigElements.isCalAvg() == true) {
			for (int i = 0; i < metricMeasurementsDouble.size(); i++) {
				measurementAvgSum += metricMeasurementsDouble.get(i);
			}
				
			if (metricMeasurementsDouble.size() != 0){
				measurementAvg = measurementAvgSum / metricMeasurementsDouble.size();
			}
			System.out.println("Avg: " + Math.abs(measurementAvg)); // Debug, remove later
		}

		// Calculate the minimum value of the metrics
		if (aggConfigElements.isCalMin() == true) {
			measurementMin = Collections.min(metricMeasurementsDouble);
			System.out.println("Min: " + measurementMin); // Debug, remove later
		}

		// Calculate the maximum value of the metrics
		if (aggConfigElements.isCalMax() == true) {
			measurementMax = Collections.max(metricMeasurementsDouble);
			System.out.println("Max: " + measurementMax); // Debug, remove later
		}

		// Calculate the standard deviation value of the metrics
		if (aggConfigElements.isCalStd() == true) {
			for (int i = 0; i < metricMeasurementsDouble.size(); i++) {
				measurementSumStd += metricMeasurementsDouble.get(i);
			}
				
			if (metricMeasurementsDouble.size() != 0){
				measurementAvgStd = measurementSumStd / metricMeasurementsDouble.size();
			}
			
			for (int i = 0; i < metricMeasurementsDouble.size(); i++) {
				sumOfSquared += Math.pow((metricMeasurementsDouble.get(i)) - Math.abs(measurementAvgStd), 2);
			}

			measurementVariance = sumOfSquared / (metricMeasurementsDouble.size() - 1);
			measurementStd = Math.sqrt(measurementVariance);
			
			System.out.println("Standard Dev: " + measurementStd); // Debug, remove later 
		}
		
		// Save the aggregated results in an object
		aggInstance = new AggInstance(measurementNum, measurementSum, measurementAvg, measurementMin, measurementMax, measurementStd);
				
		return aggInstance; // Return aggregation results
	}
	
	private static boolean savedAggregatedResults(
			AggConfigElements aggConfigElements, AggInstance aggregatedResults) {
		boolean isSaved = false;
		AggFunc func;

		if (aggConfigElements == null || aggregatedResults == null || aggregatedResults.getAggTimeStampStartStr() == null 
				|| aggregatedResults.getAggTimeStampStartStr().equals("0")){
			System.out.println("Can't save data. Data is not valid or missing");
			return false;
		}
		/*if ((timeStampStartStr == null) || (timeStampStartStr.equals("0")) || (aggregatedMeasurement == null) 
				|| (func == null) || (metric == null) || (metricType == null)){
			System.out.println("Can't save data. Data is not valid or missing");
			return false;
		}*/
		else{
			
			String[] timeStampStartStrArray = new String[1];
			timeStampStartStrArray[0] = aggregatedResults.getAggTimeStampStartStr();

			String[] aggregatedMeasurementArray = new String[1];
			// "collectd/global/aggregation-cpu-sum/cpu-idle.wsp
			String str = "collectd.global.aggregation";
			String str2 = ".";
			String str3 = "-"; 
			
			if (aggregatedResults.isCalNum()){
				aggregatedMeasurementArray[0] = String.valueOf(aggregatedResults.getMeasurementNum());
				func = AggFunc.NUM;
				String metricPath = str.concat(str3).concat(aggConfigElements.getPlugin()).concat(str3)
						.concat(String.valueOf(func).toLowerCase()).concat(str2)
						.concat(aggConfigElements.getType());
			}
			//imdhs
			
			if (aggregatedResults.isCalSum()){
				aggregatedMeasurementArray[0] = String.valueOf(aggregatedResults.getMeasurementSum());
			}
			// imdhs
			
			if (aggregatedResults.isCalAvg()){
				aggregatedMeasurementArray[0] = String.valueOf(aggregatedResults.getMeasurementAvg());
				//imdhs
			}
			
			if (aggregatedResults.isCalMin()){
				aggregatedMeasurementArray[0] = String.valueOf(aggregatedResults.getMeasurementMin());
			}
			
			if (aggregatedResults.isCalMax()){
				aggregatedMeasurementArray[0] = String.valueOf(aggregatedResults.getMeasurementMax());
			}
			
			if (aggregatedResults.isCalStd()){
				aggregatedMeasurementArray[0] = String.valueOf(aggregatedResults.getMeasurementStd());
			}
			
			
			

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
		}
		return isSaved;
	}
	
	public static void main(String[] args) throws InterruptedException {
		ArrayList<String> metricMeasurements = null;
		String aggTimeStampStartStr = null;
		AggConfigElements aggConfigElements = null	;
		AggInstance aggregatedResults = null;
		boolean isSaved =  false;
		long startTime = 0;
		long endTime = 0;
		long totalTime = 0;
		long currentTimeStamp = 0;
		File file = null;
		
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
			// Read configurations
			
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
				// Read data 
				
				// Aggregate Metrics
				aggregatedResults = aggregate(aggConfigElements, metricMeasurements);
				
				if (aggregatedResults == null){
					System.err.println("Aggregation cannot be completed for time stamp:" + aggTimeStampStartStr);
				}
				
				// Save aggregated metrics
				isSaved = savedAggregatedResults(aggConfigElements, aggregatedResults);	
			
				endTime = System.currentTimeMillis();	//This to calculate the running time of readData()
				totalTime = endTime - startTime;	//This to calculate the running time of readData()
					
				if (!isSaved){
					System.err.println("Aggregation cannot be saved for time stamp:" + aggTimeStampStartStr);
					// Thread.sleep(aggConfigurationElementsArray.get(0).getInterval() - 5);	// Sleep before trying to read more data
				}
			
				if (!(lastModified.equals(file.lastModified() / 1000))){	// Check if the configuration file was modified 
					lastModified = file.lastModified() / 1000;
					//aggConfigurationElementsArray = readConfigurationFile(configFilePath);		// Re-read the configurations
				}
			}
		}
	}
}
