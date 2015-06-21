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
// tests
package com.observability.monitoring.server;

import java.io.Serializable;

/**
 * AggConfigItems is the blueprint for the configuration elements required for
 * aggregation. Objects of configuration should be created of this class. Every
 * object will have several elements that are read from Collectd.conf, which is
 * the configuration file of Collectd, the monitoring framework used in
 * Observability project. Observability team decided to use the existing
 * aggregation configurations from the configuration file to eliminate the
 * number of configuration files used to configure the entire system.
 * 
 * @author Laila Alhmoud
 *         <p>
 *         History:<br>
 *         1. Created June 8 2015<br>
 */

public class AggConfigElements implements Serializable {

	/**
	 * Auto generated serial version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The configuration elements
	 */
	private int faultTolTimeWindow;	//The time period in seconds that allows the nodes of the under monitoring system
	 								// to send the metric data to Observability, so the aggregator can have as much 
									// data possible to perform the aggregation
	private int interval; 			// The interval of the aggregation, which is the time in seconds on which Observability
									// will apply aggregation functions (sum, max,..etc) on the specified metric measurements
									// collected from the monitored nodes and save the result to the DB
	private String plugin; 			// The collectd plugin on which data will be  aggregated. For example: plugin = cpu
	private String typeInst; 		// The type of metric on which data will be aggregated. For example: cpu-system, spu-idle

	/**
	 * Functions of aggregation
	 */
	private boolean calSum; 		// The status of the sum calculation of all measurement for the specified metric
	private boolean calAvg; 		// The status of the average calculation of all measurement for the specified metric
	private boolean calMin; 		// The status of the minimum calculation of all measurement for the specified metric
	private boolean calMax; 		// The status of the maximum calculation of all measurement for the specified metric
	private boolean calStd; 		// The status of the standard deviation calculation of all measurement for the specified metric

	/**
	 * Constructor to set the variables
	 * 
	 * @param faultTolTimeWindow
	 * 			  is the fault tolerance time window
	 * @param interval
	 *            is the time in seconds of the integration interval
	 * @param plugin
	 *            is the specified metric to be aggregated
	 * @param typeInst
	 *            is metric type
	 * @param calSum
	 *            is the status of the sum calculation
	 * @param calAvg
	 *            is the status of the average calculation
	 * @param calMin
	 *            is the status of the minimum calculation
	 * @param calMax
	 *            is the status of the maximum calculation
	 * @param calStd
	 *            is the status of the standard deviation calculation
	 */
	public AggConfigElements(int faultTolTimeWindow, int interval, String plugin, String typeInst,
			boolean calNum, boolean calSum, boolean calAvg, boolean calMin,
			boolean calMax, boolean calStd) {
		super();
		this.faultTolTimeWindow = faultTolTimeWindow;
		this.interval = interval;
		this.plugin = plugin;
		this.typeInst = typeInst;
		this.calSum = calSum;
		this.calAvg = calAvg;
		this.calMin = calMin;
		this.calMax = calMax;
		this.calStd = calStd;
		
	}

	/**
	 * Return the faultTolTimeWindow
	 */
	public int getFaultTolTimeWindow() {
		System.out.println("Debug: ");
		return faultTolTimeWindow;
	}

	/**
	 * @param faultTolTimeWindow which is the system fault tolerance time window
	 */
	public void setFaultTolTimeWindow(int faultTolTimeWindow) {
		this.faultTolTimeWindow = faultTolTimeWindow;
	}
	/**
	 * Return the interval
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * @param interval which is the aggregation interval
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

	/**
	 * Return the metric to aggregate
	 */
	public String getPlugin() {
		return plugin;
	}

	/**
	 * @param plugin which is the metric
	 */
	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}

	/**
	 * Return type of metric to aggregate
	 */
	public String getTypeInst() {
		return typeInst;
	}

	/**
	 * @param typeInst which is the type of metric
	 */
	public void setTypeInst(String typeInst) {
		this.typeInst = typeInst;
	}


	/**
	 * Return the status of the sum calculation
	 */
	public boolean isCalSum() {
		return calSum;
	}

	/**
	 * @param calSum which is the status of the sum calculation
	 */
	public void setCalSum(boolean calSum) {
		this.calSum = calSum;
	}

	/**
	 * Return the status of the average calculation
	 */
	public boolean isCalAvg() {
		return calAvg;
	}

	/**
	 * @param calAvg which is the status of the average calculation
	 */
	public void setCalAvg(boolean calAvg) {
		this.calAvg = calAvg;
	}

	/**
	 * Return the status of the minimum calculation
	 */
	public boolean isCalMin() {
		return calMin;
	}

	/**
	 * @param calMin which is the status of the minimum calculation
	 */
	public void setCalMin(boolean calMin) {
		this.calMin = calMin;
	}

	/**
	 * Return the status of the maximum calculation
	 */
	public boolean isCalMax() {
		return calMax;
	}

	/**
	 * @param calMax which is the status of the maximum calculation
	 */
	public void setCalMax(boolean calMax) {
		this.calMax = calMax;
	}

	/**
	 * Return the status of the standard deviation calculation
	 */
	public boolean isCalStd() {
		return calStd;
	}

	/**
	 * @param calStd which is the status of the standard deviation calculation
	 */
	public void setCalStd(boolean calStd) {
		this.calStd = calStd;
	}
}
