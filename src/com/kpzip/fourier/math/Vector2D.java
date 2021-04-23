package com.kpzip.fourier.math;

//Basic class for 2 dimensional vectors
//assumes all vectors are rooted at the origin
//Uses Cartesian coordinates
public class Vector2D {
	
	
	private float x;
	private float y;
	
	//constructors
	/**
	 * Creates a 2D vector with set values
	 * @param x - The x-value for the vector.
	 * @param y - The y-value for the vector.
	 */
	public Vector2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Creates a 2D vector.
	 * All values will be set to 0.0f by default.
	 */
	public Vector2D() {
		this.x = 0.0f;
		this.y = 0.0f;
	}

	//Getters and Setters
	
	/**
	 * @return Returns the X value of the vector.
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * Sets the x value of the vector.
	 * @param x - The new value of x.
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return Returns the Y value of the vector.
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Sets the y value of the vector.
	 * @param y - The new value of y.
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * Gets the length of the vector as in polar coordinates.
	 * @return Returns the length of the vector.
	 */
	public float getRadius() {
		// Use Pythagorean theorem.
		return (float) Math.sqrt((double)(Math.pow(y, 2) + Math.pow(x, 2)));
	}
	
	/**
	 * Gets the angle the vector sits at in radians.
	 * Zero radians is considered to be pointing straight in the positive x direction (right).
	 * @return Returns the angle theta.
	 */
	public float getTheta() {
		return (float) Math.atan((double)(y/x));
	}
	

}
