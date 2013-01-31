package com.pixelweaverstudios.amoeba.graphics.texture;

/**
 * @author Mike Testen
 *
 */
public interface ITexture
{
    /**
     * Load the texture to hardware.
     * @return Whether the operation was successful.
     */
    public boolean load();

    /**
     * Unload the texture from hardware.
     * @return Whether the operation was successful.
     */
    public boolean unload();

    /**
     * @return Whether the texture is loaded into hardware.
     */
    public boolean isLoaded();
    
    /**
     * @return The width of the texture.
     */
    public int getWidth();

    /**
     * @return The height of the texture.
     */
    public int getHeight();
    
    /**
     * @return The handle that represents the texture on the hardware.
     */
    public int getHandle();
    
    /**
     * @return The drawable id number that was used to generate the texture.
     */
    public int getDrawable();
}
