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
import java.util.List;

import com.observability.modeling.probe.descriptor.entities.Collect;
import com.observability.modeling.probe.descriptor.entities.DbType;
import com.observability.modeling.probe.descriptor.entities.ElementTag;
import com.observability.modeling.probe.descriptor.entities.Obsolete_PluginDefinition;

/**
 * Parses the descriptors in a given directory and converts them to a manageable
 * entity hierarchy. This object hierarchy can be used to create EMF semantic
 * elements when initializing the model. For example: An EMF DbType entity needs
 * to be created for each plugin descriptor present. This info will be taken
 * from the intermediate entities this class generates :
 * 
 * @see {@link DbType}
 * @see {@link Parameter}, @see {@link ElementTag} Intermediate entities are used to ensure decoupling
 *      with EMF generated entities.
 *      
 * @author Caglayan "Gem" Gemici, Varun Saravagi
 *
 */
public interface DescriptorParser {

	/**
	 * This method parses all descriptor in a given dir.
	 * 
	 * @return list of plugin definitions found.
	 */
	public List<DbType> parseDescriptors();

	/**
	 * Parses the content of the descriptor file (essentially de-serialize)
	 * 
	 * @param descriptorContent
	 *            The contents of the descriptor file
	 * @return root plugin entity that holds all the information about the
	 *         content in a hierarchical format.
	 */
	public void parseFile(File file, DbType dbType);

}