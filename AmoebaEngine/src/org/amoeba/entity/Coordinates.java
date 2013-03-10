package org.amoeba.entity;

/**
 * Coordinate provides a 2-dimensional (x, y) coordinate.
 */
public class Coordinates
{
	private float xCoord, yCoord;

	/**
	 * Default Constructor for Coordinate sets the initial coordinate to (0, 0).
	 */
	public Coordinates()
	{
		this(0f, 0f);
	}

	/**
	 * Constructor for Coordinate for both x and y values.
	 * @param x The x coordinate for the coordinate.
	 * @param y The y coordinate for the coordinate.
	 */
	public Coordinates(final float x, final float y)
	{
		setX(x);
		setY(y);
	}

	/**
	 * Set the x coordinate.
	 * @param x The x coordinate.
	 */
	public void setX(final float x)
	{
		xCoord = x;
	}

	/**
	 * Set the y coordinate.
	 * @param y The y coordinate.
	 */
	public void setY(final float y)
	{
		yCoord = y;
	}

	/**
	 * Get the x coordinate.
	 * @return The x coordinate.
	 */
	public float getX()
	{
		return xCoord;
	}

	/**
	 * Get the y coordinate.
	 * @return The y coordinate.
	 */
	public float getY()
	{
		return yCoord;
	}
}
