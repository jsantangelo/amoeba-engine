package org.amoeba.graphics.utilities;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions;
import org.amoeba.graphics.texture.TextureOptions.Preset;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;


/**
 * GLES20TextureUtilities provide an implementation of TextureUtilities using GLES20.
 */
public class GLES20TextureUtilities implements TextureUtilities
{
	private static final int NUM_BYTES_IN_INT = 4;
	private static final TextureOptions CLAMP_NEAREST_OPTIONS = new TextureOptions(GLES20.GL_NEAREST, GLES20.GL_NEAREST, GLES20.GL_CLAMP_TO_EDGE, GLES20.GL_CLAMP_TO_EDGE);
	private static final TextureOptions CLAMP_LINEAR_OPTIONS = new TextureOptions(GLES20.GL_LINEAR, GLES20.GL_LINEAR, GLES20.GL_CLAMP_TO_EDGE, GLES20.GL_CLAMP_TO_EDGE);
	private static final TextureOptions DEFAULT_OPTIONS = CLAMP_LINEAR_OPTIONS;


	private final Context context;
	private final int[] glIntStorage;

	/**
	 * Constructor for GLES20TextureUtilities.
	 * @param activityContext The activity's context.
	 */
	public GLES20TextureUtilities(final Context activityContext)
	{
		context = activityContext;
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
			applyTextureOptions(DEFAULT_OPTIONS);
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

			ByteBuffer bb = ByteBuffer.allocateDirect(NUM_BYTES_IN_INT);
			bb.order(ByteOrder.nativeOrder());
			texBuffer = bb.asIntBuffer();
			texBuffer.put(glIntStorage);
			texBuffer.position(0);

			GLES20.glDeleteTextures(1, texBuffer);
		}
	}

	/**
	 * Get a preset TextureOptions.
	 * @param preset The requested type of texture options.
	 * @return The requested texture options.
	 */
	public TextureOptions getTextureOptionsPreset(final Preset preset)
	{
		TextureOptions options = null;
		switch(preset)
		{
			case CLAMP_NEAREST:
				options = CLAMP_NEAREST_OPTIONS;
				break;
			case CLAMP_LINEAR:
				options = CLAMP_NEAREST_OPTIONS;
				break;
			default:
				options = DEFAULT_OPTIONS;
		}

		return options;
	}

	/**
	 * Apply OpenGL texture options.
	 * @param options The options to be applied.
	 */
	public void applyTextureOptions(final TextureOptions options)
	{
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, options.getMinFilter());
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, options.getMagFilter());
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, options.getWrapS());
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, options.getWrapT());
	}
}
