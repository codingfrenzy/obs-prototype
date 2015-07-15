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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class ObservabilityCollectdFileOperations {
    /**
     * Filepath string where the log will be stored.
     */
    private static String collectdPath = "/opt/collectd/";

    private static String collectdConf = "etc/collectd.conf";

    private static String daemonIPList = "etc/daemoniplist";

    private static String aggregationLog = "log/aggregation";

    public static final String MISSING_DAEMON_NOT_RESPONDING_LOG = "log/missingdaemon-notresponding";

    public static final String MISSING_DAEMON_NOT_COLLECTING_LOG = "log/missingdaemon-notcollecting";

    private static String dbHandlerLog = "log/databasehandler";

    private static String modelDataHandlerLog = "log/modeldatahandler";

    public static void updateIPList(ArrayList<String> ipList) {

        System.out.println("Updating Daemon IP List");

        String filename = collectdPath + daemonIPList;

        FileLock lock = null;
        BufferedWriter fbw = null;
        FileChannel fc = null;
        try {
            FileOutputStream out = new FileOutputStream(filename);
            fc = out.getChannel();

            // lock the file channel
            lock = fc.tryLock();

            // wait to acquire lock
            while (lock == null) {
                System.out.println("Waiting for Lock");
                Thread.sleep(5000);
                lock = fc.tryLock();
            }

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
        } catch (InterruptedException e) {
            System.out.println("----------Error: Thread is interrupted. Lock not Acquired. IP LIST NOT UPDATED!");
            e.printStackTrace();
        } finally {
            try {
                if (lock != null)
                    lock.release();
            } catch (IOException e) {
                System.out.println("----------Error: Releasing lock");
                e.printStackTrace();
            }
            try {
                if (fbw != null)
                    fbw.close();
            } catch (IOException e) {
                System.out.println("----------Error: Closing file");
                e.printStackTrace();
            }
        }

        System.out.println("Success: IP List file updated");
    }

    public static HashSet<String> getIPList() {

        System.out.println("Retrieving Daemon IP List");

        String filename = collectdPath + daemonIPList;

        FileLock lock = null;
        BufferedReader fbr = null;
        FileChannel fc = null;
        FileInputStream in = null;

        HashSet<String> ipList = null;

        try {
            in = new FileInputStream(filename);

            fc = in.getChannel();

            System.out.println("1");
            System.out.println(fc.tryLock());
            System.out.println("2");
            // lock the file channel
            lock = fc.tryLock();

            // wait to acquire lock
            if (lock == null) {
                return null;
            }

            // read file
            fbr = new BufferedReader(new InputStreamReader(in, "UTF8"));
            String str;
            ipList = new HashSet<String>();

            // get each line in the file
            while ((str = fbr.readLine()) != null) {
                ipList.add(str);
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Daemon IP List file not found");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (lock != null)
                    lock.release();
            } catch (IOException e) {
                System.out.println("ERROR: Releasing lock");
                e.printStackTrace();
            }
            try {
                if (fbr != null)
                    fbr.close();
            } catch (IOException e) {
                System.out.println("ERROR: Closing file");
                e.printStackTrace();
            }
        }

        System.out.println("Returning Daemon IP List");
        return ipList;
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

