package com.pixelweaverstudios.amoeba.graphics.utilities;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

import com.pixelweaverstudios.amoeba.graphics.texture.Texture;
import com.pixelweaverstudios.amoeba.graphics.texture.TextureOptions;

/**
 * GLES20TextureUtilities provide an implementation of TextureUtilities using GLES20.
 */
public class GLES20TextureUtilities implements TextureUtilities
{
	private final Context context;
	private final int[] glIntStorage;

	/**
	 * Constructor for GLES20TextureUtilities.
	 * @param context The activity's context.
	 */
	public GLES20TextureUtilities(final Context context)
	{
		this.context = context;
		glIntStorage = new int[1];
	}

	/**
	 * Determine whether a texture with a given handle is loaded into OpenGL.
	 * @param handle The OpenGL handle of the texture to check.
	 * @return Whether the texture is loaded.
	 */
	public boolean isTextureLoaded(final int handle)
	{
		return GLES20.glIsTexture(handle);
	}

	/**
	 * Generate an OpenGL handle to be used for a texture.
	 * @return A new handle to be used in the binding of a texture.
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

	/**
	 * Load a texture from a resource into OpenGL.
	 * @param texture The texture to be loaded.
	 */
	public void loadTextureFromResource(final Texture texture)
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

	/**
	 * Unload a texture from OpenGL.
	 * @param texture The texture to be unloaded.
	 */
	public void unloadTexture(final Texture texture)
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

	/**
	 * Apply OpenGL texture options.
	 * @param options The options to be applied.
	 */
	public void applyTextureOptions(final TextureOptions options)
	{
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, options.minFilter);
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, options.magFilter);
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, options.wrapS);
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, options.wrapT);
	}
}
