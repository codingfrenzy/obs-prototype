package com.observability.monitoring.server;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import com.observability.monitoring.daemon.IDaemonManagerServer;

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
	
	@Test
	public void testFileOperationHelpers2() {
		//IModelHandlerServer.FileOperationHelper.createDirectory(dirName);
		IModelHandlerServer.FileOperationHelper.unzipFile("foo", "bar");
		
	}
	
	@Test
	public void testFileOperationHelpers3() {
		IModelHandlerServer.FileOperationHelper.createDirectory(dirName);
		IModelHandlerServer.FileOperationHelper.createDirectory(subFilePath);
		PrintWriter writer;
		try {
			writer = new PrintWriter(dirName + "/1.txt", "UTF-8");
			writer.println("The first line");
			writer.println("The second line");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//deleteDirectoryContents
		IModelHandlerServer.FileOperationHelper.deleteDirectoryContents(new File(dirName));
		//IModelHandlerServer.FileOperationHelper.deleteDirectoryContents(new File(dirName));
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
			
			ret = modelhandler.endFileUpload("");
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

	@Test
	public void testmain() {
		String []args = new String[2];
		args[0] = "1.2.3.4";
		args[1] = "12321";
		ModelHandler.main(args);
	}
	
	@Test
	public void testmain1() {
		String []args = new String[1];
		args[0] = "1.2.3.4";
		ModelHandler.main(args);
	}
	
	@Test
	public void testmain2() {
		String []args = new String[0];
		
		ModelHandler.main(args);
	}
	
	@Test
	public void testdeployModel() {
		ModelHandler mh = null;
		try {
			mh = new ModelHandler();
			mh.deployModel("target");
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Test
	public void testDaemonManagerClient() {
		IDaemonManagerServer si = DaemonManagerClient.getServerInstance("52.6.202.212", "8101");
		if(si == null)
			System.out.println("null pointer");
		else
			System.out.println(si.toString());
	}
}
