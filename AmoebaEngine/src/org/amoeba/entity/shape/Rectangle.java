package org.amoeba.entity.shape;

import org.amoeba.entity.Coordinates;

/**
 * Rectangle is a shape with a with and height.
 */
public class Rectangle implements Shape
{
	private Coordinates position;
	private float scaleWidth, scaleHeight;
	private float rotation;
	private float width, height;

	/**
	 * Default constructor for Rectangle creates the rectangle at (0, 0) with a width and height of 1.
	 */
	public Rectangle()
	{
		this(new Coordinates(0f, 0f), 1f, 1f);
	}

	/**
	 * Constructor for Rectangle for a specific position and a width and height of 1.
	 * @param coordinates The position of the rectangle (top-left).
	 */
	public Rectangle(final Coordinates coordinates)
	{
		this(coordinates, 1f, 1f);
	}

	/**
	 * Constructor for Rectangle for a specific position and size.
	 * @param coordinates The position of the rectangle (top-left).
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 */
	public Rectangle(final Coordinates coordinates, final float w, final float h)
	{
		setPosition(coordinates);
		setWidth(w);
		setHeight(h);
		setScale(1.0f);
		setRotation(0.0f);
	}

	/**
	 * Get the width of the Rectangle.
	 * @return The width of the rectangle.
	 */
	public float getWidth()
	{
		return width;
	}

	/**
	 * Get the height of the rectangle.
	 * @return The height of the rectangle.
	 */
	public float getHeight()
	{
		return height;
	}

	/**
	 * Set the width of the rectangle.
	 * @param w The new width of the rectangle.
	 */
	public void setWidth(final float w)
	{
		width = w;
	}

	/**
	 * Set the height of the rectangle.
	 * @param h The new height of the rectangle.
	 */
	public void setHeight(final float h)
	{
		height = h;
	}

	@Override
	public boolean isColliding(final Shape shape)
	{
		return false;
	}

	@Override
	public Coordinates getPosition()
	{
		return position;
	}

	@Override
	public void setPosition(final Coordinates coordinates)
	{
		position = coordinates;
	}

	@Override
	public float getRotation()
	{
		return rotation;
	}

	@Override
	public void setRotation(final float angle)
	{
		rotation = angle;
	}

	@Override
	public boolean isScaled()
	{
		return (getScaleX() != 1.0f || getScaleY() != 1.0f);
	}

	@Override
	public float getScaleX()
	{
		return scaleWidth;
	}

	@Override
	public float getScaleY()
	{
		return scaleHeight;
	}

	@Override
	public void setScale(final float scale)
	{
		setScaleX(scale);
		setScaleY(scale);
	}

	@Override
	public void setScaleX(final float scaleX)
	{
		scaleWidth = scaleX;
	}

	@Override
	public void setScaleY(final float scaleY)
	{
		scaleHeight = scaleY;
	}
}
