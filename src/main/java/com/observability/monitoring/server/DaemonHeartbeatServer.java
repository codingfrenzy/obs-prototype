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

public class DaemonHeartbeatServer extends Thread {

	private ServerSocket serverSocket;
	private ArrayList<String> listOfDaemonsIP = new ArrayList<String>();
	private int missingDaemonThreshold;

	public DaemonHeartbeatServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		// serverSocket.setSoTimeout(10000);
	}
	
	private void initListofDaemons(){
		listOfDaemonsIP.add("45.55.240.162");
		listOfDaemonsIP.add("128.2.204.246");
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());

				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
				server.close();

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args) {
		int port = 52740;
		try {
			Thread t = new DaemonHeartbeatServer(port);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
