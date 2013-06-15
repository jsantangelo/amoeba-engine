package org.amoeba.graphics.texture.impl;

import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions;
import org.amoeba.graphics.utilities.TextureUtilities;

/**
 * TextTexture provides a texture with text.
 */
public class TextTexture implements Texture
{
	private final TextureUtilities utilities;
	private TextureOptions options;
	private int handle;
	private int width, height;
	private String text;

	/**
	 * The constructor for TextTexture.
	 * @param textureUtilities The utilities used to perform OpenGL functionality.
	 * @param textureOptions The options used to load the texture.
	 * @param displayedText The text to be displayed on the texture.
	 */
	public TextTexture(final TextureUtilities textureUtilities, final TextureOptions textureOptions, final String displayedText)
	{
		utilities = textureUtilities;
		options = textureOptions;
		setText(displayedText);

		handle = -1;
		width = 0;
		height = 0;
	}

	@Override
	public void load()
	{
		utilities.loadTextureFromResource(this);
	}

	@Override
	public void unload()
	{
		utilities.unloadTexture(this);
	}

	@Override
	public boolean isLoaded()
	{
		return utilities.isTextureLoaded(getHandle());
	}

	@Override
	public void setWidth(final int textureWidth)
	{
		this.width = 0;
		if (width >= 0)
		{
			width = textureWidth;
		}
	}

	@Override
	public void setHeight(final int textureHeight)
	{
		this.height = 0;
		if (height >= 0)
		{
			height = textureHeight;
		}
	}

	@Override
	public void setHandle(final int textureHandle)
	{
		handle = textureHandle;
	}

	@Override
	public void setID(final int id)
	{

	}

	@Override
	public void setOptions(final TextureOptions textureOptions)
	{
		options = textureOptions;
	}

	@Override
	public int getWidth()
	{
		return width;
	}

	@Override
	public int getHeight()
	{
		return height;
	}

	@Override
	public int getHandle()
	{
		return handle;
	}

	@Override
	public int getID()
	{
		return -1;
	}

	@Override
	public TextureOptions getOptions()
	{
		return options;
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
