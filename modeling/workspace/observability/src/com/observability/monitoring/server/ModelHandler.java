//**************************************************************************************************//
/* Observability Project
 * Copyright 2015 Master of Software Engineering team: Laila Alhmound, Ying (Joel) Gao, Caglayan Gem, Rajat Kapoor, Prasanth Nair, Varun Saravagi
 * Copyright 2015 Institute for Software Research | School of Computer Science | Carnegie Mellon University
 * Copyright 2015 Software Engineering Institute
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses/>.
 */
//**************************************************************************************************//

package com.observability.monitoring.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import org.eclipse.jface.dialogs.IMessageProvider;

import com.observability.modeling.emf.extension.EclipseResourceDelegate;
import com.observability.modeling.common.*;
/**
 * The class contains the operations required to interact with the server.
 * It fetches the descriptor files from the server and transfers the configuration
 * files to the server.
 * 
 * @author vsaravag
 * <p>
 * History <br>
 * 1. Create			June 23 2015 <br>
 * 2. Add code to fetch descriptor files from server		July 21 2015 <br>
 * 
 */
public class ModelHandler {
	
	/**
	 * name of the descriptor zip file
	 */
	private static final String DESCRIPTOR_FILE_NAME = Messages.ModelHandler_CONSTANTS_DESCRIPTOR_FILE_NAME;
	
	/**
	 * max size in which the files would be transferred over the network.
	 */
	private static final int MAX_BLOCK_SIZE = 1024*512;
	
	/**
	 * Service name where the Model Handler is running 
	 */
	static String modelHandlerService = Messages.ModelHandler_CONSTANTS_MODEL_HANDLER_RMI_SERVICE_NAME;
	
	/**
	 * server RMI instance
	 */
	private IModelHandlerServer svr = null;
	
	/**
	 * ip where the Model Handler service is running
	 */
	private String ip = null;
	
	/**
	 * port where the Model Handler service is running
	 */
	private String port = null;
	
	/**
	 * instance of the UI {@link UI} class. 
	 */
	private UI uiInstance = null;
	
	/**
	 * static instance of self.
	 */
	private static volatile ModelHandler instance = null;
	
	/**
	 * Get the instance of self. Create a new instance if not created already.
	 * @return instance of self.
	 */
	public static ModelHandler getInstance(){
		if(instance == null){
			instance = new ModelHandler();
		}
		return instance;
	}
	
	/**
	 * Set the UI {@link UI} instance.
	 * The method has been created to mock the UI in unit test.
	 * <i>It should not be used otherwise.</i>
	 * @param ui instancee of UI
	 */
	public void setUI(UI ui){
		uiInstance = ui;
	}
	
	/**
	 * Constructor to implement singleton
	 */
	private ModelHandler(){
		uiInstance = new UI();
	}
	/**
	 * Get the descriptor files from the central server and store them in the 
	 * project directory.
	 * @param dirPath the absolute path of the project root
	 * @throws Exception generic exception to catch any error
	 */
	public void getDescriptorFiles(Path dirPath) throws Exception{
		if(dirPath == null){
			throw new NullPointerException(Messages.ModelHandler_MSG_ERROR_INVALID_DIRECTORY);
		}
		// get the ip and port where the model handler service is running.
		String[] ipPort = uiInstance.getServerDetails(IMessageProvider.NONE, "");
		if(ipPort.length == 0){
			return;
		}
		else{
			ip = ipPort[0];
			port = ipPort[1];
		}
		
		// connect to the RMI
		connectRMI(ip, port);
		// create descriptor directory path in the project
		Path descDirPath = dirPath.resolve(EclipseResourceDelegate.PROBE_DESCRIPTOR_DIR_PATH);
		
		// create descriptor directory
		if(!IModelHandlerServer.FileOperationHelper.createDirectory(descDirPath.toString())){
			// Unable to create directory. Abort
			throw new RuntimeException(Messages.ModelHandler_MSG_ERROR_NO_PERMISSIONS);
		};
		
		// create descriptor file
		File descFile = descDirPath.resolve(DESCRIPTOR_FILE_NAME).toFile();
		
		// get the details of the descriptor file from the server
		int nrOfBlocks = svr.getDescFileNrOfBlocks();

		// get MD5 hash of the descriptor file from the server
		String serverMd5 = svr.getDescFileMd5();

		// Get the file from the server in blocks
		FileOutputStream fOut = null;
		try{
			for (int i = 1; i <= nrOfBlocks; i++) {
				byte[] bytes;
				bytes = svr.getDescriptorFiles(i);
				if(bytes.length > 0){
					fOut = new FileOutputStream(descFile, true);
					fOut.write(bytes);
					fOut.close();	
				}				
			}
		}
		catch (IOException e){
			if(fOut!=null){
				fOut.close();	
			}			
			throw e;
		}
		
		// get the MD5 of the received file and compare it with the MD5 received from server
		String actualMd5 = IModelHandlerServer.FileOperationHelper.getFileMD5(descFile.toString());
		if(!serverMd5.equals(actualMd5)){
			// MD5 do not match. Abort
			IModelHandlerServer.FileOperationHelper.deleteFile(descFile);			
			throw new RuntimeException(Messages.ModelHandler_MSG_ERROR_GET_DESCRIPTOR);
		}
		
		// unzip the file and delete the zip.
		int result = IModelHandlerServer.FileOperationHelper.unzipFile(descFile.toString(), descDirPath.toString());
		if(result <=0){
			// Error in unzipping. Abort	
			IModelHandlerServer.FileOperationHelper.deleteFile(descFile);
			throw new RuntimeException(Messages.ModelHandler_MSG_ERROR_DESCRIPTOR_UNZIP);
		};
		// If the code reaches here, success. Delete the zip
		IModelHandlerServer.FileOperationHelper.deleteFile(descFile);
	}
	
