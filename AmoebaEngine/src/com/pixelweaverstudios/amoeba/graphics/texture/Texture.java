package com.pixelweaverstudios.amoeba.graphics.texture;

import android.content.Context;

import com.pixelweaverstudios.amoeba.graphics.utilities.TextureUtilities;

/**
 * @author Mike Testen
 * 
 */
public class Texture implements ITexture
{
	private int handle, drawableId;
	private int width, height;

	/**
	 *
	 */
	public Texture()
	{
		handle = -1;
		drawableId = -1;
		width = 0;
		height = 0;
	}

	/**
	 * @param drawable
	 */
	public Texture(int drawable)
	{
		handle = -1;
		drawableId = drawable;
		width = 0;
		height = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#setWidth(int)
	 */
	public void load(Context context)
	{
		TextureUtilities.loadTextureFromResource(context, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#setWidth(int)
	 */
	public void unload()
	{
		TextureUtilities.unloadTexture(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#setWidth(int)
	 */
	public boolean isLoaded()
	{
		return TextureUtilities.isTextureLoaded(getHandle());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#setWidth(int)
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
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#setHeight(int)
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
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#setHandle(int)
	 */
	public void setHandle(final int handle)
	{
		this.handle = handle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#setDrawable(int)
	 */
	public void setDrawable(final int drawable)
	{
		this.drawableId = drawable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#getWidth()
	 */
	public int getWidth()
	{
		return width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#getHeight()
	 */
	public int getHeight()
	{
		return height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#getHandle()
	 */
	public int getHandle()
	{
		return handle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#getDrawable()
	 */
	public int getDrawable()
	{
		return drawableId;
	}
}
