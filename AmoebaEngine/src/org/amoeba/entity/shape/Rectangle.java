package org.amoeba.entity.shape;

import org.amoeba.entity.Entity;

import android.util.Pair;

/**
 * Rectangle is a shape with a with and height.
 */
public abstract class Rectangle implements Entity, Collidable
{
	private Pair<Float, Float> position;
	private Pair<Float, Float> scale;
	private float rotation;
	private float width, height;

	/**
	 * Default constructor for Rectangle creates the rectangle at (0, 0) with a width and height of 1.
	 */
	public Rectangle()
	{
		this(0f, 0f, 1f, 1f);
	}

	/**
	 * Constructor for Rectangle for a specific position and a width and height of 1.
	 * @param x The x position of the rectangle (left).
	 * @param y The y position of the rectangle (top).
	 */
	public Rectangle(final float x, final float y)
	{
		this(x, y, 1f, 1f);
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
	public boolean isColliding(final Collidable shape)
	{
		return false;
	}

	@Override
	public Pair<Float, Float> getPosition()
	{
		return position;
	}

	@Override
	public void setPosition(final float x, final float y)
	{
		position = Pair.create(x, y);
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
	public Pair<Float, Float> getScale()
	{
		return scale;
	}

	@Override
	public float getScaleX()
	{
		return scale.first;
	}

	@Override
	public float getScaleY()
	{
		return scale.second;
	}

	@Override
	public void setScale(final float scalingFactor)
	{
		scale = Pair.create(scalingFactor, scalingFactor);
	}

	@Override
	public void setScaleX(final float scaleX)
	{
		if (scale != null)
		{
			scale = Pair.create(scaleX, scale.second);
		}
	}

	@Override
	public void setScaleY(final float scaleY)
	{
		if (scale != null)
		{
			scale = Pair.create(scale.first, scaleY);
		}
	}
}
