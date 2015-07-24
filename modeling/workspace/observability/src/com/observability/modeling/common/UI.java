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

import javax.swing.JOptionPane;

/**
 * Class to handle the customer UI components.
 * @author vsaravag
 *
 */
public class UI {
	
	private static final String SERVER_DETAILS_TITLE = Messages.Ui_CONSTANT_SERVER_WINDOW_TITLE;
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
		
		String input = (String)JOptionPane.showInputDialog(null,
				(message + Messages.Ui_MSG_INFO_ENTER_IP_PORT),				
				SERVER_DETAILS_TITLE, messageType);

		if (input == null){ 
			//user has pressed cancel button. Take confirmation from user
			String msg = Messages.Ui_MSG_INFO_SERVER_CANCEL;
			int option = JOptionPane.showConfirmDialog(null, msg, "",JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION){
				// Do not transfer files to server
				return new String[0]; 
			}
			else {
				// show the box again
				return getServerDetails(JOptionPane.INFORMATION_MESSAGE, "");
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
				return getServerDetails(JOptionPane.WARNING_MESSAGE, Messages.Ui_MSG_ERROR_WRONG_INPUT);
			}
				
		}
	}
}
