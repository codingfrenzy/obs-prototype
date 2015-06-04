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

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * IMetricDatabaseHandlerServer is RMI server interface of MetricDatabaseHandler which can be used to:
 * 1. fetch a single metric value from whisper database at a specific epoch value
 * 2. fetch multiple metric values between an epoch range
 * 3. set/update metric values for as many epoch values as the user wants for a metric 
 * 
 * @author Rajat Kapoor
 * 
 * History: 
 * 1. Created					Jun 03 2015
 */

public interface IMetricDatabaseHandlerServer extends Remote{
	
	/**
	 * getMetricValueAtEpoch fetches a single value of a metric from whisper
	 * 
	 * @param epoch is the epoch value or the UNIX timestamp at which the
	 * metric is to be fetched; Note: epoch should be a multiple of 30
	 * 
	 * @param metricPath is the path of the metric such as :
	 * collectd/observabilityCassandra1/memory/memory-used
	 * This is the actual path of a .wsp file in which whisperPath is prefixed
	 * so the actual path built by this method is :
	 * /var/lib/graphite/whisper/collectd/collectd/observabilityCassandra1/memory/memory-used.wsp
	 * 
	 * @return null if the epoch or metricPath are empty, or no result is obtained
	 *         metric value in whisper DB if it is present
	 * Example: getMetricValueAtEpoch(1433292120,"collectd/observabilityCassandra1/memory/memory-used")
	 */
	
	public String getMetricValueAtEpoch(long epoch, String metricPath) throws RemoteException;
	
	/**
	 * getMetricsBtwEpochRange fetches a range of epoch values and their
	 * corresponding metric values in an arrayList which are between 
	 * fromEpoch and toEpoch
	 * @param fromEpoch is the starting epoch value (exclusive)
	 * @param toEpoch is the ending epoch value (inclusive)
	 * @param metricPath is the path of the metric such as :
	 * collectd/observabilityCassandra1/memory/memory-used
	 * @return null if there are no values in between fromEpoch & toEpoch
	 *         or if the arguments provided are invalid;
	 *         an arraylist containing epoch values and their corresponding
	 *         metric values separated by a tab if at least one value is
	 *         found
	 * Example: getMetricsBtwEpochRange(1433292139,1433292291,"collectd/observabilityCassandra1/memory/memory-used")
	 */
	
	public ArrayList<String> getMetricsBtwEpochRange(long fromEpoch, long toEpoch, String metricPath) throws RemoteException;
	
	/**
	 * updateMetrics takes an array of epoch values and an array of metric 
	 * values (of the same length) and updates or creates those entries
	 * in the whisper database
	 * @param epoch is an array of epoch values which are to be updated/set
	 * @param values is an array of metric values which are to be updated/set
	 * @param metricPath is the path of the metric such as :
	 * collectd/observabilityCassandra1/memory/memory-used
	 * @return true if the values were successfully updated
	 * 		   false if the values were not updated due to an error or the
	 * 		   arguments given were invalid
	 * Example: updateMetrics(new long[]{1433292180,1433292210},new String[]{"242106369.000000", "242126849.000000"},"collectd/observabilityCassandra1/memory/memory-used")
	 * Note: make sure that the epoch values provided are a multiple of 30
	 * 		 otherwise the function says that the values were updated but they
	 * 		 are actually not
	 */
	
	public boolean updateMetrics(long[] epoch, String[] values, String metricPath) throws RemoteException;
	
}
