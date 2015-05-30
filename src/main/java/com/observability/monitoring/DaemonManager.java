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


package com.observability.monitoring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * DaemonManager is a manager process that has the following functionalities:
 * 1. Start/stop collectd process on Ubuntu
 * 2. Communicate with metric engine to get configuration parameters
 * 3. Save configuration parameters to collectd conf file
 * This program needs to be started with sudo.
 * @author Ying (Joel) Gao
 * 
 * History: 
 * 1. Created					May 29 2015
 * 2. Modified					May 30 2015
 *
 */

public class DaemonManager extends UnicastRemoteObject implements IDaemonManagerServer{

	/**
	 * Auto generated serial version id
	 */
	private static final long serialVersionUID = 510701247259432164L;

	/**
	 * Default constructor
	 * 
	 */
	protected DaemonManager() throws RemoteException {
		super();
	}

	/**
	 * Kill process by the process name
	 * 
	 * @param process name of the process
	 */
	public static void killProcess(String process) {
	    try {
	        Vector<String> commands = new Vector<String>();
	        commands.add("pidof");
	        commands.add(process);
	        ProcessBuilder pb = new ProcessBuilder(commands);
	        Process pr = pb.start();
	        pr.waitFor();
	        if (pr.exitValue() != 0)
	        	return;
	        BufferedReader outReader = new BufferedReader(new InputStreamReader(pr.getInputStream(),"UTF-8"));
	        String pros = outReader.readLine();
	        if(pros != null && pros.length() > 0) {
		        String [] strs = pros.trim().split(" ");
		        for (String pid : strs) {
		            //log.info("Killing pid: "+pid);
		            Runtime.getRuntime().exec("sudo kill " + pid).waitFor();
		            System.out.println("Killing pid: " + pid);
		        }
	        }
	        outReader.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Start the process by name, this class file should be in the same folder as the target program
	 * @param process name of the process
	 */
	public static void startProcess(String process) {
		try {
			Runtime.getRuntime().exec("sudo " + process);
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Start configuration modification process.
	 * 
	 */
	public boolean startConfigurationModification() throws RemoteException {
		// open the conf file
		return false;
	}

	/**
	 * Change configuration of a section. If the section does not exist, it will be appended to the end of 
	 * configuration file as a new section.
	 * 
	 */
	public boolean changeConfiguration(String section, String config)
			throws RemoteException {
		// 1. locate the section
		// 2. modify the section
		return false;
	}

	/**
	 * Stop configuration modification process.
	 * 
	 */
	public boolean stopConfigurationModification() throws RemoteException {
		// 1. save to conf file
		// 2. stop collect process
		// 3. start collect process
		return false;
	}

	/**
	 * Main function
	 * @param args[] arguments - arg1: binding IP, arg2: binding port
	 */
	public static void main(String[] args) {
		// Get IP & port from arguments
		if(args.length  != 2){
			System.out.println("DaemonManager - error - should be started with two parameters: IP + port.");
			return;
		}

		String rmiIP = args[0];
		String rmiPort = args[1];
		
		try {
			int port = Integer.parseInt(rmiPort);
			//create the RMI registry if it doesn't exist.
			LocateRegistry.createRegistry(port);
		}
		catch(RemoteException e) {
			System.out.println("DaemonManager - error - Failed to create the RMI registry " + e);
		}
		
		DaemonManager server = null;
		try{
			server = new DaemonManager(); 
		}
		catch(RemoteException e) {
			System.out.println("DaemonManager - error - Failed to create server " + e);
			System.exit(1);
		}
		try {
			Naming.rebind(String.format("//%s:%s/DaemonManager", rmiIP, rmiPort), server);
		} catch (RemoteException e) {
			System.out.println(e);
 		} catch (MalformedURLException e) {
			System.out.println(e);
		}
	}
}
