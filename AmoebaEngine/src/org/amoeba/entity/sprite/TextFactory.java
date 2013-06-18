package org.amoeba.entity.sprite;

import org.amoeba.geom.Point;

/**
 * TextFactory provides various ways to create text sprites.
 */
public interface TextFactory
{
	/**
	 * Create a sprite that displays text.
	 * @param text The text to display.
	 * @return A TextSprite containing the text specified.
	 */
	public TextSprite createTextSprite(final String text);

	/**
	 * Create a sprite that displays text.
	 * @param text The text to display.
	 * @param position The location of the text sprite (center).
	 * @return A TextSprite containing the text specified.
	 */
	public TextSprite createTextSprite(final String text, final Point position);

	/**
	 * Create a sprite that displays text.
	 * @param text The text to display.
	 * @param x The x location of the text sprite.
	 * @param y The y location of the text sprite.
	 * @return A TextSprite containing the text specified.
	 */
	public TextSprite createTextSprite(final String text, final float x, final float y);
}
