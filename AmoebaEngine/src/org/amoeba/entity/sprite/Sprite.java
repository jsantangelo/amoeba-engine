package org.amoeba.entity.sprite;

import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.entity.Entity;
import org.amoeba.entity.shape.Rectangle;

/**
 * Sprite is an entity that is used to display an image.
 */
public interface Sprite extends Entity, UpdateListener, DrawListener
{
	/**
	 * Load the sprite.
	 */
	public void load();

	/**
	 * Get the width of the Rectangle.
	 * @return The width of the rectangle.
	 */
	public float getWidth();

	/**
	 * Get the height of the rectangle.
	 * @return The height of the rectangle.
	 */
	public float getHeight();

	/**
	 * Get a rectangle representing the shape of the sprite.
	 * @return A rectangle representing the shape of the sprite.
	 */
	public Rectangle getHitbox();

	/**
	 * Set the width of the rectangle.
	 * @param w The new width of the rectangle.
	 */
	public void setWidth(final float w);

	/**
	 * Set the height of the rectangle.
	 * @param h The new height of the rectangle.
	 */
	public void setHeight(final float h);

	/**
	 * Pack the color into the sprite buffer.
	 * @param color The new color of the sprite (as defined by android.graphics.Color).
	 */
	public void setColor(final int color);

	/**
	 * Pack the color into the sprite buffer.
	 * @param red The red component of the color (0.0f - 1.0f).
	 * @param green The green component of the color (0.0f - 1.0f).
	 * @param blue The blue component of the color (0.0f - 1.0f).
	 * @param alpha The alpha component of the color (0.0f - 1.0f).
	 */
	public void setColor(final float red, final float green, final float blue, final float alpha);

	/**
	 * Transition to a new color over a set time.
	 * @param color The new color of the sprite (as defined by android.graphics.Color).
	 * @param duration The time it takes to transition to the new color (milliseconds).
	 */
	public void setColor(final int color, final long duration);
}
