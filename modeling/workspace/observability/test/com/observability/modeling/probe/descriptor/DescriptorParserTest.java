/**
 * 
 */
package com.observability.modeling.probe.descriptor;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
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

	@Test
	public void testParseDescriptors(){
		File descriptor = new File (DescriptorParserTest.class.getResource("cassandra.descriptor").getFile());
		Path path = descriptor.toPath(); 
		DescriptorParserImpl desc = new DescriptorParserImpl(path.getParent());
		desc.parseDescriptors();
		System.out.println(desc.getPlugins());
	}
	
	@Test
	public void testNegativeParseDescriptors(){
		File descriptor = new File (DescriptorParserTest.class.getResource("cassandra.descriptor").getFile());
		Path path = descriptor.toPath(); 
		DescriptorParserImpl desc = new DescriptorParserImpl(path);
		desc.parseDescriptors();
		System.out.println(desc.getPlugins());
	}
	
	@Test
	public void testCassandraParseDescriptors() throws FileNotFoundException {
		File descriptor = new File (DescriptorParserTest.class.getResource("cassandra.descriptor").getFile());
		Path path = descriptor.toPath(); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("cassandra");
		
		parser.parseFile(path.toFile(), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testPostgresParseDescriptors() throws FileNotFoundException {
		File descriptor = new File (DescriptorParserTest.class.getResource("postgres.descriptor").getFile());
		Path path = descriptor.toPath(); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("postgres");
		
		parser.parseFile(path.toFile(), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testMongoParseDescriptors() throws FileNotFoundException {
		File descriptor = new File (DescriptorParserTest.class.getResource("mongo.descriptor").getFile());
		Path path = descriptor.toPath(); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("mongo");
		
		parser.parseFile(path.toFile(), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testRedisParseDescriptors() throws FileNotFoundException {
		File descriptor = new File (DescriptorParserTest.class.getResource("redis.descriptor").getFile());
		Path path = descriptor.toPath(); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("redis");
		
		parser.parseFile(path.toFile(), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testFeatureParseDescriptors() throws FileNotFoundException {
		
		File descriptor = new File (DescriptorParserTest.class.getResource("central.descriptor").getFile());
		Path path = descriptor.toPath();  
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("");
		
		parser.parseFile(path.toFile(), dbType, true);
		System.out.println(parser.getFeatures());		
	}
	
	@Test
	public void testDescriptorDoesNotExist() {
		Throwable e = null;
		File descriptor = new File ("");
		Path path = descriptor.toPath(); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("redis");
		try{
			parser.parseFile(path.toFile(), dbType, false);
		}
		catch(Throwable ex){
			e = ex;
		}
		assertTrue(e instanceof FileNotFoundException);
	}
	
}
