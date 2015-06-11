package com.observability.modeling.probe.descriptor.entities;

import java.util.ArrayList;

/**
 * The class defines the structure of a machine.<br>
 * The parameters required for a machine would be contained in 
 * this.<br>
 * @author vsaravag
 *
 */
public class Machine extends Parameter {
	
	public Machine(){
		this.elements = new ArrayList<ElementTag>();
	}
	
	public Machine(String name, String value){
		if(name!=null){
			this.name = name;
			this.value = value;
			this.elements = new ArrayList<ElementTag>();
		}
	}
	
}
