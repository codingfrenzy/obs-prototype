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
import java.net.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * DaemonHeartbeatListener is a thread of the DaemonHeartbeatMain process<br>
 * 1. It listens to UDP packets continuously.<br>
 * 2. Depending on the toggle (maintained by Main class), it saves the daemon info to the corresponding hashmap.
 *
 * @author Prasanth Nair<br>
 *         Created June 10 2015<br>
 */
public class DaemonHeartbeatListener implements Runnable {

    /**
     * Port that will be used by the daemons to connect to this server.
     */
    private int port = 52740;

    /**
     * List of daemons that has send heartbeat for each interval. <br>
     * There are 2 HashMaps so as to avoid editing information of one while it is being reset.<br>
     * Allows stable data transfer between 2 threads.<br>
     * The switching happen based on the boolean toggle.
     */
    private HashMap<String, DaemonInfo> listOfDaemonHeartbeatReceived1;
    private HashMap<String, DaemonInfo> listOfDaemonHeartbeatReceived2;

    private AtomicBoolean daemonHeartbeatCollectionToggle;

//    private ServerSocket serverSocket;

    /**
     * Constructor<br>
     * Intiliazes the reference to the 2 Hashmap objects and the AtomicBoolean object that controls the toggle.
     *
     * @param HashMap       list1
     * @param HashMap       list2
     * @param AtomicBoolean daemonHeartbeatCollectionToggle - This is used for switch between the hashmaps between threads.
     */
    DaemonHeartbeatListener(HashMap<String, DaemonInfo> l1, HashMap<String, DaemonInfo> l2, AtomicBoolean daemonHeartbeatCollectionToggle) {
        listOfDaemonHeartbeatReceived1 = l1;
        listOfDaemonHeartbeatReceived2 = l2;
        this.daemonHeartbeatCollectionToggle = daemonHeartbeatCollectionToggle;
    }

    /**
     * Method to continuously listen to all communications coming from the daemons.<br>
     * Uses UDP.<br>
     */
    private void listenForDaemons() throws SocketException {

        DatagramSocket datagramSocket = new DatagramSocket(port);
        while (true) {
            try {
                byte[] buffer = new byte[30];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(packet);
                buffer = packet.getData();
                String messageFromDaemon = new String(buffer, "UTF-8");
                System.out.println(messageFromDaemon);

                saveDaemonInfo(messageFromDaemon);

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        datagramSocket.close();
    }

    /**
     * Method to decrypt the message from the daemon and save it to
     * listOfDaemonHeartbeatReceived1 or listOfDaemonHeartbeatReceived2 depending on the toggle.
     *
     * @param String messageFromDaemon
     */
    private void saveDaemonInfo(String messageFromDaemon) {
        String[] daemonInfo = messageFromDaemon.split("_");
        if (daemonHeartbeatCollectionToggle.get()) {
            listOfDaemonHeartbeatReceived1.put(daemonInfo[0], new DaemonInfo(daemonInfo[0], daemonInfo[1], (daemonInfo[2].equals("2"))));
//            System.out.println("Using SH1");
        } else {
            listOfDaemonHeartbeatReceived2.put(daemonInfo[0], new DaemonInfo(daemonInfo[0], daemonInfo[1], (daemonInfo[2].equals("2"))));
//            System.out.println("Using SH2");
        }
    }

    /**
     * Starts this thread.
     */
    public void run() {
        try {
            listenForDaemons();
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
}
