package com.pixelweaverstudios.amoeba.graphics.texture;

import com.pixelweaverstudios.amoeba.graphics.utilities.TextureUtilities;

public class BitmapTexture implements Texture
{
	private TextureUtilities utilities;
	private int handle, drawableId;
	private int width, height;

	/**
	 * @param utilities
	 * @param options
	 * @param drawableId
	 */
	public BitmapTexture(TextureUtilities utilities, int drawableId)
	{
		this.utilities = utilities;
		this.drawableId = drawableId;

		handle = -1;
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
		utilities.loadTextureFromResource(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.Texture#unload()
	 */
	public void unload()
	{
		utilities.unloadTexture(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.Texture#isLoaded()
	 */
	public boolean isLoaded()
	{
		return utilities.isTextureLoaded(getHandle());
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
