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

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * DaemonHeartbeatClient is a process that runs in the daemons.<br>
 * 1. Periodically checks if measurements are being collected<br>
 * 2. Periodically sends heart beat message to collectd server. The message
 * depends on the outcome of step 1.<br>
 *
 * @author Prasanth Nair<br>
 *         Created June 5 2015<br>
 *         Joel Gao <br>
 *         Modified Jun 19 2015<br>
 */

public class DaemonHeartbeatClient extends Thread implements Serializable {

    /**
     * IP for the collectd server
     */
    String collectdServerIP;

    /**
     * Port of the collectd server
     */
    int collectdServerPort;

    String collectdMetricPath = "/home/ubuntu/collectd/csv/";

    /**
     * This daemon's IP. (IP of this machine)
     */
    String currentDaemonIP;

    /**
     * The metric used to check if measurements are being collected at the right
     * interval.
     */
    String metricName = "cpu-idle";

    /**
     * The frequency (sampling rate) at which measurements are collected.
     */
    int samplingRate = 30;

    /**
     * The epoch time of the system.
     */
    long systemEpoch;

    /*
     * Initialize collectd Server IP <br> Depending on where we are storing the
     * configuration, it can be taken from there. For now its hard coded.
     */
    public void initCollectdServerIP() {
        collectdServerIP = "52.6.202.212";
    }

    /*
     * Initialize collectd Server port <br> Depending on where we are storing
     * the configuration, it can be taken from there. For now its hard coded.
     */
    public void initCollectdServerPort() {
        collectdServerPort = 8102;
    }

    /*
     * Initialize current daemon IP. <br> Depending on where we are storing the
     * configuration, it can be taken from there. For now its hard coded.
     */
    public void initCurrentDaemonIP(String currentDaemonIP) {
        this.currentDaemonIP = currentDaemonIP;
    }

    /**
     * Default constructor. Also initializes the server IP and port and the IP of the current machine.
     */
    DaemonHeartbeatClient(String currentDaemonIP) {
        initCollectdServerIP();
        initCollectdServerPort();
        initCurrentDaemonIP(currentDaemonIP);
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

    /*
     * Method to get the file name of the metric CSV file.<br>
     *
     * @return String the full absolute path of the file including file name
     */
    public String getMetricFileName() {
        String date = "-" + getTodayDate();
        String metricNameAbsolutePath = collectdMetricPath + currentDaemonIP + "/cpu-0/" + metricName + date;
        // metricPath =
        // "/home/owls/collectd_data_20150604/csv/observabilityCassandra1/cpu-0/cpu-idle-2015-06-02";
        return metricNameAbsolutePath;
    }

    /**
     * Method to calculate the maximum confidence time-window. The measurement
     * collected should be newer than this time-window.
     *
     * @return int threshold
     */
    private int getThreshold() {
        return samplingRate * 2;
    }

    /**
     * Method to verify if a valid measurement is present in the CSV metric
     * file.<br>
     * A measurement is valid if it is newer than the configured threshold. <br>
     *
     * @return boolean Returns true if valid. False if not.
     * @throws IOException
     */
    public boolean verifyLatestMetricMeasurement(String fileName) {
        systemEpoch = System.currentTimeMillis() / 1000;

        // Read the metric file in csv folder
        boolean verification = false;
        FileInputStream stream = null;
        String strLine, temp = null;
        try {
            stream = new FileInputStream(fileName);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

            // Read file line by line and save the last line.
            while (true) {
                if ((strLine = br1.readLine()) == null) {
                    break;
                }
                temp = strLine;
            }

            // Close the input stream
            br1.close();
        } catch (RuntimeException e) {
            System.out.println("Collectd metric file: RuntimeException occured");
            //e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Collectd metric file not found.");
//            e.printStackTrace();
//            verification = false;
        }

        // extract timestamp and save
        if (temp != null) {
            temp = temp.substring(0, temp.indexOf('.'));
            long metricLatestEpoch = Long.parseLong(temp);

            // check if the measurement is older than threshold
            int thresholod = getThreshold();
            if ((systemEpoch - metricLatestEpoch) <= thresholod) {
                verification = true;
            }
        }
        return verification;
    }

    /**
     * Method to send a message to collectd server.<br>
     * Currently uses TCP. Should change to UDP.<br>
     *
     * @param message
     */
    public void sendToCollectdServer(String message) {
        try {

            // Send the packet via UDP
            byte[] buffer = message.getBytes("UTF-8");
            InetAddress address = InetAddress.getByName(collectdServerIP);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, collectdServerPort);

            // send the message in the packet
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.send(packet);
            System.out.println("Message sent: " + message);
            datagramSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to create the message that will be sent to collectd server.
     * Message Protocol :<br>
     * <current daemon IP>_<the epoch time of the system>_<METRIC_VERIFICATIONn><br>
     * METRIC_VERIFICATION:<br>
     * 1 = metric is old<br>
     * 2 = metric is ok and latest<br>
     *
     * @param metricLatestVerified - is the latest metric verified?
     * @return String message
     */
    private String getMessage(boolean metricLatestVerified) {
        String message = currentDaemonIP;
        message += "_" + Long.toString(systemEpoch);
        if (metricLatestVerified) {
            message += "_2";
        } else {
            message += "_1";
        }
        return message;
    }

    /**
     * Update the interval upon change of collectd configuration
     */
    public void updateInterval() {
        System.out.println("Daemon Heartbeat interval updated to " + samplingRate);
    }

    /**
     * Method to verify the measurement and send the message.<br>
     * Needs optimization.
     */
    public void run() {
        while (true) {
            boolean metricLatestVerified = false;
            try {
                // get the file name and verify the last measurement
                String fileName = getMetricFileName();
                metricLatestVerified = verifyLatestMetricMeasurement(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // get the message to be sent and send it to server
            String message = getMessage(metricLatestVerified);
            sendToCollectdServer(message);
            System.out.println(systemEpoch + " : " + metricLatestVerified);

            // pause thread for the collection interval
            try {
                long sleepTime = (long) samplingRate * 1000;
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// http://stackoverflow.com/questions/3541676/java-thread-every-x-seconds
//