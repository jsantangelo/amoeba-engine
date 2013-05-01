package org.amoeba.graphics.shape;

import android.util.Pair;

/**
 * Rectangle is a shape with a with and height.
 */
public class Rectangle implements Collidable
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
	 * Constructor for Rectangle for a specific width and height.
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 */
	public Rectangle(final float w, final float h)
	{
		this(0f, 0f, w, h);
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

	/**
	 * Get the position of the entity.
	 * @return The position of the entity.
	 */
	public Pair<Float, Float> getPosition()
	{
		return position;
	}

	/**
	 * Set the coordinates of the entity.
	 * @param x The x position of the entity.
	 * @param y The y position of the entity.
	 */
	public void setPosition(final float x, final float y)
	{
		position = Pair.create(x, y);
	}

	/**
	 * Get the rotation of the entity.
	 * @return The rotation of the entity.
	 */
	public float getRotation()
	{
		return rotation;
	}

	/**
	 * Set the rotation angle in degrees of the entity.
	 * @param angle The new rotation angle in degrees of the entity.
	 */
	public void setRotation(final float angle)
	{
		rotation = angle;
	}

	/**
	 * Determine whether the entity is scaled.
	 * @return Whether the entity is scaled.
	 */
	public boolean isScaled()
	{
		return (getScaleX() != 1.0f || getScaleY() != 1.0f);
	}

	/**
	 * Get the scale of the entity.
	 * @return The scale of the entity in both the X and Y direction.
	 */
	public Pair<Float, Float> getScale()
	{
		return scale;
	}

	/**
	 * Get the scale of the entity in the X-direction.
	 * @return The X scale of the entity.
	 */
	public float getScaleX()
	{
		return scale.first;
	}

	/**
	 * Get the scale of the entity in the Y-direction.
	 * @return The Y scale of the entity.
	 */
	public float getScaleY()
	{
		return scale.second;
	}

	/**
	 * Set the both the X and Y scale of the entity.
	 * @param scalingFactor The new scale of the entity.
	 */
	public void setScale(final float scalingFactor)
	{
		scale = Pair.create(scalingFactor, scalingFactor);
	}

	/**
	 * Set the X scale of the entity.
	 * @param scaleX The new X scale of the entity.
	 */
	public void setScaleX(final float scaleX)
	{
		scale = Pair.create(scaleX, scale.second);
	}

	/**
	 * Set the Y scale of the entity.
	 * @param scaleY The new Y scale of the entity.
	 */
	public void setScaleY(final float scaleY)
	{
		scale = Pair.create(scale.first, scaleY);
	}
}
