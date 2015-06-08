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
import java.util.ArrayList;

/**
 * DaemonHeartbeatServer is a process that runs in the server. Functionalities<br>
 * 1. Keeps in a list of daemons that is supposed to send heartbeat.<br>
 * 2. Listens to all the heartbeats from the daemons.<br>
 * 3. Cross checks to find out which daemons did not respond and which daemons
 * is having trouble collecting metrics.<br>
 * 
 * @author Prasanth Nair<br>
 *         Created June 5 2015<br>
 */

public class DaemonHeartbeatServer extends Thread {

	/**
	 * DaemonInfo is a class to hold the information of each daemons.<br>
	 * 
	 * @author Prasanth Nair
	 */
	class DaemonInfo {
		String ip;
		String epoch;
		boolean metricStatus;

		public DaemonInfo(String ip, String epoch, boolean metricStatus) {
			this.ip = ip;
			this.epoch = epoch;
			this.metricStatus = metricStatus;
		}

		public String toString() {
			return ip + " : " + epoch + " : " + metricStatus;
		}
	}

	/**
	 * Port that will be used by the daemons to connect to this server.
	 */
	private int port;

	private ServerSocket serverSocket;

	/**
	 * List of daemons that is supposed to send the heartbeat.
	 */
	private ArrayList<String> listOfConfiguredDaemons = new ArrayList<String>();

	/**
	 * Sampling rate of this process. It should be same as the daemons.<br>
	 * Currently hard coded to 30.
	 */
	int samplingRate = 30;

	/**
	 * List of daemons that has send heartbeat for each interval. <br>
	 * It is of type DaemonInfo because it will hold information of each of the
	 * daemons.
	 */
	private ArrayList<DaemonInfo> listOfDaemonHearbeatReceived = new ArrayList<DaemonInfo>();

	/**
	 * Constructor to create a socket for connection with the port.<br>
	 * Also initializes the list of daemons that is supposed to send the
	 * heartbeats.
	 * 
	 * @param port
	 * @throws IOException
	 */
	public DaemonHeartbeatServer(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
		initListofConfiguredDaemons();
		// serverSocket.setSoTimeout(10000);
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
	 * Method to decrypt the message from the daemon and save it to
	 * listOfDaemonHearbeatReceived
	 * 
	 * @param String
	 *            messageFromDaemon
	 */
	private void saveDaemonInfo(String messageFromDaemon) {
		String[] daemonInfo = messageFromDaemon.split("_");
		listOfDaemonHearbeatReceived.add(new DaemonInfo(daemonInfo[0], daemonInfo[1], (daemonInfo[2].equals("2") ? true : false)));
	}

	/**
	 * Method to verify which all daemons have sent the hearbeat and which all
	 * daemons are having trouble collecting metrics.<br>
	 * Calls logDaemonsNotResponding or logDaemonsNotCollectingMetrics as deemed
	 * appropriate.
	 */
	private void verifyDaemonHeartbeat() {
		// System.out.println(listOfDaemonHearbeatReceived.get(0).toString());
		// System.out.println(listOfDaemonHearbeatReceived.get(1));

		System.out.println("Verifying daemons");
		System.out.println(listOfConfiguredDaemons.size());
		System.out.println(listOfDaemonHearbeatReceived.size());
		for (int i = 0; i < listOfConfiguredDaemons.size(); i++) {
			boolean foundFlag = false;
			boolean collecting = false;
			for (int j = 0; j < listOfDaemonHearbeatReceived.size(); j++) {
				if (listOfConfiguredDaemons.get(i).equals(listOfDaemonHearbeatReceived.get(j).ip)) {
					foundFlag = true;
					collecting = listOfDaemonHearbeatReceived.get(j).metricStatus;
					break;
				}
			}
			if (!foundFlag) {
				logDaemonsNotResponding(listOfConfiguredDaemons.get(i));
			}
			if (!collecting) {
				logDaemonsNotCollectingMetrics(listOfConfiguredDaemons.get(i));
			}
		}
		listOfDaemonHearbeatReceived.clear();
	}

	/**
	 * Method to log/notify a dead daemon.
	 * 
	 * @param ip
	 */
	private void logDaemonsNotResponding(String ip) {
		System.out.println("Daemon not responding: " + ip);

	}

	/**
	 * Method to log/notify daemon having trouble collecting metrics.
	 * 
	 * @param ip
	 */
	private void logDaemonsNotCollectingMetrics(String ip) {
		System.out.println("Daemon not collecting: " + ip);
	}

	/**
	 * Method to listen to all communications coming from the daemons.<br>
	 * Currently uses TCP. Should change to UDP.<br>
	 * Resets at every samplingRate.
	 */
	private void listenForDaemons() {
		long startEpoch = System.currentTimeMillis() / 1000;
		while (true) {
			try {
				Socket server = serverSocket.accept();
				// String connectedDaemonIP =
				// server.getRemoteSocketAddress().toString();
				DataInputStream in = new DataInputStream(server.getInputStream());
				String messageFromDaemon = in.readUTF();
				server.close();

				System.out.println(messageFromDaemon);
				saveDaemonInfo(messageFromDaemon);

				long currentEpoch = System.currentTimeMillis() / 1000;
				if (currentEpoch - startEpoch > samplingRate) {
					break;
				}

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	/**
	 * Starts the thread.<br>
	 * After every samplingRate, verifies the daemon list and then listens
	 * again.
	 */
	public void run() {
		while (true) {
			listenForDaemons();
			verifyDaemonHeartbeat();
		}
	}

	public static void main(String[] args) {
		try {
			Thread t = new DaemonHeartbeatServer(52740);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
