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
 * The class creates an element tag and its related attributes. <br>
 * An element tag in the descriptor file is one which is within a <>.
 * 
 * @author vsaravag
 *
 */
public class ElementTag {
	
	/**
	 * name of the element. The first element in (<foo bar>)
	 */
	private String name;
	/**
	 * value of the element. The second element in (<foo bar>).
	 * Can be null.
	 */
	private String value;
	/**
	 * the id of the element. Combination of name and value separated by _
	 */
	private String id;
	/**
	 * the scope of the element. @see {@link Scope}
	 */
	private Scope scope;
	/**
	 * KeyValues inside the element
	 */
	private ArrayList<KeyValue> keyValues;
	/**
	 * sub-elements inside the element
	 */
	private ArrayList<ElementTag> elements;
	
	/**
	 * Constructor
	 * @param name the name of the element
	 * @param value value of the element
	 * @param id id of the element 
	 * @param scope scope of the element. {@link Scope}
	 */
	public ElementTag(String name, String value, String id, Scope scope){
		this.name = name;
		this.value = value;
		this.id = id;
		this.scope = scope;
		keyValues = new ArrayList<KeyValue>();
		elements = new ArrayList<ElementTag>();
	}
	/**
	 * @return the name of the element tag
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 
	 * 			the name of the element to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value of the element
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value 
	 * 			the value to set in the element
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the scope
	 */
	public Scope getScope() {
		return scope;
	}
	
	
	/**
	 * @param scope the scope to set
	 */
	public void setScope(Scope scope) {
		this.scope = scope;
	}
	
	
	/**
	 * @return the list of all the key-values for the element
	 */
	public ArrayList<KeyValue> getKeyValues() {
		return keyValues;
	}

	/**
	 * Add the given key value pair to the element
	 * 
	 * @param key the name of the key. Cannot be null 
	 * @param value the value to be set to the key
	 */
	public void addKeyValue(String key, String value){
		
		if(key!=null){
			keyValues.add(new KeyValue(key, value));
		}
		
	}
	
	/**
	 * @return the elements contained in this element
	 */
	public ArrayList<ElementTag> getElements(){
		return elements;
	}
	
	
	/**
	 * Add the element to the Element
	 * @param element the element to be added
	 */
	public void addElement(ElementTag element){
		if(element!=null){
			elements.add(element);
		}
	}
	
	@Override
	public String toString(){
		return toString(1);		
		
	}
	
	
	/**
	 * converts the class to string and prints level number of -> before it.
	 * @param level the level at which the element exists
	 * @return String representation of the class.
	 */
	private String toString(int level){
		StringBuffer buf = new StringBuffer();
		//add as many arrows as the level
		for(int i=0; i< level; i++)
			buf.append("-> ");
		
		buf.append("Element (" + name + ", " + value + ", " + id + ", " + scope + ")\n");
		    
		//Print all the key-value pairs
		for(KeyValue keyValue : keyValues){
			buf.append(keyValue.toString(level+1));
		}
		
		//recursively get all the elements
		for (ElementTag element : elements) {
			buf.append(element.toString(level+1));
		}
					
		return buf.toString();
	}
	
}
