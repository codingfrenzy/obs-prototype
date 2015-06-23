package com.observability.monitoring.server;

import static org.junit.Assert.*;

import java.io.File;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class ModelHandlerTest {

	private String dirName = "/home/joel/dummy";
	
	@Test
	public void testFileOperationHelperdeleteDirectoryContents() {
		
		IModelHandlerServer.FileOperationHelper.deleteDirectoryContents(new File(dirName));
	}
	/*
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testModelHandler() {
		fail("Not yet implemented");
	}

	@Test
	public void testBeginFileUpload() {
		fail("Not yet implemented");
	}

	@Test
	public void testUploadFileChunk() {
		fail("Not yet implemented");
	}

	@Test
	public void testEndFileUpload() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeployModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitializeService() {
		fail("Not yet implemented");
	}
	*/

}
