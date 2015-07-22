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

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ObservabilityCollectdFileOperations {
    /**
     * Filepath string where the log will be stored.
     */
    private static String collectdPath = "/opt/collectd/";

    private static String collectdConf = "etc/collectd.conf";

    private static String collectdConfLock = "etc/collectd.conf";

    private static String daemonIPList = "etc/daemoniplist";

    private static String daemonIPListLock = "etc/daemoniplist.lock";

    private static String failedIPList = "etc/failediplist";

    private static String aggregationLog = "log/aggregation";

    public static final String MISSING_DAEMON_NOT_RESPONDING_LOG = "log/missingdaemon-notresponding";

    public static final String MISSING_DAEMON_NOT_COLLECTING_LOG = "log/missingdaemon-notcollecting";

    private static String dbHandlerLog = "log/databasehandler";

    private static String modelDataHandlerLog = "log/modeldatahandler";

    public static void updateIPList(ArrayList<String> ipList) {

        putLock(daemonIPListLock);

        System.out.println("Updating Daemon IP List");

        String filename = collectdPath + daemonIPList;

        BufferedWriter fbw = null;
        try {
            FileOutputStream out = new FileOutputStream(filename);

            // write to file
            OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
            fbw = new BufferedWriter(writer);

            for (int i = 0; i < ipList.size(); i++) {
                fbw.write(ipList.get(i));
                fbw.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fbw != null)
                    fbw.close();
            } catch (IOException e) {
                System.out.println("----------Error: Closing file");
                e.printStackTrace();
            }
        }

        System.out.println("Success: IP List file updated");

        removeLock(daemonIPListLock);
    }

    public static void updateFailedPropogation(ArrayList<String> ipList) {

        System.out.println("Updating Failed propogation Daemon IP List");

        String filename = collectdPath + failedIPList;

        BufferedWriter fbw = null;
        try {
            FileOutputStream out = new FileOutputStream(filename);

            // write to file
            OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
            fbw = new BufferedWriter(writer);

            for (int i = 0; i < ipList.size(); i++) {
                fbw.write(ipList.get(i));
                fbw.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fbw != null)
                    fbw.close();
            } catch (IOException e) {
                System.out.println("----------Error: Closing file");
                e.printStackTrace();
            }
        }

        System.out.println("Success: Failed IP List file updated");
    }

    private static boolean lockExists(String file) {
        File f = new File(collectdPath + file);
        if (f.exists() && !f.isDirectory()) {
            return true;
        }
        return false;
    }

    private static void putLock(String file) {
        System.out.println("Creating lock " + file);

        BufferedWriter fbw = null;
        try {
            FileOutputStream out = new FileOutputStream(collectdPath + file);

            // write to file
            OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
            fbw = new BufferedWriter(writer);
            fbw.write("lock");
            fbw.newLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fbw != null)
                    fbw.close();
            } catch (IOException e) {
                System.out.println("----------Error: Closing file");
                e.printStackTrace();
            }
        }

        System.out.println("Lock created");
    }

    private static void removeLock(String f) {
        try {
            File file = new File(collectdPath + f);
            if (file.delete()) {
                System.out.println(file.getName() + " lock is deleted!");
            } else {
                System.out.println(file.getName() + " delete operation is failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static HashSet<String> getIPList() {

        if (lockExists(daemonIPListLock)) {
            System.out.println("IP Lock exists. Returning null");
            return null;
        }

        System.out.println("Retrieving Daemon IP List");

        String filename = collectdPath + daemonIPList;

        HashSet<String> ipList = new HashSet<String>();
        FileInputStream stream = null;
        String strLine;
        try {
            stream = new FileInputStream(filename);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

            while ((strLine = br1.readLine()) != null) {
                ipList.add(strLine);
            }

            // Close the input stream
            br1.close();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Returning Daemon IP List");
        return ipList;
    }

    public static HashSet<String> getFailedIPList() {
        HashSet<String> ipList = new HashSet<String>();
        FileInputStream stream = null;
        String strLine;
        try {
            stream = new FileInputStream(collectdPath + failedIPList);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

            while ((strLine = br1.readLine()) != null) {
                ipList.add(strLine);
            }

            // Close the input stream
            br1.close();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ipList;
    }

    public static HashMap<String, Object> getMissingDaemonConf() {
        HashMap<String, Object> conf = new HashMap<String, Object>();

        FileInputStream stream = null;
        String strLine;
        String[] temp;
        int interval = -1;
        try {
            stream = new FileInputStream(collectdPath + collectdConf);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

            while ((strLine = br1.readLine()) != null) {
                strLine = strLine.trim().replace("\"", "");
                if (strLine.startsWith("Interval") && interval < 0) {
                    temp = strLine.split(" ");
                    interval = Integer.parseInt(temp[1]);
                    conf.put("Interval", interval);
                }

                // entering MIssing daemon plugin tag
                if (strLine.startsWith("<Plugin MissingDaemon>")) {
                    while ((strLine = br1.readLine()) != null) {
                        strLine = strLine.trim().replace("\"", "");

                        if (strLine.startsWith("</Plugin>")) {
                            break;
                        }

                        if (strLine.startsWith("Threshold")) {
                            temp = strLine.split(" ");
                            conf.put("Threshold", Integer.valueOf(temp[1]));
                        }

                        if (strLine.startsWith("EmailInterval")) {
                            temp = strLine.split(" ");
                            conf.put("EmailInterval", Integer.valueOf(temp[1]));
                        }
                        //end email interval

                        if (strLine.startsWith("<Email MissingDaemon>")) {
                            List<String> recipients = new ArrayList<String>();
                            while ((strLine = br1.readLine()) != null) {
                                strLine = strLine.trim().replace("\"", "");

                                if (strLine.startsWith("</Email>"))
                                    break;

                                if (strLine.startsWith("recpt")) {
                                    temp = strLine.split(" ");
                                    recipients.add(temp[1]);
                                }
                            }
                            conf.put("EmailMissingDaemon", recipients);
                        }
                        //end email
                    }
                }
            }

            // Close the input stream
            br1.close();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conf;
    }

    public static void logMessageAggregation(String message) {
        logMessage(collectdPath + aggregationLog, message);
    }

    public static boolean logMessageMissingDaemonNotCollecting(String message) {
        return logMessage(collectdPath + MISSING_DAEMON_NOT_COLLECTING_LOG, message);
    }

    public static String getMissingDaemonNotCollectingLogPath(){
        return collectdPath + MISSING_DAEMON_NOT_COLLECTING_LOG + "-" + getTodayDate();
    }

    public static boolean logMessageMissingDaemonNotResponding(String message) {
        return logMessage(collectdPath + MISSING_DAEMON_NOT_RESPONDING_LOG, message);
    }

    public static String getMissingDaemonNotRespondingLogPath(){
        return collectdPath + MISSING_DAEMON_NOT_RESPONDING_LOG + "-" + getTodayDate();
    }

    public static void logMessageDBHandler(String message) {
        logMessage(collectdPath + dbHandlerLog, message);
    }

    public static void logMessageModelDataHandler(String message) {
        logMessage(collectdPath + modelDataHandlerLog, message);
    }

    private static boolean logMessage(String path, String message) {
        try {
            // append to file
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path + "-" + getTodayDate(), true), "UTF-8");
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.write(message);
            fbw.newLine();
            fbw.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method to get the current date. Used for metric collection CSV file
     * name.<br>
     *
     * @return String current date in format yyyy-MM-dd
     */
    public static String getTodayDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * Gets the last modified time of collectd.conf in (long) timestamp
     *
     * @return long timestamp of last modified time
     */
    public static long lastModifiedCollectdConf() {
        File file = new File(collectdPath + collectdConf);
        long lastModified = file.lastModified() / 1000;
        return lastModified;
    }

    /**
     * Gets the last modified time of collectd.conf in (long) timestamp
     *
     * @return long timestamp of last modified time
     */
    public static long lastModifiedDaemonIP() {
        File file = new File(collectdPath + daemonIPList);
        long lastModified = file.lastModified() / 1000;
        return lastModified;
    }

    public static boolean checkAccess(){
        File file = new File(collectdPath + collectdConf);
        return file.canWrite();
    }
    
    //////////////////// Start: Reading Aggregation Configurations ////////////////////
    /**
	 * readConfigurationFile() reads aggregation configurations by:</br>
	 * 1. Reading collectd.conf file, capture aggregation section, and saves 
	 * it into an object of AggConfigElements. The object has the following keys and
	 * values: </br>
	 * 		- Fault Tolerance Time Window: the time period in seconds that
	 * allows the nodes of the under monitoring system to send the metric data
	 * to Observability, so the aggregator can have as much data possible to
	 * perform the aggregation. If no value is provided or if it is not a valid
	 * number, use the default value. </br>
	 * 		- Aggregation interval: the time in seconds that Observability
	 * aggregates the data and writes them to DB. If no value is provided
	 * or if it is not a valid number, use the default value. </br>
	 * 		- Metric to aggregate: captured from "plugin" key element of
	 * collectd.conf file. </br> 
	 * 		- Type of metric to aggregate: captured from "typeInstance" 
	 * key element of collectd.conf file. </br> 
	 * 		- Aggregation function to apply: captured from the status of 
	 * the relative key elements of collectd.conf file </br>
	 * 
	 * @return
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public static ArrayList<AggConfigElements> readConfigurationFile() throws IOException {

		int faultTolTimeWindow = 0; // Fault Tolerance Time Window. 
		int interval = 0; // Aggregation interval. 
		
		Scanner scan = new Scanner(System.in,  "UTF-8");
		System.out.println("Kindly enter the Fault Tolerance Time Window. Only Integer numbers are allowed. To exit, enter 0");
		System.out.println("Note that the default value is set to 60 seconds: ");
		
		do {
            System.out.println("Please enter a positive number: ");
            while (!scan.hasNextInt()) {
                String input = scan.next();
                System.out.printf(input +"is not a valid number");
    			System.out.println("Try again. Only Integer numbers are allowed.");
            }
            faultTolTimeWindow = scan.nextInt();
        } while (faultTolTimeWindow < 0);
		
		scan.close();
		
		if (faultTolTimeWindow <= 0) {
			faultTolTimeWindow = 60; //Default value is set to 60 seconds
		}
		
		System.out.println("faultTolTimeWindow: " + faultTolTimeWindow); //Debug, remove later

		interval = getIntervalConf(collectdPath+collectdConf); // Get interval value from
												// collectd.conf file
		// Interval validation
		if (interval <= 0) {
			interval = 30;	//Default value is set to 30 seconds
		}

		ArrayList<HashMap<String,String>> aggConfigurationsListArray = getAggConf(collectdPath+collectdConf);
		
		ArrayList<AggConfigElements> aggConfigurationElementsArray = new ArrayList<AggConfigElements>();
		AggConfigElements aggConfigurationElements = null;
		
		for(int i=0; i<aggConfigurationsListArray.size();i++){
			aggConfigurationElements = setConfigurations(
					faultTolTimeWindow, interval, aggConfigurationsListArray.get(i)); // Save configurations to an object
			aggConfigurationElementsArray.add(i, aggConfigurationElements);
		}
		return aggConfigurationElementsArray;
	}

	/**
	 * Read the configuration file and get the interval value
	 * 
	 * @return integer of the interval value
	 * @throws IOException
	 */
	protected static int getIntervalConf(String fileName) throws IOException, FileNotFoundException {
		BufferedReader bufferReader = null;
		boolean intervalFound = false;
		boolean intervalCommentedOut = false;
		
		try{
			bufferReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();	
		}
		if (bufferReader == null)
			return 0;
		
		String line = "";
		int interval = 0;
		
		do {
			try {
				line = bufferReader.readLine();
				if(line == null)
					break;
				
				line = line.trim();	//Trim any spaces at the beginning of the line
				if (line.isEmpty() || line.trim().equals("")
							|| line.trim().equals("\n"))
					continue;	// Read the next line
				else if (line.toLowerCase().startsWith("#interval")) { // TODO: no need for this clause, remove later
					intervalCommentedOut = true;
					}
				else if (line.toLowerCase().startsWith("interval")) { 
					String str[] = line.trim().split("\\s+");
					if (str.length > 1) {
						interval = Integer.parseInt(str[1]);	
						intervalFound = true;
						}
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (line != null && !intervalFound && !intervalCommentedOut);
		try {
			bufferReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("interval: " + interval); // Debug, remove later
		return interval;
	}
    
	/**
	 * Read the configuration file and get the aggregation configuration keys and values
	 * Save them in an array of hashmap
	 * 
	 * @return array of hashmap. 
	 * @throws IOException
	 */
	protected static ArrayList<HashMap<String,String>> getAggConf(String fileName) throws IOException {
		
		ArrayList<HashMap<String,String>> aggConfigArray = new ArrayList<HashMap<String,String>>();
		
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), "UTF-8"));
		String line = "";
		do {
			try {
				HashMap<String,String> aggConfig = new HashMap<String,String>();
				line = bufferReader.readLine();

					if (line != null && line.trim().equalsIgnoreCase("<Aggregation>") && !line.trim().startsWith("#")) {	//go to aggregation configuration section
						do {						

							line = bufferReader.readLine();
							if (line == null)
								break;
							line = line.trim();		//Trim any spaces at the beginning of the line
							if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n") || line.trim().startsWith("#"))
								continue;	// Read the next line
							else {
								String str[] = line.trim().split("\\s+");	//split both key and value to save them in an array
								if (str.length > 1) {
									aggConfig.put(str[0].toLowerCase(), str[1].toLowerCase());	// Add this configuration element to the hashmap
								}
							}
							
						} while (!line.trim().equalsIgnoreCase("</Aggregation>") && (line != null) );
						aggConfigArray.add(aggConfig);
						line = bufferReader.readLine();
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (line != null);
		try {
			if(bufferReader!=null)		// Close the BufferedReader
				bufferReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return aggConfigArray;
	}

	/**
	 * Set the configurations to AggConfigItems object
	 * 
	 * @param faultTolTimeWindow which is the fault tolerance time window of receiving metric data
	 * @param interval of the aggregation
	 * @param aggConfigurations
	 * @return an object of class AggConfigElements
	 */
	protected static AggConfigElements setConfigurations(int faultTolTimeWindow, int interval,
			HashMap<String, String> aggConfigurations) {
		String host = null; 	
		String plugin = null; 			// The collectd plugin on which data will be  aggregated. For example: plugin = cpu
		String pluginInstance = null; 	
		String type = null;
		String typeInst = null; 		// The type of metric on which data will be aggregated. For example: cpu-system, spu-idle
		String groupBy = null; 
		
		Boolean calNum = false;
		Boolean calSum = false;
		Boolean calAvg = false;
		Boolean calMin = false;
		Boolean calMax = false;
		Boolean calStd = false;

		for (int i = 0; i < aggConfigurations.size(); i++) {
			host = aggConfigurations.get("host");
			plugin = aggConfigurations.get("plugin");
			pluginInstance = aggConfigurations.get("plugininstance");
			type = aggConfigurations.get("type");
			typeInst = aggConfigurations.get("typeinstance");
			groupBy = aggConfigurations.get("groupby");
			calNum = Boolean.parseBoolean(aggConfigurations.get("calculatenum"));
			calSum = Boolean.parseBoolean(aggConfigurations.get("calculatesum"));
			calAvg = Boolean.parseBoolean(aggConfigurations.get("calculateaverage"));
			calMin = Boolean.parseBoolean(aggConfigurations.get("calculateminimum"));
			calMax = Boolean.parseBoolean(aggConfigurations.get("calculatemaximum"));
			calStd = Boolean.parseBoolean(aggConfigurations.get("calculatestddev"));
		}
		// Save the elements in the object
		AggConfigElements aggConfigElements = new AggConfigElements(
				faultTolTimeWindow, interval, host, plugin, pluginInstance, type, typeInst, groupBy, calNum, calSum,
				calAvg, calMin, calMax, calStd);
	return aggConfigElements;
	}
	
    //////////////////// End: Reading Aggregation Configurations ////////////////////
	 
    public static void main(String[] args) {
        System.out.println(ObservabilityCollectdFileOperations.lastModifiedCollectdConf());
        System.out.println(ObservabilityCollectdFileOperations.lastModifiedDaemonIP());

    }
}
