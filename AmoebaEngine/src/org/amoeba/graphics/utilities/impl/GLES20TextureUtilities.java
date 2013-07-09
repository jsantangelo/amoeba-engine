package org.amoeba.graphics.utilities.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions;
import org.amoeba.graphics.texture.TextureOptions.Preset;
import org.amoeba.graphics.texture.impl.BaseTexture;
import org.amoeba.graphics.utilities.TextureUtilities;

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

	@Override
	public boolean isTextureLoaded(final int handle)
	{
		return GLES20.glIsTexture(handle);
	}

	@Override
	public int generateTextureHandle()
	{
		GLES20.glGenTextures(1, glIntStorage, 0);
		if (glIntStorage[0] == 0)
		{
			throw new RuntimeException("Unable to generate a new texture id.");
		}

		return glIntStorage[0];
	}

	@Override
	public Texture loadTextureFromResource(final int resource, final TextureOptions options, final int handle)
	{
		Texture texture = null;

		int textureHandle = handle;
		if (textureHandle == -1)
		{
			textureHandle = generateTextureHandle();
		}

		if (textureHandle != -1)
		{
			BitmapFactory.Options opts = new BitmapFactory.Options();
			opts.inScaled = false;

			Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), resource, opts);

			GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureHandle);
			applyTextureOptions(options);
			GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bmp, 0);

			texture = new BaseTexture(this, options, textureHandle, bmp.getWidth(), bmp.getHeight());

			bmp.recycle();
		}

		return texture;
	}

	@Override
	public void createTextTexture(final Texture texture, final String text)
	{
		int textureHandle = texture.getHandle();
		if (textureHandle == -1)
		{
			textureHandle = generateTextureHandle();
		}

		/*
		if (textureHandle != -1)
		{
			Paint textPaint = new Paint();
			textPaint.setTextSize(textSize);
			textPaint.setAntiAlias(true);
			textPaint.setColor(textColor);
			textPaint.setTextAlign(Align.CENTER);

			if (textFont != null)
			{
				textPaint.setTypeface(textFont);
			}

			// Measure the text size
			int ascent = (int) FloatMath.ceil(-textPaint.ascent());
			int descent = (int) FloatMath.ceil(textPaint.descent());
			int measuredTextHeight = ascent + descent;
			int measuredTextWidth = (int) FloatMath.ceil(textPaint.measureText(text));

			int width = nextPowerTwo(measuredTextWidth);
			int height = nextPowerTwo(measuredTextHeight);
			width = Math.max(width, 2);
			height = Math.max(height, 2);

			Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(bitmap);
			bitmap.eraseColor(0);

			// draw the text centered
			int textXPosition = (width / 2);
			int textYPosition = (height / 2) + (measuredTextHeight / 4);
			canvas.drawText(text, textXPosition, textYPosition, textPaint);

			GLES20.glBindTexture(GL10.GL_TEXTURE_2D, textureHandle);
			applyTextureOptions(DEFAULT_OPTIONS);
			GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
			bitmap.recycle();

			setText(text);
			texture.setHandle(textureHandle);
			texture.setWidth(width);
			texture.setHeight(height);
		}
		*/
	}

	@Override
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

	@Override
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

	@Override
	public void applyTextureOptions(final TextureOptions options)
	{
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, options.getMinFilter());
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, options.getMagFilter());
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, options.getWrapS());
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, options.getWrapT());
	}
}
