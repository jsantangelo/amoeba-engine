package com.pixelweaverstudios.amoeba.graphics.utilities;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import com.pixelweaverstudios.amoeba.graphics.texture.Texture;
import com.pixelweaverstudios.amoeba.graphics.texture.TextureOptions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

public class GLES20TextureUtilities implements TextureUtilities
{
	private Context context;
	private int[] glIntStorage;

	/**
	 * @param context
	 */
	public GLES20TextureUtilities(Context context)
	{
		this.context = context;
		glIntStorage = new int[1];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.utilities.ITextureUtilities#
	 * isTextureLoaded(int)
	 */
	public boolean isTextureLoaded(int handle)
	{
		return GLES20.glIsTexture(handle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.utilities.ITextureUtilities#
	 * generateTextureHandle()
	 */
	public int generateTextureHandle()
	{
		GLES20.glGenTextures(1, glIntStorage, 0);
		if (glIntStorage[0] == 0)
		{
			throw new RuntimeException("Unable to generate a new texture id.");
		}

		return glIntStorage[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.utilities.ITextureUtilities#
	 * loadTextureFromResource
	 * (com.pixelweaverstudios.amoeba.graphics.texture.ITexture)
	 */
	public void loadTextureFromResource(Texture texture)
	{
		int textureHandle = texture.getHandle();
		if (textureHandle == -1)
		{
			textureHandle = generateTextureHandle();
		}

		if (textureHandle != -1)
		{
			BitmapFactory.Options opts = new BitmapFactory.Options();
			opts.inScaled = false;

			Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), texture.getID(), opts);

			GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureHandle);
			applyTextureOptions(TextureOptions.DEFAULT);
			GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bmp, 0);

			texture.setWidth(bmp.getWidth());
			texture.setHeight(bmp.getHeight());
			texture.setHandle(textureHandle);

			bmp.recycle();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.utilities.ITextureUtilities#
	 * unloadTexture(com.pixelweaverstudios.amoeba.graphics.texture.ITexture)
	 */
	public void unloadTexture(Texture texture)
	{
		int textureHandle = texture.getHandle();
		if (textureHandle != -1)
		{
			IntBuffer texBuffer;
			glIntStorage[0] = textureHandle;

			ByteBuffer bb = ByteBuffer.allocateDirect(4);
			bb.order(ByteOrder.nativeOrder());
			texBuffer = bb.asIntBuffer();
			texBuffer.put(glIntStorage);
			texBuffer.position(0);

			GLES20.glDeleteTextures(1, texBuffer);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.utilities.ITextureUtilities#
	 * applyTextureOptions(com.pixelweaverstudios.amoeba.graphics.texture.TextureOptions)
	 */
	public void applyTextureOptions(TextureOptions options)
	{
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, options.minFilter);
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, options.magFilter);
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, options.wrapS);
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, options.wrapT);
	}
}