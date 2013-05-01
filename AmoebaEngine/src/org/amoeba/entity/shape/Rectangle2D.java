package org.amoeba.entity.shape;

import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.graphics.shape.Rectangle;

/**
 * Rectangle2D is Rectangle that can be drawn.
 */
public abstract class Rectangle2D extends Rectangle implements DrawListener, UpdateListener
{
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
