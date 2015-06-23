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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * MetricDatabaseHandlerServer is a manager process which can be used to:<br>
 * 1. fetch a single metric value from whisper database at a specific epoch value<br>
 * 2. fetch multiple metric values between an epoch range<br>
 * 3. set/update metric values for as many epoch values as the user wants for a metric<br> 
 * <p>
 * @author Rajat Kapoor
 * <p>
 * History:<br> 
 * 1. Created					Jun 03 2015<br>
 * 2. Modified					Jun 06 2015<br>
 * 3. Modified					Jun 23 2015<br>
 */

public class MetricDatabaseHandler extends UnicastRemoteObject implements IMetricDatabaseHandlerServer{
	
	/**
	 * Auto generated serial version id
	 */
	private static final long serialVersionUID = 1379506436554341853L;
	
	private static Logger LOGGER;
	
	/**
	 * Default constructor
	 */
	protected MetricDatabaseHandler() throws RemoteException {
		super();
		LOGGER = Logger.getLogger(MetricDatabaseHandler.class.getName());
	}
	
	/**
	 * Path where whisper data is stored (must end with '/')
	 */
	private static String whisperPath = "/var/lib/graphite/whisper/";
	/**
	 * The lowest frequency in seconds of metric collection
	 */
	private int lowestInterval = 30;
	
