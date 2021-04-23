package main.math;

//Basic class for 2 dimensional vectors
//assumes all vectors are rooted at the origin
//Uses Cartesian coordinates
public class Vector2D {
	
	
	private float x;
	private float y;
	
	//constructors
	/**
	 * Creates a 2D vector with set values
	 * @param x the x-value for the vector
	 * @param y the y-value for the vector
	 */
	public Vector2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Creates a 2D vector
	 * All values will be set to 0.0f by default
	 */
	public Vector2D() {
		this.x = 0.0f;
		this.y = 0.0f;
	}

	//Getters and Setters
	
	/**
	 * @return returns the X value of the vector
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * Sets the x value of the vector
	 * @param x the new x value
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return returns the Y value of the vector
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Sets the y value of the vector
	 * @param y the new y value
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * Gets the length of the vector as in polar coordinates
	 * @return returns the length of the vector
	 */
	public float getRadius() {
		//use Pythagrean theorem
		return (float) Math.sqrt((double)(Math.pow(y, 2) + Math.pow(x, 2)));
	}
	
	/**
	 * Gets the angle the vector sits at in radians.
	 * zero radians is considdered to be pointing straight in the positive x direction (right)
	 * @return returns the angle Theta
	 */
	public float getTheta() {
		return (float) Math.atan((double)(y/x));
	}
	

}
