package org.amoeba.entity.sprite;

import org.amoeba.entity.shape.Rectangle2D;

/**
 * Sprite is an entity that is used to display an image.
 */
public abstract class Sprite extends Rectangle2D
{
	/**
	 * Constructor for Sprite.
	 * @param x The x position of the sprite (center).
	 * @param y The y position of the sprite (center).
	 */
	public Sprite(final float x, final float y)
	{
		super(x, y, 0f, 0f);
	}

	/**
	 * Load the sprite.
	 */
	public abstract void load();
}
