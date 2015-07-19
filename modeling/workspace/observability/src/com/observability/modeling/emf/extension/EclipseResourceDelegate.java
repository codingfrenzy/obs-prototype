/**
 * 
 */
package com.observability.modeling.emf.extension;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;


/**
 * @author gemici
 *
 */
public class EclipseResourceDelegate {
	
	/*
	 * The relative path to where the probe descriptors are stored
	 */
	public static String PROBE_DESCRIPTOR_DIR_PATH = "descriptors";
	
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

}
