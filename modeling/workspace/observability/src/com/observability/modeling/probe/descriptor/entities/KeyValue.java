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
 * The class defines the structure for a key-value entity
 * @author vsaravag
 *
 */
public class KeyValue {
	
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
		return "-> KeyValue (" + name + ", " + value + ")\n";
	}
	
	public String toString(int level){
		StringBuffer buf = new StringBuffer();
		//add as many arrows as the level
		for(int i=0; i< level; i++)
			buf.append("->");
		buf.append(" KeyValue (" + name + ", " + value + ")\n");
		return buf.toString();
		
	}
}
