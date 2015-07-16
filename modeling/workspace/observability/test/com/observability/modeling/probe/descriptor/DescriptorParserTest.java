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

	@Test
	public void testParseDescriptors(){
		String descriptorDirPath = "/home/vsaravag/git/obs-prototype/modeling"
				+ "/workspace/observability/src/resources";
		DescriptorParserImpl desc = new DescriptorParserImpl(Paths.get(descriptorDirPath));
		desc.parseDescriptors();
		System.out.println(desc.getPlugins());
	}
	@Test
	public void testCassandraParseDescriptors() {
		Path path = Paths.get("/home/vsaravag/git/obs-prototype/modeling"
				+ "/workspace/observability/src/resources/cassandra.descriptor"); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("cassandra");
		
		parser.parseFile(path.toFile(), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testPostgresParseDescriptors() {
		Path path = Paths.get("/home/vsaravag/git/obs-prototype/modeling"
				+ "/workspace/observability/src/resources/postgres.descriptor"); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("postgres");
		
		parser.parseFile(path.toFile(), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testMongoParseDescriptors() {
		Path path = Paths.get("/home/vsaravag/git/obs-prototype/modeling"
				+ "/workspace/observability/src/resources/mongo.descriptor"); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("mongo");
		
		parser.parseFile(path.toFile(), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testRedisParseDescriptors() {
		Path path = Paths.get("/home/vsaravag/git/obs-prototype/modeling"
				+ "/workspace/observability/src/resources/redis.descriptor"); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("redis");
		
		parser.parseFile(path.toFile(), dbType, false);
		System.out.println(dbType.toString());	
	}
	
	@Test
	public void testFeatureParseDescriptors() {
		Path path = Paths.get("/home/vsaravag/git/obs-prototype/modeling"
				+ "/workspace/observability/src/resources/features.descriptor"); 
		DescriptorParserImpl parser = new DescriptorParserImpl(path);
		DbType dbType = new DbType("");
		
		parser.parseFile(path.toFile(), dbType, true);
		System.out.println(parser.getFeatures());		
	}
	
}
