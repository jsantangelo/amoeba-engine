package org.amoeba.entity.sprite;

import org.amoeba.entity.EntityVertexBufferObject;
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
	 * @param vbo The vertex buffer object for the sprite.
	 */
	public Sprite(final float x, final float y, final EntityVertexBufferObject vbo)
	{
		super(x, y, 0f, 0f, vbo);
	}
}
