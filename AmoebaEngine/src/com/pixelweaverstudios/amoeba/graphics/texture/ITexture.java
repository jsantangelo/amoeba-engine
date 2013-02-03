package com.pixelweaverstudios.amoeba.graphics.texture;

/**
 * @author Mike Testen
 * 
 */
public interface ITexture
{
    /**
     * @param width
     */
    public void setWidth(int width);

    /**
     * @param height
     */
    public void setHeight(int height);

    /**
     * @param handle
     */
    public void setHandle(int handle);

    /**
     * @param drawable
     */
    public void setDrawable(int drawable);

    /**
     * @return The width of the texture.
     */
    public int getWidth();

    /**
     * @return The height of the texture.
     */
    public int getHeight();

    /**
     * @return The handle that represents the texture.
     */
    public int getHandle();

    /**
     * @return The drawable id number that was used to generate the texture.
     */
    public int getDrawable();
}
