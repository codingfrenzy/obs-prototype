/**
 * 
 */
package com.observability.modeling.probe.descriptor.entities;

import java.util.ArrayList;

/**
 * @author vsaravag
 *
 */
public class Feature extends Parameter {
	
	public Feature(){
		this.elements = new ArrayList<ElementTag>();
		this.keyValues = new ArrayList<KeyValue>();
	}
	
	public Feature(String name){
		if(name!=null){
			this.name = name;
			this.elements = new ArrayList<ElementTag>();
			this.keyValues = new ArrayList<KeyValue>();
		}
	}
	
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("\nFeature (" + name + ", \n");
		
		for (KeyValue keyValue : keyValues){
			buf.append(keyValue.toString(1));
		}
		for (ElementTag element : elements) {
			buf.append(element.toString());
		}
		return buf.toString();
	}
	
}
