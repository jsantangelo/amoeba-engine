 package org.amoeba.entity.sprite;

 import org.amoeba.entity.EntityVertexBufferObject;

/**
 * TextSprite is an entity that is used to display text.
 */
public abstract class TextSprite extends Sprite
{
	private String displayedText;

	/**
	 * Constructor for TextSprite.
	 * @param text The text to display.
	 * @param x The x position of the sprite (center).
	 * @param y The y position of the sprite (center).
	 * @param vbo The vertex buffer object for the rectangle.
	 */
	public TextSprite(final String text, final float x, final float y, final EntityVertexBufferObject vbo)
	{
		super(x, y, vbo);
		setText(text);
	}

	/**
	 * Set the text string.
	 * @param text The string to be displayed.
	 */
	public void setText(final String text)
	{
		displayedText = text;
	}

	/**
	 * Get the text string.
	 * @return The text string.
	 */
	public String getText()
	{
		return displayedText;
	}

	/**
	 * Set the size of the text.
	 * @param textSize The new text size.
	 */
	public abstract void setTextSize(final int textSize);

	/**
	 * Get the size of the text.
	 * @return The text size.
	 */
	public abstract int getTextSize();

	/**
	 * Set the color of the text.
	 * @param textColor The new text color.
	 */
	public abstract void setTextColor(final int textColor);

	/**
	 * Get the color of the text.
	 * @return The text color.
	 */
	public abstract int getTextColor();
}
