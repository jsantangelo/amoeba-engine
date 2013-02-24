package com.pixelweaverstudios.amoeba.graphics.texture;

import android.opengl.GLES20;

public class TextureOptions
{
	public static final TextureOptions CLAMP_NEAREST = new TextureOptions(GLES20.GL_NEAREST, GLES20.GL_NEAREST, GLES20.GL_CLAMP_TO_EDGE, GLES20.GL_CLAMP_TO_EDGE);
	public static final TextureOptions CLAMP_LINEAR = new TextureOptions(GLES20.GL_LINEAR, GLES20.GL_LINEAR, GLES20.GL_CLAMP_TO_EDGE, GLES20.GL_CLAMP_TO_EDGE);
	public static final TextureOptions DEFAULT = CLAMP_LINEAR;

	public final int minFilter;
	public final int magFilter;
	public final float wrapS;
	public final float wrapT;
	
	public TextureOptions(final int minFilter, final int magFilter, final int wrapS, final int wrapT)
	{
		this.minFilter = minFilter;
		this.magFilter = magFilter;
		this.wrapS = wrapS;
		this.wrapT = wrapT;
	}
}
