package com.observability.monitoring.server;

import java.rmi.Naming;

/* To run this program manually:
 * 1. cd into the base folder in which com folder is contained
 * 2. If RMI registry is not already running, type:
 * 	  rmiregistry &
 * 3. run RMI server:
 *    java com.observability.monitoring.server.MetricDatabaseHandler localhost 8100
 * 4. run this client by: 
 * 	  java com.observability.monitoring.server.SampleMetricDatabaseHandlerClient localhost 8100 1433641326.507 1433641416.508 collectd/observabilityCassandra1/memory/memory-used 
 */

public class SampleMetricDatabaseHandlerClient {
	
	public static void main(String[] args) {
		if(args.length != 5){
			System.out.println("Incorrect number of params!");
			System.out.println("args[0] is the ip addr of RMI server");
			System.out.println("args[1] is the port no. of RMI server");
			System.out.println("args[2] is the fromEpoch value (exclusive)");
			System.out.println("args[3] is the toEpoch value (inclusive)");
			System.out.println("args[4] is the metricPath e.g. collectd/observabilityCassandra1/memory/memory-used");
			System.exit(1);
		}
		try{
			// below are the only two lines you need to use in your program to use methods of MetricDatabaseHandler
			IMetricDatabaseHandlerServer imdhs = (IMetricDatabaseHandlerServer)Naming.lookup("rmi://"+args[0]+":"+args[1]+"/MetricDatabaseHandler");
			System.out.println(imdhs.getMetricsBtwEpochRange(args[2],args[3],args[4]));
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
