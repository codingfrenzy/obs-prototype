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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     * At every interval (minutes), an email will be sent with list of daemons not respodning/collecting
     */
    int emailInterval = 15;

    /**
     * Last email sent at.<br>
     * Initialized with current timestamp when starting so that the first email will be sent exactly after the interval.
     */
    long lastEmailTimestamp = System.currentTimeMillis() / 1000;

    /**
     * Constructor<br>
     * Intiliazes the reference to the 2 Hashmap objects and the AtomicBoolean object that controls the toggle.
     *
     * @param list1
     * @param list2
     * @param daemonHeartbeatCollectionToggle - This is used for switch between the hashmaps between threads.
     */
    DaemonHeartbeatMain(HashMap<String, DaemonInfo> list1, HashMap<String, DaemonInfo> list2, AtomicBoolean daemonHeartbeatCollectionToggle) {
        listOfDaemonHeartbeatReceived1 = list1;
        listOfDaemonHeartbeatReceived2 = list2;
        this.daemonHeartbeatCollectionToggle = daemonHeartbeatCollectionToggle;
        initListofConfiguredDaemons();
    }

    /**
     * Default constructor. Should be used with caution as it severely limits functionality
     */
    DaemonHeartbeatMain() {
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

        System.out.println("Verifying daemons' heartbeat");

        // select the hashmap based on toggle
        HashMap<String, DaemonInfo> tempHeartbeatReceived = null;
        if (daemonHeartbeatCollectionToggle.get()) {
            tempHeartbeatReceived = listOfDaemonHeartbeatReceived1;
        } else {
            tempHeartbeatReceived = listOfDaemonHeartbeatReceived2;
        }

        // toggle the hashmap so that the same hashmap is not used for saving new daemons and retreiving it for verification
        daemonHeartbeatCollectionToggle.set(!daemonHeartbeatCollectionToggle.get());

        // iterate through all the configured daemons to see which haven't send
        for (String configuredIp : listOfConfiguredDaemons) {

            boolean foundFlag = false;
            boolean collecting = false;

            // if the daemon has sent heartbeat
            if (tempHeartbeatReceived.containsKey(configuredIp)) {
                foundFlag = true;
                collecting = tempHeartbeatReceived.get(configuredIp).metricStatus;

                // clear this daemon from the not collecting/responding stack
                // this is because, an entry in this stack will only exist if it is within the threshold.
                // After the threshold, the entry will be logged and cleared.
                // Therefore, this means that if the key exists in the stack, we can assume that it missed only a part of the threshold so it is allowed.
                if (listOfNotRespondingDaemons.containsKey(configuredIp)) {
                    listOfNotRespondingDaemons.remove(configuredIp);
                    System.out.println(configuredIp);
                }
                if (listOfNotCollectingDaemons.containsKey(configuredIp)) {
                    listOfNotCollectingDaemons.remove(configuredIp);
                }

            }

            // if not found, then save it as appropriate
            if (!foundFlag) {
                saveDaemonNotResponding(configuredIp);
            }
            if (!collecting) {
                saveDaemonNotCollectingMetrics(configuredIp);
            }
        }

        // clear the hashmap
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
     * @param ip - IP of the daemon that is not responding
     */
    private void saveDaemonNotResponding(String ip) {

        // add only if it does not already exist
        if (!listOfNotRespondingDaemons.containsKey(ip)) {
            Long systemEpoch = System.currentTimeMillis() / 1000;
            listOfNotRespondingDaemons.put(ip, systemEpoch);
            System.out.println("Saving Daemon not responding: " + ip + " date " + systemEpoch.toString());
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
     * @param ip - IP of the daemon that is not responding
     */
    private void saveDaemonNotCollectingMetrics(String ip) {
        // add only if it does not already exist
        if (!listOfNotCollectingDaemons.containsKey(ip)) {
            Long systemEpoch = System.currentTimeMillis() / 1000;
            listOfNotCollectingDaemons.put(ip, systemEpoch);
//            System.out.println("Daemon not collecting: " + ip + systemEpoch.toString());
        }
    }

    /**
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

    /**
     * Get the absolute file path for the log file.
     *
     * @param responding boolean - Are you calling this method for daemons not-responding or not-collecting?
     * @return
     */
    public String getFullFilePath(boolean responding) {
        String fileName;
        if (responding) {
            fileName = "NotResponding";
        } else {
            fileName = "NotCollecting";
        }
        return filePath + fileName + "-" + getTodayDate();
    }

    /**
     * Write the IP, time of the daemon to the corresponding log file.
     *
     * @param ip
     * @param time
     * @param responding boolean - Are you calling this method for daemons not-responding or not-collecting?
     */
    private void writeToFile(String ip, long time, boolean responding) {

        // create the line to be written in the log file
        String date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date(time * 1000));
        String line = "IP: " + ip + " since " + date + " (" + time + ")";

        // get file path
        String fullFile = getFullFilePath(responding);
        System.out.println("Writing to log: " + line);

        try {
            // append to file
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fullFile, true), "UTF-8");
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.write(line);
            fbw.newLine();
            fbw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks every not responding and/or not collecting daemons' timestamp.<br>
     * If timestamp is older than threshold, then logs it and deletes it from hashmap.
     */
    private void processNotRespondingCollectingDaemons() {

        System.out.println("Processing daemons' heartbeat & threshold");

        Iterator entries = listOfNotRespondingDaemons.entrySet().iterator();
        long systemEpoch = System.currentTimeMillis() / 1000;

        // iterate through not responding daemons
        while (entries.hasNext()) {

            // get key and value
            Map.Entry entry = (Map.Entry) entries.next();
            String key = entry.getKey().toString();
            Long value = Long.parseLong(entry.getValue().toString());

            // if the timestamp at which it was saved is greater than
            if (systemEpoch - value.longValue() > getThreshold()) {
                logDaemonNotResponding(key, value.longValue());
                // After saving to log, remove the entry
                entries.remove();
            }
        }

        // iterate through not collecting daemons
        entries = listOfNotCollectingDaemons.entrySet().iterator();
        while (entries.hasNext()) {

            //get key and value
            Map.Entry entry = (Map.Entry) entries.next();
            String key = entry.getKey().toString();
            Long value = Long.parseLong(entry.getValue().toString());

            // if the timestamp at which it was saved is greater than
            if (systemEpoch - value.longValue() > getThreshold()) {
                logDaemonNotCollecting(key, value.longValue());
                // After saving to log, remove the entry
                entries.remove();
            }
        }

    }

    /**
     * Sends the email for daemon not-responding or not-collecting depending on the flag
     *
     * @return boolean status of email sending
     */
    public boolean sendEMail() {

        System.out.println("Last email timestamp " + lastEmailTimestamp);
        System.out.println("Next email timestamp " + ( lastEmailTimestamp + (emailInterval * 60)));
        long systemEpoch = System.currentTimeMillis() / 1000;
        System.out.println("Current timestamp " + systemEpoch);

        // Return if enough time, as per emailInterval, has not passed
        if (systemEpoch - lastEmailTimestamp < (long) emailInterval * 60) {
            return false;
        }

        System.out.println("Email");
        // initailize email object
        NotificationEMail ne = new NotificationEMail();
        List<String> recipients = ne.initRecipients();

        // get both file paths
        String[] filePaths = {
                getFullFilePath(true),
                getFullFilePath(false)
        };

        // make email bodies
        String[] emailBodies = new String[2];
        ArrayList<String> ips = new ArrayList<String>();
        ArrayList<String> dates = new ArrayList<String>();

//        filePath = "/Users/prasanthnair/obs-prototype-intellij/src/main/java/com/observability/monitoring/server/NotResponding-2015-06-12";
//        System.out.println(filePath);

        int i = 0;

        // iterate through both types of non-responsiveness log filfes
        while (i < filePaths.length) {
            try {
                // Open file
                File fileDir = new File(filePaths[i]);
                if (!fileDir.exists()) {
                    System.out.println("File does not exist: " + filePaths[i]);
                    return false;
                }

                // read file
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
                String str;

                // get each line in the file
                while ((str = in.readLine()) != null) {

                    String ip = null, date = null, timestamp = null;

                    // example line: "IP: 441.442.444.446 since 06/22/2015 15:19:41 (1435000781)"

                    // get ip
                    Pattern pattern = Pattern.compile("\\ (.{1,3}?\\..{1,3}?\\..{1,3}?\\..{1,3}?\\ )*\\w", Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(str);
                    if (matcher.find()) {
                        ip = matcher.group(1);
                    }

                    // get timestamp
                    pattern = Pattern.compile("\\((.+)\\)", Pattern.CASE_INSENSITIVE);
                    matcher = pattern.matcher(str);
                    if (matcher.find()) {
                        timestamp = matcher.group(1);
                    }

                    // get whole date
                    pattern = Pattern.compile("since (.+)$", Pattern.CASE_INSENSITIVE);
                    matcher = pattern.matcher(str);
                    if (matcher.find()) {
                        date = matcher.group(1);
                    }


                    // if the entry is newer than last email sent, then add it. This means that this entry is a new daemon that failed that did not appaer in the last email.
                    if (!timestamp.isEmpty() && lastEmailTimestamp < Long.parseLong(timestamp)){
                        System.out.format("Last email timestamp %s | daemon time : %s | ip %s | date %s %n", lastEmailTimestamp, timestamp, ip, date);
                        ips.add(ip);
                        dates.add(date);
                    }
                }
                in.close();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(ips.size() == 0){
                return false;
            }

            // Not responding email
            if (i == 0) {
                emailBodies[i] = ne.makeNotRespondingEmailBody(ips, dates);
            }
            // Not collecting email
            else {
                emailBodies[i] = ne.makeNotCollectingEmailBody(ips, dates);
            }

            // clear the array list
            ips.clear();
            dates.clear();
            i++;
        }

        // If both emails are sent, then return true
        if (ne.sendEMail(recipients, "Observability: Daemons not responding", emailBodies[0], false) &&
                ne.sendEMail(recipients, "Observability: Daemons not collecting", emailBodies[1], false)) {
            lastEmailTimestamp = systemEpoch;
            return true;
        }
        return false;
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

                    // verify the heartbeats of clients
                    verifyDaemonHeartbeat();

                    // process deamons that have not send heartbeat for threshold
                    processNotRespondingCollectingDaemons();

                    // send mail
                    if (sendEMail()) {
                        System.out.println("Daemon Not respoding/collecting email sent");
                    }
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

        // initalize both hashmaps and the toggle
        HashMap<String, DaemonInfo> l1 = new HashMap<String, DaemonInfo>();
        HashMap<String, DaemonInfo> l2 = new HashMap<String, DaemonInfo>();
        AtomicBoolean toggle = new AtomicBoolean(true);

        // start main thread
        DaemonHeartbeatMain main = new DaemonHeartbeatMain(l1, l2, toggle);
        Thread t1 = new Thread(main);
        t1.start();

        // start UDP server thread
        DaemonHeartbeatListener listener = new DaemonHeartbeatListener(l1, l2, toggle);
        Thread t2 = new Thread(listener);
        t2.start();
    }

}

//java com/observability/monitoring/server/DaemonHeartbeatMain > missingDaemon 2>&1 &