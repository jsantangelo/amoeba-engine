 package org.amoeba.entity.sprite;

 import org.amoeba.entity.EntityVertexBufferObject;

import android.graphics.Typeface;

/**
 * TextSprite is an entity that is used to display text.
 */
public abstract class TextSprite extends Sprite
{
	/**
	 * Constructor for TextSprite.
	 * @param text The text to display.
	 * @param vbo The vertex buffer object for the rectangle.
	 */
	public TextSprite(final String text, final EntityVertexBufferObject vbo)
	{
		super(0f, 0f, vbo);
	}

	/**
	 * Set the text string.
	 * @param text The string to be displayed.
	 */
	public abstract void setText(final String text);

	/**
	 * Get the text string.
	 * @return The text string.
	 */
	public abstract String getText();

	/**
	 * Set the size of the font.
	 * @param size The size of the font.
	 */
	public abstract void setTextSize(final int size);

	/**
	 * Set the font.
	 * @param font The font to use for the text.
	 */
	public abstract void setFont(final Typeface font);
}
