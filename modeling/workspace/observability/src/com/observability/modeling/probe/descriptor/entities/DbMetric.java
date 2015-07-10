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
 * This class defines the semantic structure of a Metric.<br>
 * The metric identifier (tag) and metric name would go in
 * name and the value parameter respectively.
 * @author vsaravag
 *
 */
public class DbMetric extends Parameter {
	
	private MetricType type;
	
	public DbMetric(){
		this.elements = new ArrayList<ElementTag>();
		this.keyValues = new ArrayList<KeyValue>();
	}
	
	public DbMetric(String name, MetricType type){
		if(name!=null){
			this.name = name;
			this.type = type;
			this.elements = new ArrayList<ElementTag>();
			this.keyValues = new ArrayList<KeyValue>();
		}
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("\nDbMetric (" + name + ", " + value + ", " + type + ")\n");
		
		for (KeyValue keyValue : keyValues){
			buf.append(keyValue.toString(1));
		}
		for (ElementTag element : elements) {
			buf.append(element.toString());
		}
		return buf.toString();
	}

	public MetricType getType() {
		return type;
	}
}	
