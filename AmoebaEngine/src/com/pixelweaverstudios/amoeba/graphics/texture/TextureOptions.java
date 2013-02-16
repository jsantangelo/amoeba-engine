package com.pixelweaverstudios.amoeba.graphics.texture;

import android.opengl.GLES20;

public class TextureOptions implements ITextureOptions
{
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
	
	public void apply()
	{
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, this.minFilter);
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, this.magFilter);
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, this.wrapS);
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, this.wrapT);
	}
}
