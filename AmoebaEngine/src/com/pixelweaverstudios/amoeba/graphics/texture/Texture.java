package com.pixelweaverstudios.amoeba.graphics.texture;

import android.opengl.GLES20;

public class Texture implements ITexture
{
	private int handle, drawableId;
	private int width, height;

	public Texture()
	{
	    handle = -1;
		drawableId = -1;

		setWidth(0);
		setHeight(0);
	}

	public Texture(int drawable)
	{
	    handle = -1;
		drawableId = drawable;
	}

	public boolean load()
	{

	}

	public boolean unload()
	{

	}

	public boolean isLoaded()
	{
		return GLES20.glIsTexture(handle);
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public int getHandle()
	{
		return handle;
	}

	public int getDrawable()
	{
		return drawableId;
	}

	private void setWidth(int w)
	{
		width = 0;
		if(w >= 0)
		{
			width = w;
		}
	}

	private void setHeight(int h)
	{
		height = 0;
		if(h >= 0)
		{
			height = h;
		}
	}
}
