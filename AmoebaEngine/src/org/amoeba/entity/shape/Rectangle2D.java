package org.amoeba.entity.shape;

import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.entity.Entity;
import org.amoeba.geom.Dimension;
import org.amoeba.geom.Rectangle;

/**
 * Rectangle2D is Rectangle that can be drawn.
 */
public abstract class Rectangle2D extends Rectangle implements Entity, DrawListener, UpdateListener
{
	/**
	 * Default constructor for Rectangle2D.
	 * Creates the rectangle at (0, 0) with a width and height of 1.0f.
	 */
	public Rectangle2D()
	{
		super(0f, 0f, 1f, 1f);
	}

	/**
	 * Constructor for Rectangle2D for a specific width and height.
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 */
	public Rectangle2D(final float w, final float h)
	{
		super(0f, 0f, w, h);
	}

	/**
	 * Constructor for Rectangle2D for a specific width and height.
	 * @param dimension The width and height of the rectangle.
	 */
	public Rectangle2D(final Dimension dimension)
	{
		super(0f, 0f, dimension.getWidth(), dimension.getHeight());
	}

	/**
	 * Constructor for Rectangle2D for a specific position and size.
	 * @param x The x position of the rectangle (left).
	 * @param y The y position of the rectangle (top).
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 */
	public Rectangle2D(final float x, final float y, final float w, final float h)
	{
		super(x, y, w, h);
	}

	/**
	 * Load the rectangle.
	 */
	public abstract void load();

	/**
	 * Pack the color into the buffer.
	 * @param color The new color of the rectangle (as defined by android.graphics.Color).
	 */
	public abstract void setColor(final int color);

	/**
	 * Pack the color into the buffer.
	 * @param red The red component of the color (0.0f - 1.0f).
	 * @param green The green component of the color (0.0f - 1.0f).
	 * @param blue The blue component of the color (0.0f - 1.0f).
	 * @param alpha The alpha component of the color (0.0f - 1.0f).
	 */
	public abstract void setColor(final float red, final float green, final float blue, final float alpha);

	/**
	 * Transition to a new color over a set time.
	 * @param color The new color of the (as defined by android.graphics.Color).
	 * @param duration The time it takes to transition to the new color (milliseconds).
	 */
	public abstract void setColor(final int color, final long duration);
}
