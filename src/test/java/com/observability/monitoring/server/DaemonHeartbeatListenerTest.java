package com.observability.monitoring.server;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Before;
import org.junit.Test;

public class DaemonHeartbeatListenerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDaemonHeartbeatListener() {
		HashMap<String, DaemonInfo> l1 = new HashMap<String, DaemonInfo>();
		HashMap<String, DaemonInfo> l2 = new HashMap<String, DaemonInfo>(); 
		AtomicBoolean daemonHeartbeatCollectionToggle = new AtomicBoolean(false);
		DaemonHeartbeatListener dhbl = new DaemonHeartbeatListener(l1, l2, daemonHeartbeatCollectionToggle);
		assertNotNull(dhbl);
		System.out.println(dhbl.toString());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testRun() {
		/*
		HashMap<String, DaemonInfo> l1 = new HashMap<String, DaemonInfo>();
		HashMap<String, DaemonInfo> l2 = new HashMap<String, DaemonInfo>(); 
		AtomicBoolean daemonHeartbeatCollectionToggle = new AtomicBoolean(false);
		DaemonHeartbeatListener dhbl = new DaemonHeartbeatListener(l1, l2, daemonHeartbeatCollectionToggle);
		assertNotNull(dhbl);
		Thread t = new Thread(dhbl);
		t.start();
		System.out.println(t.toString());
		try {
			t.join();
			Thread.sleep(100);
			t.stop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
