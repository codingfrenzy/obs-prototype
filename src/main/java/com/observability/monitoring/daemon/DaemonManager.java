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


package com.observability.monitoring.daemon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * DaemonManager is a manager process that has the following functionalities:<br>
 * 1. Start/stop collectd process on Ubuntu<br>
 * 2. Communicate with metric engine to get configuration parameters<br>
 * 3. Save configuration parameters to collectd conf file<p>
 * This program needs to be started with sudo.
 * @author Ying (Joel) Gao
 * <p>
 * History:<br>
 * 1. Created					May 29 2015<br>
 * 2. Modified					May 30 2015<br>
 * 3. Modified					May 31 2015<br>
 * 4. Modified					Jun 02 2015<br>
 * 5. Modified					Jun 07 2015<br>
 * 6. Modified					Jun 19 2015<br>
 * 7. Modified					Jun 23 2015<br>
 */

public class DaemonManager extends UnicastRemoteObject implements IDaemonManagerServer{

	/**
	 * Auto generated serial version id
	 */
	private static final long serialVersionUID = 510701247259432164L;
	
	/**
	 * Current string of the whole configuration file 
	 */
	private String confString = null;
	
	/**
	 * Path to the configuration file 
	 */
	private static String collectdPath = "/opt/collectd/sbin/collectd";
	/**
	 * Path to the configuration file 
	 */
	private static String configPath = "/opt/collectd/etc/collectd.conf";

	/**
	 * DaemonHeartbeatClient object
	 */
	public DaemonHeartbeatClient dhc = null;
	/**
	 * Default constructor
	 * 
	 */
	protected DaemonManager() throws RemoteException {
		super();
	}

	/**
	 * Get the file path of configuration
	 * @return the file path
	 * 
	 */
	public static String getConfigurationFilePath() {
		return configPath;
	}
	
	/**
	 * Get the file path of configuration
	 * @param config the new file path of configuration file
	 * 
	 */
	public static void setConfigurationFilePath(String config) {
		configPath = config;
	}
	
