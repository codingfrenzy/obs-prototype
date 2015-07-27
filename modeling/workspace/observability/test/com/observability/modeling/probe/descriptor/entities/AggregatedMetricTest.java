package com.observability.modeling.probe.descriptor.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AggregatedMetricTest {

	AggregatedMetric am = null;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testAggregatedMetric() {
		am = new AggregatedMetric(null, "value");
		assertEquals(am.getValue(), null);
	}

	@Test
	public void testToString() {
		am = new AggregatedMetric("name", "value");
		am.addKeyValue(new KeyValue("kName", "kValue"));
		am.addElement(new ElementTag("eName", "eValue", "id", Scope.LOCAL));
		System.out.println(am.toString());
	}

}
