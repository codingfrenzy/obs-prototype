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
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
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

        System.out.println("Updating Daemon IP List");

        putLock(daemonIPListLock);

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

        removeLock(daemonIPListLock);

        System.out.println("Success: IP List file updated");
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

    public static void logMessageMissingDaemonNotCollecting(String message) {
        logMessage(collectdPath + MISSING_DAEMON_NOT_COLLECTING_LOG, message);
    }

    public static void logMessageMissingDaemonNotResponding(String message) {
        logMessage(collectdPath + MISSING_DAEMON_NOT_RESPONDING_LOG, message);
    }

    public static void logMessageDBHandler(String message) {
        logMessage(collectdPath + dbHandlerLog, message);
    }

    public static void logMessageModelDataHandler(String message) {
        logMessage(collectdPath + modelDataHandlerLog, message);
    }

    private static void logMessage(String path, String message) {
        try {
            // append to file
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path + "-" + getTodayDate(), true), "UTF-8");
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.write(message);
            fbw.newLine();
            fbw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) {
        System.out.println(ObservabilityCollectdFileOperations.lastModifiedCollectdConf());
        System.out.println(ObservabilityCollectdFileOperations.lastModifiedDaemonIP());

    }
}

