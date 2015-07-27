/**
 * 
 */
package com.observability.monitoring.server;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.observability.modeling.common.UI;
import com.observability.modeling.emf.extension.EclipseResourceDelegate;
import com.observability.modeling.probe.descriptor.DescriptorFilter;
import com.observability.monitoring.server.ModelHandler;

/**
 * @author vsaravag
 *
 */
public class ModelHandlerTest {
	
	private static UI mockUI = null;
	private static ModelHandler mh = null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass @Ignore
	public static void setUpBeforeClass() throws Exception {
		mh = ModelHandler.getInstance();
		mockUI = mock(UI.class);
		mh.setUI(mockUI);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	/**
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#connectRMI(java.nio.file.Path)}.
	 */
	public void testRMIRemoteException(){
		ModelHandler.modelHandlerService = "ModelHandler";
		Throwable e = null;
		try{
			mh.connectRMI("127.1.1.1", "8000");
		}
		catch(Exception ex){
			e = ex;
		}
		assertTrue(e instanceof RemoteException);		
	}
	
	@Test @Ignore
	/**
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#connectRMI(java.nio.file.Path)}.
	 */
	public void testRMINotBound(){
		ModelHandler.modelHandlerService = "test";
		Throwable e = null;
		try{
			mh.connectRMI("127.0.0.1", "8101");
		}
		catch(Exception ex){
			e = ex;		
		}
		assertTrue(e instanceof NotBoundException);
	}
	
	@Test @Ignore
	/**
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#connectRMI(java.nio.file.Path)}.
	 */
	public void testRMIMalformedURL(){
		ModelHandler.modelHandlerService = "test";
		Throwable e = null;
		try{
			mh.connectRMI("127.0.0.1", "8&101");
		}
		catch(Exception ex){
			e = ex;			
		}
		assertTrue(e instanceof MalformedURLException);
	}
	
	/**
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#getDescriptorFiles(java.nio.file.Path)}.
	 * Happy Path case
	 */ 
	@Test @Ignore
	public void testGetDescriptorFiles() {
		ModelHandler.modelHandlerService = "ModelHandler";
		try{
			String[] params = new String[2];
			params[0] = "127.0.0.1";
			params[1] = "8101";
			
			when(mockUI.getServerDetails(JOptionPane.PLAIN_MESSAGE,	"")).thenReturn(params);
			Path dirPath = Paths.get(ModelHandlerTest.class.getResource("Pathtest").getPath()).getParent();
			if(dirPath!=null){
				mh.getDescriptorFiles(dirPath);
				Path descDirPath = dirPath.resolve(EclipseResourceDelegate.PROBE_DESCRIPTOR_DIR_PATH);
				assertTrue(Files.exists(descDirPath, LinkOption.NOFOLLOW_LINKS));
				assertEquals(descDirPath.toFile().listFiles().length, 5);
			}			
		}
		catch(Exception e){
			fail("Exception raised. Test failed");
		}
	}
	
	/**
	 * 
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#getDescriptorFiles(java.nio.file.Path)}.
	 * Null path given to the method
	 */
	@Test @Ignore
	public void testNullDescriptorPath(){
		Throwable e = null;
		try{
			mh.getDescriptorFiles(null);
		}
		catch(Exception ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
	}
	
	/**
	 * 
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#getDescriptorFiles(java.nio.file.Path)}.
	 * No ip/port specified. Transfer not done.
	 */
	@Test @Ignore
	public void testGetDescriptorFilesNoTransfer() {
		ModelHandler.modelHandlerService = "ModelHandler";
		try{
			String[] params = new String[0];
			
			when(mockUI.getServerDetails(JOptionPane.PLAIN_MESSAGE,	"")).thenReturn(params);
			Path dirPath = Paths.get(ModelHandlerTest.class.getResource("Pathtest").getPath()).getParent();
			if(dirPath!=null){
				mh.getDescriptorFiles(dirPath);
				Path descDirPath = dirPath.resolve(EclipseResourceDelegate.PROBE_DESCRIPTOR_DIR_PATH);
				assertTrue(!Files.exists(descDirPath, LinkOption.NOFOLLOW_LINKS));	
			}			
		}
		catch(Exception e){
			fail("Exception raised. Test failed");
		}
	}
	
	/**
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#getDescriptorFiles(java.nio.file.Path)}.
	 * No permission to create directory
	 */
	@Test @Ignore
	public void testGetDescriptorFilesPermissions() {
		ModelHandler.modelHandlerService = "ModelHandler";
		Throwable e = null;
		Path dirPath = null;
		Path descDirPath = null;
		try{
			String[] params = new String[2];
			params[0] = "127.0.0.1";
			params[1] = "8101";
			
			when(mockUI.getServerDetails(JOptionPane.PLAIN_MESSAGE,	"")).thenReturn(params);
			dirPath = Paths.get(ModelHandlerTest.class.getResource("Pathtest").getPath()).getParent();
			if(dirPath!=null){
				dirPath.toFile().setReadOnly();
				descDirPath = dirPath.resolve(EclipseResourceDelegate.PROBE_DESCRIPTOR_DIR_PATH);
				mh.getDescriptorFiles(dirPath);
			}			
		}
		catch(Exception ex){
			e = ex;
			dirPath.toFile().setWritable(true);
			if(descDirPath!=null)
				assertTrue(!Files.exists(descDirPath, LinkOption.NOFOLLOW_LINKS));
			assertTrue(e instanceof RuntimeException);
		}
	}
	
	/**
	 * 
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#getDescriptorFiles(java.nio.file.Path)}.
	 */
	@Test @Ignore
	public void testGetDescriptorFilesZip() {
		ModelHandler.modelHandlerService = "ModelHandler";
		Path dirPath = null;
		try{
			String[] params = new String[2];
			params[0] = "127.0.0.1";
			params[1] = "8101";
			
			when(mockUI.getServerDetails(JOptionPane.PLAIN_MESSAGE,	"")).thenReturn(params);
			dirPath = Paths.get(ModelHandlerTest.class.getResource("Pathtest").getPath()).getParent();
			if(dirPath!=null){
				mh.getDescriptorFiles(dirPath);
				Path descDirPath = dirPath.resolve(EclipseResourceDelegate.PROBE_DESCRIPTOR_DIR_PATH);
				assertEquals(descDirPath.toFile().listFiles(new DescriptorFilter()).length,5);
			}			
		}
		catch(Exception ex){
			fail("Exception raised");
		}
	}

	/**
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#deployFile(java.lang.String, java.lang.String)}.
	 */
	@Test @Ignore
	public void testDeployFile() {
		try{ 
			ModelHandler.modelHandlerService = "ModelHandler";
			String target = Paths.get(ModelHandlerTest.class.getResource("My.zip").
					getPath()).toString();
			String[] params = new String[2];
			params[0] = "127.0.0.1";
			params[1] = "8101";
			
			when(mockUI.getServerDetails(JOptionPane.PLAIN_MESSAGE,	"")).thenReturn(params);
			mh.deployFile(target, "deploy");
		}
		catch(Exception ex){
			fail("Exception raised");
		}
	}

	/**
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#deployFile(java.lang.String, java.lang.String)}.
	 */
	@Test @Ignore
	public void testDeployFileFail() {
		Throwable e = null;
		try{ 
			ModelHandler.modelHandlerService = "ModelHandler";
			String target = Paths.get(ModelHandlerTest.class.getResource("Pathtest").
					getPath()).toString();
			String[] params = new String[2];
			params[0] = "127.0.0.1";
			params[1] = "8101";
			
			when(mockUI.getServerDetails(JOptionPane.PLAIN_MESSAGE,	"")).thenReturn(params);
			mh.deployFile(target, "deploy");
		}
		catch(Exception ex){
			e = ex;
			assertTrue(e instanceof RuntimeException);
		}
	}
	

	/**
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#deployFile(java.lang.String, java.lang.String)}.
	 */
	@Test @Ignore
	public void testDeployFileLarge() {
		try{ 
			ModelHandler.modelHandlerService = "ModelHandler";
			String target = Paths.get(ModelHandlerTest.class.getResource("Large.zip").
					getPath()).toString();
			String[] params = new String[2];
			params[0] = "127.0.0.1";
			params[1] = "8101";
			
			when(mockUI.getServerDetails(JOptionPane.PLAIN_MESSAGE,	"")).thenReturn(params);
			mh.deployFile(target, "large");
		}
		catch(Exception ex){
			ex.printStackTrace();
			fail("Exception raised");
		}
	}
	
	@After @Ignore
	public void tearDown(){
		Path dirPath = Paths.get(ModelHandlerTest.class.getResource("Pathtest").getPath()).getParent();
		if(dirPath!=null){
			File descDir = dirPath.resolve(EclipseResourceDelegate.PROBE_DESCRIPTOR_DIR_PATH).toFile();
			if(descDir != null){
				File[] files = descDir.listFiles();
				if(files!=null && files.length > 0){
					for(File file : files){
						if(!file.getName().equals("Pathtest") && !file.getName().equals("My.zip")
								&& !file.getName().equals("Large.zip"))
							file.delete();
					}
					descDir.delete();	
				}
					
			}			
		}
		else{
			fail("File \"Pathtest\" is not there in resources");
		}
		
	}
	
}
