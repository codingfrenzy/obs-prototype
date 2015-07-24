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
package com.observability.modeling.emf.extension;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;


/**
 * @author gemici
 * Encapsulates the eclipse IDE dependency so that we can
 * mock it in unit test cases.
 */
public class EclipseResourceDelegate {
	
	/*
	 * The relative path to where the probe descriptors are stored
	 */
	public static final String PROBE_DESCRIPTOR_DIR_PATH = "descriptors";
	
	/**
	 * Cycles through all open projects and seeks for a descriptor dir.
	 * @return the folder of the descriptors
	 */
	public File getDescriptorPath(){
		IProject[] projects =	ResourcesPlugin.getWorkspace().getRoot().getProjects();
		File descriptorDir = null;
		boolean descriptorDirFound = false;
		for (int i = 0; i < projects.length; i++) {
			descriptorDir = projects[i].getLocation().append(PROBE_DESCRIPTOR_DIR_PATH).toFile();
			if(Files.exists(descriptorDir.toPath() , LinkOption.NOFOLLOW_LINKS)){
				descriptorDirFound = true;
				break;
			}
		}
		if(descriptorDirFound)
			return descriptorDir;
		return null;
	}
	
	public void  eclipseShowError(String title, String message){
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MessageDialog.openError(shell, title, message);
	}

}
