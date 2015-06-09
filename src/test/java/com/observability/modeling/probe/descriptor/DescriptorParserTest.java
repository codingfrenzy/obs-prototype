/**
 * 
 */
package com.observability.modeling.probe.descriptor;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;


import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author cem
 *
 */
public class DescriptorParserTest {

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
	 * Test method for {@link com.observability.modeling.probe.descriptor.DescriptorParserImpl#parseDescriptors()}.
	 */
	@Test
	public void testParseDescriptors() {
		ClassLoader classLoader = DescriptorParserImpl.class.getClassLoader();
		URL path = classLoader.getResource("cassandra.descriptor");
		DescriptorParser parser = new DescriptorParserImpl( new File (path.getFile()).toPath().getParent());
		parser.parseDescriptors();
		
		
	}

}
