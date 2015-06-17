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


/**
 * @author vsaravag
 *
 */
public class DbType {
	
	private String name;
	private Machine machineParams;
	private Metric metricParams;
	private Collect collectParams;
	
	
	public DbType(String name){
		this.name = name;
		setMachineParams(new Machine());
		setMetricParams(new Metric());
		setCollectParams(new Collect());
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
	 * @return the machineParams
	 */
	public Machine getMachineParams() {
		return machineParams;
	}
	/**
	 * @param machineParams the machineParams to set
	 */
	public void setMachineParams(Machine machineParams) {
		this.machineParams = machineParams;
	}
	/**
	 * @return the metricParams
	 */
	public Metric getMetricParams() {
		return metricParams;
	}
	/**
	 * @param metricParams the metricParams to set
	 */
	public void setMetricParams(Metric metricParams) {
		this.metricParams = metricParams;
	}
	/**
	 * @return the collectParams
	 */
	public Collect getCollectParams() {
		return collectParams;
	}
	/**
	 * @param collectParams the collectParams to set
	 */
	public void setCollectParams(Collect collectParams) {
		this.collectParams = collectParams;
	}
	
	@Override
	public String toString(){
		String string = "";
		string += "DbType (" + name + ")\n";
		string += "Machine Parameters" + machineParams.toString();
		string += "Metric Parameters" + metricParams.toString();
		string += "Collect Parameters" + collectParams.toString();
		return string;
	}
	
}
