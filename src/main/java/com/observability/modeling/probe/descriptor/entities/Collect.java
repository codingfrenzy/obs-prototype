package com.observability.modeling.probe.descriptor.entities;

import java.util.ArrayList;

/**
 * The class defines the metrics which the user wants to collect
 * from the list of available metrics.
 * @author vsaravag
 *
 */
public class Collect extends Parameter {
	
	public Collect(){
		this.elements = new ArrayList<ElementTag>();
	}
	public Collect(String name, String value){
		if(name!=null){
			this.name = name;
			this.value = value;
			this.elements = new ArrayList<ElementTag>();
		}
	}
}