	/**
	 * @see com.observability.monitoring.server.IMetricDatabaseHandlerServer
	 */
	public String getMetricValueAtEpoch(String epoch, String metricPath)
			throws RemoteException {
		if(epoch == null || "".equals(epoch.trim()) || metricPath == null || "".equals(metricPath.trim()))
			return null;	// for any invalid input, return null
		StringBuilder command = new StringBuilder();	// used to build command string
		long actualEpoch = (long)Double.parseDouble(epoch);	// convert epoch to long
		actualEpoch = actualEpoch - (actualEpoch % lowestInterval);	// round down
		// whisper-fetch utility needs a range of epoch so to get the result
		// for a specific epoch find metric value b/w epoch-1 and epoch+1 
		long from = actualEpoch-1;
		long to = actualEpoch+1;
		command.append("whisper-fetch.py "+whisperPath+metricPath+".wsp --from="+from+" --until="+to);
		Process p;			// initialize a process class
		BufferedReader outReader = null;	// used to hold result from command executed
		String returnStr = null;			// used to hold result from command executed
		try {
			p = Runtime.getRuntime().exec(command.toString());	// run the UNIX command
			p.waitFor();		// wait for it to finish execution
		    if (p.exitValue() != 0)		// if there is an error
		    	return null;			// return null
		    // else fetch the result:
		    outReader = new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
		    String output = outReader.readLine();
		    if(output!=null && !"".equals(output) && output.contains("\t")){
		    	String[] value = output.split("\t");	// returned result contains two values
		    	returnStr =  actualEpoch+"\t"+value[1];	// separated by a tab
		    }
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception in getMetricValueAtEpoch::", e);
			e.printStackTrace();
			return null;
		} finally{
			try {
				if(outReader!=null)
					outReader.close();		// close the BufferedReader stream at the end
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "Exception in getMetricValueAtEpoch::", e);
				e.printStackTrace();
			}
		}
       return returnStr;
	}
	
	/**
	 * @see com.observability.monitoring.server.IMetricDatabaseHandlerServer
	 */
	public ArrayList<String> getMetricsBtwEpochRange(String fromEpoch,
			String toEpoch, String metricPath) throws RemoteException {
		if(fromEpoch == null || "".equals(fromEpoch.trim()) || toEpoch == null || "".equals(toEpoch.trim()) || metricPath == null || "".equals(metricPath.trim()))
			return null;	// return null if an invalid input is given
		StringBuilder command = new StringBuilder();	// used to store the command
		// convert the from and to epoch values to long from String and
		// round them down to the nearest 'lowestInterval'
		long fromEpochLong = (long)Double.parseDouble(fromEpoch);
		fromEpochLong = fromEpochLong - (fromEpochLong % lowestInterval);
		long toEpochLong = (long)Double.parseDouble(toEpoch);
		toEpochLong = toEpochLong - (toEpochLong % lowestInterval);
		command.append("whisper-fetch.py "+whisperPath+metricPath+".wsp --from="+(fromEpochLong-1)+" --until="+(toEpochLong+1));
		Process p;
		BufferedReader outReader = null;
		// the result returned will be multi-line so use an arraylist to store it: 
		ArrayList<String> outputList = new ArrayList<String>();
		try {
			p = Runtime.getRuntime().exec(command.toString());	// execute the command
			p.waitFor();		// wait for it to execute
		    if (p.exitValue() != 0)		// if there is an error
		    	return null;			// return null
		    outReader = new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
		    String output = null;
		    while( (output = outReader.readLine())!=null ){	// while the returned result contains more lines
		    if(!"".equals(output) && output.contains("\t")){// check that the line is valid
		    	outputList.add(output);						// add it to arraylist
		     }
		    }
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception in getMetricsBtwEpochRange::", e);
			e.printStackTrace();
			return null;
		} finally{
			try {
				if(outReader!=null)		// close the BufferedReader
					outReader.close();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "Exception in getMetricsBtwEpochRange::", e);
				e.printStackTrace();
			}
		}
		return outputList;
	}
	
	/**
	 * @see com.observability.monitoring.server.IMetricDatabaseHandlerServer
	 */
	public boolean updateMetrics(String[] epoch, String[] values,
			String metricPath) throws RemoteException {
		if(epoch == null || values == null || metricPath == null || "".equals(metricPath.trim()) || epoch.length != values.length)
			return false;		// return false if the input provided is invalid
		Process p;
		StringBuilder command = new StringBuilder();		// holds the command to execute
		command.append("whisper-update.py "+whisperPath+metricPath+".wsp ");
		long currentEpoch;	// holds the currentEpoch when epoch[] is iterated
		for(int i=0;i<epoch.length;i++){
			currentEpoch = (long)Double.parseDouble(epoch[i]);		// parse to long
			currentEpoch = currentEpoch - (currentEpoch % lowestInterval);	// round down
			command.append(currentEpoch+":"+values[i]);				// append to command string
			if(i!=epoch.length-1)
				command.append(" ");		// append a space if it is not the last element of array
		}
		try {
			p = Runtime.getRuntime().exec(command.toString());		// run the command
			p.waitFor();					// wait for it to execute
		    if (p.exitValue() != 0)			// if there is an error
		    	return false;				// return false
		    else
		    	return true;		    	// else return true
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception in updateMetrics::", e);
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * initLogger() method is used to start Java logging
	 */
	
	private static void initLogger() {
		Handler fileHandler = null;
		Formatter simpleFormatter = null;
		try {
			// Creating FileHandler
			fileHandler = new FileHandler("MetricDBHandler.log", true);
			// Creating SimpleFormatter
			simpleFormatter = new SimpleFormatter();
			// Assigning handler to logger
			LOGGER.addHandler(fileHandler);
			fileHandler.setFormatter(simpleFormatter);
			// Setting Level to ALL
			fileHandler.setLevel(Level.ALL);
			LOGGER.setLevel(Level.ALL);
			LOGGER.info("Logging started");
		} catch(IOException exception) {
			LOGGER.log(Level.SEVERE, "Error occured in FileHandler.", exception);
		}
	}
	
	/**
	 * Main function
	 * @param args arguments - arg1: binding port
	 */
	public static void main(String[] args){
		System.setProperty("java.net.preferIPv4Stack","true");	// has to be specified so that RMI
													// registry doesn't accept only IPv6 connections
		if(args.length!=1){							// parse arguments
			System.out.println("Invalid arguments: Please provide port no. as an argument");
			System.exit(1);
		}
		
		try {
			int portno = Integer.parseInt(args[0]);
			String name = "MetricDatabaseHandler";		// name of RMI service
			IMetricDatabaseHandlerServer engine = new MetricDatabaseHandler();
			initLogger();
			UnicastRemoteObject.unexportObject(engine, true);	// unexport a unicast object if it already exported
			IMetricDatabaseHandlerServer stub =
					(IMetricDatabaseHandlerServer) UnicastRemoteObject.exportObject(engine, 0);	// export unicast object again 
			Registry registry = LocateRegistry.createRegistry(portno);	// create registry at the specified port
			registry.rebind(name, stub);								// re-bind service to this registry
			System.out.println("MetricDatabaseHandler bound");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception in MetricDatabaseHandler::", e);
			e.printStackTrace();
		}
	}

}
