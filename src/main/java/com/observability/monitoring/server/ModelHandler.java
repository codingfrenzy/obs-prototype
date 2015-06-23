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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.regex.Pattern;

import com.observability.monitoring.daemon.IDaemonManagerServer;

/**
 * ModelHandler is the a RMI service. It has the following functionalities:<br>
 * 1. Communicate with model editor to get configuration files<br>
 * 2. Save & unzip the files on disk<br>
 * 3. Propagate them to remote nodes by communicating with daemon manager<p>
 * 
 * @author Ying (Joel) Gao
 * <p>
 * History:<br>
 * 1. Created					Jun 22 2015<br>
 * 2. Modified					Jun 23 2015<br>
 * 
 */

public class ModelHandler implements IModelHandlerServer {
	// File object for handling uploaded zip file
	private RandomAccessFile 	rafZip = null;
	
	// File target name
	private String				targetName = null;
	
	/**
	 * Get the target directory by the target name
	 * @param target the target name
	 * @return directory path, null for error
	 * 
	 */
	private String getTargetFileDirectory(String target) {
		// get Canonical Path 
		String canonicalPath = null;
		try {
			canonicalPath = new File(".").getCanonicalPath();
			String combinedPath = canonicalPath + "/models/" + target;
			System.out.println(combinedPath);
			return combinedPath;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	/**
	 * Get the zip file path by the target name
	 * @param target the target name
	 * @return file path, null for error
	 * 
	 */
	private String getTargetFilePath(String target) {
		String ret = getTargetFileDirectory(target);
		return (ret == null) ? null : (ret + ".zip");
	}
	/**
	 * @see com.observability.monitoring.server.IModelHandlerServer
	 */
	@Override
	public boolean beginFileUpload(String target) throws RemoteException {
		// check the file object
		if(rafZip != null) {
			try {
				rafZip.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			rafZip = null;
		}
		
		try{
			targetName = target;
			// save it with zip appendix
			// in sub folder models
			String combinedPath = getTargetFilePath(target);
			// make sure the path exist
			File targetFile = new File(combinedPath);
			File parent = targetFile.getParentFile();
			if(!parent.exists() && !parent.mkdirs()) {
				return false;
			}
			
			// 2. Open the file from the beginning
			rafZip = new RandomAccessFile(combinedPath, "rw");
			rafZip.setLength(0);// start from 0
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		return false;
	}

	/**
	 * @see com.observability.monitoring.server.IModelHandlerServer
	 */
	@Override
	public boolean uploadFileChunk(byte[] buffer) throws RemoteException {
		if(rafZip == null)
			return false;
		
		try{
			// write file
			rafZip.write(buffer);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		return false;
	}

	/**
	 * @see com.observability.monitoring.server.IModelHandlerServer
	 */
	@Override
	public int endFileUpload(String md5) throws RemoteException {
		// 1. check file object
		if(rafZip == null || targetName == null) 
			return -1;// file error
		// Now everything should be uploaded
		// close the file
		try {
			rafZip.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		rafZip = null;
		// 2. check file md5
		String combinedPath = getTargetFilePath(targetName);
		if(combinedPath == null){
			return -1;
		}
		String calcMD5 = FileOperationHelper.getFileMD5(combinedPath);
		if(!calcMD5.equals(md5)){//MD5 checksum error
			return -2;
		}
		// 3. unzip the file into the corresponding folder
		String dir = getTargetFileDirectory(targetName);
		if(dir == null){
			return -1;
		}
		// make sure the directory is created
		if(!FileOperationHelper.createDirectory(dir)){
			return -3;
		}
		int unzipret = FileOperationHelper.unzipFile(combinedPath, dir);
		if(unzipret < 0){//unzip error
			return unzipret;
		}
		// 4. deploy the model
		
		return deployModel(targetName);
	}

	private boolean propagateConfig(String rmtIP, String rmtPort, String confPath) {
		// 1. connect to daemon manager on remote node
		IDaemonManagerServer dmServer = null;
		try{
			dmServer = DaemonManagerClient.getServerInstance(rmtIP, rmtPort);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}

		if(dmServer == null) {
			System.out.println("ModelHandler - error - Cannot connect to server: " + rmtIP + " Port: " + rmtPort);
			return false;
		}
		boolean ret = false;
		try {
			// 1. Start modifying configuration
			ret = dmServer.startConfigurationModification();
			if(!ret){//failed
				System.out.println("ModelHandler - Failed to start configuration modification to server: " + rmtIP + " Port: " + rmtPort);
				return false;
			}
			// 2. Modify the content
			// read in the whole file as a string
			String cfgData = new String(Files.readAllBytes(Paths.get(confPath)), "UTF-8");
			// Replace the whole file			
			ret = dmServer.replaceWholeConfiguration(cfgData);
			if(!ret){//failed
				System.out.println("ModelHandler - Failed to modify configuration on server: " + rmtIP + " Port: " + rmtPort);
				return false;
			}
			// 3. Stop configuration process
			ret = dmServer.stopConfigurationModification();
			if(!ret){//failed
				System.out.println("ModelHandler - Failed to end configuration modification to server: " + rmtIP + " Port: " + rmtPort);
				return false;
			}
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. send the whole configuration file
		return false;
	}
	/**
	 * @see com.observability.monitoring.server.IModelHandlerServer
	 */
	@Override
	public int deployModel(String target) throws RemoteException {
		// directory 
		String dir = getTargetFileDirectory(targetName);
		if(dir == null){
			return -1;
		}
		// traverse through all configuration files
		File dirFile = new File(dir);
		if(!dirFile.isDirectory()){
			return -3;
		}
		// File name pattern : xxx.xxx.xxx.xxx_nnnn_collectd.conf
		Pattern pattern = Pattern.compile("_");
        
		// get file list
		File[] files = dirFile.listFiles();
		if(files == null) {
			return -3;
		}
		// loop through file list
		int totalSent = 0;
		for (int i = 0 ; i < files.length ; i++) {
	        if (files[i] != null && files[i].isFile()) {
	        	String fn = files[i].getName();
	        	String[] items = pattern.split(fn);
	           
	            System.out.println("File: " + fn + " IP: " + items[0] + " Port: " + items[1]);
	            // send the files
	            String canonicalPath = null;
				try {
					canonicalPath = files[i].getCanonicalPath();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				}
	            if(propagateConfig(items[0], items[1], canonicalPath)){//sent ok
	            	totalSent++;
	            }
	        }
	    }
		
		return totalSent;
	}

	/**
	 * Initialize the RMI service.
	 * @param rmiIP Binding IP address
	 * @param rmiPort Binding port
	 */
	public static void initializeService(String rmiIP, String rmiPort) {
		try {
			IModelHandlerServer imhs = new ModelHandler();
            UnicastRemoteObject.unexportObject(imhs, true);
            IModelHandlerServer stub = (IModelHandlerServer) UnicastRemoteObject.exportObject(imhs, 0);
            
			int port = Integer.parseInt(rmiPort);
			//create the RMI registry if it doesn't exist.
			Registry registry = LocateRegistry.createRegistry(port);
			registry.rebind("ModelHandler", stub);
		}
		catch(RemoteException e) {
			System.out.println("ModelHandler - error - Failed to create the RMI registry " + e);
		}
	}
	
	/**
	 * Main function
	 * @param args arguments - arg1: binding IP, arg2: binding port
	 */
	public static void main(String[] args) {
		/*/ test
		ModelHandler server = new ModelHandler(); 
		try {
			server.beginFileUpload("v1");
			server.deployModel("v1");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return;
		// end test*/

		// Get IP & port from arguments
		if(args.length  != 2){
			System.out.println("DaemonManager - error - should be started with two parameters: IP + port.");
			return;
		}

		String rmiIP = args[0];
		String rmiPort = args[1];
		initializeService(rmiIP, rmiPort);
	}

}
