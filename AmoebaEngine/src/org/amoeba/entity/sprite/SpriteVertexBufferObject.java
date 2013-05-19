package org.amoeba.entity.sprite;

import org.amoeba.graphics.vbo.VertexBufferObject;

/**
 * SpriteVertexBufferObject provides a VBO that is used for sprites.
 */
public interface SpriteVertexBufferObject extends VertexBufferObject
{
	/**
	 * Load the VBO.
	 */
	public void load();

	/**
	 * Pack the color into the sprite buffer.
	 * @param color The new color of the sprite.
	 */
	public void setColor(final int color);

	/**
	 * Pack the color into the sprite buffer.
	 * @param red The red component of the color.
	 * @param green The green component of the color.
	 * @param blue The blue component of the color.
	 * @param alpha The alpha component of the color.
	 */
	public void setColor(final float red, final float green, final float blue, final float alpha);

	/**
	 * Get the current color in the buffer.
	 * @return The color currently stored in the buffer in the form of android.graphics.Color.
	 */
	public int getColor();
}
