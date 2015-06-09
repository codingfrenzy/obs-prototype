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
package com.observability.modeling.probe.descriptor;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.observability.modeling.probe.descriptor.entities.PluginDefinition;

/**
 * {@inheritDoc}
 */

public class DescriptorParserImpl implements DescriptorParser {

	/**
	 * Tags that correspond to the tags of a collectd.conf plugin description. @see
	 * "cassandra.descriptor"
	 * */

	private static final String DESCRIPTOR_EXTENSION = "descriptor";
	private static final String PLUGIN_START = "<plugin>";
	private static final String PLUGIN_END = "</plugin>";
	private static final String TAG_START = "<";
	private static final String TAG_END = ">";
	private static final String TAG_CLOSE_START = "</";

	/**
	 * Anotations that represent on which entity in the semantic model the
	 * parsed elements need to be appended. For the metamodel @see
	 * "modeling/workspace/observability_new/model/observability_new.aird"
	 */

	private static final String MACHINE_SCOPE = "@Machine";
	private static final String DB_TYPE_SCOPE = "@Cluster";
	private static final String METRIC_SCOPE = "@Metric";
	private static final String COLLECT = "@Collect";

	/**
	 * The path where the descriptor files are stored
	 */
	private Path descriptorDirectory;

	/**
	 * Constructor
	 * 
	 * @param descriptorDirPath
	 *            the path in which the descriptors are located.
	 */
	public DescriptorParserImpl(Path descriptorDirPath) {
		this.descriptorDirectory = descriptorDirPath;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<PluginDefinition> parseDescriptors() {

		// Filter the files with correct extension
		File dir = descriptorDirectory.toFile();
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith("." + DESCRIPTOR_EXTENSION);
			}
		});

		List<PluginDefinition> plugins = new ArrayList<PluginDefinition>();

		// For each file generate a PluginDefinition
		if (files != null) {
			try {
				for (File file : files) {

					String content = readFile(file.getPath(),
							StandardCharsets.US_ASCII);
					plugins.add(parsePlugin(content));

				}
			} catch (IOException ex) {
				ex.printStackTrace();
				throw new RuntimeException();
			}
		}
		return plugins;

	}

	/**
	 * {@inheritDoc}
	 */
	public PluginDefinition parsePlugin(String descriptorContent) {
		return new PluginDefinition();
	}

	/**
	 * Utility file to convert the file contents into String
	 * 
	 * @param path
	 * @param encoding
	 * @return String representation of the file's content
	 * @throws IOException
	 */
	public static String readFile(String path, Charset encoding)
			throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
