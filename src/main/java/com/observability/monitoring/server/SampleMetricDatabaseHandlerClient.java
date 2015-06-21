package com.observability.monitoring.server;

import java.io.IOException;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

/* To run this program manually:
 * 1. cd into the base folder in which com folder is contained
 * 2. run RMI server:
 *    java com.observability.monitoring.server.MetricDatabaseHandler 8100
 * 3. run this client by: 
 * 	  java com.observability.monitoring.server.SampleMetricDatabaseHandlerClient
 * 
 * Sample parameters:
 * localhost 8100 1433641326.507 1433641416.508 collectd/observabilityCassandra1/memory/memory-used
 */

public class SampleMetricDatabaseHandlerClient {
	
	public static void main(String[] args) throws IOException {
		String serverIP, serverPort;
		IMetricDatabaseHandlerServer imdhs = null;
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter RMI Server IP:");
		serverIP = scn.next();
		System.out.print("Enter RMI Server port:");
		serverPort = scn.next();
		System.out.println("connecting..");
		try{
			imdhs = (IMetricDatabaseHandlerServer)Naming.lookup("rmi://"+serverIP+":"+serverPort+"/MetricDatabaseHandler");
			//System.out.println(imdhs.getMetricsBtwEpochRange(args[2],args[3],args[4]));
		} catch(Exception e){
			e.printStackTrace();
			scn.close();
		}
		System.out.println("connection successful!");
		int ch = 1;
		while(ch>=1 && ch<=3){
		System.out.println("Press enter to continue..");
		System.in.read();
		System.out.println("1. Get metric at epoch");
		System.out.println("2. Get metric b/w epoch range");
		System.out.println("3. Update metric values at epochs");
		System.out.print("Enter your choice:");
		ch = scn.nextInt();
		switch(ch){
			case 1:	String epoch, metricPath;
					System.out.println("\nCurrent epoch is: "+System.currentTimeMillis()/1000);
					System.out.print("Enter epoch value:");
					epoch = scn.next();
					System.out.print("Enter metricPath:");
					metricPath = scn.next();
					String out1 = imdhs.getMetricValueAtEpoch(epoch, metricPath);
					System.out.println(out1);
					break;
			case 2:	String fromEpoch, toEpoch;
					System.out.println("\nCurrent epoch is: "+System.currentTimeMillis()/1000);
					System.out.print("Enter fromEpoch value:");
					fromEpoch = scn.next();
					System.out.print("Enter toEpoch value:");
					toEpoch = scn.next();
					System.out.print("Enter metricPath:");
					metricPath = scn.next();
					ArrayList<String> out2 = imdhs.getMetricsBtwEpochRange(fromEpoch, toEpoch, metricPath);
					System.out.println(out2.toString());
					break;
			case 3: System.out.println("\nCurrent epoch is: "+System.currentTimeMillis()/1000);
					System.out.println("Enter the epochs and metric values in the format:");
					System.out.println("epoch1:metricVal1 epoch2:metricVal2 epoch3:metricVal3 ...");
					scn.nextLine();
					String input3 = scn.nextLine();
					System.out.print("Enter metricPath:");
					metricPath = scn.next();
					String[] epochs, values;
					if(!input3.trim().equals("") && input3.length()>0 && input3.contains(":")){
						String[] split = input3.split("\\s+");
						epochs = new String[split.length];
						values = new String[split.length];
						for(int i=0;i<split.length;i++){
							if(split[i].contains(":")){
								String[] innerSplit = split[i].split(":");
								epochs[i] = innerSplit[0];
								values[i] = innerSplit[1];
								System.out.print("Current db record for "+epochs[i]+" = ");
								String tempOut = imdhs.getMetricValueAtEpoch(epochs[i], metricPath);
								System.out.println(tempOut);
							}
						}
						boolean valuesUpdated = imdhs.updateMetrics(epochs, values, metricPath);
						System.out.println("ValuesUpdated: "+valuesUpdated);
						if(valuesUpdated == true){
							for(int i=0;i<epochs.length;i++){
								System.out.print("New db record for "+epochs[i]+" = ");
								String tempOut = imdhs.getMetricValueAtEpoch(epochs[i], metricPath);
								System.out.println(tempOut);
							}
						}
					}
					break;
			default:System.out.println("Invalid choice! Exiting..");
					scn.close();
					System.exit(1);
		}
	}
	}

}
