package com.observability.modeling.emf.presentation.extension;


import org.eclipse.ui.views.properties.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

/**
 * @author Administrator
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class SizePropertySource implements IPropertySource {
	
	protected ButtonElement element;

	public static String ID_WIDTH = "Width"; //$NON-NLS-1$
	public static String ID_HEIGHT = "Height"; //$NON-NLS-1$
	protected static IPropertyDescriptor[] descriptors;
	
	static{
		descriptors = new IPropertyDescriptor[] {
			new TextPropertyDescriptor(ID_WIDTH,"width"),
			new TextPropertyDescriptor(ID_HEIGHT,"height")
		};
	}
	
	protected Point point = null;
	
	public SizePropertySource(ButtonElement m_element,Point point){
		this.point = new Point(point.x,point.y);
		element = m_element;
	}
	
	protected void firePropertyChanged(String propName) {
		Control ctl = (Control)element.getControl();
		
		if (ctl == null) {
			// the GUIView is probably hidden in this case
			return;
		}
		ctl.setSize(point);
	}

	
	public Object getEditableValue(){
		return this;
	}
	
	public IPropertyDescriptor[] getPropertyDescriptors(){
		return descriptors;
	}
	
	public Object getPropertyValue(Object propName){
		if(ID_WIDTH.equals(propName)){
			return new String(new Integer(point.x).toString());
		}
		if(ID_HEIGHT.equals(propName)){
			return new String(new Integer(point.y).toString());
		}
		return null;
	}
	
	public Point getValue(){
		return new Point(point.x, point.y);
	}
	
	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(Object)
	 */
	public boolean isPropertySet(Object propName){
		if(ID_WIDTH.equals(propName) || ID_HEIGHT.equals(propName))return true;
		return false;
	}
	
	public void resetPropertyValue(Object propName){}
	
	public void setPropertyValue(Object propName, Object value){
		if(ID_WIDTH.equals(propName)){
			Integer newInt = new Integer((String)value);
			point.x = newInt.intValue();
		}
		if(ID_HEIGHT.equals(propName)){
			Integer newInt = new Integer((String)value);
			point.y = newInt.intValue();
		}
		firePropertyChanged((String)propName);
	}
	
	public String toString(){
		return point.toString();
	}
	

}
