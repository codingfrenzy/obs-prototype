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
 * <li>@Metric</li>
 * <li>@Machine</li>
 * <li>@Collect</li>
 * 
 * @author vsaravag
 *
 */
public abstract class Parameter {
	
	protected String name;
	protected String value;
	protected ArrayList<ElementTag> elements;
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
	 * @param elements the elements to set
	 */
	public void setElements(ArrayList<ElementTag> elements) {
		this.elements = elements;
	}
	
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
