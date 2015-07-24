package com.observability.monitoring.server;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AggConfigElementsTest {
	static AggConfigElements aggConfigElementsFalseNull = new AggConfigElements(
			0, 0, null, null, null, null, null, null, false, false,
			false, false, false, false);
	static AggConfigElements aggConfigElementsTrueNotNull = new AggConfigElements(
			10, 10, "", "", "", "", "", "", true, true,
			true, true, true, true);
	
	AggConfigElements aggConfigElements = null;
	
	@Before
	public void setUp() throws Exception {
		 aggConfigElements = new AggConfigElements(
				0, 0, null, null, null, null, null, null, false, false,
				false, false, false, false);
	}
	
	@Test
	public void testAggConfigElementsSettersTrueNotNull() {

		System.out.println("AggConfigElements has the following initial values: Fault Tolerance: " + aggConfigElements.getFaultTolTimeWindow() 
				+ ", Interval: " + aggConfigElements.getInterval() +", Host: " + aggConfigElements.getHost() 
				+ ", Plugin: " + aggConfigElements.getPlugin() +  ", PluginInstance: " + aggConfigElements.getPluginInstance()
				+ ", Type: " + aggConfigElements.getType() + ", TypeInst: " + aggConfigElements.getTypeInst()
				+ ", GroupBy: " + aggConfigElements.getGroupBy() + ", CalNum: " + aggConfigElements.isCalNum()
				+ ", CalSum: " + aggConfigElements.isCalSum() + ", CalAvg: " + aggConfigElements.isCalAvg()
				+ ", CalMin: " + aggConfigElements.isCalMin() + ", CalMax: " + aggConfigElements.isCalMax()
				+ ", CalStd: " + aggConfigElements.isCalStd()
				);
		aggConfigElements.setFaultTolTimeWindow(10); 
		aggConfigElements.setInterval(10); 
		aggConfigElements.setHost("Test");
		aggConfigElements.setPlugin("cpu");
		aggConfigElements.setPluginInstance("Test"); 
		aggConfigElements.setType("cpu-system");
		aggConfigElements.setTypeInst("Test");
		aggConfigElements.setGroupBy("TypeInstance");
		aggConfigElements.setCalNum(true);
		aggConfigElements.setCalAvg(true);	
		aggConfigElements.setCalSum(true);
		aggConfigElements.setCalStd(true);
		aggConfigElements.setCalMin(true);
		aggConfigElements.setCalMax(true);

		//assertTrue(aggConfigElements.getFaultTolTimeWindow() == 0);
		//assertTrue(aggConfigElements.getInterval() == 0);
		assertNotNull(aggConfigElements.getHost());
		assertNotNull(aggConfigElements.getPlugin());
		assertNotNull(aggConfigElements.getPluginInstance());
		assertNotNull(aggConfigElements.getType());
		assertNotNull(aggConfigElements.getTypeInst());
		assertNotNull(aggConfigElements.getGroupBy());
		
		assertTrue(aggConfigElements.isCalNum());
		assertTrue(aggConfigElements.isCalAvg());
		assertTrue(aggConfigElements.isCalSum());
		assertTrue(aggConfigElements.isCalMax());
		assertTrue(aggConfigElements.isCalMin());
		assertTrue(aggConfigElements.isCalStd());
	}
	
	@Test
	public final void testAggConfigElementsSettersFalseNull() {

		System.out.println("AggConfigElements has the following initial values: Fault Tolerance: " + aggConfigElements.getFaultTolTimeWindow() 
				+ ", Interval: " + aggConfigElements.getInterval() +", Host: " + aggConfigElements.getHost() 
				+ ", Plugin: " + aggConfigElements.getPlugin() +  ", PluginInstance: " + aggConfigElements.getPluginInstance()
				+ ", Type: " + aggConfigElements.getType() + ", TypeInst: " + aggConfigElements.getTypeInst()
				+ ", GroupBy: " + aggConfigElements.getGroupBy() + ", CalNum: " + aggConfigElements.isCalNum()
				+ ", CalSum: " + aggConfigElements.isCalSum() + ", CalAvg: " + aggConfigElements.isCalAvg()
				+ ", CalMin: " + aggConfigElements.isCalMin() + ", CalMax: " + aggConfigElements.isCalMax()
				+ ", CalStd: " + aggConfigElements.isCalStd()
				);
		
		assertFalse(aggConfigElements.getFaultTolTimeWindow() == 1);
		assertFalse(aggConfigElements.getInterval() == 1);
		assertNull(aggConfigElements.getHost());
		assertNull(aggConfigElements.getPlugin());
		assertNull(aggConfigElements.getPluginInstance());
		assertNull(aggConfigElements.getType());
		assertNull(aggConfigElements.getTypeInst());
		assertNull(aggConfigElements.getGroupBy());

		assertFalse(aggConfigElements.isCalNum());
		assertFalse(aggConfigElements.isCalAvg());
		assertFalse(aggConfigElements.isCalSum());
		assertFalse(aggConfigElements.isCalMax());
		assertFalse(aggConfigElements.isCalMin());
		assertFalse(aggConfigElements.isCalStd());
	}


	@Test
	public final void testGetFaultTolTimeWindow() {
		assertNotNull(aggConfigElementsTrueNotNull.getFaultTolTimeWindow());		// Positive TC
	}
	
	@Test
	public final void testGetFaultTolTimeWindowNull() {
		assertNotNull(aggConfigElementsFalseNull.getFaultTolTimeWindow());		// Negative TC
	}

	@Test
	public final void testSetFaultTolTimeWindow() {
		aggConfigElements.setFaultTolTimeWindow(20);
		assertTrue(aggConfigElements.getFaultTolTimeWindow() == 20);
	}

	@Test
	public final void testGetInterval() {
		assertNotNull(aggConfigElementsTrueNotNull.getInterval());
	}

	@Test
	public final void testSetInterval() {	
		aggConfigElements.setInterval(30);					// Positive TC
		assertTrue(aggConfigElements.getInterval() == 30);
	}

	@Test
	public final void testGetHost() {
		assertNotNull(aggConfigElementsTrueNotNull.getHost());
	}

	@Test
	public final void testSetHosT() {
		aggConfigElements.setHost("Test");					// Positive TC
		assertNotNull(aggConfigElements.getHost());
	}

	@Test
	public final void testGetPlugin() {
		assertNotNull(aggConfigElementsTrueNotNull.getPlugin());
	}

	@Test
	public final void testSetPlugin() {
		aggConfigElements.setPlugin("Test");					// Positive TC
		assertNotNull(aggConfigElements.getPlugin());
	}

	@Test
	public final void testGetPluginInstance() {
		assertNotNull(aggConfigElementsTrueNotNull.getPluginInstance());
	}

	@Test
	public final void testSetPluginInstance() {
		aggConfigElements.setPluginInstance("Test");					// Positive TC
		assertNotNull(aggConfigElements.getPluginInstance());
	}

	@Test
	public final void testGetType() {
		assertNotNull(aggConfigElementsTrueNotNull.getType());
	}

	@Test
	public final void testSetType() {
		aggConfigElements.setType("Test");					// Positive TC
		assertNotNull(aggConfigElements.getType());
	}

	@Test
	public final void testGetTypeInst() {
		assertNotNull(aggConfigElementsTrueNotNull.getTypeInst());
	}

	@Test
	public final void testSetTypeInst() {
		aggConfigElements.setTypeInst("Test");					// Positive TC
		assertNotNull(aggConfigElements.getTypeInst());
	}

	@Test
	public final void testGetGroupBy() {
		assertNotNull(aggConfigElementsTrueNotNull.getGroupBy());
	}

	@Test
	public final void testSetGroupBy() {
		aggConfigElements.setGroupBy("Test");					// Positive TC
		assertNotNull(aggConfigElements.getGroupBy());
	}

	@Test
	public final void testIsCalNum() {
		assertNotNull(aggConfigElementsTrueNotNull.isCalNum());
	}

	@Test
	public final void testSetCalNum() {
		aggConfigElements.setCalNum(true);					// Positive TC
		assertTrue(aggConfigElements.isCalNum());
	}

	@Test
	public final void testIsCalSum() {
		assertNotNull(aggConfigElementsTrueNotNull.isCalSum());
	}

	@Test
	public final void testSetCalSum() {
		aggConfigElements.setCalSum(true);					// Positive TC
		assertTrue(aggConfigElements.isCalSum());
	}

	@Test
	public final void testIsCalAvg() {
		assertNotNull(aggConfigElementsTrueNotNull.isCalAvg());
	}

	@Test
	public final void testSetCalAvg() {
		aggConfigElements.setCalAvg(true);					// Positive TC
		assertTrue(aggConfigElements.isCalAvg());
	}

	@Test
	public final void testIsCalMin() {
		assertNotNull(aggConfigElementsTrueNotNull.isCalMin());
	}

	@Test
	public final void testSetCalMin() {
		aggConfigElements.setCalMin(true);					// Positive TC
		assertTrue(aggConfigElements.isCalMin());
	}

	@Test
	public final void testIsCalMax() {
		assertNotNull(aggConfigElementsTrueNotNull.isCalMax());
	}

	@Test
	public final void testSetCalMax() {
		aggConfigElements.setCalMax(true);					// Positive TC
		assertTrue(aggConfigElements.isCalMax());
	}

	@Test
	public final void testIsCalStd() {
		assertNotNull(aggConfigElementsTrueNotNull.isCalStd());
	}

	@Test
	public final void testSetCalStd() {
		aggConfigElements.setCalStd(true);					// Positive TC
		assertTrue(aggConfigElements.isCalStd());
	}
}