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

import java.io.File;
import java.net.URL;
import java.rmi.RemoteException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for com.observability.monitoring.daemon.DaemonManager.
 * <p>
 * In bin folder, run the following command to start testing<br>
 * sudo java -cp .:/usr/share/java/junit4.jar com.observability.monitoring.daemon.DaemonManagerTest
 * <p>
 * To test saving to conf file, make sure there is a collect.conf file in the same folder.
 * <p>
 * @author Ying (Joel) Gao
 * <p>
 * History:<br>
 * 1. Created					Jun 02 2015<br>
 * 2. Modified 					Jun 19 2015<br>
 * 3. Modified					Jly 14 2015<br>
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
	//@Ignore @Test
	@Test
	public void testKillProcess() {
		System.out.println("Start testing for killing collectd");
		String processmame = "collectdmon"; 
		// Kill collectd monitor
		DaemonManager.killProcess(processmame);
		
		processmame = "collectd"; 
		// Kill collectd
		DaemonManager.killProcess(processmame);
	}
	
	@Test
	public void testKillProcess1() {
		System.out.println("Start testing for killing collectd");
		String processmame = "collectdmon1"; 
		// Kill collectd monitor
		DaemonManager.killProcess(processmame);
		
		processmame = "collectd1"; 
		// Kill collectd
		DaemonManager.killProcess(processmame);
		
		DaemonManager.killProcess("-impossible");
	}

	/**
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#startProcess(java.lang.String)}.
	 */
	@Test
	public void testStartProcess() {
		System.out.println("Start testing for starting collectd");
		//String processmame = "collectd"; 
		String processmame = "/opt/collectd/sbin/collectd";
		// Start collectd monitor
		DaemonManager.startProcess(processmame);
	}

	/**
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#startConfigurationModification()}.
	 */
	//@Test
	public void testStartConfigurationModification() {
		try {
			ClassLoader classLoader = DaemonManagerTest.class.getClassLoader();
			URL path = classLoader.getResource("collectd.conf");
			
			DaemonManager.setConfigurationFilePath( new File (path.getFile()).toPath().toString());
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
	@Test
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
			
			dm.changeConfiguration(null, "");
			
			dm.changeConfiguration("", null);
			dm.changeConfiguration(null, null);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeConfiguration1() {
		try{
			// change interval from 30 to 20
			dm.changeConfiguration("Interval 30", "Interval 20");
			// comment out LoadPlugin "logfile"
			dm.changeConfiguration("Interval 31", "Interval 21");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#replaceWholeConfiguration(java.lang.String)}.
	 */
	@Test
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
			//Assert.assertTrue(ret);
			
			ret = dm.replaceWholeConfiguration(null);
			Assert.assertFalse(ret);
			
			ret = dm.replaceWholeConfiguration("");
			Assert.assertFalse(ret);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.observability.monitoring.daemon.DaemonManager#stopConfigurationModification()}.
	 */
	@Test
	public void testStopConfigurationModification() {
		try {
			DaemonManager.setConfigurationFilePath("collectd.conf");
			boolean ret = dm.stopConfigurationModification();
			Assert.assertTrue(ret);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testStopConfigurationModification1() {
		try {
			DaemonManager dm1 = new DaemonManager();
			DaemonManager.setConfigurationFilePath("collectd.conf");
			DaemonManager.initializeService("1.2.3.4", "8101");
			boolean ret = dm1.stopConfigurationModification();
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
	
	@Test
	public void testInitializeService() {
		DaemonManager.initializeService("127.0.0.1", "22345");
	}
	
	@Test
	public void testmain0() {
		String[] args = new String[1];
		args[0] = "10.20.30.40";

		DaemonManager.main(args);
	}
	
	@Test
	public void testmain1() {
		String[] args = new String[2];
		args[0] = "10.20.30.40";
		args[1] = "21323";
		DaemonManager.main(args);
	}
	
	@Test
	public void testmain3() {
		String[] args = new String[3];
		args[0] = "10.20.30.40";
		args[1] = "21323";
		args[2] = "aqsdd";
		DaemonManager.main(args);
	}
	
	@Test
	public void testmain4() {
		String[] args = new String[4];
		args[0] = "10.20.30.40";
		args[1] = "21323";
		args[2] = "aqsdd";
		args[3] = "aqaaaaq";
		DaemonManager.main(args);
	}
	
	@Test
	public void testgetConfigurationFilePath() {
		String s1 = DaemonManager.getConfigurationFilePath();
		System.out.println(s1);
	}
/*
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
		//
		System.out.println("4.3. Replace all");
		dmt.testReplaceWholeConfiguration();
		//
		System.out.println("4.4. Stop");
		dmt.testStopConfigurationModification();
		System.out.println("4. Done");

		// end all tests
		System.out.println("Finished testing: com.observability.monitoring.daemon.DaemonManagerTest");
		System.exit(0);
	}
	*/
}
