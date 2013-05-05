package org.amoeba.geom;

import org.amoeba.geom.collision.Collidable;


/**
 * Point holds 2D coordinates of the form (x, y).
 */
public class Point extends Collidable
{
	private float xPosition, yPosition;

	/**
	 * Default constructor for Point.
	 * Initializes the Point at (0, 0).
	 */
	public Point()
	{
		setPosition(0f, 0f);
	}

	/**
	 * Constructor for Point with a specific position.
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public Point(final float x, final float y)
	{
		setPosition(x, y);
	}

	/**
	 * Constructor for Point with a specific position.
	 * @param position The x and y coordinates
	 */
	public Point(final Point position)
	{
		setPosition(position);
	}

	/**
	 * Set both coordinates of the point.
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public void setPosition(final float x, final float y)
	{
		setX(x);
		setY(y);
	}

	/**
	 * Set both coordinates of the point.
	 * @param position The x and y coordinates
	 */
	public void setPosition(final Point position)
	{
		setX(position.getX());
		setY(position.getY());
	}

	/**
	 * Set the x coordinate of the point.
	 * @param x The x coordinate
	 */
	public void setX(final float x)
	{
		xPosition = x;
	}

	/**
	 * Set the y coordinate of the point.
	 * @param y The y coordinate
	 */
	public void setY(final float y)
	{
		yPosition = y;
	}

	/**
	 * Get the x coordinate of the point.
	 * @return The x coordinate
	 */
	public float getX()
	{
		return xPosition;
	}

	/**
	 * Get the y coordinate of the point.
	 * @return The y coordinate
	 */
	public float getY()
	{
		return yPosition;
	}
}
