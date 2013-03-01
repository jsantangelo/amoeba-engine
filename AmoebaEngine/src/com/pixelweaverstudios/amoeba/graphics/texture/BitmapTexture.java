package com.pixelweaverstudios.amoeba.graphics.texture;

import com.pixelweaverstudios.amoeba.graphics.utilities.TextureUtilities;

public class BitmapTexture implements Texture
{
	private TextureUtilities textureUtilities;
	private int handle, drawableId;
	private int width, height;

	/**
	 *
	 */
	public BitmapTexture(TextureUtilities textureUtilities)
	{
		this.textureUtilities = textureUtilities;
		handle = -1;
		drawableId = -1;
		width = 0;
		height = 0;
	}

	/**
	 * @param drawable
	 */
	public BitmapTexture(int drawable)
	{
		handle = -1;
		drawableId = drawable;
		width = 0;
		height = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.Texture#load()
	 */
	public void load()
	{
		textureUtilities.loadTextureFromResource(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.Texture#unload()
	 */
	public void unload()
	{
		textureUtilities.unloadTexture(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.Texture#isLoaded()
	 */
	public boolean isLoaded()
	{
		return textureUtilities.isTextureLoaded(getHandle());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.Texture#setWidth(int)
	 */
	public void setWidth(final int width)
	{
		this.width = 0;
		if (width >= 0)
		{
			this.width = width;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pixelweaverstudios.amoeba.graphics.texture.Texture#setHeight(int)
	 */
	public void setHeight(final int height)
	{
		this.height = 0;
		if (height >= 0)
		{
			this.height = height;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pixelweaverstudios.amoeba.graphics.texture.Texture#setHandle(int)
	 */
	public void setHandle(final int handle)
	{
		this.handle = handle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.Texture#setID(int)
	 */
	public void setID(final int id)
	{
		this.drawableId = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.Texture#getWidth()
	 */
	public int getWidth()
	{
		return width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.Texture#getHeight()
	 */
	public int getHeight()
	{
		return height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.Texture#getHandle()
	 */
	public int getHandle()
	{
		return handle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.Texture#getID()
	 */
	public int getID()
	{
		return drawableId;
	}
}
