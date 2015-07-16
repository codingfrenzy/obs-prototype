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

/**<p>
 * @author Rajat Kapoor
 * <p>
 * References: https://docs.oracle.com/javase/tutorial/rmi/implementing.html<br>
 * How to run:<br>
 * 1. Start MetricDatabaseHandler in server:<br>
 * 		java com.observability.monitoring.server.MetricDatabaseHandler 8100<br>
 * 2. Right-click on this file and run as Junit test<br>
 */
public class MetricDatabaseHandlerTest {
	// These variables should be set before running the JUnit:
	// These are all values that should return positive results:
	static final String rmiIp = "45.55.197.112";		// Server IP
	static final String rmiPort = "8100";		// Server port
	// testGetMetricValueAtEpoch variables to be set:
	static final String epoch1 = "1436973780";
	static final String metricPath1 = "collectd/45_55_197_112/memory/memory-used";
	// testGetMetricsBtwEpochRange variables to be set:
	static final String fromEpoch2 = "1436973780";
	static final String toEpoch2 = "1436973900";
	static final String metricPath2 = "collectd/45_55_197_112/memory/memory-used";
	// testUpdateMetrics variables to be set:
	static final String[] epoch3 = new String[]{"1436973780", "1436973900"};
	static final String[] values3 = new String[]{"356024320.0", "356024320.0"};
	static final String metricPath3 = "collectd/45_55_197_112/memory/memory-used";
	
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
	}
	
	@Test
	public void testGetMetricValueAtEpochEmptyEpoch() throws RemoteException {
		assertNull(imdhs.getMetricValueAtEpoch("", metricPath1));			// negative TC
	}
	
	@Test
	public void testGetMetricValueAtEpochNullEpoch() throws RemoteException {
		assertNull(imdhs.getMetricValueAtEpoch(null, metricPath1));			// negative TC
	}
	
	@Test
	public void testGetMetricValueAtEpochNullMetricpath() throws RemoteException {
		assertNull(imdhs.getMetricValueAtEpoch(epoch1, null));				// negative TC
	}
	
	@Test
	public void testGetMetricValueAtEpochEmptyMetricPath() throws RemoteException {
		assertNull(imdhs.getMetricValueAtEpoch(epoch1, ""));				// negative TC
	}
	
	@Test
	public void testGetMetricValueAtEpochNaNEpoch() throws RemoteException {
		assertNull(imdhs.getMetricValueAtEpoch("abcd", metricPath1));				// negative TC
	}
	/**
	 * Test method for {@link com.observability.monitoring.server.MetricDatabaseHandler#getMetricsBtwEpochRange(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws RemoteException 
	 */
	@Test
	public void testGetMetricsBtwEpochRange() throws RemoteException {
		assertNotNull(imdhs.getMetricsBtwEpochRange(fromEpoch2, toEpoch2, metricPath2));	// positive TC
	}
	
	@Test
	public void testGetMetricsBtwEpochRangeFromEpochNull() throws RemoteException {
		assertNull(imdhs.getMetricsBtwEpochRange(null, toEpoch2, metricPath2));			// negative TC
	}
	
	@Test
	public void testGetMetricsBtwEpochRangeEmptyFromEpoch() throws RemoteException {
		assertNull(imdhs.getMetricsBtwEpochRange("", toEpoch2, metricPath2));			// negative TC
	}
	
	@Test
	public void testGetMetricsBtwEpochRangeToEpochNull() throws RemoteException {
		assertNull(imdhs.getMetricsBtwEpochRange(fromEpoch2, null, metricPath2));		// negative TC
	}
	
	@Test
	public void testGetMetricsBtwEpochRangeEmptyToEpoch() throws RemoteException {
		assertNull(imdhs.getMetricsBtwEpochRange(fromEpoch2, "", metricPath2));			// negative TC
	}
	
	@Test
	public void testGetMetricsBtwEpochRangeMetricpathNull() throws RemoteException {
		assertNull(imdhs.getMetricsBtwEpochRange(fromEpoch2, toEpoch2, null));			// negative TC
	}
	
	@Test
	public void testGetMetricsBtwEpochRangeEmptyMetricPath() throws RemoteException {
		assertNull(imdhs.getMetricsBtwEpochRange(fromEpoch2, toEpoch2, ""));			// negative TC
	}
	
	@Test
	public void testGetMetricsBtwEpochRangeNaNFromEpoch() throws RemoteException {
		assertNull(imdhs.getMetricsBtwEpochRange("abcd", toEpoch2, metricPath2));		// negative TC
	}
	
	@Test
	public void testGetMetricsBtwEpochRangeDatapointsLessThanZero() throws RemoteException {
		assertNull(imdhs.getMetricsBtwEpochRange(fromEpoch2, "0", metricPath2));			// negative TC
	}
	
	@Test
	public void testGetMetricsBtwEpochRangeSameEpochs() throws RemoteException {
		assertNull(imdhs.getMetricsBtwEpochRange(fromEpoch2, fromEpoch2, metricPath2));			// negative TC
	}

	/**
	 * Test method for {@link com.observability.monitoring.server.MetricDatabaseHandler#updateMetrics(java.lang.String[], java.lang.String[], java.lang.String)}.
	 * @throws RemoteException 
	 */
	@Test
	public void testUpdateMetrics() throws RemoteException {
		assertTrue(imdhs.updateMetrics(epoch3, values3, metricPath3));	// positive TC
	}
	
	@Test
	public void testUpdateMetricsNullEpoch() throws RemoteException {
		assertFalse(imdhs.updateMetrics(null, values3, metricPath3));			// negative TC
	}
	
	@Test
	public void testUpdateMetricsNullValues() throws RemoteException {
		assertFalse(imdhs.updateMetrics(epoch3, null, metricPath3));			// negative TC
	}
	
	@Test
	public void testUpdateMetricsNullMetricPath() throws RemoteException {
		assertFalse(imdhs.updateMetrics(epoch3, values3, null));			// negative TC
	}
	
	@Test
	public void testUpdateMetricsEmptyMetricpath() throws RemoteException {
		assertFalse(imdhs.updateMetrics(epoch3, values3, ""));			// negative TC
	}
	
	@Test
	public void testUpdateMetricsLengthMismatch() throws RemoteException {
		assertFalse(imdhs.updateMetrics(epoch3, new String[]{"356024320.0"}, metricPath3));		// negative TC
	}
	
	@Test
	public void testUpdateMetricsBadEpochs() throws RemoteException {
		assertFalse(imdhs.updateMetrics(new String[]{"abcd", "efgh"}, values3, metricPath3));	// negative TC
	}
	
}
