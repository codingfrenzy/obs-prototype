/**
 * 
 */
package com.observability.modeling.probe.descriptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author vsaravag
 *
 */
public final class ParserUtility {
	
	
	private ParserUtility(){
		
	}
	
	public static boolean isAnnotated(String line){
		if(line == null){
			return false;
		}
		String regex = ".*@(Machine|Metric|Collect)$";
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
			String[] insideTag = new String[2];
			insideTag = matcher.group(2).trim().split("\\s+", 2); //get the string and split at space
			int i = 0;
			for (String s : insideTag) {
				// i = 0 -> name of the element
				// i = 1 -> value of the element
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
			for (String s : keyValue) {
				// i = 0 -> name of the key
				// i = 1 -> value of the value
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
}
