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
import java.io.FileNotFoundException;
import java.util.List;

import com.observability.modeling.probe.descriptor.entities.DbType;
import com.observability.modeling.probe.descriptor.entities.ElementTag;
import com.observability.modeling.probe.descriptor.entities.Feature;
import com.observability.modeling.probe.descriptor.entities.KeyValue;

/**
 * Parses the descriptors in a given directory and converts them to a manageable
 * entity hierarchy. This object hierarchy can be used to create EMF semantic
 * elements when initializing the model. 
 * 
 * This code is used when the modeler wants to create a model of the system.
 * An EMF DbType entity would be created for each descriptor file present, a 
 * descriptor file is recognized by the .descriptor extension. When a cluster 
 * is associated with a DbType, all the machines created inside that cluster 
 * would automatically get the parameters denoted by the \@machine tag in the
 * descriptor file. A more detailed description of the descriptor file can be
 * found at {@link https://github.com/observability/obs-prototype/wiki/Descriptor-File-Format}
 * 
 * @see {@link DbType}
 * @see {@link Parameter}, @see {@link ElementTag}, @see {@link KeyValue}
 * Intermediate entities are used to ensure decoupling with EMF generated entities.
 *      
 * @author Caglayan "Gem" Gemici, Varun Saravagi
 *
 */
public interface DescriptorParser {

	/**
	 * This method parses all descriptor in a given directory.
	 */
	public void parseDescriptors();

	/**
	 * Parses the content of the descriptor file (essentially de-serialize)
	 * 
	 * @param file the descriptor file to parse
	 * @param dbType instance of the database to which the file belongs
	 * @param isFeatureFile true: if the file describes central server, false otherwise
	 * @throws FileNotFoundException given file is not found
	 */
	public void parseFile(File file, DbType dbType, boolean isFeatureFile) throws FileNotFoundException;
	
	/**
	 * @return the list containing parsed descriptor files
	 */
	public List<DbType> getPlugins();
	
	/**
	 * @return the list containing the features for the central file.
	 */
	public List<Feature> getFeatures();

}