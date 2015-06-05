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

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.Vector;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for com.observability.monitoring.daemon.DaemonManager.
 * <p>
 * In bin folder, run the following command to start testing<br>
 * sudo java -cp .:sr/share/java/junit4.jar com.observability.monitoring.daemon.DaemonManagerTest
 * <p>
 * To test saving to conf file, make sure there is a collect.conf file in the same folder.
 * <p>
 * @author Ying (Joel) Gao
 * <p>
 * History:<br>
 * 1. Created					Jun 02 2015<br>
 *
 */
public class DaemonManagerTest {

	private static DaemonManager dm = null;
	
	@BeforeClass
    public static void setUp() {	
		try {
			dm = new DaemonManager();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#killProcess(java.lang.String)}.
	 */
	@Ignore @Test
	public void testKillProcess() {
		System.out.println("Start testing for killing collectd");
		String processmame = "collectdmon"; 
		// Kill collectd monitor
		DaemonManager.killProcess(processmame);
		
		processmame = "collectd"; 
		// Kill collectd
		DaemonManager.killProcess(processmame);
		
		// check if it is killed
		boolean killed = true;
		try {
	        Vector<String> commands = new Vector<String>();
	        commands.add("pidof");
	        commands.add(processmame);
	        ProcessBuilder pb = new ProcessBuilder(commands);
	        Process pr = pb.start();
	        pr.waitFor();
	        if (pr.exitValue() != 0)
	        	return;
	        BufferedReader outReader = new BufferedReader(new InputStreamReader(pr.getInputStream(),"UTF-8"));
	        String pros = outReader.readLine();
	        if(pros != null && pros.length() > 0) {
		        // no, we still have collectd process
	        	String [] strs = pros.trim().split(" ");
	        	System.out.println("Got the following pid of collectd");
		        for (String pid : strs) {
		            System.out.println("Collectd pid: " + pid);
		        }
		        killed = false;
		        fail("collecd process not killed!");
	        }
	        outReader.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		Assert.assertTrue(killed);
		System.out.println("End testing for killing collectd");
	}

	/**
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#startProcess(java.lang.String)}.
	 */
	@Test
	public void testStartProcess() {
		System.out.println("Start testing for starting collectd");
		String processmame = "collectd"; 
		// Start collectd monitor
		DaemonManager.startProcess(processmame);
		
		// check if it is started
		boolean started = false;
		try {
			// Wait for collectd to start up
			Thread.sleep(2000);
			Vector<String> commands = new Vector<String>();
			commands.add("pidof");
			commands.add(processmame);
			ProcessBuilder pb = new ProcessBuilder(commands);
			Process pr = pb.start();
			pr.waitFor();
			
			if (pr.exitValue() != 0){
				//System.out.println("Pr exit value is not 0");
				//fail("collecd process not started!");
				return;
			}
			BufferedReader outReader = new BufferedReader(new InputStreamReader(pr.getInputStream(),"UTF-8"));
			String pros = outReader.readLine();
			if(pros != null && pros.length() > 0) {
				// yes, we have started collectd process
			    String [] strs = pros.trim().split(" ");
			    System.out.println("Got the following pid of collectd");
				for (String pid : strs) {
					System.out.println("Collectd pid: " + pid);
				}
				started = true;
			 }
			 outReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(started);
		System.out.println("End testing for starting collectd");
	}

	/**
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#startConfigurationModification()}.
	 */
	//@Test
	public void testStartConfigurationModification() {
		try {
			boolean ret = dm.startConfigurationModification();
			Assert.assertTrue(ret);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#changeConfiguration(java.lang.String, java.lang.String)}.
	 */
	//@Test
	public void testChangeConfiguration() {
		try{
			// change interval from 30 to 20
			dm.changeConfiguration("Interval 30", "Interval 20");
			// comment out LoadPlugin "logfile"
			dm.changeConfiguration("LoadPlugin \"logfile\"", "#LoadPlugin \"logfile\"");
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
			dm.changeConfiguration(s1, s2);
			// add a new section
			String s3 = "<Plugin \"perl\">\n" +
					"  Interval 60\n" +
					"</Plugin>";
			dm.changeConfiguration(null, s3);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#replaceWholeConfiguration(java.lang.String)}.
	 */
	//@Test
	public void testReplaceWholeConfiguration() {
		try {
			String s1 = 
					"Interval 30\n" +
					"LoadPlugin \"logfile\"\n" +
					"<Plugin \"logfile\">\n" +
					"  LogLevel \"info\"\n" +
					"  File \"/home/owls/collectd/log/collectd.log\"\n" +
					"  Timestamp true\n" +
					"  PrintSeverity true\n" +
					"</Plugin>";
			
			boolean ret = dm.replaceWholeConfiguration(s1);
			Assert.assertTrue(ret);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#stopConfigurationModification()}.
	 */
	//@Test
	public void testStopConfigurationModification() {
		try {
			boolean ret = dm.stopConfigurationModification();
			Assert.assertTrue(ret);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#startConfigurationModification()}.
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#changeConfiguration(java.lang.String, java.lang.String)}.
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#replaceWholeConfiguration(java.lang.String)}.
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#stopConfigurationModification()}.
	 */
	@Test
	public void testConfigurationModification() {
		testStartConfigurationModification();
		testChangeConfiguration();
		testStopConfigurationModification();
		testReplaceWholeConfiguration();
	}

	public static void main(String[] args) {
		
		System.out.println("Start testing: com.observability.monitoring.daemon.DaemonManagerTest");
		DaemonManagerTest dmt = new DaemonManagerTest();
		// 1. test constructor
		System.out.println("1. Test constructor");
		//dmt.testDaemonManager();
		setUp();
		System.out.println("1. Done");
		
		// 2. test kill collectd
		System.out.println("2. Test kill collectd");
		dmt.testKillProcess();
		System.out.println("2. Done");
		// kill again
		//dmt.testKillProcess();
		
		// 3. test start collectd
		System.out.println("3. Test start collectd");
		dmt.testStartProcess();
		System.out.println("3. Done");
		
		// 4. test modify the configuration file
		System.out.println("4. Test modify the configuration file");
		System.out.println("4.1. Start");
		dmt.testStartConfigurationModification();
		System.out.println("4.2. Modify");
		dmt.testChangeConfiguration();
		///*
		System.out.println("4.3. Replace all");
		dmt.testReplaceWholeConfiguration();
		//*/
		System.out.println("4.4. Stop");
		dmt.testStopConfigurationModification();
		System.out.println("4. Done");

		// end all tests
		System.out.println("Finished testing: com.observability.monitoring.daemon.DaemonManagerTest");
		System.exit(0);
	}
}
