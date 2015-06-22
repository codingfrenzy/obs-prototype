package observability_new.design.handlers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.module.sample.files.Main;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.Resource;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IWorkbenchPart part = HandlerUtil.getActivePartChecked(event);
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		workspace.getFullPath().toString();
		String modelPath = workspace.getLocationURI().toString() + "/Final.design/My.observability_new";
		//String target = workspace.getLocationURI().toString();
		String target = "/home/vsaravag/git/obs-prototype/modeling/editor/"
				+ "Generator/src/org/eclipse/acceleo/module/sample/files";
		
		URI modelURI = URI.createURI(modelPath);
        File folder = new File(target);
        List<String> arguments = new ArrayList<String>();
        
		try {
			Main generator = new Main(modelURI, folder, arguments);
			generator.doGenerate(new BasicMonitor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MessageDialog.openInformation(
				window.getShell(),
				"observability_new.design",
				workspace.getLocation().toString());
		return null;
	}
}
