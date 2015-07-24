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
 * The abstract class defines the attributes and methods needed to define
 * parameters for any type of annotation.<br>
 * Any new annotation would need to extend this class. <br>
 * Currently, the following annotations are supported<br>
 * <li>@MetricSystem</li>
 * <li>@MetricDB</li>
 * <li>@MetricAggregated</li>
 * <li>@Machine</li>
 * <li>@Feature</li>
 * 
 * @author vsaravag
 *
 */
public abstract class Parameter {
	
	/**
	 * Name of the parameter
	 */
	protected String name;
	/**
	 * Value, if any, assigned to the parameter
	 */
	protected String value;
	/**
	 * Elements inside the parameter
	 */
	protected ArrayList<ElementTag> elements;
	/**
	 * Key Values inside the parameter
	 */
	protected ArrayList<KeyValue> keyValues;
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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the elements
	 */
	public ArrayList<ElementTag> getElements() {
		return elements;
	}

	
	/**
	 * Add the key value to the parameter
	 * @param keyValue the keyValue to be added.
	 */
	public void addKeyValue(KeyValue keyValue){
		if(keyValue != null){
			this.keyValues.add(keyValue);
		}
	}
	/**
	 * @return the keyValues
	 */
	public ArrayList<KeyValue> getKeyValues() {
		return keyValues;
	}
	
	/**
	 * Adds the element to the parameter
	 * @param element
	 * 			the element to be added
	 */
	public void addElement(ElementTag element){
		if(element!=null){
			elements.add(element);
		}
	}
	
	
}
