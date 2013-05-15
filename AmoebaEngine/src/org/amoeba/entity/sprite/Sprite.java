package org.amoeba.entity.sprite;

import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.entity.Entity;
import org.amoeba.entity.shape.Rectangle2D;

/**
 * Sprite is an entity that is used to display an image.
 */
public abstract class Sprite extends Rectangle2D implements Entity, DrawListener, UpdateListener
{
	/**
	 * Constructor for Sprite.
	 * @param x The x position of the sprite (left).
	 * @param y The y position of the sprite (top).
	 * @param w The width of the sprite.
	 * @param h The height of the sprite.
	 */
	public Sprite(final float x, final float y, final float w, final float h)
	{
		super(x, y, w, h);
	}

	/**
	 * Load the sprite.
	 */
	public abstract void load();

	/**
	 * Pack the color into the sprite buffer.
	 * @param color The new color of the sprite (as defined by android.graphics.Color).
	 */
	public abstract void setColor(final int color);

	/**
	 * Pack the color into the sprite buffer.
	 * @param red The red component of the color (0.0f - 1.0f).
	 * @param green The green component of the color (0.0f - 1.0f).
	 * @param blue The blue component of the color (0.0f - 1.0f).
	 * @param alpha The alpha component of the color (0.0f - 1.0f).
	 */
	public abstract void setColor(final float red, final float green, final float blue, final float alpha);

	/**
	 * Transition to a new color over a set time.
	 * @param color The new color of the sprite (as defined by android.graphics.Color).
	 * @param duration The time it takes to transition to the new color (milliseconds).
	 */
	public abstract void setColor(final int color, final long duration);
}
