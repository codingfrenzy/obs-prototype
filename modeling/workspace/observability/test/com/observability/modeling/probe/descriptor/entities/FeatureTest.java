package com.observability.modeling.probe.descriptor.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FeatureTest {

	Feature f = null;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFeature() {
		f = new Feature(null);
		assertEquals(f.keyValues, null);
	}

	@Test
	public void testToString() {
		f = new Feature("feature");
		f.addKeyValue(new KeyValue("kName", "kValue"));
		f.addElement(new ElementTag("eName", "eValue", "id", Scope.LOCAL));
		System.out.println(f.toString());
	}

}
