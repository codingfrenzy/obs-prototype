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
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * DaemonHeartbeatMain is a process that runs in the server. Functionalities<br>
 * 1. Keeps in a list of daemons that is supposed to send heartbeat.<br>
 * 2. Listens to all the heartbeats from the daemons.<br>
 * 3. Cross checks to find out which daemons did not respond and which daemons
 * is having trouble collecting metrics.<br>
 *
 * @author Prasanth Nair<br>
 *         Created June 5 2015<br>
 */
public class DaemonHeartbeatMain implements Runnable {

    /**
     * List of daemons that is supposed to send the heartbeat.
     */
    private HashSet<String> listOfConfiguredDaemons = new HashSet<String>();

    /**
     * List of daemons that has not responding within the threshold.
     */
    private HashMap<String, Long> listOfNotRespondingDaemons = new HashMap<String, Long>();

    /**
     * List of daemons that has not been collecting measurements within the threshold.
     */
    private HashMap<String, Long> listOfNotCollectingDaemons = new HashMap<String, Long>();

    /**
     * Toggle to switch between 2 HashMaps for collecting information regarding the daemons that sent the heartbeat.
     */
    private AtomicBoolean daemonHeartbeatCollectionToggle;

    /**
     * Sampling rate of this process. It should be same as the daemons.<br>
     * Currently hard coded to 30.
     */
    int samplingRate = 30;

    /**
     * Filepath string where the log will be stored.
     */
    String filePath = "/home/owls/collectd/missingDaemonLog/";

    /**
     * List of daemons that has send heartbeat for each interval. <br>
     * There are 2 HashMaps so as to avoid editing information of one while it is being reset.<br>
     * Allows stable data transfer between 2 threads.<br>
     * The switching happen based on the boolean toggle.
     */
    private HashMap<String, DaemonInfo> listOfDaemonHeartbeatReceived1;
    private HashMap<String, DaemonInfo> listOfDaemonHeartbeatReceived2;

    /**
     * Constructor<br>
     * Intiliazes the reference to the 2 Hashmap objects and the AtomicBoolean object that controls the toggle.
     *
     * @param HashMap       list1
     * @param HashMap       list2
     * @param AtomicBoolean daemonHeartbeatCollectionToggle - This is used for switch between the hashmaps between threads.
     */
    DaemonHeartbeatMain(HashMap<String, DaemonInfo> l1, HashMap<String, DaemonInfo> l2, AtomicBoolean daemonHeartbeatCollectionToggle) {
        listOfDaemonHeartbeatReceived1 = l1;
        listOfDaemonHeartbeatReceived2 = l2;
        this.daemonHeartbeatCollectionToggle = daemonHeartbeatCollectionToggle;
        initListofConfiguredDaemons();
    }

    /**
     * Initialize list of daemons that is supposed to send the heartbeats.
     * Currently hard coded.
     */
    private void initListofConfiguredDaemons() {
        listOfConfiguredDaemons.add("45.55.240.162");
        listOfConfiguredDaemons.add("128.2.204.246");
        listOfConfiguredDaemons.add("123.2.204.246");
    }

    /**
     * Method to calculate how long to wait for daemons to send heart beat
     * before declaring them 'dead'.
     *
     * @return int threshold
     */
    private int getThreshold() {
        return samplingRate * 4;
    }

    /**
     * Method to verify which all daemons have sent the hearbeat and which all
     * daemons are having trouble collecting metrics.<br>
     * Calls saveDaemonNotResponding or saveDaemonNotCollectingMetrics as deemed
     * appropriate.<br>
     * The hashmap accessed depends on the toggle. <br>
     * At the end of the method, we toggle the toggle so that the current hashmap can be cleared, meanwhile data will be entered into the other hashmap.
     */
    private void verifyDaemonHeartbeat() {

        HashMap<String, DaemonInfo> tempHeartbeatReceived = null;
        if (daemonHeartbeatCollectionToggle.get()) {
            tempHeartbeatReceived = listOfDaemonHeartbeatReceived1;
            System.out.println("Using VH1");
        } else {
            tempHeartbeatReceived = listOfDaemonHeartbeatReceived2;
            System.out.println("Using VH2");
        }

        System.out.println("Verifying daemons");
        for (String configuredIp : listOfConfiguredDaemons) {

            boolean foundFlag = false;
            boolean collecting = false;

            if (tempHeartbeatReceived.containsKey(configuredIp)) {
                foundFlag = true;
                collecting = tempHeartbeatReceived.get(configuredIp).metricStatus;

                // clear this daemon from the not collecting/responding stack
                // this is because, an entry in this stack will only exist if it is within the threshold.
                // After the threshold, the entry will be logged and cleared.
                // Therefore, this means that if the key exists in the stack, we can assume that it missed only a part of the threshold so it is allowed.
                if (listOfNotRespondingDaemons.containsKey(configuredIp)) {
                    listOfNotRespondingDaemons.remove(configuredIp);
                }
                if (listOfNotCollectingDaemons.containsKey(configuredIp)) {
                    listOfNotCollectingDaemons.remove(configuredIp);
                }

            }
            if (!foundFlag) {
                saveDaemonNotResponding(configuredIp);
            }
            if (!collecting) {
                saveDaemonNotCollectingMetrics(configuredIp);
            }
        }

        // toggle and clear the old hashmap
        daemonHeartbeatCollectionToggle.set(!daemonHeartbeatCollectionToggle.get());
        tempHeartbeatReceived.clear();
    }

