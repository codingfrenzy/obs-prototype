//**************************************************************************************************//
/* Observability Project
 * Copyright 2015 Master of Software Engineering team: Laila Alhmound, Ying (Joel) Gao, Caglayan (Gem) Gemici, Rajat Kapoor, Prasanth Nair, Varun Saravagi
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


/**
 * Messages for the Modeling component
 * @author vsaravag, cgemici
 *
 */
public class Messages  {

	// Messages for the SiriusServices component
	public static final String SiriusServices_ID_SEPERATOR="_";
	public static final String SiriusServices_MACHINE="Machine ";
	public static final String SiriusServices_MSG_ERROR_ECLIPSE_CANNOTBENULL="Argument cannot be null: EclipseResourceDelegate";
	public static final String SiriusServices_MSG_ERROR_MUST_BE_DB_CLUSTER="Container that new machine will be added must be of type DatabaseCluster!";
	public static final String SiriusServices_MSG_ERROR_NO_DESCRIPTOR_DIR="Cannot find descriptor directory <project_dir>/descriptors";
	public static final String SiriusServices_MSG_ERROR_NO_DESCRIPTOR_FILES="No descriptor files found. Please add the descriptor files and do the operation again.";
	public static final String SiriusServices_NULL="null";

	// Messages for the Model Handler component
	public static final String ModelHandler_MSG_ERROR_INVALID_DIRECTORY="Invalid project directory path.";
	public static final String ModelHandler_MSG_ERROR_NO_PERMISSIONS="Unable to create descriptors directory. Please check permissions.";
	public static final String ModelHandler_MSG_ERROR_GET_DESCRIPTOR="Failed to get correct descriptor file from server. Please try again.";
	public static final String ModelHandler_MSG_ERROR_DESCRIPTOR_UNZIP="Error in unzipping the descriptor files.";
	public static final String ModelHandler_MSG_ERROR_CONNECTION="Failed to connect to the server. ";
	public static final String ModelHandler_MSG_ERROR_NOT_BOUND="The service is not bound at"; 
	public static final String ModelHandler_MSG_ERROR_WRONG_URL="URL is not well-formed. Please check Ip and Port provided.";
	public static final String ModelHandler_MSG_ERROR_UPLOAD="Error in uploading the file";
	public static final String ModelHandler_MSG_ERROR_UPLOAD_NOT_STARTED="File upload could not be started";
	public static final String ModelHandler_CONSTANTS_DESCRIPTOR_FILE_NAME="descriptors.zip";
	public static final String ModelHandler_CONSTANTS_MODEL_HANDLER_RMI_SERVICE_NAME="ModelHandler";

	// Messages for the UI component
	public static final String Ui_MSG_INFO_ENTER_IP_PORT="Enter the IP and port where the Model Handler service is running, in the format -> ip:port";
	public static final String Ui_CONSTANT_SERVER_WINDOW_TITLE="Server Details";
	public static final String Ui_MSG_INFO_SERVER_CANCEL="Model creation cannot continue unless the descriptor files are obtained. Continue?";
	public static final String Ui_MSG_ERROR_WRONG_INPUT="Input is not in correct format.";

	//Messages for the Design (odesign) component
	public static final String Design_ZIP_WINDOW_TITLE="Generate File";
	public static final String Design_ZIP_ERROR="Error";
	public static final String Design_ZIP_ERROR_SELECT="Select the model file";
	public static final String Design_ZIP_ERROR_FILE_NOT_TRANSFER="File not transferred to server";
	public static final String Design_ZIP_ERROR_UPLOAD="Error while uploading the file to server";
	public static final String Design_ZIP_SUCCESS_UPLOAD="File successfully transferred to server";
	public static final String Design_ZIP_SUCCESS_GENERATED="Configuration files have been zipped successfully and stored in <project> root";


	private Messages() {}

}
