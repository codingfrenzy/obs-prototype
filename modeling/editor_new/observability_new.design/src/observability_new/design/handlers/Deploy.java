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

package observability_new.design.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.observability.monitoring.server.IModelHandlerServer;

/**
 * Deploy is the client program of the ModelHandler. It connects with the server
 * using RMI and transfers the generated configuration files to the server.
 * 
 * @author vsaravag
 * <p>
 * History <br>
 * 1. Create			June 23 2015 <br>
 *
 */
public class Deploy {
	
	private static IModelHandlerServer svr = null;
	//maximum size of a block for file transfer
	private static int MAX_BLOCK_SIZE = 1024*512;
	
	public static void main(String[] args){
		try {
			deployFile(args[0], args[1], args[2]);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private static void connectRMI(String ip, String port) throws Exception{
		try {
			svr = (IModelHandlerServer) Naming.lookup(String.format(
					"//%s:%s/ModelHandler", ip, port));
		} catch (RemoteException e) {
			throw e;
			//throw new RemoteException("Failed to connect to the server (" + ip + ":" + port + ")");
		} catch (NotBoundException e) {
			throw new NotBoundException("Failed to connect to the server (" + ip + ":" + port + ")");
		} catch (MalformedURLException e) {
			throw new MalformedURLException("Please check Ip and Port provided");
		}
		
		if (svr == null) {
			throw new RuntimeException("Failed to bind with the server. Please check if the server is up and running");
		}
	}
	
	public static void deployFile(String ip, String port, String target) throws Exception{
		// connect to the Model Handler
		connectRMI(ip, port);
		
		// get the md5 hash of the file
		String md5 = IModelHandlerServer.FileOperationHelper.getFileMD5(target);
		if(svr.beginFileUpload("conf")){
			// start uploading the files in blocks of MAX_BLOCK_SIZE byte
			File file = new File(target);
			long size = file.length();
			int noOfBlocks = 1;
			if(size > MAX_BLOCK_SIZE){
				noOfBlocks = (int) Math.ceil(size/MAX_BLOCK_SIZE);
			}
			int skipBytes = 0;
			int bufferSize = MAX_BLOCK_SIZE;
			for (int i = 1; i <= noOfBlocks; i++) {
				// skip blocksize bytes if more than one block is to be sent
				if (i != 1){
					skipBytes += MAX_BLOCK_SIZE;
				}
				// if it is the last block, get the size of the block
				if(i == noOfBlocks){
					// bufferSize should decrease if the last block is less than MAX_BLOCK_SIZE
					bufferSize = (int) (size % MAX_BLOCK_SIZE);
					bufferSize = bufferSize != 0 ? bufferSize : MAX_BLOCK_SIZE;
				}
				
				FileInputStream fIn = new FileInputStream(target);
				fIn.skip(skipBytes);
				
				byte[] bytes = new byte[bufferSize];
				fIn.read(bytes);
				fIn.close();
				// write file to the server
				svr.uploadFileChunk(bytes);
			}
			int uploadStatus = svr.endFileUpload(md5);
			if(uploadStatus < 0){
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
			}
		}
		else {
			throw new RuntimeException("File upload could not be started");
		}
	}
}
