package org.amoeba.entity.sprite;

import org.amoeba.geom.Point;
import org.amoeba.graphics.texture.TextOptions;

/**
 * TextFactory provides various ways to create text sprites.
 */
public interface TextFactory
{
	/**
	 * Set the default text options so it is not necessary to
	 * pass them in every time.
	 * @param options The default text options.
	 */
	public void setDefaultTextOptions(final TextOptions options);

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

	/**
	 * Create a sprite that displays text.
	 * @param text The text to display.
	 * @param textOptions Options used to display the text.
	 * @return A TextSprite containing the text specified.
	 */
	public TextSprite createTextSprite(final String text, final TextOptions textOptions);

	/**
	 * Create a sprite that displays text.
	 * @param text The text to display.
	 * @param textOptions Options used to display the text.
	 * @param position The location of the text sprite (center).
	 * @return A TextSprite containing the text specified.
	 */
	public TextSprite createTextSprite(final String text, final TextOptions textOptions, final Point position);

	/**
	 * Create a sprite that displays text.
	 * @param text The text to display.
	 * @param textOptions Options used to display the text.
	 * @param x The x location of the text sprite.
	 * @param y The y location of the text sprite.
	 * @return A TextSprite containing the text specified.
	 */
	public TextSprite createTextSprite(final String text, final TextOptions textOptions, final float x, final float y);
}
