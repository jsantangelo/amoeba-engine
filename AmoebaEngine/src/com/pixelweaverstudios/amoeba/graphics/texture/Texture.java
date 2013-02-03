package com.pixelweaverstudios.amoeba.graphics.texture;

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

		setWidth(0);
		setHeight(0);
	}

	/**
	 * @param drawable
	 */
	public Texture(int drawable)
	{
	    handle = -1;
		drawableId = drawable;
	}

	/* (non-Javadoc)
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#setWidth(int)
	 */
	public void setWidth(int width)
    {
        this.width = 0;
        if(width >= 0)
        {
            this.width = width;
        }
    }

    /* (non-Javadoc)
     * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#setHeight(int)
     */
    public void setHeight(int height)
    {
        this.height = 0;
        if(height >= 0)
        {
            this.height = height;
        }
    }
    
    /* (non-Javadoc)
     * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#setHandle(int)
     */
    public void setHandle(int handle)
    {
        this.handle = handle;
    }
    
    /* (non-Javadoc)
     * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#setDrawable(int)
     */
    public void setDrawable(int drawable)
    {
        this.drawableId = drawable;
    }
	
	/* (non-Javadoc)
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#getWidth()
	 */
	public int getWidth()
	{
		return width;
	}

	/* (non-Javadoc)
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#getHeight()
	 */
	public int getHeight()
	{
		return height;
	}

	/* (non-Javadoc)
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#getHandle()
	 */
	public int getHandle()
	{
		return handle;
	}

	/* (non-Javadoc)
	 * @see com.pixelweaverstudios.amoeba.graphics.texture.ITexture#getDrawable()
	 */
	public int getDrawable()
	{
		return drawableId;
	}
}
