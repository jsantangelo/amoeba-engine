package com.pixelweaverstudios.amoeba.graphics.texture;

import com.pixelweaverstudios.amoeba.graphics.utilities.TextureUtilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

/**
 * @author Mike Testen
 *
 */
public class TextureFactory
{
    /**
     * @param context
     * @param textureResource
     * @return A new texture that has been loaded.
     */
    static public ITexture createTexture(Context context, int textureResource) 
    {
        Texture texture = new Texture(textureResource);
        int textureHandle = TextureUtilities.generateTextureHandle();
        
        if(textureHandle != -1)
        {
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inScaled = false;
            
            Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), textureResource, opts);
            
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureHandle);
            
            GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR);
            GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);
            
            GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_CLAMP_TO_EDGE);
            GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_CLAMP_TO_EDGE);
            
            GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bmp, 0);
            
            texture.setWidth(bmp.getWidth());
            texture.setHeight(bmp.getHeight());
            texture.setHandle(textureHandle);
            
            bmp.recycle();
        }
        
        return texture;
    }
}
