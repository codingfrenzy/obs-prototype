/**
 * 
 */
package com.observability.modeling.probe.descriptor.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author vsaravag
 *
 */
public class KeyValueTest {
	
	KeyValue kv =  null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		kv = new KeyValue("name", "value");
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.KeyValue#KeyValue(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testKeyValue() {
		kv = new KeyValue(null, null);
		assertEquals(kv.getName(), null);
		assertEquals(kv.getValue(), null);
		
		kv = new KeyValue("name", "value");
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.KeyValue#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals(kv.getName(), "name");
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.KeyValue#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		kv.setName("changedName");
		assertEquals(kv.getName(), "changedName");
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.KeyValue#getValue()}.
	 */
	@Test
	public void testGetValue() {
		assertEquals(kv.getValue(), "value");
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.KeyValue#setValue(java.lang.String)}.
	 */
	@Test
	public void testSetValue() {
		kv.setValue("changedValue");
		assertEquals(kv.getValue(), "changedValue");
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.KeyValue#toString()}.
	 */
	@Test
	public void testToString() {
		System.out.println(kv);
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.KeyValue#toString(int)}.
	 */
	@Test
	public void testToStringInt() {
		System.out.println(kv.toString(2));
	}

}