	/**
	 * Kill process by the process name.<br>
	 * This method runs the following commands as external process.<br>
	 * pidof: get pid of collectd process;<br>
	 * sudo kill: kill the process with sudo privilege;<br>
	 * If there are multiple collectd processes, all of them will be killed.<br>
	 * 
	 * @param process name of the process
	 */
	public static void killProcess(String process) {
	    try {
	    	// build the pid command
	        Vector<String> commands = new Vector<String>();
	        commands.add("pidof");
	        commands.add(process);
	        ProcessBuilder pb = new ProcessBuilder(commands);
	        // run the command
	        Process pr = pb.start();
	        // wait for return
	        pr.waitFor();
	        if (pr.exitValue() != 0){//error return value
	        	System.out.println("DaemonManager - error - getting pid of collectd failed.");
	        	return;
	        }
	        // get the pid value
	        BufferedReader outReader = new BufferedReader(new InputStreamReader(pr.getInputStream(),"UTF-8"));
	        String pros = outReader.readLine();
	        if(pros != null && pros.length() > 0) {
		        String [] strs = pros.trim().split(" ");
		        // loop through to kill all of them
		        for (String pid : strs) {
		            // kill the pid
		            Process kill = Runtime.getRuntime().exec("kill " + pid);
		            kill.waitFor();
		            System.out.println("Killing pid: " + pid);
		            // get the output and print
		            /*
		            BufferedReader br = new BufferedReader(new InputStreamReader(kill.getInputStream(),"UTF-8"));
		            String killOutputLine = "";
		            while ((killOutputLine = br.readLine()) != null) {
			            System.out.println(killOutputLine);

		            }
		            br.close();
		            */
		        }
	        }
	        outReader.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Start the process by name, this class file should be in the same folder as the target program.
	 * @param process name of the process
	 */
	public static void startProcess(String process) {
		try {
			// start process with sudo (required by collectd)
			Runtime.getRuntime().exec(process);
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Start configuration modification process.
	 * @return true/false client gets true to continue
	 * @throws RemoteException connection error
	 */
	public boolean startConfigurationModification() throws RemoteException {
		// open the configuration file
		// the configuration file is required to be saved in the same directory of this program
		
        try {
        	Path path = Paths.get(configPath);
        	confString = new String(Files.readAllBytes(path), StandardCharsets.US_ASCII);

        } catch (Exception e) {
            e.printStackTrace();
            confString = null;
            return false;
        }
		return true;
	}

	/**
	 * Change configuration of a section. There are two kinds of configurations:<br>
	 * 1. Single line that outside any sections;<br>
	 * 2. Sections (inside &lt; and &gt;);<p>
	 * For example:
	 * <p>
	 * &lt;LoadPlugin perl&gt;<br>
	 * 		Interval 60<br>
	 * &lt;/LoadPlugin&gt;<br>
	 * <p>
	 * If the oldconfig is null, newconfig will be appended to the end of 
	 * configuration file as a new section. 
	 * <p>
	 * This function can be called multiple times to change multiple sections.
	 * 
	 * @param oldconfig the old configuration value, for a section, it includes everything.
	 * @param newconfig the new configuration value, for a section, it includes everything.
	 * @return true/false
	 * @throws RemoteException connection error
	 */
	public boolean changeConfiguration(String oldconfig, String newconfig) throws RemoteException {
		
		if(confString == null || newconfig == null)// String not available
			return false;
		// 1. locate the section
		//String header = "<Plugin \"" + section + "\">";
		//String footer = "</Plugin>";
		boolean oldconfigexist = false;
		if(oldconfig != null){
			int start = confString.indexOf(oldconfig);
			if(start != -1){//exists
				confString = confString.replace(oldconfig, newconfig);
				oldconfigexist = true;
			}
		}
		
		if(!oldconfigexist){//does not exist
			// adding new configuration
			// append to end of the string
			confString += "\n";
			confString += newconfig;
			confString += "\n";
		}
		
		return true;
	}

	/**
	 * Replace the whole configuration file content with string config.
	 * @param config the string for new configuration as a whole
	 * @return true/false
	 * @throws RemoteException connection error
	 */
	public boolean replaceWholeConfiguration(String config) throws RemoteException {
		if(confString == null || config == null || config.isEmpty())
			return false;
		// replace the whole configuration string
		confString = config;
		return true;
	}
	
	/**
	 * Stop configuration modification process.
	 * @return true/false client gets true to confirm the success of changing configuration
	 * @throws RemoteException connection error
	 */
	public boolean stopConfigurationModification() throws RemoteException {
		try{
			// 1. save to conf file
			if(confString != null){
				Path path = Paths.get(configPath);
				Files.write(path, confString.getBytes(StandardCharsets.US_ASCII));
			}
			
			// 2. stop collect process
			killProcess("collectd");
			// Update heartbeat client
			if(dhc != null)
				dhc.updateInterval();
			// 3. start collect process
			//startProcess("collectd");
			startProcess(collectdPath);
			
		} catch(Exception e) {
            e.printStackTrace();
            return false;
		}
		
		return true;
	}

	/**
	 * Initialize the RMI service.
	 * @param rmiIP Binding IP address
	 * @param rmiPort Binding port
	 */
	public static void initializeService(String rmiIP, String rmiPort) {
		try {
			DaemonManager server = new DaemonManager();
			IDaemonManagerServer idms = server;//new DaemonManager();
            UnicastRemoteObject.unexportObject(idms, true);
            IDaemonManagerServer stub = (IDaemonManagerServer) UnicastRemoteObject.exportObject(idms, 0);
            
			int port = Integer.parseInt(rmiPort);
			//create the RMI registry if it doesn't exist.
			Registry registry = LocateRegistry.createRegistry(port);
			registry.rebind("DaemonManager", stub);
			
			server.dhc = new DaemonHeartbeatClient(rmiIP);
			server.dhc.start();
		}
		catch(RemoteException e) {
			System.out.println("DaemonManager - error - Failed to create the RMI registry " + e);
		}
		/*
		DaemonManager server = null;
		try{
			server = new DaemonManager(); 
		}
		catch(RemoteException e) {
			System.out.println("DaemonManager - error - Failed to create server " + e);
			System.exit(1);
		}
		try {
			// bind service
			Naming.rebind(String.format("//%s:%s/DaemonManager", rmiIP, rmiPort), server);
		} catch (RemoteException e) {
			System.out.println(e);
 		} catch (MalformedURLException e) {
			System.out.println(e);
		}*/
	}
	
	/**
	 * Main function
	 * @param args arguments - arg1: binding IP, arg2: binding port
	 */
	public static void main(String[] args) {
		// Get IP & port from arguments
		if(args.length  < 2){
			System.out.println("DaemonManager - error - should be started with at least two parameters: IP + port.");
			System.out.println("DaemonManager - Usage:");
			System.out.println("Parameter 1 - IP");
			System.out.println("Parameter 2 - Port");
			System.out.println("Parameter 3 - collectd path. E.g. /opt/collectd/sbin/collectd");
			System.out.println("Parameter 4 - collectd.conf path. E.g. /etc/collectd/collectd.conf");
			return;
		}
		if(args.length >= 3){
			collectdPath = args[2];
		}
		if(args.length >= 4){
			configPath = args[3];
		}
		
		String rmiIP = args[0];
		String rmiPort = args[1];
		// Set to use IP v4
		System.setProperty("java.net.preferIPv4Stack" , "true");
		System.setProperty("java.rmi.server.hostname", rmiIP);
		// Initialize the RMI service
		initializeService(rmiIP, rmiPort);
	}
}
