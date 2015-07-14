/**
 * 
 */
package com.observability.modeling.probe.descriptor.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author vsaravag
 *
 */
public class SystemMetricTest {
	SystemMetric sm = null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sm = new SystemMetric("metric", MetricType.DATABASE);
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.SystemMetric#SystemMetric(java.lang.String, com.observability.modeling.probe.descriptor.entities.MetricType)}.
	 */
	@Test
	public void testSystemMetric() {
		assertNotNull(sm);
		sm = new SystemMetric(null, MetricType.DATABASE);
		assertNull(sm.getName());
		sm = new SystemMetric("metric", MetricType.DATABASE);
		
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.SystemMetric#getType()}.
	 */
	@Test
	public void testGetType() {
		assertEquals(sm.getType(), MetricType.DATABASE);
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.Parameter#getName()}
	 * {@link com.observability.modeling.probe.descriptor.entities.Parameter#setName()}.
	 */
	@Test
	public void testName() {
		sm.setName("changedMetric");
		assertEquals(sm.getName(), "changedMetric");
	}


	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.Parameter#getValue()}
	 * {@link com.observability.modeling.probe.descriptor.entities.Parameter#setValue()}.
	 */
	@Test
	public void testValue() {
		sm.setValue("changedMetricValue");
		assertEquals(sm.getValue(), "changedMetricValue");
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.Parameter#getElements()}
	 * {@link com.observability.modeling.probe.descriptor.entities.Parameter#addElement()}.
	 */
	@Test
	public void testElements() {
		assertEquals(sm.getElements().size(), 0);
		sm.addElement(new ElementTag("element", "element value", "element_element value", Scope.EXTERNAL));
		assertEquals(sm.getElements().size(), 1);
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.Parameter#getKeyValues()}
	 * {@link com.observability.modeling.probe.descriptor.entities.Parameter#addKeyValue()}..
	 */
	@Test
	public void testKeyValues() {
		assertEquals(sm.getKeyValues().size(), 0);
		sm.addKeyValue(new KeyValue("name", "value"));
		assertEquals(sm.getKeyValues().size(), 1);
	}

}
