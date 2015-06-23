/**
 * 
 */
package com.observability.monitoring.server;

import static org.junit.Assert.*;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Aggregation means ...
 * @author Laila
 *
 */
public class AggregatorTest {

	//private static Aggregator aggregation;
	//private static AggConfigElements aggConfigElements;

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
		//assertNotNull(Aggregator.readConfigurationFile(wrongFileName));	//
	}
	
	@Test
	public void testStartAggregating() throws IOException, NotBoundException, InterruptedException{
		//Aggregator.main();
	}
	
	@Test
	public void testAggConfigElementsClass(){
		//aggConfigElements.setFaultTolTimeWindow(10); // positive TC
		//aggConfigElements.setInterval(10); // positive TC
		//aggConfigElements.setPlugin("cpu"); // positive TC
	}
	
	public static void main(String[] args) {
		AggregatorTest.setUp();
	}

}
