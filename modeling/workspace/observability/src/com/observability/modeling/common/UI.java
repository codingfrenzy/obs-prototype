//**************************************************************************************************//
/* Observability Project
 * Copyright 2015 Master of Software Engineering team: Laila Alhmound, Ying (Joel) Gao, Caglayan Gem, Rajat Kapoor, Prasanth Nair, Varun Saravagi
 * Copyright 2015 Institute for Software Research | School of Computer Science | Carnegie Mellon University
 * Copyright 2015 Software Engineering Institute
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses/>.
 */
//**************************************************************************************************//

package com.observability.modeling.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

/**
 * Class to handle the customer UI components.
 * @author vsaravag
 *
 */
public class UI {
	
	private static final String SERVER_DETAILS_TITLE = Messages.Ui_CONSTANT_SERVER_WINDOW_TITLE;
	private Shell shell = null;
	private InputDialog ipPortInputDialog = null;
	
	public UI(){
		ipPortInputDialog = new InputDialog(shell);
		shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
	
	/**
	 * This method gets the server details (ip and port) where the ModelHandler RMI service
	 * is running. It shows an input dialog where the user would enter the ip and port where
	 * the RMI service is running. 
	 * If the user presses Cancel, the action would be cancelled and nothing would be done. 
	 * 
	 * The user input is validated before being accepted. Currently only ipv4 addresses are accepted.
	 * 
	 * @param messageType the type of the message to be shown in the dialog box.
	 * The values should be used from JOptionPane class.
	 * @param message Any additional message which needs to be appended before the default input message
	 * 
	 * @return A String array containing ip and port. Index 0 contains ip, index 1 contains port
	 */
	 public String[] getServerDetails(int messageType, String message){
		String input = null;
		// create the input dialog box
		ipPortInputDialog.create(messageType, (message + Messages.Ui_MSG_INFO_ENTER_IP_PORT));
		// open the input dialog box and take user input
		if(ipPortInputDialog.open() == org.eclipse.jface.window.Window.OK){
			input = ipPortInputDialog.getIpPort();
		}
		if (input == null || input.equals("")){ 
			//user has pressed cancel button or has not entered anything Take confirmation from user
			String msg = Messages.Ui_MSG_INFO_SERVER_CANCEL;
			boolean option = MessageDialog.openConfirm(shell, SERVER_DETAILS_TITLE, msg);
			if(option){
				// Do not transfer files to server
				return new String[0]; 
			}
			else {
				// show the box again
				return getServerDetails(IMessageProvider.NONE, "");
			}
		}
		else{
			//validate input
			String ipRegex = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}):(\\d{1,5})";
			Pattern pattern = Pattern.compile(ipRegex);
			Matcher matcher = pattern.matcher(input);
			String[] serverDetails = new String[2];
			if(matcher.matches()){
				serverDetails[0] = matcher.group(1); //ip
				serverDetails[1] = matcher.group(2); //port
				return serverDetails;
			}
			else {
				//wrong input. Get input again
				return getServerDetails(IMessageProvider.ERROR, Messages.Ui_MSG_ERROR_WRONG_INPUT);
			}
				
		}
	}
	 
	 
	/**
	 * Inner class to generate custom JFace dialog
	 * to get Ip and port of the RMI service
	 * @author vsaravag
	 *
	 */
	private static class InputDialog extends TitleAreaDialog {
		
		/**
		 * Text field where the user would enter the input
		 */
		private Text ipField;
		/**
		 * String to store the user input
		 */
		private String ipPort;
		
		/**
		 * Constructor
		 * @param parentShell parent shell ({@link Shell}) object 
		 */
		private InputDialog(Shell parentShell){
			super(parentShell);
		}
		
		
		/**
		 * Create the dialog box
		 * @param messageType the type of message, selected from {@link IMessageProvider}
		 * @param message the message to be displayed
		 */
		private void create(int messageType, String message){
			super.create();
			setTitle(SERVER_DETAILS_TITLE);
			setMessage(message, IMessageProvider.INFORMATION);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		protected Control createDialogArea(Composite parent){
			Composite area = (Composite) super.createDialogArea(parent);
			Composite container = new Composite(area, SWT.NONE);
		    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    org.eclipse.swt.layout.GridLayout layout = new org.eclipse.swt.layout.GridLayout(2, false);
		    container.setLayout(layout);

		    createIp(container);

		    return area;
		}
		
		/**
		 * Create the text field to get the input
		 * @param container the container object which would contain the field
		 */
		private void createIp(Composite container){
			Label lbtFirstName = new Label(container, SWT.NONE);
			lbtFirstName.setText("ip:port");

			GridData dataFirstName = new GridData();
			dataFirstName.grabExcessHorizontalSpace = true;
			dataFirstName.horizontalAlignment = GridData.FILL;

			ipField = new Text(container, SWT.BORDER);
			ipField.setLayoutData(dataFirstName);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.dialogs.Dialog#isResizable()
		 */
		@Override
		protected boolean isResizable(){
			return true;
		}
		
		/**
		 * Save the user entered input
		 */
		private void saveInput(){
			ipPort = ipField.getText();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
		 */
		@Override
		protected void okPressed(){
			saveInput();
			super.okPressed();
		}
		
		/**
		 * @return the String user entered
		 */
		public String getIpPort(){
			return ipPort;
		}
	}
}
