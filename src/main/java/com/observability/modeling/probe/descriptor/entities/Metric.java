package com.observability.modeling.probe.descriptor.entities;

import java.util.ArrayList;

/**
 * This class defines the semantic structure of a Metric.<br>
 * The metric identifier (tag) and metric name would go in
 * name and the value parameter respectively.
 * @author vsaravag
 *
 */
public class Metric extends Parameter {
	
	public Metric(){
		this.elements = new ArrayList<ElementTag>();
	}
	
	public Metric(String name, String value){
		if(name!=null){
			this.name = name;
			this.value = value;
			this.elements = new ArrayList<ElementTag>();
		}
	}
}	
