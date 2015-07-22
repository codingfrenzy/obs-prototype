/**
 * 
 */
package com.observability.monitoring.server;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.observability.modeling.emf.extension.EclipseResourceDelegate;

/**
 * @author vsaravag
 *
 */
public class ModelHandlerTest {

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
	}

	/**
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#getDescriptorFiles(java.nio.file.Path)}.
	 */
	@Test
	public void testGetDescriptorFiles() {
		try{
			Path dirPath = Paths.get(ModelHandlerTest.class.getResource("Pathtest").getPath()).getParent();
			if(dirPath!=null){
				ModelHandler.getDescriptorFiles(dirPath);
				Path descDirPath = dirPath.resolve(EclipseResourceDelegate.PROBE_DESCRIPTOR_DIR_PATH);
				assertTrue(Files.exists(descDirPath, LinkOption.NOFOLLOW_LINKS));	
			}			
		}
		catch(Exception e){
			fail("Exception raised. Test failed");
		}
	}
	
	@Test
	public void testNullDescriptorPath(){
		Throwable e = null;
		try{
			ModelHandler.getDescriptorFiles(null);
		}
		catch(Exception ex){
			e = ex;
		}
		assertTrue(e instanceof NullPointerException);
	}
	
	@Test
	public void testGetServerDetails(){
		try{
			ModelHandler.getDescriptorFiles(Paths.get("."));
			Robot robot = new Robot();
			robot.setAutoDelay(40);
			robot.setAutoWaitForIdle(true);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	/**
	 * Test method for {@link com.observability.monitoring.server.ModelHandler#deployFile(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDeployFile() {
		try{
			String target = Paths.get(ModelHandlerTest.class.getResource("descriptors.zip").
					getPath()).toString();
			ModelHandler.ip = "127.0.0.1";
			ModelHandler.port = "8101";
			ModelHandler.deployFile(target, "descriptors");
		}
		catch(Exception ex){
			
		}
	}
	
}
