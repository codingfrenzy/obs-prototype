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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.observability.modeling.emf.extension.EclipseResourceDelegate;
import com.observability.monitoring.server.IModelHandlerServer;


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
	
	// name of the descriptor file 
	private static final String DESCRIPTOR_FILE_NAME = "descriptors.zip";
	
	// max size in which the files would be transferred over the network.
	private static final int MAX_BLOCK_SIZE = 1024*512;
	
	//Service name where the Model Handler is running
	private static final String MODEL_HANDLER_SERVICE = "ModelHandler";
	
	// server RMI instance
	private static IModelHandlerServer svr = null;
	
	// ip where the Model Handler service is running
	static String ip = null;
	
	// port where the Model Handler service is running
	static String port = null;

	/**
	 * Get the descriptor files from the central server and store them in the 
	 * project directory.
	 * @param dirPath the absolute path of the project root
	 * @throws Exception generic exception to catch any error
	 */
	public static void getDescriptorFiles(Path dirPath) throws Exception{
		if(dirPath == null){
			throw new NullPointerException("Invalid project directory path");
		}
		// get the ip and port where the model handler service is running.
		String[] serverDetails = ModelHandler.getServerDetails(JOptionPane.PLAIN_MESSAGE, "");
		if(serverDetails.length == 0){
			return;
		}
		else {
			ip = serverDetails[0];
			port = serverDetails[1];
		}
		// connect to the RMI
		connectRMI(ip, port);
		// create descriptor directory path in the project
		Path descDirPath = dirPath.resolve(EclipseResourceDelegate.PROBE_DESCRIPTOR_DIR_PATH);
		
		// create descriptor directory
		if(!IModelHandlerServer.FileOperationHelper.createDirectory(descDirPath.toString())){
			// Unable to create directory. Abort
			throw new RuntimeException("Unable to create descriptors directory. Please check permissions");
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
			throw new RuntimeException("Failed to get correct descriptor file from server. Please try again\n");
		}
		
		// unzip the file and delete the zip.
		int result = IModelHandlerServer.FileOperationHelper.unzipFile(descFile.toString(), descDirPath.toString());
		if(result <=0){
			// Error in unzipping. Abort
			String message = "";
			switch(result) {
			case -21:
				message += "Zip format not supported.";
				break;
			case -22:
				message += "Zip file not valid.";
				break;
			case -23:
				message += "Zip file cannot be read due to security reasons.";
			default:
				message += "";
				break;			
			}
			IModelHandlerServer.FileOperationHelper.deleteFile(descFile);
			throw new RuntimeException("Descriptor files cannot be unzipped. " + message);
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
	private static void connectRMI(String ip, String port) throws Exception{
		try {
			svr = (IModelHandlerServer) Naming.lookup(String.format(
					("//%s:%s/" + MODEL_HANDLER_SERVICE), ip, port));
		} catch (RemoteException e) {
			throw e;
		} catch (NotBoundException e) {
			throw new NotBoundException("Failed to connect to the server (" + ip + ":" + port + ")");
		} catch (MalformedURLException e) {
			throw new MalformedURLException("Please check Ip and Port provided");
		}
		
		if (svr == null) {
			throw new RuntimeException("Failed to bind with the server. Please check if the server is up and running");
		}
	}
	
	/**
	 * This method gets the server details (ip and port) where the ModelHandler RMI service
	 * is running. It shows an input dialog where the user would enter the ip and port where
	 * the RMI service is running. 
	 * If the user presses Cancel, the action would be cancelled and nothing would be done. 
	 * 
	 * The user input is validated before being accepted. Currently only ipv4 addresses are accepted.
	 * 
	 * @param messageType the type of the message to be shown in the dialog box.
	 * The values should be used from JOptionPane class.
	 * @param message Any additional message which needs to be appended before the default input message
	 * 
	 * @return A String array containing ip and port. Index 0 contains ip, index 1 contains port
	 */
	 static String[] getServerDetails(int messageType, String message){
		
		String input = (String)JOptionPane.showInputDialog(null,
				(message + "Enter the IP and port where the Model Handler service is running, in the format -> ip:port"),				
				"Server Details", messageType);

		if (input == null){ 
			//user has pressed cancel button. Take confirmation from user
			String msg = "Model creation cannot continue unless the descriptor files are obtained."
					+ " Do you want to continue?";
			int option = JOptionPane.showConfirmDialog(null, msg, "",JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION){
				// Do not transfer files to server
				return new String[0]; 
			}
			else {
				// show the box again
				return getServerDetails(JOptionPane.INFORMATION_MESSAGE, "");
			}
		}
		else{
			//validate input
			String ipRegex = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}):(\\d{1,5})";
			Pattern pattern = Pattern.compile(ipRegex);
			Matcher matcher = pattern.matcher(input);
			String[] serverDetails = new String[2];
			if(matcher.matches()){
				serverDetails[0] = matcher.group(1); //ip
				serverDetails[1] = matcher.group(2); //port
			}
			else {
				//wrong input. Get input again
				return getServerDetails(JOptionPane.WARNING_MESSAGE, "Input is not in correct format.\n");
			}
			
			return serverDetails;	
		}
	}
	
	/**
	 * Deploy the generated file to the server
	 * @param target the absolute path of the file which is to be transferred
	 * @param fileName the name of the file, without the extension.
	 * @return integer containing the number of files deployed by the server
	 * @throws Exception generic exception to catch any error.
	 */
	public static int deployFile(String target, String fileName) throws Exception{
		if(ip == null || port == null){
			// get the ip and port where the model handler service is running.
			String[] serverDetails = getServerDetails(JOptionPane.PLAIN_MESSAGE, "");
			if(serverDetails.length == 0){
				return -1;
			}
			else {
				ip = serverDetails[0];
				port = serverDetails[1];
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
					if(fIn.skip(skipBytes)!= skipBytes){
						// bytes skipped actually are not equal to the bytes meant to be skipped. Abort
						fIn.close();
						throw new IOException("Error in reading zip");
					}
					
					byte[] bytes = new byte[bufferSize];
					if(fIn.read(bytes)!=-1){
						// No more bytes to read. Write file to the server
						svr.uploadFileChunk(bytes);
					}
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
				// Failure in ending the process. Abort.
				switch(uploadStatus){
				case -1:
					throw new RuntimeException("Error in zip file");
				case -2:
					throw new RuntimeException("There has been an error in MD5 verification");
				case -3:
					throw new RuntimeException("There has been an error on server");
				case -21:
					throw new RuntimeException("The zip format is not supported");
				case -22:
					throw new RuntimeException("The zip file is not valid");
				case -23:
					throw new RuntimeException("The zip file cannot be read due to security reasons");
				case -24:
					throw new RuntimeException("Target directory cannot be created");
				}
				return -2;
			}
		}
		else {
			throw new RuntimeException("File upload could not be started");
		}
		return 0;
	}
}
