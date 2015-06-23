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
 * An element tag in the descritor file is one which is within a <> and has 
 * an annotation. <br>
 * 
 * @author vsaravag
 *
 */
public class ElementTag {
	
	private String name;
	private String value;
	
	private ArrayList<KeyValue> keyValues;
	private ArrayList<ElementTag> elements;
	
	public ElementTag(String name, String value){
		this.name = name;
		this.value = value;
		keyValues = new ArrayList<ElementTag.KeyValue>();
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
	 * add the given element to the current element
	 * @param name the name of the element
	 * @param value the value of the element tag
	 */
	public void addElement(String name, String value){
		if(name!=null){
			elements.add(new ElementTag(name, value));
		}
	}
	
	public void addElement(ElementTag element){
		if(element!=null){
			elements.add(element);
		}
	}
	
	@Override
	public String toString(){
		return toString(1);		
		
	}
	
	private String toString(int level){
		StringBuffer buf = new StringBuffer();
		//add as many arrows as the level
		for(int i=0; i< level; i++)
			buf.append("->");
		
		buf.append("Element (" + name + ", " + value + ")\n");
		
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
	
	/**
	 * The class defines a key-value pair. <br>
	 * This is an inner class and can be used within an element tag only. <br>
	 * 
	 * @author vsaravag
	 *
	 */
	public static class KeyValue {
		
		private String name;
		private String value;
		
		/**
		 * @param name the name of key. Cannot be null
		 * @param value the value of the key
		 */
		public KeyValue(String name, String value){
			if(name!=null){
				this.name = name;
				this.value = value;
			}
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
		
		@Override
		public String toString() {
			return "KeyValue (" + name + ", " + value + ")\n";
		}
		
		private String toString(int level){
			StringBuffer buf = new StringBuffer();
			//add as many arrows as the level
			for(int i=0; i< level; i++)
				buf.append("->");
			buf.append("KeyValue (" + name + ", " + value + ")\n");
			return buf.toString();
			
		}
	}
	
	
}
