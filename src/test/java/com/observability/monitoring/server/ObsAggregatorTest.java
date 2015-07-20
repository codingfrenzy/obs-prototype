/**
 * 
 */
package com.observability.monitoring.server;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Laila
 *
 */
public class ObsAggregatorTest {

	ArrayList<String> metricMeasurements = new ArrayList<String>();
	
	int faultTolTimeWindow = 60;
	int interval = 30; 			
	String host = ""; 	
	String plugin = "postgresql"; 			
	String pluginInstance = ""; 	
	String type = "pg_blks";
	String typeInst = "heap_read"; 		
	String groupBy = ""; 
	boolean calNum = true; 		
	boolean calSum = true; 		
	boolean calAvg =  true; 		
	boolean calMin = true; 		
	boolean calMax = true; 		
	boolean calStd = true; 		

	AggConfigElements aggConfigElements = null;
	
	String[] elements1 =  {"FaultTolTimeWindow", "60"}; 
	String[] elements2 =  {"Interval", "30"}; 
	String[] elements3 =  {"Host", ""}; 
	String[] elements4 =  {"Plugin", "postgresql"}; 
	String[] elements5 =  {"PluginInstance", ""}; 
	String[] elements6 =  {"Type", "pg_blks"};
	String[] elements7 =  {"TypeInstance", "heap_read"};
	String[] elements8 =  {"GroupBy", ""};
	String[] elements9 =  {"CalculateSum", "true"}; 
	String[] elements10 =  {"CalculateAverage", "true"}; 
	String[] elements11 =  {"CalculateMinimum", "true"}; 
	String[] elements12 =  {"CalculateMaximum", "true"}; 
	String[] elements13 =  {"CalculateStddev", "true"}; 
	
	List<String[]> aggConfigurations = new ArrayList<String[]>();
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		aggConfigElements = new AggConfigElements(faultTolTimeWindow,  interval,  host,  plugin,  pluginInstance, 
				 type,  typeInst,  groupBy, calNum, calSum,  calAvg, calMin, calMax,  calStd);
		
		metricMeasurements.add("1.0");
		metricMeasurements.add("2.5");
		metricMeasurements.add("10.0");
		metricMeasurements.add("1000");
		
		try {
			aggConfigurations.add(elements1);
			aggConfigurations.add(elements2);
			aggConfigurations.add(elements3);
			aggConfigurations.add(elements4);
			aggConfigurations.add(elements5);
			aggConfigurations.add(elements6);
			aggConfigurations.add(elements7);
			aggConfigurations.add(elements8);
			aggConfigurations.add(elements9);
			aggConfigurations.add(elements10);
			aggConfigurations.add(elements11);
			aggConfigurations.add(elements12);
			aggConfigurations.add(elements13);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.observability.monitoring.server.ObsAggregator#aggregate(com.observability.monitoring.server.AggConfigElements, java.util.ArrayList)}.
	 */
	@Test
	public final void testAggregate() {

		assertNotNull(ObsAggregator.aggregate(aggConfigElements, metricMeasurements));
	}

	/**
	 * Test method for {@link com.observability.monitoring.server.ObsAggregator#main(java.lang.String[])}.
	 */
	@Test
	public final void testMain() {
		//fail("Not yet implemented"); // TODO
	}

}
