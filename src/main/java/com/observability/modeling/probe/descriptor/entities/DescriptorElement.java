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

import java.util.List;

/**
 * Represents an element inside a descriptor file.
 * Below is an example descriptor file (without the annotations) and how it converts to a
 * entity structure 
 * 
 * <Plugin "GenericJMX">	---> Element which has key = "Plugin"  and value ="GenericJMX"
							---> it has one child which is the <Mbean...> element below
    <MBean "metrics"> 
        ObjectName "org.apache.cassandra.metrics:type=Storage,name=Load"
        <Value>				---> this element has key but no value so value == null
          Type "gauge"		---> this element has no children so children list should be empty.
          InstancePrefix "data_load"
          Attribute "Count"
        </Value>
	   <Value>
          Type "gauge"
          InstancePrefix "data_load"
          Attribute "Count"
        </Value>
    </MBean>
    </Plugin>
 *
 * @author Caglayan "Gem" Gemici
 *
 */
public  class DescriptorElement {
	
	
	/**
	 * If an element has children they are stored here.
	 */
	private List<DescriptorElement> children;
	
	/**
	 * The key value attributes that every element can have
	 */
	private String key;
	private String value;

	
	public List<DescriptorElement> getChildren() {
		return children;
	}
	public void setChildren(List<DescriptorElement> children) {
		this.children = children;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
