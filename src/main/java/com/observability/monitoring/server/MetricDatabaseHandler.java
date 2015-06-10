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
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * MetricDatabaseHandlerServer is a manager process which can be used to:
 * 1. fetch a single metric value from whisper database at a specific epoch value
 * 2. fetch multiple metric values between an epoch range
 * 3. set/update metric values for as many epoch values as the user wants for a metric 
 * 
 * @author Rajat Kapoor
 * 
 * History: 
 * 1. Created					Jun 03 2015
 * 2. Modified					Jun 06 2015
 */

public class MetricDatabaseHandler extends UnicastRemoteObject implements IMetricDatabaseHandlerServer{
	
	/**
	 * Auto generated serial version id
	 */
	private static final long serialVersionUID = 1379506436554341853L;
	
	/**
	 * Default constructor
	 */
	protected MetricDatabaseHandler() throws RemoteException {
		super();
	}
	
	/**
	 * Path where whisper data is stored (must end with '/')
	 */
	private static String whisperPath = "/var/lib/graphite/whisper/";
	/*
	 * The lowest frequency in seconds of metric collection
	 */
	private int lowestInterval = 30;
	
	/**
	 * for details about this method refer IMetricDatabaseHandler
	 */
	public String getMetricValueAtEpoch(String epoch, String metricPath)
			throws RemoteException {
		if(epoch == null || "".equals(epoch.trim()) || metricPath == null || "".equals(metricPath.trim()))
			return null;
		StringBuilder command = new StringBuilder();
		long actualEpoch = (long)Double.parseDouble(epoch);
		actualEpoch = actualEpoch - (actualEpoch % lowestInterval);
		long from = actualEpoch-1;
		long to = actualEpoch+1;
		command.append("whisper-fetch.py "+whisperPath+metricPath+".wsp --from="+from+" --until="+to);
		Process p;
		BufferedReader outReader = null;
		String returnStr = null;
		try {
			p = Runtime.getRuntime().exec(command.toString());
			p.waitFor();
		    if (p.exitValue() != 0)
		    	return null;
		    outReader = new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
		    String output = outReader.readLine();
		    if(output!=null && !"".equals(output) && output.contains("\t")){
		    	String[] value = output.split("\t");
		    	returnStr =  actualEpoch+"\t"+value[1];
		    }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			try {
				if(outReader!=null)
					outReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
       return returnStr;
	}
	
	/**
	 * for details about this method refer IMetricDatabaseHandler
	 */
	public ArrayList<String> getMetricsBtwEpochRange(String fromEpoch,
			String toEpoch, String metricPath) throws RemoteException {
		if(fromEpoch == null || "".equals(fromEpoch.trim()) || toEpoch == null || "".equals(toEpoch.trim()) || metricPath == null || "".equals(metricPath.trim()))
			return null;
		StringBuilder command = new StringBuilder();
		long fromEpochLong = (long)Double.parseDouble(fromEpoch);
		fromEpochLong = fromEpochLong - (fromEpochLong % lowestInterval);
		long toEpochLong = (long)Double.parseDouble(toEpoch);
		toEpochLong = toEpochLong - (toEpochLong % lowestInterval);
		command.append("whisper-fetch.py "+whisperPath+metricPath+".wsp --from="+(fromEpochLong-1)+" --until="+(toEpochLong+1));
		Process p;
		BufferedReader outReader = null;
		ArrayList<String> outputList = new ArrayList<String>();
		try {
			p = Runtime.getRuntime().exec(command.toString());
			p.waitFor();
		    if (p.exitValue() != 0)
		    	return null;
		    outReader = new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
		    String output = null;
		    while( (output = outReader.readLine())!=null ){
		    if(!"".equals(output) && output.contains("\t")){
		    	outputList.add(output);
		     }
		    }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			try {
				if(outReader!=null)
					outReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return outputList;
	}
	
	/**
	 * for details about this method refer IMetricDatabaseHandler
	 */
	public boolean updateMetrics(String[] epoch, String[] values,
			String metricPath) throws RemoteException {
		if(epoch == null || values == null || metricPath == null || "".equals(metricPath.trim()) || epoch.length != values.length)
			return false;
		Process p;
		StringBuilder command = new StringBuilder();
		command.append("whisper-update.py "+whisperPath+metricPath+".wsp ");
		long currentEpoch;
		for(int i=0;i<epoch.length;i++){
			currentEpoch = (long)Double.parseDouble(epoch[i]);
			currentEpoch = currentEpoch - (currentEpoch % lowestInterval);
			command.append(currentEpoch+":"+values[i]);
			if(i!=epoch.length-1)
				command.append(" ");
		}
		try {
			p = Runtime.getRuntime().exec(command.toString());
			p.waitFor();
		    if (p.exitValue() != 0)
		    	return false;
		    else
		    	return true;		    
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Main function
	 * @param args arguments - arg1: binding port
	 */
	public static void main(String[] args){
		System.setProperty("java.net.preferIPv4Stack","true");
		if(args.length!=1){
			System.out.println("Invalid arguments: Please provide port no. as an argument");
			System.exit(1);
		}
		try {
			int portno = Integer.parseInt(args[0]);
			String name = "MetricDatabaseHandler";
			IMetricDatabaseHandlerServer engine = new MetricDatabaseHandler();
			UnicastRemoteObject.unexportObject(engine, true);
			IMetricDatabaseHandlerServer stub =
					(IMetricDatabaseHandlerServer) UnicastRemoteObject.exportObject(engine, 0);
			Registry registry = LocateRegistry.createRegistry(portno);
			registry.rebind(name, stub);
			System.out.println("MetricDatabaseHandler bound");
		} catch (Exception e) {
			System.err.println("MetricDatabaseHandler exception:");
			e.printStackTrace();
		}
	}

}
