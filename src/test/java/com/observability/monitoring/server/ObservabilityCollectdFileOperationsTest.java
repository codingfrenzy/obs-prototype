package com.observability.monitoring.server;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class ObservabilityCollectdFileOperationsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testUpdateIPList() {
		ArrayList<String> ipList = new ArrayList<String>();
		for(int i = 1 ; i < 6 ; i++)
			ipList.add("1.1.1." + i);
		ObservabilityCollectdFileOperations.updateIPList(ipList);
	}

	@Test
	public void testUpdateFailedPropogation() {
		ArrayList<String> ipList = new ArrayList<String>();
		for(int i = 1 ; i < 6 ; i++)
			ipList.add("1.1.1." + i);
		ObservabilityCollectdFileOperations.updateFailedPropogation(ipList);
	}

	@Test
	public void testGetIPList() {
		//HashSet<String> ipl = ObservabilityCollectdFileOperations.getIPList();
		//if(ipl != null)
		//	System.out.println(ipl.toString());
	}

	@Test
	public void testGetFailedIPList() {
		HashSet<String> ipl = ObservabilityCollectdFileOperations.getFailedIPList();
		System.out.println(ipl.toString());
	}

	@Test
	public void testLogMessageAggregation() {
		ObservabilityCollectdFileOperations.logMessageAggregation("test Aggregation");
	}

	@Test
	public void testLogMessageMissingDaemonNotCollecting() {
		ObservabilityCollectdFileOperations.logMessageMissingDaemonNotCollecting("test DaemonNotCollecting");
	}

	@Test
	public void testLogMessageMissingDaemonNotResponding() {
		ObservabilityCollectdFileOperations.logMessageMissingDaemonNotResponding("test DaemonNotResponding");
	}

	@Test
	public void testLogMessageDBHandler() {
		ObservabilityCollectdFileOperations.logMessageDBHandler("test DBHandler");
	}

	@Test
	public void testLogMessageModelDataHandler() {
		ObservabilityCollectdFileOperations.logMessageModelDataHandler("test ModelDataHandler");
	}

	@Test
	public void testGetTodayDate() {
		String dt = ObservabilityCollectdFileOperations.getTodayDate();
		System.out.println(dt);
	}

	@Test
	public void testLastModifiedCollectdConf() {
		long lm = ObservabilityCollectdFileOperations.lastModifiedCollectdConf();
		System.out.println("Last modified collectd conf time: " + lm);
	}

	@Test
	public void testLastModifiedDaemonIP() {
		long lm = ObservabilityCollectdFileOperations.lastModifiedDaemonIP();
		System.out.println("Last modified daemon ip time: " + lm);
	}

	@Test
	public void testMain() {
		String []args = new String[1];
		args[0] = "1.2.3.4";
		ObservabilityCollectdFileOperations.main(args);
	}

}
