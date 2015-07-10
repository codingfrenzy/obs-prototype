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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the utility class used by {@link DescriptorParser} to 
 * parse the probe descriptors.
 * 
 * @author vsaravag (Varun Saravagi)
 *
 */
public class ParserUtility {
	
	
	private ParserUtility(){
		
	}
	
	public static boolean isAnnotated(String line){
		if(line == null){
			return false;
		}
		String regex = ".*@.*$";
		return line.matches(regex);
	}
	
	public static boolean isElementStart(String line){
		if(line == null){
			return false;
		}
		String regex = "^<[^/].*"; // the line should start with < and not </
		return line.matches(regex);
	}
	
	public static boolean isElementEnd(String line){
		if(line == null){
			return false;
		}
		String regex = "^</.*"; // the line should start with </
		return line.matches(regex);
	}
	
	
	/**
	 * Get the details of an Element Tag.
	 * @param line
	 * 			the line from which details are to be extracted
	 * @return
	 * 		A String array with the following details:
	 * 		index 0 -> element name
	 * 		index 1 -> element value
	 */
	public static String[] getElementDetails(String line){
		if(line == null){
			return null;
		}
		String[] result = new String[2];
		String regex = "(^</|^<)(.*)>.*$"; // the regex would group the string inside < >
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		if(matcher.find()){ //there would be only one match in a line
			String[] insideTag = matcher.group(2).trim().split("\\s+", 2); //get the string and split at space. This would only give 2 elements
			int i = 0;
			regex = "\"(.*)\""; //The regex is to remove the quotes ("") around the string.
			pattern = Pattern.compile(regex);
			for (String s : insideTag) {
				// i = 0 -> name of the element
				// i = 1 -> value of the element
				matcher = pattern.matcher(s);
				if(matcher.find()){
					//remove the quotes ("") from around the string
					result[i] = matcher.group(1).trim();
				}
				else
					result[i] = s.trim();
				i++;
			}
		}
		return result;
	}
	
	
	
	/**
	 * Get the key-value pair from the line
	 * @param line
	 * 			the line from which details are to be extracted
	 * @return
	 * 		A String array with the following details:
	 * 		index 0 -> key name
	 * 		index 1 -> key value
	 */
	public static String[] getKeyValueDetails(String line){
		if(line == null){
			return null;
		}
		String[] result = new String[2];
		String regex = "([^<].*)[^>]@.*$"; //the regex would group the string before the annotation
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		if(matcher.find()){ //there would be only one match in a line
			String[] keyValue = matcher.group(1).trim().split("\\s+",2); //get the string and split at space
			int i = 0;
			regex = "\"(.*)\""; //The regex is to remove the quotes ("") around the string.
			pattern = Pattern.compile(regex);
			for (String s : keyValue) {
				// i = 0 -> name of the key
				// i = 1 -> value of the value
				matcher = pattern.matcher(s);
				if(matcher.find()){
					result[i] = matcher.group(1).trim();
				}
				else
					result[i] = s.trim();
				i++;
			}
		}
		return result;
	}
	
	/**
	 * Get the annotation on the line
	 * @param line
	 * 			the line on which the annotation is to be found
	 * @return
	 * 		the annotation
	 */
	public static String getAnnotation(String line){
		if(line == null){
			return null;
		}
		String regex = ".*(@.*)$"; // the regex would group the annotation 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		if(matcher.find()){ //there would be only one match in a line
			return matcher.group(1).trim();
		}
		return null;
	}
	
	/**
	 * Get the name from the annotation
	 * @param annotation the annotation from which the name is
	 * to be extracted
	 * @return name, if any else null
	 */
	public static String getNameFromAnnotated(String annotation){
		if(annotation == null){
			return null;
		}
		String regex = "@.*\\((.*)\\)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(annotation);
		if(matcher.find()){ //there would be only one match in a line
			return matcher.group(1).trim();
		}
		return null;
	}
	
	public static String getAnnotationFromAnnotated(String annotatedString){
		if(annotatedString == null){
			return null;
		}
		return annotatedString.split("\\(")[0].trim();
	}
}
