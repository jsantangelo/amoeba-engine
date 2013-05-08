package org.amoeba.geom;

import org.amoeba.geom.collision.Collidable;

/**
 * Triangle is a shape with 3 vertices.
 */
public class Triangle extends Collidable
{
	private static final int NUM_POINTS = 3;

	private Point[] points;
	private Dimension scale;
	private float rotation;

	/**
	 * Default constructor for Triangle.
	 * Creates the triangle with all vertices at (0, 0).
	 */
	public Triangle()
	{
		this(new Point(0.0f, 0.0f), new Point(0.0f, 0.0f), new Point(0.0f, 0.0f));
	}

	/**
	 * Constructor for Triangle with specific positions for the vertices.
	 * @param x1 The x position of the first vertex.
	 * @param y1 The y position of the first vertex.
	 * @param x2 The x position of the second vertex.
	 * @param y2 The y position of the second vertex.
	 * @param x3 The x position of the third vertex.
	 * @param y3 The y position of the third vertex.
	 */
	public Triangle(final float x1, final float y1, final float x2, final float y2, final float x3, final float y3)
	{
		this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
	}

	/**
	 * Constructor for Triangle with specific positions for the vertices.
	 * @param vertex1 The first vertex.
	 * @param vertex2 The second vertex.
	 * @param vertex3 The third vertex.
	 */
	public Triangle(final Point vertex1, final Point vertex2, final Point vertex3)
	{
		points = new Point[NUM_POINTS];
		setPosition1(vertex1);
		setPosition2(vertex2);
		setPosition3(vertex3);
		setScale(1.0f);
		setRotation(0.0f);
	}

	/**
	 * Get the position of the first vertex.
	 * @return The position of the first vertex.
	 */
	public Point getPosition1()
	{
		return points[0];
	}

	/**
	 * Set the position of the first vertex.
	 * @param position The position of the first vertex.
	 */
	public void setPosition1(final Point position)
	{
		points[0].setPosition(position);
	}

	/**
	 * Set the position of the first vertex.
	 * @param x The x position of the first vertex.
	 * @param y The y position of the first vertex.
	 */
	public void setPosition1(final float x, final float y)
	{
		points[0].setPosition(x, y);
	}

	/**
	 * Get the position of the second vertex.
	 * @return The position of the second vertex.
	 */
	public Point getPosition2()
	{
		return points[1];
	}

	/**
	 * Set the position of the second vertex.
	 * @param position The position of the second vertex.
	 */
	public void setPosition2(final Point position)
	{
		points[1].setPosition(position);
	}

	/**
	 * Set the position of the second vertex.
	 * @param x The x position of the second vertex.
	 * @param y The y position of the second vertex.
	 */
	public void setPosition2(final float x, final float y)
	{
		points[1].setPosition(x, y);
	}

	/**
	 * Get the position of the third vertex.
	 * @return The position of the third vertex.
	 */
	public Point getPosition3()
	{
		return points[2];
	}

	/**
	 * Set the position of the third vertex.
	 * @param position The position of the third vertex.
	 */
	public void setPosition3(final Point position)
	{
		points[2].setPosition(position);
	}

	/**
	 * Set the position of the third vertex.
	 * @param x The x position of the third vertex.
	 * @param y The y position of the third vertex.
	 */
	public void setPosition3(final float x, final float y)
	{
		points[2].setPosition(x, y);
	}

	/**
	 * Get the rotation of the rectangle.
	 * @return The rotation of the rectangle.
	 */
	public float getRotation()
	{
		return rotation;
	}

	/**
	 * Set the rotation angle in degrees of the rectangle.
	 * @param angle The new rotation angle in degrees of the rectangle.
	 */
	public void setRotation(final float angle)
	{
		rotation = angle;
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
