/**
 * 
 */
package com.observability.monitoring.server;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Aggregation means ...
 * @author Laila
 *
 */
public class AggregatorTest {

	//private static Aggregator aggregation;
	//private static AggConfigElements aggConfigElements = null;

	String plugin = "cpu";
	String typeInst = "cpu-idle"; 
	Boolean calSum = false;
	Boolean calAvg = false;
	Boolean calMin = false;
	Boolean calMax = false;
	Boolean calStd = false;
	
	static final String[] elements1 =  {"Plugin", "cpu"}; 
	static final String[] elements2 =  {"TypeInstance", "cpu-system"};
	static final String[] elements3 =  {"CalculateNum", "true"}; 
	static final String[] elements4 =  {"CalculateSum", "true"}; 
	static final String[] elements5 =  {"CalculateAverage", "true"}; 
	static final String[] elements6 =  {"CalculateMinimum", "true"}; 
	static final String[] elements7 =  {"CalculateMaximum", "true"}; 
	static final String[] elements8 =  {"CalculateStddev", "true"}; 
	
	static final List<String[]> aggConfigurations = new ArrayList<String[]>();
	
	static final int faultTolTimeWindow = 60;
	static final int interval = 30;
	
	static final String fileName = "Test.txt";
	static final String wrongFileName = "Test1.txt";
	
	static final String correctTimeStamp = "1430000000";
	static final String wrongTimeStamp = "0";
	
	static final ArrayList<String> metricMeasurements = new ArrayList<String>();
	
	static IMetricDatabaseHandlerServer imdhs = null;	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp()  {
		try {
			aggConfigurations.add(elements1);
			aggConfigurations.add(elements2);
			aggConfigurations.add(elements3);
			aggConfigurations.add(elements4);
			aggConfigurations.add(elements5);
			aggConfigurations.add(elements6);
			aggConfigurations.add(elements7);
			aggConfigurations.add(elements8);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	//setConfigurations(int interval, List<String[]> aggConfigurations)
	@Test
	public void testSetConfigurations() throws RemoteException {
		assertNotNull(Aggregator.setConfigurations(faultTolTimeWindow, interval, aggConfigurations));	// positive TC
		assertNotNull(Aggregator.setConfigurations(faultTolTimeWindow, 0, aggConfigurations));			// negative TC
		assertNotNull(Aggregator.setConfigurations(0,faultTolTimeWindow, aggConfigurations));			// negative TC
	}
	
	//readConfigurationFile(String configFilePath)
	@Test
	public void testReadConfigurationFile() throws IOException, NotBoundException {
		assertNotNull(Aggregator.readConfigurationFile(fileName));	// positive TC
		//assertNotNull(Aggregator.readConfigurationFile(wrongFileName));	// Negative TC
	}
	
	@Test
	public void tesGetIntervalConf() throws IOException, NotBoundException {
		assertNotNull(Aggregator.getIntervalConf(fileName));	// positive TC
		//assertNotNull(Aggregator.readConfigurationFile(wrongFileName));	// Negative TC
	}
	
	
	@Test
	public void testAggConfigElementsClass(){
		//Since this is only a class to setup values of the aggregation configuration, only positive TC were used. Note
		//that the validation is being taken care of in the main program "Aggregator"
		AggConfigElements aggConfigElements = new AggConfigElements(
				faultTolTimeWindow, interval, plugin, typeInst, calSum,
				calAvg, calMin, calMax, calStd);

		System.out.println("AggConfigElements has the following initial values: Fault Tolerance: " + aggConfigElements.getFaultTolTimeWindow() 
				+ ", Interval: " + aggConfigElements.getInterval() + ", Plugin: " + aggConfigElements.getPlugin() +", TypeInst: " +
				aggConfigElements.getTypeInst());
		aggConfigElements.setFaultTolTimeWindow(10); 
		aggConfigElements.setInterval(10); 
		aggConfigElements.setPlugin("cpu"); 
		aggConfigElements.setTypeInst(null);
		aggConfigElements.setCalAvg(true);	
		aggConfigElements.setCalSum(false);
		aggConfigElements.setCalStd(true);
		aggConfigElements.setCalMin(true);
		aggConfigElements.setCalMax(true);
		
		assertTrue(aggConfigElements.isCalAvg());
		assertFalse(aggConfigElements.isCalSum());
		assertTrue(aggConfigElements.isCalMax());
		assertTrue(aggConfigElements.isCalMin());
		assertTrue(aggConfigElements.isCalStd());
	}

	@Test
	public void testAggregate() throws MalformedURLException, RemoteException, NotBoundException{
		// Positive TC
		metricMeasurements.add("123.0");
		//metricMeasurements.add(null);
		metricMeasurements.add("111.0");
		Aggregator.aggregate(metricMeasurements, "1430000000", true, true, true, true, true, "cpu", "cpu-idle");
		Aggregator.aggregate(metricMeasurements, "1430000000", true, false, false, false, false, "cpu", "cpu-nice");
		Aggregator.aggregate(metricMeasurements, "1430000000", false, false, false, false, false, "cpu", "cpu-nice");

		// Negative TC
	}
	
	/*@Test
	public void testRead() throws NotBoundException, IOException, InterruptedException {
		String[] nodeListTemp = new String[2];
		nodeListTemp[0] = "128_2_204_246";
		nodeListTemp[1] = "45_55_240_162";
		long timeSatmp = 1435856310;
		
		try {
			imdhs = (IMetricDatabaseHandlerServer) Naming
					.lookup("rmi://" + "45.55.197.112" + ":" + "8100"
							+ "/MetricDatabaseHandler");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AggConfigElements aggConfigElements = new AggConfigElements(
				60, 30, "cpu", "cpu-user", true, false, false, false, false);
		boolean dataIsRead = Aggregator.readData(timeSatmp, nodeListTemp, aggConfigElements);
		System.out.println("Data read? " + dataIsRead);
	}*/
	
	@Test
	public void testMain() throws IOException, NotBoundException, InterruptedException{
		Aggregator.main(new String[0]);
	}
}
