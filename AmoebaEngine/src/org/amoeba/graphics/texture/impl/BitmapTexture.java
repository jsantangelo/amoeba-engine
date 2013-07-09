package org.amoeba.graphics.texture.impl;

import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions;
import org.amoeba.graphics.utilities.TextureUtilities;

/**
 * BitmapTexture is a texture implementation that uses bitmaps to load the texture.
 */
public class BitmapTexture implements Texture
{
	private final TextureUtilities utilities;
	private TextureOptions options;
	private int handle;
	private int drawableID;
	private int width, height;

	/**
	 * The constructor for BitmapTexture.
	 * @param textureUtilities The utilities used to perform OpenGL functionality.
	 * @param textureOptions The options used to load the texture.
	 * @param id The id of the resource representing the texture.
	 */
	public BitmapTexture(final TextureUtilities textureUtilities, final TextureOptions textureOptions, final int id)
	{
		utilities = textureUtilities;
		options = textureOptions;
		drawableID = id;

		handle = -1;
		width = 0;
		height = 0;
	}

	@Override
	public void load()
	{
		utilities.loadTextureFromResource(this, drawableID);
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
	public TextureOptions getOptions()
	{
		return options;
	}
}
