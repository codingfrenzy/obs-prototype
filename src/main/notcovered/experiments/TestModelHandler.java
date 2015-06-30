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

package com.observability.experiments;

import java.rmi.RemoteException;

import com.observability.monitoring.daemon.IDaemonManagerServer;

/**
 * TestModelHandler is an experiment program to communicate with com.observability.monitoring.daemon.DaemonManager.
 * It does the following tests:
 * 1. Communicate with DaemonManager through RMI;
 * 2. Simulate user changing model and propagating changes to DaemonManager.
 * @author Ying (Joel) Gao
 * 
 * History: 
 * 1. Created					Jun 03 2015
 *
 */

public class TestModelHandler {

	private static IDaemonManagerServer dmServer = null;
	/**
	 * @param args IP & Port of the RMI server
	 */
	public static void main(String[] args) {
		// Get IP & port from arguments
		if(args.length  != 2){
			System.out.println("TestModelHandler - error - should be started with two parameters: IP + port.");
			return;
		}

		String rmiIP = args[0];
		String rmiPort = args[1];
		
		try{
			dmServer = TestModelHandlerClient.getServerInstance(rmiIP, rmiPort);
		}
		catch(Exception e) {
			e.printStackTrace(); //you should actually handle exceptions properly
		}

		if(dmServer == null) {
			System.out.println("TestModelHandler - error - Cannot connect to server: " + rmiIP + " Port: " + rmiPort);
			return;
		}
		
		boolean ret = false;
		try {
			// 1. Start modifying configuration
			ret = dmServer.startConfigurationModification();
			if(!ret){//failed
				System.out.println("Failed to start configuration modification.");
				return;
			}
			// 2. Modify the content
			// change interval from 30 to 20
			dmServer.changeConfiguration("Interval 30", "Interval 20");
			// comment out LoadPlugin "logfile"
			dmServer.changeConfiguration("LoadPlugin \"logfile\"", "#LoadPlugin \"logfile\"");
			// change the whole section 
			String s1 = "<Plugin \"logfile\">\n" +
						"  LogLevel \"info\"\n" +
						"  File \"/home/owls/collectd/log/collectd.log\"\n" +
						"  Timestamp true\n" +
						"  PrintSeverity true\n" +
						"</Plugin>";
			String s2 = "<Plugin \"logfile\">\n" +
					"  LogLevel \"info\"\n" +
					"  File \"/home/owls/collectd/log/collectd1.log\"\n" +
					"  Timestamp false\n" +
					"  PrintSeverity false\n" +
					"</Plugin>";
			dmServer.changeConfiguration(s1, s2);
			// add a new section
			String s3 = "<Plugin \"perl\">\n" +
					"  Interval 60\n" +
					"</Plugin>";
			dmServer.changeConfiguration(null, s3);
			// Replace the whole file
			s1 = 
					"Interval 30\n" +
					"LoadPlugin \"logfile\"\n" +
					"<Plugin \"logfile\">\n" +
					"  LogLevel \"info\"\n" +
					"  File \"/home/owls/collectd/log/collectd.log\"\n" +
					"  Timestamp true\n" +
					"  PrintSeverity true\n" +
					"</Plugin>";
			
			dmServer.replaceWholeConfiguration(s1);
			// 3. Stop configuration process
			ret = dmServer.stopConfigurationModification();
			if(!ret){//failed
				System.out.println("Failed to stop configuration modification.");
				return;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
