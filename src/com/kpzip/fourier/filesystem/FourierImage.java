package com.kpzip.fourier.filesystem;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.kpzip.fourier.util.Logger;
import com.kpzip.fourier.util.LoggerType;

// Class used for reading and writing in the Fourier Image Format.
// The Fourier Image Format is used for storing the data about each rotating vector.
public class FourierImage {
	
	public static final String FILE_EXTENSION = ".pft";
	
	private ResourceLocation location;
	private FileReader read;
	private FileWriter write;
	private boolean closed = false;
	
	/**
	 * Simple constructor that passes in a file location; mainly used when reading a file, since we might have a file that isnt in the default directory.
	 * Attempting to pass a file that does not end with the correct file extension will cause an illegal argument exception.
	 * @param Location - The location of the file on disk.
	 * @throws IOException 
	 */
	public FourierImage(ResourceLocation loc) throws IOException {
		//check if the file specified ends in FILE_EXTENSION
		if (loc.getExtension() != FILE_EXTENSION) {
			Logger.log(LoggerType.ERROR, "Trying to open the wrong file type with the fourier image loader!");
			throw new IllegalArgumentException();
		}
		//if the file is valid, set the location variable
		this.location = loc;
		write = new FileWriter(location.toString());
		read = new FileReader(location.toString());
	}
	
	/**
	 * Getter Method for the file location
	 * Note there is no Setter method for the file location
	 * @return Returns the file location associated with this object
	 */
	public ResourceLocation getFileLocation() {
		return location;
	}
	
	/**
	 * When called, closes the file. 
	 * This should be called when writing or reading to this file via this object is not longer needed.
	 * @throws IOException if it is unable to close it
	 */
	public void close() throws IOException {
		read.close();
		write.close();
		setClosed(true);
	}
	
	public void writeBaseValues(String author, String name, int resolution) {
		
	}

	/**
	 * @return returns whether or not this file has been closed
	 */
	public boolean isClosed() {
		return closed;
	}

	private void setClosed(boolean closed) {
		this.closed = closed;
	}
	
	


}
