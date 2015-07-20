/**
 * 
 */
package com.observability.modeling.probe.descriptor;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Locale;

/**
 * @author gemici
 *
 */
public class DescriptorFilter implements FilenameFilter
{
	private static final String DESCRIPTOR_EXTENSION = ".descriptor";
	
	public boolean accept(File dir, String name) {
		return name.toLowerCase(Locale.ENGLISH).endsWith(DESCRIPTOR_EXTENSION);
	}
}
