package com.observability.modeling.emf.presentation.extension;

/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */
import org.eclipse.ui.views.properties.*;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.*;
import org.eclipse.jface.viewers.*;

import java.util.List;
import java.util.Vector;

/**
 * This class encapsulates property sheet properties
 * for MarkElement.  This will display properties for
 * the MarkElement when selected in the readme editor's
 * content outline.
 */
public class ButtonElementProperties implements IPropertySource {
	final protected ButtonElement element;
		 		
	protected static final String PROPERTY_FONT = "font"; 	
	protected static final String PROPERTY_SIZE = "size";	
	protected static final String PROPERTY_TEXT = "text";	
	

	private final Object PropertiesTable[][] = 
		{ { PROPERTY_FONT, new FontPropertyDescriptor(PROPERTY_FONT,"Font")},
          { PROPERTY_SIZE, new PropertyDescriptor(PROPERTY_SIZE,"Size")},
		  { PROPERTY_TEXT, new TextPropertyDescriptor(PROPERTY_TEXT,"Text")},		  
		};	
	
	String strFont = "";
	Point ptSize = null;
	String strText = "";
	
	protected void firePropertyChanged(String propName, Object value) {
		Button ctl = element.getControl();
		
		if (ctl == null) {
			// the GUIView is probably hidden in this case
			return;
		}
		
		if (propName.equals(PROPERTY_FONT)) {
			/**
			Font oldfont = ctl.getFont();
			if (oldfont != null) {
				oldfont.dispose();
			}
			**/
			ctl.setFont(new Font (ctl.getDisplay(),new FontData((String)value)) );
			return;
		}
		if (propName.equals(PROPERTY_TEXT)) {
			ctl.setText((String)value);
			return;
		}
		
	}
	
	protected void initProperties() {
		Button ctl = element.getControl();

		if (ctl == null) {
			// the GUIView is probably hidden in this case
			return;
		}
		
		strText = ctl.getText();
		/**
		Font font = ctl.getFont();
		if (font != null) {
			strFont = font.getFontData().toString();
		}
		**/
		ptSize = ctl.getSize();		
	}
	

	/**
	 * Creates a new ButtonElementProperties.
	 *
	 * @param element  the element whose properties this instance represents
	 */
	public ButtonElementProperties(ButtonElement element) {
		super();
		this.element = element;
		initProperties();
	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#getEditableValue()
	 */
	public Object getEditableValue() {
		return this;
	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		// Create the property vector.
		IPropertyDescriptor[] propertyDescriptors = new IPropertyDescriptor[PropertiesTable.length];

		for (int i=0;i<PropertiesTable.length;i++) {				
			// Add each property supported.
			
			PropertyDescriptor descriptor;

			descriptor = (PropertyDescriptor)PropertiesTable[i][1];
			propertyDescriptors[i] = (IPropertyDescriptor)descriptor;
			descriptor.setCategory("Basic");
		}
				
		// Return it.
		return propertyDescriptors;

	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(Object)
	 */
	public Object getPropertyValue(Object name) {
		if (name.equals(PROPERTY_FONT))
			return strFont;
		if (name.equals(PROPERTY_SIZE))
			return new SizePropertySource(element,ptSize);
		if (name.equals(PROPERTY_TEXT))
			return strText;

		return null;
	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(Object)
	 */
	public boolean isPropertySet(Object id) {
		return false;
	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#resetPropertyValue(Object)
	 */
	public void resetPropertyValue(Object id) {
	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(Object, Object)
	 */
	public void setPropertyValue(Object name, Object value) {
		firePropertyChanged((String)name,value);
		
		if (name.equals(PROPERTY_FONT)) {
			strFont = (String)value;	
			return;
		}
		if (name.equals(PROPERTY_TEXT)) {
			strText = (String)value;	
			return;
		}
		if (name.equals(PROPERTY_SIZE)) {
			SizePropertySource sizeProp = (SizePropertySource)value;			
			ptSize = sizeProp.getValue();
		}
		
	}
	
	/**
	 * Returns the mocha element.
	 * @return MochaElement
	 */
	public ButtonElement getButtonElement() {
		return element;
	}

}