	/**
	 * Connect to the Model Handler RMI Service
	 * @param ip IP where the service is running
	 * @param port port where the service is running
	 * @throws Exception generic exception to catch any error
	 */
	 void connectRMI(String ip, String port) throws Exception{
		try {
			svr = (IModelHandlerServer) Naming.lookup(String.format(
					("//%s:%s/" + modelHandlerService), ip, port));
		} catch (RemoteException e) {
			throw new RemoteException(Messages.ModelHandler_MSG_ERROR_CONNECTION);
		} catch (NotBoundException e) {
			throw new NotBoundException(Messages.ModelHandler_MSG_ERROR_NOT_BOUND + 
					"(" + ip + ":" + port + ")");
		} catch (MalformedURLException e) {
			throw new MalformedURLException(Messages.ModelHandler_MSG_ERROR_WRONG_URL);
		}

	}

	
	/**
	 * Deploy the generated file to the server
	 * @param target the absolute path of the file which is to be transferred
	 * @param fileName the name of the file, without the extension.
	 * @return integer containing the number of files deployed by the server
	 * @throws Exception generic exception to catch any error.
	 */
	public int deployFile(String target, String fileName) throws Exception{
		if(ip == null || port == null){
			// get the ip and port where the model handler service is running.
			String[] ipPort = uiInstance.getServerDetails(IMessageProvider.NONE, "");
			if(ipPort.length == 0){
				return -1;
			}
			else{
				ip = ipPort[0];
				port = ipPort[1];
			}
		}
		// connect to the Model Handler
		connectRMI(ip, port);
		
		// get the md5 hash of the file
		String md5 = IModelHandlerServer.FileOperationHelper.getFileMD5(target);

		if(svr.beginFileUpload(fileName)){
			// start uploading the files in blocks of maxBlockSize byte
			File file = new File(target);
			long size = file.length();
			int noOfBlocks = 1;
			if(size > MAX_BLOCK_SIZE){
				noOfBlocks = (int) Math.ceil((double)size/MAX_BLOCK_SIZE);
			}
			int skipBytes = 0;
			int bufferSize = MAX_BLOCK_SIZE;
			FileInputStream fIn = null;
			try{
				for (int i = 1; i <= noOfBlocks; i++) {
					// skip blocksize bytes if more than one block is to be sent
					if (i != 1){
						skipBytes += MAX_BLOCK_SIZE;
					}
					// if it is the last block, get the size of the block
					if(i == noOfBlocks){
						// bufferSize should decrease if the last block is less than maxBlockSize
						bufferSize = (int) (size % MAX_BLOCK_SIZE);
						bufferSize = bufferSize != 0 ? bufferSize : MAX_BLOCK_SIZE;
					}
					
					fIn = new FileInputStream(target);
					fIn.skip(skipBytes);					
					
					byte[] bytes = new byte[bufferSize];
					fIn.read(bytes);
					// No more bytes to read. Write file to the server
					svr.uploadFileChunk(bytes);					
					fIn.close();
				}
			}
			catch (IOException e){
				fIn.close();
				throw e;
			}
			
			// End the upload process.
			int uploadStatus = svr.endFileUpload(md5);
			if(uploadStatus < 0){
				throw new RuntimeException(Messages.ModelHandler_MSG_ERROR_UPLOAD);							
			}
		}
		else {
			throw new RuntimeException(Messages.ModelHandler_MSG_ERROR_UPLOAD_NOT_STARTED);
		}
		return 0;
	}
}
