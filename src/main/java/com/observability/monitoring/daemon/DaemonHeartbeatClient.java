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
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;

public class DaemonHeartbeatClient extends Thread {

	String collectdServerIP;
	int collectdServerPort;
	String currentDaemonIP;
	Socket client;
	String metricNameAbsolutePath;
	String metricName = "cpu-idle";
	int samplingRate = 30;
	long systemEpoch;

	public void initCollectdServerIP() {
		collectdServerIP = "45.55.197.112";
	}

	public void initCollectdServerPort() {
		collectdServerPort = 52740;
	}

	public void initCurrentDaemonIP() {
		currentDaemonIP = "45.55.240.162";
	}

	public String getTodayDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public void initMetricFileName() {
		String date = "-" + getTodayDate();
		metricNameAbsolutePath = "/home/owls/collectd/csv/" + currentDaemonIP + "/cpu-0/" + metricName + date;
		// metricPath =
		// "/home/owls/collectd_data_20150604/csv/observabilityCassandra1/cpu-0/cpu-idle-2015-06-02";
	}

	public boolean verifyLatestMetricMeasurement() throws IOException {
		initMetricFileName();
		FileInputStream stream = null;
		stream = new FileInputStream(metricNameAbsolutePath);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(stream));
		String strLine, temp = null;

		// Read file line by line and save the last line.
		while (true) {
			if ((strLine = br1.readLine()) == null) {
				break;
			}
			temp = strLine;
		}

		// Close the input stream
		br1.close();

		System.out.println(metricNameAbsolutePath);
		System.out.println(temp);

		temp = temp.substring(0, temp.indexOf('.'));

		systemEpoch = System.currentTimeMillis() / 1000;
		long metricLatestEpoch = Long.valueOf(temp).longValue();

		int thresholod = samplingRate * 2;
		if ((systemEpoch - metricLatestEpoch) <= thresholod) {
			return true;
		}
		return false;
	}

	public void sendToCollectdServer(String message) {
		try {

			Socket client = new Socket(collectdServerIP, collectdServerPort);

			// client.getLocalPort(); // local port
			// client.getLocalSocketAddress(); // local IP & port
			// client.getRemoteSocketAddress(); // collectd server IP & port

			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF(message);
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("Server says " + in.readUTF());
			client.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		initCollectdServerIP();
		initCollectdServerPort();
		initCurrentDaemonIP();
		boolean metricLatestVerified = false;
		try {
			metricLatestVerified = verifyLatestMetricMeasurement();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(metricLatestVerified);
		String message = Long.toString(systemEpoch);
		if (metricLatestVerified) {
			message += "_2";
		} else {
			message += "_1";
		}
		sendToCollectdServer(message);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DaemonHeartbeatClient t = new DaemonHeartbeatClient();
		t.initCollectdServerIP();
		t.initCollectdServerPort();
		t.start();

	}

}
