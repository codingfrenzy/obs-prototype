package com.observability.monitoring.server;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class ModelHandlerTest {

	private String dirName = "/home/joel/dummy";
	private String subFilePath = "/home/joel/dummy/100";
	
	@Test
	public void testFileOperationHelpers() {
		IModelHandlerServer.FileOperationHelper.getFileMD5(null);
		IModelHandlerServer.FileOperationHelper.getFileMD5(dirName);
		IModelHandlerServer.FileOperationHelper.createDirectory(dirName);
		IModelHandlerServer.FileOperationHelper.createDirectory(dirName);
		File f = new File(subFilePath);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//deleteDirectoryContents
		IModelHandlerServer.FileOperationHelper.deleteDirectoryContents(new File("123"));
		IModelHandlerServer.FileOperationHelper.deleteDirectoryContents(new File(dirName));
	}
	
	private ModelHandler modelhandler = null;
	
	@Before
	public void setUp() throws Exception {
		try {
			modelhandler = new ModelHandler();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testModelHandler() {
		ModelHandler mh = null;
		try {
			mh = new ModelHandler();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(mh);
	}

	@Test
	public void testBeginFileUpload() {
		try {
			boolean b1 = modelhandler.beginFileUpload("1234");
			
			boolean b2 = modelhandler.beginFileUpload("5678");
			assertTrue(b1 && b2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUploadFileChunk() {
		try {
			boolean b1 = modelhandler.uploadFileChunk(null);
			assertFalse(b1);
			
			b1 = modelhandler.beginFileUpload("5678");
			assertTrue(b1);
			byte [] buf = new byte[10];
			for(int i = 0 ; i < 10 ; i++)
				buf[i] = (byte)i;
			b1 = modelhandler.uploadFileChunk(buf);
			assertTrue(b1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testEndFileUpload() {
		try {
			int ret = modelhandler.endFileUpload(null);
			assertTrue(ret < 0);
			
			boolean b1 = modelhandler.beginFileUpload("5678");
			assertTrue(b1);
			byte [] buf = new byte[100];
			for(int i = 0 ; i < 100 ; i++)
				buf[i] = (byte)i;
			b1 = modelhandler.uploadFileChunk(buf);
			assertTrue(b1);
			modelhandler.endFileUpload("7acedd1a84a4cfcb6e7a16003242945e");
			
			b1 = modelhandler.beginFileUpload("5678");
			assertTrue(b1);
			b1 = modelhandler.uploadFileChunk(buf);
			assertTrue(b1);
			modelhandler.endFileUpload("1234");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeployModel() {
		try {
			modelhandler.deployModel("1234");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testInitializeService() {
		ModelHandler.initializeService("127.0.0.1", "12348");
	}

}
