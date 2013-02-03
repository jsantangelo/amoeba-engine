package com.pixelweaverstudios.amoeba.graphics.utilities;

import android.opengl.GLES20;

/**
 * @author Mike Testen
 *
 */
public class TextureUtilities
{
    /**
     * @param handle
     * @return Whether the texture is loaded.
     */
    static public boolean isTextureLoaded(int handle)
    {
        return GLES20.glIsTexture(handle); 
    }
    
    /**
     * @return A new handle to be used in the binding of a texture.
     */
    static public int generateTextureHandle()
    {
        int[] temp = new int[1];

        GLES20.glGenTextures(1, temp, 0);
        if(temp[0] == 0)
        {
            throw new RuntimeException("Unable to generate a new texture id.");
        }

        return temp[0];
    }
}
