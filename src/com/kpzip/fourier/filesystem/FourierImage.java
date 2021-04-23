package com.kpzip.fourier.filesystem;

// Class used for reading and writing in the Fourier Image Format.
// The Fourier Image Format is used for storing the data about each rotating vector.
public class FourierImage {
	
	public static final String FILE_EXTENSION = ".pft";
	
	private String fileLocation;
	
	/**
	 * Simple constructor that passes in a file location; mainly used when reading a file, since we might have a file that isnt in the default directory.
	 * Attempting to pass a file that does not end with the correct file extension will cause an illegal argument exception.
	 * @param Location - The location of the file on disk.
	 */
	public FourierImage(String Location) {
		if (Location.substring(Location.length() - FILE_EXTENSION.length()) == FILE_EXTENSION) {
			throw new IllegalArgumentException("Opening a non-" + FILE_EXTENSION.substring(1) + " file with the " + FILE_EXTENSION + " loader!");
		}
		this.fileLocation = Location;
	}
	
	public String getFileLocation() {
		return fileLocation;
	}


}
