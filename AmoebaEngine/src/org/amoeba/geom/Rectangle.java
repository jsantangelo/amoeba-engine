package org.amoeba.geom;

import org.amoeba.geom.collision.Collidable;


/**
 * Rectangle is a shape with a with and height.
 */
public class Rectangle extends Collidable
{
	private Point position;
	private Dimension size;
	private Dimension scale;
	private float rotation;

	/**
	 * Default constructor for Rectangle.
	 * Creates the rectangle at (0, 0) with a width and height of 1.
	 */
	public Rectangle()
	{
		this(0f, 0f, 1f, 1f);
	}

	/**
	 * Constructor for Rectangle for a specific width and height.
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 */
	public Rectangle(final float w, final float h)
	{
		this(0f, 0f, w, h);
	}

	/**
	 * Constructor for Rectangle for a specific width and height.
	 * @param dimension The width and height of the rectangle.
	 */
	public Rectangle(final Dimension dimension)
	{
		this(0f, 0f, dimension.getWidth(), dimension.getHeight());
	}

	/**
	 * Constructor for Rectangle for a specific position and size.
	 * @param x The x position of the rectangle (left).
	 * @param y The y position of the rectangle (top).
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 */
	public Rectangle(final float x, final float y, final float w, final float h)
	{
		setPosition(x, y);
		setWidth(w);
		setHeight(h);
		setScale(1.0f);
		setRotation(0.0f);
	}

	/**
	 * Constructor for Rectangle for a specific position and size.
	 * @param pos The position of the rectangle (top-left).
	 * @param dimension The width and height of the rectangle.
	 */
	public Rectangle(final Point pos, final Dimension dimension)
	{
		setPosition(pos.getX(), pos.getY());
		setWidth(dimension.getWidth());
		setHeight(dimension.getHeight());
		setScale(1.0f);
		setRotation(0.0f);
	}

	/**
	 * Get the width of the Rectangle.
	 * @return The width of the rectangle.
	 */
	public float getWidth()
	{
		return size.getWidth();
	}

	/**
	 * Get the height of the rectangle.
	 * @return The height of the rectangle.
	 */
	public float getHeight()
	{
		return size.getHeight();
	}

	/**
	 * Get the size of the rectangle.
	 * @return The size of the rectangle.
	 */
	public Dimension getSize()
	{
		return size;
	}

	/**
	 * Set the width of the rectangle.
	 * @param w The width of the rectangle.
	 */
	public void setWidth(final float w)
	{
		size.setWidth(w);
	}

	/**
	 * Set the height of the rectangle.
	 * @param h The new height of the rectangle.
	 */
	public void setHeight(final float h)
	{
		size.setHeight(h);
	}

	/**
	 * Get the position of the rectangle.
	 * @return The position of the rectangle.
	 */
	public Point getPosition()
	{
		return position;
	}

	/**
	 * Set the coordinates of the rectangle.
	 * @param x The x position of the rectangle.
	 * @param y The y position of the rectangle.
	 */
	public void setPosition(final float x, final float y)
	{
		position.setPosition(x, y);
	}

	/**
	 * Set the coordinates of the entity.
	 * @param pos The x and y coordinates of the entity.
	 */
	public void setPosition(final Point pos)
	{
		position.setPosition(pos);
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