    /**
     * Method to log/notify a dead daemon.
     *
     * @param ip
     */
    private void logDaemonNotResponding(String ip, long time) {
        // File write or email can be done here
        writeToFile(ip, time, true);

    }

    /**
     * Saves the IP of the daemon that is not responding into the corresponding stack.
     *
     * @param String ip - IP of the daemon that is not responding
     */
    private void saveDaemonNotResponding(String ip) {
        if (!listOfNotRespondingDaemons.containsKey(ip)) {
            Long systemEpoch = System.currentTimeMillis() / 1000;
            listOfNotRespondingDaemons.put(ip, systemEpoch);
//            System.out.println("Saving Daemon not responding: " + ip + "date" + systemEpoch.toString());
        }
    }

    /**
     * Method to log/notify daemon having trouble collecting metrics.
     *
     * @param ip
     */
    private void logDaemonNotCollecting(String ip, long time) {
        // File write or email can be done here
        writeToFile(ip, time, false);
    }

    /**
     * Saves the IP of the daemon that is not collecting into the corresponding stack.
     *
     * @param String ip - IP of the daemon that is not responding
     */
    private void saveDaemonNotCollectingMetrics(String ip) {
        if (!listOfNotCollectingDaemons.containsKey(ip)) {
            Long systemEpoch = System.currentTimeMillis() / 1000;
            listOfNotCollectingDaemons.put(ip, systemEpoch);
//            System.out.println("Daemon not collecting: " + ip + systemEpoch.toString());
        }
    }

    /*
     * Method to get the current date. Used for metric collection CSV file
     * name.<br>
     *
     * @return String current date in format yyyy-MM-dd
     */
    public String getTodayDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    private void writeToFile(String ip, long time, boolean responding) {

        String date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date(time * 1000));

        String fileName, content;
        if (responding) {
            fileName = "NotResponding";
            content = "not responding";
        } else {
            fileName = "NotCollecting";
            content = "not collecting";
        }

        String line = "Daemon " + content + ": " + ip + " since " + date + " (" + time + ")";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(new File(filePath + fileName + "-" + getTodayDate()), true));
//            writer = new PrintWriter(filePath + fileName + "-" + getTodayDate(), "UTF-8");
            writer.println(line);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks every not responding and/or not collecting daemons' timestamp.<br>
     * If timestamp is older than threshold, then logs it and deletes it from hashmap.
     */
    private void processNotRespondingCollectingDaemons() {
        Iterator entries = listOfNotRespondingDaemons.entrySet().iterator();
        long systemEpoch = System.currentTimeMillis() / 1000;
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = entry.getKey().toString();
            Long value = Long.parseLong(entry.getValue().toString());
            if (systemEpoch - value.longValue() > getThreshold()) {
                logDaemonNotResponding(key, value.longValue());
                entries.remove();
            }
        }

        entries = listOfNotCollectingDaemons.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = entry.getKey().toString();
            Long value = Long.parseLong(entry.getValue().toString());
            if (systemEpoch - value.longValue() > getThreshold()) {
                logDaemonNotCollecting(key, value.longValue());
                entries.remove();
            }
        }

    }

    /**
     * Starts the thread.<br>
     * After every samplingRate, verifies the daemon list and then processes the not-responding or not-collecting hashmap.
     */
    public void run() {
        boolean first = true;
        while (true) {
            try {
                if (!first) {
                    verifyDaemonHeartbeat();
                    processNotRespondingCollectingDaemons();
                }
                long sleepTime = (long) samplingRate * 1000;
                Thread.sleep(sleepTime);
                first = !first;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        HashMap<String, DaemonInfo> l1 = new HashMap<String, DaemonInfo>();
        HashMap<String, DaemonInfo> l2 = new HashMap<String, DaemonInfo>();
        AtomicBoolean toggle = new AtomicBoolean(true);

        DaemonHeartbeatMain main = new DaemonHeartbeatMain(l1, l2, toggle);
        Thread t1 = new Thread(main);
        t1.start();

        DaemonHeartbeatListener listener = new DaemonHeartbeatListener(l1, l2, toggle);
        Thread t2 = new Thread(listener);
        t2.start();
    }

}
