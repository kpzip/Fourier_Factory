package com.kpzip.fourier.filesystem;

//Class used for reading and writing in the Fourier Image Format
//The Fourier Image Format is used for storing the data about each rotating vector
public class FourierImage {
	
	private String fileLocation = "";
	public static final String FILE_EXTENSION = ".pft";
	
	/**
	 * Simple constructor that passes in a file location; mainly used when reading a file, since we might have a file that isnt in the default directory
	 * Attempting to pass a file that does not end with the correct file extention will cause an illegal argument exception
	 * @param Location the location of the file on disk
	 */
	public FourierImage(String Location) {
		if (Location.substring(Location.length() - FILE_EXTENSION.length()) == FILE_EXTENSION) {
			
		}
		this.fileLocation = Location;
	}

}
