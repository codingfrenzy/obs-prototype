/**
 * 
 */
package com.observability.modeling.probe.descriptor;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author vsaravag
 *
 */
public class ParserUtilityTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.ParserUtility#isAnnotated(java.lang.String)}.
	 */
	@Test
	public void testIsAnnotated() {
		// Test annotation key-value pair
		String line = "key value @Metric";
		assertTrue(ParserUtility.isAnnotated(line));
		
		// Test annotation on element tag
		line = "<Mbean \"metrics\"> @Metric";
		assertTrue(ParserUtility.isAnnotated(line));
		
		// Test annotation on non-annotated string
		line = "<Mbean \"metrics\">";
		assertFalse(ParserUtility.isAnnotated(line));
		
		// Test annotation on empty string
		line = "";
		assertFalse(ParserUtility.isAnnotated(line));
		
		// Test annotation on null string
		line = null;
		assertFalse(ParserUtility.isAnnotated(line));
		
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.ParserUtility#isElementStart(java.lang.String)}.
	 */
	@Test
	public void testIsElementStart() {
		// Test element start on normal string
		String line = "<Mbean \"metrics\"> @Metric";
		assertTrue(ParserUtility.isElementStart(line));
		
		// Test element start on a non-element string
		line = "Mbean \"metrics\" @Metric";
		assertFalse(ParserUtility.isElementStart(line));
		
		// Test element start on an element-end string
		line = "</Mbean>";
		assertFalse(ParserUtility.isElementStart(line));
		
		// Test element start on an empty string
		line = "";
		assertFalse(ParserUtility.isElementStart(line));
		
		// Test element start on a null string
		line = null;
		assertFalse(ParserUtility.isElementStart(line));
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.ParserUtility#isElementEnd(java.lang.String)}.
	 */
	@Test
	public void testIsElementEnd() {
		// Test element end on normal string
		String line = "</Mbean>";
		assertTrue(ParserUtility.isElementEnd(line));
		
		// Test element end on a non-element string
		line = "Mbean \"metrics\" @Metric";
		assertFalse(ParserUtility.isElementEnd(line));
		
		// Test element end on an element-start string
		line = "<Mbean \"lang\">";
		assertFalse(ParserUtility.isElementEnd(line));
		
		// Test element end on an empty string
		line = "";
		assertFalse(ParserUtility.isElementEnd(line));
		
		// Test element end on a null string
		line = null;
		assertFalse(ParserUtility.isElementEnd(line));
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.ParserUtility#getElementDetails(java.lang.String)}.
	 */
	@Test
	public void testGetElementDetails() {
		
		// Get element details on normal element string
		String line = "<MBean \"metrics metrics\"> @Metric";
		System.out.println(Arrays.toString(ParserUtility.getElementDetails(line)));
		
		// Get element details from spaced element string
		line = "<   MBean \"metrics\"   > @Metric";
		System.out.println(Arrays.toString(ParserUtility.getElementDetails(line)));
		
		// Get element details from element end string
		line = "</MBean>";
		System.out.println(Arrays.toString(ParserUtility.getElementDetails(line)));
		
		// Get element details from non-element string
		line = "/MBean mbean test";
		System.out.println(Arrays.toString(ParserUtility.getElementDetails(line)));
		
		// Get element details from null string
		line = null;
		System.out.println(Arrays.toString(ParserUtility.getElementDetails(line)));
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.ParserUtility#getKeyValueDetails(java.lang.String)}.
	 */
	@Test
	public void testGetKeyValueDetails() {

		// Get key-value details on normal string
		String line = "host \"localhost\" @Metric";
		System.out.println(Arrays.toString(ParserUtility.getKeyValueDetails(line)));
		
		// Get key-value details from spaced  string
		line = "    host   \"localhost\"    @Metric";
		System.out.println(Arrays.toString(ParserUtility.getKeyValueDetails(line)));
		
		// Get key-value details from element end string
		line = "</MBean>";
		System.out.println(Arrays.toString(ParserUtility.getKeyValueDetails(line)));
		
		// Get element details from element start string
		line = "<MBean \"mbean test\">";
		System.out.println(Arrays.toString(ParserUtility.getKeyValueDetails(line)));
		
		// Get element details from null string
		line = null;
		System.out.println(Arrays.toString(ParserUtility.getKeyValueDetails(line)));
		
	}

	/**
	 * Test method for {@link com.observability.modeling.probe.descriptor.ParserUtility#getAnnotation(java.lang.String)}.
	 */
	@Test
	public void testGetAnnotation() {
		
		// Get annotation from an element string
		String line = "<MBean \"metrics metrics\"> @Metric";
		System.out.println(ParserUtility.getAnnotation(line));
		
		// Get annotation from a key-value string
		line = "host \"localhost\"     @Metric";
		System.out.println(ParserUtility.getAnnotation(line));
		
		// Get annotation from a non-annotated string
		line = "host \"localhost\" ";
		System.out.println(ParserUtility.getAnnotation(line));
		
		// Get annotation from an empty string
		line = "";
		System.out.println(ParserUtility.getAnnotation(line));		
		
		// Get annotation from null string
		line = null;
		System.out.println(ParserUtility.getAnnotation(line));
		

	}

}
