package org.amoeba.graphics.texture.impl;

import org.amoeba.graphics.texture.TextOptions;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions;
import org.amoeba.graphics.utilities.TextureUtilities;

/**
 * TextTexture provides a texture with text.
 */
public class TextTexture extends BaseTexture
{
	private String text;
	private TextOptions displayedTextOptions;

	/**
	 * The constructor for TextTexture.
	 * @param textureUtilities The utilities used to perform OpenGL functionality.
	 * @param textureOptions The options used to load the texture.
	 * @param textOptions The options used to display the text.
	 * @param displayedText The text to be displayed on the texture.
	 */
	public TextTexture(final TextureUtilities textureUtilities, final TextureOptions textureOptions, final TextOptions textOptions, final String displayedText)
	{
		super(textureUtilities, textureOptions, -1, 0, 0);
		setText(displayedText);
		displayedTextOptions = textOptions;
	}

	@Override
	public void load()
	{
		Texture result = getUtilities().loadTextTexture(text, getOptions(), displayedTextOptions, getHandle());
		if (result != null)
		{
			setHandle(result.getHandle());
			setWidth(result.getWidth());
			setHeight(result.getHeight());
		}
	}

	@Override
	public void unload()
	{
		getUtilities().unloadTexture(this);
		setHandle(-1);
		setWidth(0);
		setHeight(0);
	}

	/**
	 * Get the text of the texture.
	 * @return The text on this texture.
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * Set the text on the texture.
	 * @param displayedText The text to display on the texture.
	 */
	public void setText(final String displayedText)
	{
		text = displayedText;
	}
}
