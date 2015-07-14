/**
 * 
 */
package com.observability.modeling.probe.descriptor;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.observability.modeling.probe.descriptor.entities.DbType;

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
	public void testBasic1ParseDescriptors() {
		ClassLoader classLoader = DescriptorParserImpl.class.getClassLoader();
		URL path = classLoader.getResource("basicTest1.descriptor");
		DescriptorParserImpl parser = new DescriptorParserImpl( new File (path.getFile()).toPath().getParent());
		
		DbType dbType = new DbType("basic");
		parser.parseFile(new File(path.getFile()), dbType, false);
		System.out.println(dbType.toString());	
	}

	@Test
	public void testBasic2ParseDescriptors() {
		ClassLoader classLoader = DescriptorParserImpl.class.getClassLoader();
		URL path = classLoader.getResource("basicTest2.descriptor");
		DescriptorParserImpl parser = new DescriptorParserImpl( new File (path.getFile()).toPath().getParent());
		
		DbType dbType = new DbType("basic");
		parser.parseFile(new File(path.getFile()), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testCassandraParseDescriptors() {
		Path path = Paths.get("/home/vsaravag/git/obs-prototype/modeling"
				+ "/workspace/observability/src/com/observability/modeling/"
				+ "probe/descriptor/resources/cassandra.descriptor"); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("cassandra");
		
		parser.parseFile(path.toFile(), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testPostgresParseDescriptors() {
		ClassLoader classLoader = DescriptorParserImpl.class.getClassLoader();
		URL path = classLoader.getResource("postgres.descriptor");
		DescriptorParserImpl parser = new DescriptorParserImpl( new File (path.getFile()).toPath().getParent());
		
		DbType dbType = new DbType("postgres");
		parser.parseFile(new File(path.getFile()), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testMongoParseDescriptors() {
		ClassLoader classLoader = DescriptorParserImpl.class.getClassLoader();
		URL path = classLoader.getResource("mongodb.descriptor");
		DescriptorParserImpl parser = new DescriptorParserImpl( new File (path.getFile()).toPath().getParent());
		
		DbType dbType = new DbType("mongo");
		parser.parseFile(new File(path.getFile()), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testFeatureParseDescriptors() {
		Path path = Paths.get("/home/vsaravag/git/obs-prototype/modeling"
				+ "/workspace/observability/src/com/observability/modeling/"
				+ "probe/descriptor/resources/features.descriptor"); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("");
		
		parser.parseFile(path.toFile(), dbType, true);
		System.out.println(parser.getFeatures());		
	}
	
	@Test
	public void testDirectoryDescriptor(){
		ClassLoader classLoader = DescriptorParserImpl.class.getClassLoader();
		URL path = classLoader.getResource("mongodb.descriptor");
		DescriptorParserImpl parser = new DescriptorParserImpl( new File (path.getFile()).toPath().getParent());
		
		parser.parseDescriptors();
	}
}
