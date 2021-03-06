package com.observability.modeling.design.handlers;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

import com.observability.modeling.common.Messages;
import com.observability.modeling.generation.files.Main;
import com.observability.monitoring.server.*;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class GenerateFiles extends AbstractHandler {

	private static String ZIPEXTENSION = ".zip";
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

		if(selection.isEmpty()){
			MessageDialog.openError(window.getShell(), Messages.Design_ZIP_ERROR, Messages.Design_ZIP_ERROR_SELECT);
			return null;
		}						

		// Get the current selection
		TreePath[] path = selection.getPaths();
		// Get the selected file
		IFile file =  (IFile) path[0].getSegment(1);
		String zipName = file.getName().split("\\.")[0];
		// Get the project 
		IProject project = (IProject) path[0].getFirstSegment();
		// Absolute path of the project
		String projectPath = project.getLocation().toString();
		// Absolute path where the zip file is to be created
		String zipPath = projectPath + File.separatorChar + zipName + ZIPEXTENSION;
		// Absolute path of the file
		String modelPath = file.getLocation().toString();

		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();		
		workspace.getFullPath().toString();


		URI modelURI = URI.createFileURI(modelPath);
		File targetFolder = new File(projectPath);
		List<String> arguments = new ArrayList<String>();

		try {
			Main generator = new Main(modelURI, targetFolder, arguments);
			generator.setFileParameters(projectPath, zipPath);
			generator.doGenerate(new BasicMonitor());

			MessageDialog.openInformation(
					window.getShell(),
					Messages.Design_ZIP_WINDOW_TITLE,
					(Messages.Design_ZIP_SUCCESS_GENERATED));

			// Deploy the zip file on the server
			ModelHandler mh = ModelHandler.getInstance();
			int result = mh.deployFile(zipPath, zipName);
			String message = "";
			if(result == -1){
				message += Messages.Design_ZIP_ERROR_FILE_NOT_TRANSFER;
			}
			else if(result == -2){
				message += Messages.Design_ZIP_ERROR_UPLOAD;
			}
			else if(result == 0){
				message += Messages.Design_ZIP_SUCCESS_UPLOAD;
			}
			MessageDialog.openInformation(
					window.getShell(),
					Messages.Design_ZIP_WINDOW_TITLE,
					message);	

			return null;

		} catch (Exception e) {
			// Display the error message.
			
			MessageDialog.openError(window.getShell(), Messages.Design_ZIP_ERROR, e.getMessage());
			return null;
		}
	}
}
