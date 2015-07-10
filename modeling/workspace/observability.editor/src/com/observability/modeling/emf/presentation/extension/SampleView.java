package com.observability.modeling.emf.presentation.extension;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.SWT;
import java.util.*;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.model.*;
import org.eclipse.ui.views.properties.*;

/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class SampleView extends ViewPart {
	private ListViewer viewer;
	
	private Composite viewpage;
	private Group grp1;
	private Button btn;

	/**
	 * The constructor.
	 */
	public SampleView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		// create all the GUI controls
		// create two groups
		viewer = new ListViewer(parent, SWT.SINGLE );		

			
		grp1 = new Group (parent,SWT.NONE);
		grp1.setText("Preview");		
		RowLayout rowLayout = new RowLayout();
		grp1.setLayout(rowLayout);

		Button btn = new Button(grp1,SWT.PUSH);
		btn.setText("Hello");
		
		// fill in the element		
		AdaptableList ctlList = new AdaptableList();
		ButtonElement btnEl = new ButtonElement(btn,"Button");
		ctlList.add(btnEl);
		
		viewer.setContentProvider(new WorkbenchContentProvider());
		viewer.setLabelProvider(new WorkbenchLabelProvider());			
		viewer.setInput(ctlList);
		getSite().setSelectionProvider(viewer);


	
	}


	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(Class)
	 */
	public Object getAdapter(Class adapter) {
	//	if (adapter == IPropertySheetPage.class)
	//		return new PropertySheetPage();		
		return super.getAdapter(adapter);
	}


	/**
	 * @see org.eclipse.ui.IWorkbenchPart#dispose()
	 */
	public void dispose() {
		super.dispose();
	}

}