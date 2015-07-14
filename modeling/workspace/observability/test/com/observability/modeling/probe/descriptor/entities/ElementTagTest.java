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
public class ElementTagTest {
	
	ElementTag e = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		e = new ElementTag("name", "value", "name_value", Scope.LOCAL);
	}
	
	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.ElementTag#ElementTag(java.lang.String, java.lang.String, java.lang.String, com.observability.modeling.probe.descriptor.entities.Scope)}.
	 */
	@Test
	public void testElementTag() {
		assertNotNull(e);
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.ElementTag#getName()}
	 * {@link com.observability.modeling.probe.descriptor.entities.ElementTag#setName()}.
	 */
	@Test
	public void testName() {
		e.setName("test");
		assertEquals(e.getName(), "test");
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.ElementTag#getValue()}
	 * {@link com.observability.modeling.probe.descriptor.entities.ElementTag#setValue()}.
	 */
	@Test
	public void testValue() {
		e.setValue("testValue");
		assertEquals(e.getValue(), "testValue");
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.ElementTag#getId()}
	 * {@link com.observability.modeling.probe.descriptor.entities.ElementTag#setId()}.
	 */
	@Test
	public void testId() {
		e.setId("test_test");
		assertEquals(e.getId(), "test_test");
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.ElementTag#getScope()}
	 * {@link com.observability.modeling.probe.descriptor.entities.ElementTag#setScope()}.
	 */
	@Test
	public void testScope() {
		assertEquals(e.getScope(), Scope.LOCAL);
		e.setScope(Scope.EXTERNAL);
		assertEquals(e.getScope(), Scope.EXTERNAL);
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.ElementTag#getKeyValues()}
	 * {@link com.observability.modeling.probe.descriptor.entities.ElementTag#addKeyValues()}.
	 */
	@Test
	public void testKeyValues() {
		assertEquals(e.getKeyValues().size(), 0);
		e.addKeyValue("key", "value");
		assertEquals(e.getKeyValues().size(), 1);
		
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.entities.ElementTag#getElements()}.
	 */
	@Test
	public void testGetElements() {
		assertEquals(e.getElements().size(), 0);
		e.addElement(e);
		assertEquals(e.getElements().size(), 1);
	}


}
