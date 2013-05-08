package org.amoeba.geom;

import org.amoeba.geom.collision.Collidable;

/**
 * Circle is a shape with a single center point and radius.
 */
public class Circle extends Collidable
{
	private Point center;
	private float radius;
	private Dimension scale;

	/**
	 * Default constructor for Circle.
	 * Creates the circle at (0, 0) with a radius 1.0f.
	 */
	public Circle()
	{
		this(new Point(0f, 0f), 1.0f);
	}

	/**
	 * Constructor for Circle with a specific position and radius.
	 * @param x The x position of the circle (center).
	 * @param y The y position of the circle (center).
	 * @param r The radius of the circle.
	 */
	public Circle(final float x, final float y, final float r)
	{
		this(new Point(x, y), r);
	}

	/**
	 * Constructor for Circle with a specific position and radius.
	 * @param position The position of the circle (center).
	 * @param r The radius of the circle.
	 */
	public Circle(final Point position, final float r)
	{
		setPosition(position);
		setRadius(r);
		setScale(1.0f);
	}

	/**
	 * Get the position of the circle.
	 * @return The position of the circle.
	 */
	public Point getPosition()
	{
		return center;
	}

	/**
	 * Set the coordinates of the circle.
	 * @param x The x position of the circle.
	 * @param y The y position of the circle.
	 */
	public void setPosition(final float x, final float y)
	{
		center.setPosition(x, y);
	}

	/**
	 * Set the coordinates of the circle.
	 * @param position The x and y coordinates of the circle.
	 */
	public void setPosition(final Point position)
	{
		center.setPosition(position);
	}

	/**
	 * Get the radius of the circle.
	 * @return The radius of the circle.
	 */
	public float getRadius()
	{
		return radius;
	}

	/**
	 * Set the radius of the circle.
	 * @param r The radius of the circle.
	 */
	public void setRadius(final float r)
	{
		radius = r;
	}

	/**
	 * Determine whether the rectangle is scaled.
	 * @return Whether the rectangle is scaled.
	 */
	public boolean isScaled()
	{
		return (scale.getWidth() != 1.0f || scale.getHeight() != 1.0f);
	}

	/**
	 * Get the scale of the rectangle.
	 * @return The scale of the entity in both the X and Y direction.
	 */
	public Dimension getScale()
	{
		return scale;
	}

	/**
	 * Set the both the X and Y scale of the rectangle.
	 * @param scalingFactor The new scale of the rectangle.
	 */
	public void setScale(final float scalingFactor)
	{
		scale.setSize(scalingFactor, scalingFactor);
	}

	/**
	 * Set the scale of the rectangle.
	 * @param s The scale of the rectangle.
	 */
	public void setScale(final Dimension s)
	{
		scale.setSize(s);
	}
}
