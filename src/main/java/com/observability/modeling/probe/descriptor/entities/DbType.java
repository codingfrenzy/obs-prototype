/**
 * 
 */
package com.observability.modeling.probe.descriptor.entities;

import java.util.ArrayList;

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
