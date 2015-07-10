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

package com.observability.modeling.probe.descriptor.entities;

import java.util.ArrayList;


/**
 * @author vsaravag
 *
 *
 *
 *
 */
public class DbType {
	
	private String name;
	private Machine machine;
	private ArrayList<SystemMetric> systemMetrics;
	private ArrayList<DbMetric> dbMetrics;
	private ArrayList<AggregatedMetric> aggregatedMetrics;
	
	public DbType(String name){
		this.name = name;
		machine = new Machine();
		systemMetrics = new ArrayList<SystemMetric>();
		dbMetrics = new ArrayList<DbMetric>();
		aggregatedMetrics = new ArrayList<AggregatedMetric>();
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the machines
	 */
	public Machine getMachine() {
		return machine;
	}


	/**
	 * @param machines the machines to set
	 */
	public void setMachine(Machine machine) {
		this.machine = machine;
	}


	/**
	 * @return the systemMetrics
	 */
	public ArrayList<SystemMetric> getSystemMetrics() {
		return systemMetrics;
	}
	

	/**
	 * @return the dbMetrics
	 */
	public ArrayList<DbMetric> getDbMetrics() {
		return dbMetrics;
	}


	/**
	 * @return the aggregatedMetrics
	 */
	public ArrayList<AggregatedMetric> getAggregatedMetrics() {
		return aggregatedMetrics;
	}
	
	
	
	@Override
	public String toString(){
		String string = "";
		string += "DbType (" + name + ")\n";
		string += "Machine Parameters" + machine.toString() +"\n\n";
		string += "System Metric Parameters" + systemMetrics.toString() + "\n\n";
		string += "Db Metric Parameters" + dbMetrics.toString() + "\n\n";
		string += "Aggregated Metric Parameters" + aggregatedMetrics.toString();
		return string;
	}
	
}
