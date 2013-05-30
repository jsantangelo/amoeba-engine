 package org.amoeba.entity.sprite;

 import android.graphics.Typeface;

/**
 * TextSprite is an entity that is used to display text.
 */
public abstract class TextSprite extends Sprite
{
	/**
	 * Constructor for TextSprite.
	 * @param text The text to display.
	 */
	public TextSprite(final String text)
	{
		super(0f, 0f);
	}

	/**
	 * Set the text string.
	 * @param text The string to be displayed.
	 */
	public abstract void setText(String text);

	/**
	 * Set the size of the font.
	 * @param size The size of the font.
	 */
	public abstract void setTextSize(int size);

	/**
	 * Set the font.
	 * @param font The font to use for the text.
	 */
	public abstract void setFont(Typeface font);
}
