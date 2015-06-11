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
		String string = "";
		//add as many arrows as the level
		for(int i=0; i< level; i++)
			string += "->";
		
		string += "Element (" + name + ", " + value + ")\n";
		
		//Print all the key-value pairs
		for(KeyValue keyValue : keyValues){
			string += keyValue.toString(level+1);
		}
		
		//recursively get all the elements
		for (ElementTag element : elements) {
			string += element.toString(level+1);
		}
					
		return string;
	}
	
	/**
	 * The class defines a key-value pair. <br>
	 * This is an inner class and can be used within an element tag only. <br>
	 * 
	 * @author vsaravag
	 *
	 */
	private static class KeyValue {
		
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
			String string = "";
			//add as many arrows as the level
			for(int i=0; i< level; i++)
				string += "->";
			string += "KeyValue (" + name + ", " + value + ")\n";
			return string;
			
		}
	}
	
	
}
