package com.pixelweaverstudios.amoeba.graphics.texture;

public class Texture
{
	private Integer handle, drawableId;
	private float width, height;

	public Texture() 
	{
	    handle = null;
		drawableId = null;
		
		setWidth(1.0f);
		setHeight(1.0f);
	}
	
	public Texture(Integer drawable)
	{		
	    handle = null;
		drawableId = drawable;
	}
	
	public Texture(Integer drawable, Integer tex)
	{		
	    handle = tex;
		drawableId = drawable;
	}
	
	public void setTexture(Integer texID)
	{
	    handle = texID;
	}

	public void setDrawable(Integer drawable)
	{
		drawableId = drawable;
	}

	public void setWidth(float w)
	{
		if(w > 0.0f)
			width = w;
		else
			width = 1.0f;
	}

	public void setHeight(float h)
	{
		if(h > 0.0f)
			height = h;
		else
			height = 1.0f;
	}

	public Integer getHandle()
	{
		return handle;
	}

	public Integer getDrawableID()
	{
		return drawableId;
	}

	public float getWidth()
	{
		return width;
	}

	public float getHeight()
	{
		return height;
	}
}
