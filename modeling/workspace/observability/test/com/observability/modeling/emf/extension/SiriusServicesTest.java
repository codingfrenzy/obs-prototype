/**
 * 
 */
package com.observability.modeling.emf.extension;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.observability.modeling.emf.DatabaseCluster;
import com.observability.modeling.emf.EmfFactory;
import com.observability.modeling.emf.Model;
import com.observability.modeling.probe.descriptor.DescriptorFilter;
import com.observability.modeling.probe.descriptor.DescriptorParser;
import com.observability.modeling.probe.descriptor.DescriptorParserImpl;
import com.observability.modeling.probe.descriptor.DescriptorParserTest;
import com.observability.modeling.probe.descriptor.entities.DbType;
import com.observability.modeling.probe.descriptor.entities.Feature;

/**
 * @author gemici
 *
 */
public class SiriusServicesTest {

	private static DescriptorParser parser = null ;
	private static Path descriptorPath = null;
	private static EmfFactory factory = EmfFactory.eINSTANCE;
	private static Model model = null;
	private static EclipseResourceDelegate mockEclipse = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		File descriptor = new File (DescriptorParserTest.class.getResource("cassandra.descriptor").getFile());
		Path path = descriptor.toPath(); 
		parser = new DescriptorParserImpl(path.getParent());
		parser.parseDescriptors();
		descriptorPath= path.getParent();
		
		
		model = factory.createModel(); 
		
		if(descriptorPath == null)
			fail();
		copyToDecriptorsPath(descriptorPath);
		
		mockEclipse = mock(EclipseResourceDelegate.class);
		when(mockEclipse.getDescriptorPath()).thenReturn(new File (descriptorPath.toString()));
		
		
	}
	private static void copyToDecriptorsPath(Path descriptorPath) throws IOException {
		Path targetPath = descriptorPath.resolve(EclipseResourceDelegate.PROBE_DESCRIPTOR_DIR_PATH);
		if(!Files.exists(targetPath))
			Files.createDirectory(targetPath);
		
		File descriptorDir = new File(descriptorPath.toString());
		File[] files = descriptorDir.listFiles(new DescriptorFilter());
		if(files == null)
			fail();
		for(int i = 0; i< files.length;i++){
			if(!Files.exists(targetPath.resolve(files[i].getName())))
				Files.copy(descriptorPath.resolve(files[i].getName()), targetPath.resolve(files[i].getName()), StandardCopyOption.COPY_ATTRIBUTES);
		}
		
	}
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
		deleteDescriptorsPath();
		
	}

	private static void deleteDescriptorsPath() throws IOException {
		Path targetPath = descriptorPath.resolve(EclipseResourceDelegate.PROBE_DESCRIPTOR_DIR_PATH);
		Files.delete(targetPath);
		
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
	 * Test method for {@link com.observability.modeling.emf.extension.CustomServices#parseDescriptors()}.
	 */
	@Test
	public void testParseDescriptors() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.observability.modeling.emf.extension.CustomServices#parseDescriptors(java.nio.file.Path)}.
	 */
	@Test
	public void testParseDescriptorsPath() {
		SiriusServices services = SiriusServices.getInstance(mockEclipse);
		
		services.parseDescriptors(descriptorPath);
		List<Feature> features = parser.getFeatures();
		List<DbType> dbTypes = parser.getPlugins();
		assertNotNull(features);
		assertNotNull(dbTypes);
		assertTrue(features.size()>0);
		assertTrue(dbTypes.size()> 0);
	}
	/**
	 * Test method for {@link com.observability.modeling.emf.extension.CustomServices#parseDescriptors(java.nio.file.Path)}.
	 */
	@Test(expected=RuntimeException.class)
	public void testParseDescriptorsFilesNotThere() {
		
		SiriusServices services = SiriusServices.getInstance(mockEclipse);
		services.parseDescriptors(Paths.get("notexists"));
	}

	/**
	 * Test method for {@link com.observability.modeling.emf.extension.CustomServices#initializeModel(com.observability.modeling.emf.Model, java.nio.file.Path)}.
	 */
	@Test
	public void testInitializeModel() {
		SiriusServices services = SiriusServices.getInstance(mockEclipse);
		services.initializeModel(model, descriptorPath);
		assertTrue(model.getAvailableDbTypes().size() == 6);
	}

	/**
	 * Test method for {@link com.observability.modeling.emf.extension.CustomServices#initializeMachine(org.eclipse.emf.ecore.EObject)}.
	 */
	@Test
	public void testInitializeMachine() {
		SiriusServices services = SiriusServices.getInstance(mockEclipse);
				
		DatabaseCluster cluster = factory.createDatabaseCluster();
		com.observability.modeling.emf.DbType dbType = factory.createDbType();
		dbType.setName("cassandra");
		cluster.setAssociatedDbType(dbType);
		services.initializeMachine((EObject)cluster);
		assertTrue(cluster.getMachines().size() == 1);
	}

	/**
	 * Test method for {@link com.observability.modeling.emf.extension.CustomServices#createNodes(com.observability.modeling.emf.DatabaseCluster, int)}.
	 */
	@Test
	public void testCreateNodes() {
		SiriusServices services = SiriusServices.getInstance(mockEclipse);
		DatabaseCluster cluster = factory.createDatabaseCluster();
		com.observability.modeling.emf.DbType dbType = factory.createDbType();
		dbType.setName("cassandra");
		cluster.setAssociatedDbType(dbType);

		services.createNodes(cluster, 3);
		assertTrue(cluster.getMachines().size() == 3);
		assertTrue(cluster.getNoOfMachines() == 3);

	}

	/**
	 * Test method for {@link com.observability.modeling.emf.extension.CustomServices#addMetricSpecificParamsToMachinesInCluster(com.observability.modeling.emf.DatabaseCluster, com.observability.modeling.emf.Metric)}.
	 */
	@Test
	public void testAddMetricSpecificParamsToMachinesInCluster() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.observability.modeling.emf.extension.CustomServices#getMatchingElements(com.observability.modeling.emf.Metric, com.observability.modeling.emf.DbType)}.
	 */
	@Test
	public void testGetMatchingElements() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.observability.modeling.emf.extension.CustomServices#CustomServices()}.
	 */
	@Test
	public void testCustomServices() {
		fail("Not yet implemented");
	}

}
