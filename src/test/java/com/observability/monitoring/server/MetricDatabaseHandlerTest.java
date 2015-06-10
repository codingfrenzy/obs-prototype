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

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Rajat Kapoor
 * References: https://docs.oracle.com/javase/tutorial/rmi/implementing.html
 * How to run:
 * 1. Start MetricDatabaseHandler in server:
 * 		java com.observability.monitoring.server.MetricDatabaseHandler 8100
 * 2. Right-click on this file and run as Junit test
 */
public class MetricDatabaseHandlerTest {
	// These variables should be set before running the JUnit:
	// These are all values that should return positive results:
	static final String rmiIp = "45.55.197.112";		// Server IP
	static final String rmiPort = "8100";		// Server port
	// testGetMetricValueAtEpoch variables to be set:
	static final String epoch1 = "1433641326.507";
	static final String metricPath1 = "collectd/observabilityCassandra1/memory/memory-used";
	// testGetMetricsBtwEpochRange variables to be set:
	static final String fromEpoch2 = "1433641326.507";
	static final String toEpoch2 = "1433641416.508";
	static final String metricPath2 = "collectd/observabilityCassandra1/memory/memory-used";
	// testUpdateMetrics variables to be set:
	static final String[] epoch3 = new String[]{"1433641326.507", "1433641416.508"};
	static final String[] values3 = new String[]{"242106369.000000", "242126849.000000"};
	static final String metricPath3 = "collectd/observabilityCassandra1/memory/memory-used";
	
	private static IMetricDatabaseHandlerServer imdhs;
	
	@BeforeClass
    public static void setUp() {
	try {
			imdhs = (IMetricDatabaseHandlerServer)Naming.lookup("rmi://"+rmiIp+":"+rmiPort+"/MetricDatabaseHandler");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test method for {@link com.observability.monitoring.server.MetricDatabaseHandler#getMetricValueAtEpoch(java.lang.String, java.lang.String)}.
	 * @throws RemoteException 
	 */
	@Test
	public void testGetMetricValueAtEpoch() throws RemoteException {
		assertNotNull(imdhs.getMetricValueAtEpoch(epoch1, metricPath1));	// positive TC
		assertNull(imdhs.getMetricValueAtEpoch("", metricPath1));			// negative TC
	}

	/**
	 * Test method for {@link com.observability.monitoring.server.MetricDatabaseHandler#getMetricsBtwEpochRange(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws RemoteException 
	 */
	@Test
	public void testGetMetricsBtwEpochRange() throws RemoteException {
		assertNotNull(imdhs.getMetricsBtwEpochRange(fromEpoch2, toEpoch2, metricPath2));	// positive TC
		assertNull(imdhs.getMetricsBtwEpochRange(fromEpoch2, null, metricPath2));			// negative TC
	}

	/**
	 * Test method for {@link com.observability.monitoring.server.MetricDatabaseHandler#updateMetrics(java.lang.String[], java.lang.String[], java.lang.String)}.
	 * @throws RemoteException 
	 */
	@Test
	public void testUpdateMetrics() throws RemoteException {
		assertTrue(imdhs.updateMetrics(epoch3, values3, metricPath3));	// positive TC
		assertFalse(imdhs.updateMetrics(epoch3, values3, " "));			// negative TC
	}
	
	public static void main(String[] args){
		MetricDatabaseHandlerTest.setUp();
	}
}
