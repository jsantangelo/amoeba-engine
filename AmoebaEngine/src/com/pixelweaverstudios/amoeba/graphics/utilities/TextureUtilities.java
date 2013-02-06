package com.pixelweaverstudios.amoeba.graphics.utilities;

import com.pixelweaverstudios.amoeba.graphics.texture.ITexture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

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
	public static boolean isTextureLoaded(int handle)
	{
		return GLES20.glIsTexture(handle);
	}

	/**
	 * @return A new handle to be used in the binding of a texture.
	 */
	public static int generateTextureHandle()
	{
		int[] temp = new int[1];

		GLES20.glGenTextures(1, temp, 0);
		if(temp[0] == 0)
		{
			throw new RuntimeException("Unable to generate a new texture id.");
		}

		return temp[0];
	}

	public static void loadTextureFromResource(Context context, ITexture texture)
	{
		int textureHandle = texture.getHandle();
		if(textureHandle == -1)
		{
		    textureHandle = generateTextureHandle();
		}

		if(textureHandle != -1)
		{
			BitmapFactory.Options opts = new BitmapFactory.Options();
			opts.inScaled = false;

			Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), texture.getDrawable(), opts);

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
	}
}
