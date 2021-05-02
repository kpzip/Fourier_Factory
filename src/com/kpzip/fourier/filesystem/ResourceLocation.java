package com.kpzip.fourier.filesystem;

import java.util.regex.Pattern;

//Class for storing data about a file or resource's location
public class ResourceLocation {
	
	private String path;
	private String filename;
	private String extension;
	
	/**
	 * Generates a resource location object that points to the specified file
	 * @param path the path of said file
	 * @precondition contains a file name and extension, uses backslashes "\" to separate folder names
	 */
	public ResourceLocation(String path) {
		
		//some string parsing code to get the extension of the file includes the "."
		this.extension = "." + path.split("\\.")[path.split("\\.").length - 1];
		
		//gets the filename without the extension
		this.filename = path.split("\\.")[0].split(Pattern.quote("\\"))[path.split("\\.")[0].split(Pattern.quote("\\")).length - 1];
		
		//gets the folder location of the file.
		this.path = path.substring(0, path.length() - (this.filename.length() + this.extension.length() + 1));
		
	}
	
	/**
	 * @return returns the path of the file. does not include the file name or extension.
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @return returns the name of the file. does not include the path or the extension.
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @return returns the extension of the file. includes the "."
	 */
	public String getExtension() {
		return extension;
	}
	
	/**
	 * @return string representing the files location, name and extension. Same as the string you would pass into a file reader 
	 */
	@Override
	public String toString() {
		return path + filename + extension;
	}

}
