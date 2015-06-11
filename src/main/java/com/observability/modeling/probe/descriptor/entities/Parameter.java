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
	
	/**
	 * add the given element to the current el
	 * @param name the name of the element
	 * @param value the value of the element tag
	 */
	public void addElement(String name, String value){
		if(name!=null){
			elements.add(new ElementTag(name, value));
		}
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
	@Override
	public String toString() {
		String string = "";
		string += "(" + name + ", " + value + ")\n";
		
		for (ElementTag element : elements) {
			string += element.toString();
		}
		return string;
	}
	
	
	
}
