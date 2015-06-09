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
import java.util.List;

/**
 * Parses the descriptors in a given directory and converts them to a manageable
 * entity hierarchy. This object hierarchy can be used to create EMF semantic
 * elements when initializing the model. For example: An EMF DbType entity needs
 * to be created for each plugin descriptor present. This info will be taken
 * from the intermediate entities this class generates :
 * 
 * @see DescriptorElement
 * @see PluginDefinition Intermediate entities are used to ensure decoupling
 *      with EMF generated entities.
 * @author Caglayan "Gem" Gemici
 *
 */
public class PluginDefinition {
	
	/**
	 * The type of this plugin. These are based on 
	 * bindings collectd provides
	 * @see  
	 */
	private PluginType pluginType;
	
	/**
	 * These lists will hold the elements that are parsed 
	 * from the descriptor files. Each list corresponds
	 * to elements that are tagged with an annotation.
	 * @see DescriptorParserImpl#MACHINE_SCOPE
	 * @see DescriptorParserImpl#DB_TYPE_SCOPE
	 * @see DescriptorParserImpl#METRIC_SCOPE
	 * @see DescriptorParserImpl#COLLECT
	 */
	private List<DescriptorElement> machineScopeElements;
	private List<DescriptorElement> dbTypeScopeElements;
	private List<DescriptorElement> metricScopeElements;
	private List<DescriptorElement> collectElements;
	
	
	/**
	 * Default constructor
	 */
	public PluginDefinition() {
		super();
		machineScopeElements = new ArrayList<DescriptorElement>();
		dbTypeScopeElements = new ArrayList<DescriptorElement>();
		metricScopeElements = new ArrayList<DescriptorElement>();
		collectElements = new ArrayList<DescriptorElement>();
		
	}

	public PluginType getPluginType() {
		return pluginType;
	}

	public void setPluginType(PluginType pluginType) {
		this.pluginType = pluginType;
	}

	public List<DescriptorElement> getMachineScopeElements() {
		return machineScopeElements;
	}

	public void setMachineScopeElements(List<DescriptorElement> machineScopeElements) {
		this.machineScopeElements = machineScopeElements;
	}

	public List<DescriptorElement> getDbTypeScopeElements() {
		return dbTypeScopeElements;
	}

	public void setDbTypeScopeElements(List<DescriptorElement> dbTypeScopeElements) {
		this.dbTypeScopeElements = dbTypeScopeElements;
	}

	public List<DescriptorElement> getMetricScopeElements() {
		return metricScopeElements;
	}

	public void setMetricScopeElements(List<DescriptorElement> metricScopeElements) {
		this.metricScopeElements = metricScopeElements;
	}

	public List<DescriptorElement> getCollectElements() {
		return collectElements;
	}

	public void setCollectElements(List<DescriptorElement> collectElements) {
		this.collectElements = collectElements;
	}

}


