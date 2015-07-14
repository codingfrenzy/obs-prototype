package com.observability.modeling.probe.descriptor.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnumTest {

	@Test
	public void test() {
		assertNotEquals(MetricType.valueOf("DATABASE"), null);
		assertNotEquals(MetricType.valueOf("SYSTEM"), null);
		assertNotEquals(Scope.valueOf("LOCAL"), null);
		assertNotEquals(Scope.valueOf("EXTERNAL"), null);
	}

}
