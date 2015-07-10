package com.observability.modeling.emf.presentation.extension;

import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;


/**
 * @author Administrator
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class FontDialogCellEditor extends DialogCellEditor {

	/**
	 * Creates a new Font dialog cell editor parented under the given control.
	 * The cell editor value is <code>null</code> initially, and has no 
	 * validator.
	 *
	 * @param parent the parent control
	 */
	protected FontDialogCellEditor(Composite parent) {
		super(parent);
	}

	/**
	 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(Control)
	 */
	protected Object openDialogBox(Control cellEditorWindow) {
//		FontDialog ftDialog = new FontDialog(Obser.getActiveWorkbenchShell());
//		
//		String value = (String) getValue();
//		
//		if ((value != null) && (value.length() > 0)) {
//			ftDialog.setFontData(new FontData(value));
//		}
//		FontData fData = ftDialog.open();
//			
//		if (fData != null) {
//			value = fData.toString();
//		}
//		return value;
		return null;
	}

}
