package com.observability.modeling.generator.handlers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.eclipse.acceleo.module.sample.files.Main;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class GenerateFiles extends AbstractHandler {
	
	/**
	 * The constructor.
	 */
	public GenerateFiles() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		TreeSelection selection = (TreeSelection) window.getSelectionService().getSelection();
		boolean transfer = true;
		
		if(selection.isEmpty()){
			MessageDialog.openError(window.getShell(), "Error", "Select the model file");
			return null;
		}
				
		String[] serverDetails = getServerDetails(JOptionPane.PLAIN_MESSAGE,"");
		String ip = null, port = null;
		if(serverDetails == null){
			// Do not transfer configuration files to server
			transfer = false;
		}
		else{
			// Get the ip and port
			ip = serverDetails[0];
			port = serverDetails[1];
		}
		
		
		// Get the current selection
		TreePath[] path = selection.getPaths();
		// Get the selected file
		IFile file =  (IFile) path[0].getSegment(1);
		// Get the project 
		IProject project = (IProject) path[0].getFirstSegment();
		// Absolute path of the project
		String projectPath = project.getLocation().toString();
		// Absolute path of the file
		String modelPath = file.getLocation().toString();
		
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();		
		workspace.getFullPath().toString();
		

		URI modelURI = URI.createFileURI(modelPath);
        File targetFolder = new File(projectPath);
        List<String> arguments = new ArrayList<String>();
        
		try {
			Main generator = new Main(modelURI, targetFolder, arguments);
			generator.setFileParameters("", projectPath, projectPath);
			generator.doGenerate(new BasicMonitor());
			
			MessageDialog.openInformation(
					window.getShell(),
					"Generate File",
					("File conf.zip generated in project directory"));
			
			//String ip = "128.237.201.134";
			//String port = "17680";
			
			if(transfer){
				// Deploy the zip file on the server
				Deploy.deployFile(ip, port, (projectPath+ File.separatorChar + "conf.zip"));
				
				MessageDialog.openInformation(
						window.getShell(),
						"Generate File",
						("File successfully transferred to server (" + ip + ":" + port + ")"));	
			}
			
			return null;
			
		} catch (Exception e) {
			// Display the error message.
			MessageDialog.openError(window.getShell(), "Error", e.getMessage());
			return null;
		}
	}

	/**
	 * This method gets the server details (ip and port) where the ModelHandler RMI service
	 * is running. It shows an input dialog where the user would enter the value. If the user
	 * presses Cancel and accepts that the files should not be transferred, the files would not
	 * be transferred to the server. 
	 * 
	 * The user input is validated before being accepted. Currently only ipv4 addresses are accepted.
	 * 
	 * @param messageType the type of the message to be shown in the dialog box.
	 * The values should be used from JOptionPane class.
	 * @param message Any additional message which needs to be appended before the default input message
	 * 
	 * @return A String array containing ip and port. Index 0 contains ip, index 1 contains port
	 */
	private String[] getServerDetails(int messageType, String message){
		
		String input = (String)JOptionPane.showInputDialog(null,
				(message + "Enter the IP and port of the server in the format -> ip:port"),				
				"Server Details", messageType);
		
		if (input == null){ 
			//user has pressed cancel button. Take confirmation from user
			String msg = "Configuration files would not be transferred to "
					+ "the server and have to be transferred manually."
					+ " Do you want to continue?";
			int option = JOptionPane.showConfirmDialog(null, msg, "",JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION){
				return null; //Do not transfer files to server
			}
			else {
				getServerDetails(JOptionPane.INFORMATION_MESSAGE, "");
			}
		}
		
		//validate input
		String ipRegex = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}):(\\d{1,5})";
		Pattern pattern = Pattern.compile(ipRegex);
		Matcher matcher = pattern.matcher(input);
		String[] serverDetails = new String[2];
		if(matcher.matches()){
			serverDetails[0] = matcher.group(1); //ip
			serverDetails[1] = matcher.group(2); //port
		}
		else {
			//wrong input. Get input again
			getServerDetails(JOptionPane.WARNING_MESSAGE, "Input is not in correct format.\n");
		}
		
		return serverDetails;
	}
}
