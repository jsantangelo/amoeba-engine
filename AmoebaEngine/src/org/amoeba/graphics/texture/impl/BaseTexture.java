package org.amoeba.graphics.texture.impl;

import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions;
import org.amoeba.graphics.utilities.TextureUtilities;

/**
 * BaseTexture provides a base implementation of a texture.
 * This implementation can not be used to load and unload the texture.
 */
public class BaseTexture implements Texture
{
	private final TextureUtilities utilities;
	private TextureOptions options;
	private int handle;
	private int width, height;

	/**
	 * The constructor for BaseTexture.
	 * @param textureUtilities The utilities used to perform OpenGL functionality.
	 * @param textureOptions The options used to load the texture.
	 * @param textureHandle The OpenGL handle to the texture.
	 * @param textureWidth The width of the texture.
	 * @param textureHeight the height of the texture.
	 */
	public BaseTexture(final TextureUtilities textureUtilities, final TextureOptions textureOptions, final int textureHandle, final int textureWidth, final int textureHeight)
	{
		utilities = textureUtilities;
		options = textureOptions;
		handle = textureHandle;
		width = textureWidth;
		height = textureHeight;
	}

	@Override
	public void load()
	{
		throw new RuntimeException("BaseTexture.load() should not be called.");
	}

	@Override
	public void unload()
	{
		throw new RuntimeException("BaseTexture.unload() should not be called.");
	}

	@Override
	public boolean isLoaded()
	{
		return utilities.isTextureLoaded(getHandle());
	}

	@Override
	public int getWidth()
	{
		return width;
	}

	@Override
	public int getHeight()
	{
		return height;
	}

	@Override
	public int getHandle()
	{
		return handle;
	}

	@Override
	public TextureOptions getOptions()
	{
		return options;
	}

	/**
	 * Get the texture utilities used to perform OpenGL functionality.
	 * @return The texture utilities used to perform OpenGL functionality.
	 */
	protected TextureUtilities getUtilities()
	{
		return utilities;
	}

	/**
	 * Set the width of the texture.
	 * @param textureWidth The texture's width.
	 */
	protected void setWidth(final int textureWidth)
	{
		width = textureWidth;
	}

	/**
	 * Set the height of the texture.
	 * @param textureHeight The texture's height.
	 */
	protected void setHeight(final int textureHeight)
	{
		height = textureHeight;
	}

	/**
	 * Set the handle of the texture.
	 * @param textureHandle The texture's handle.
	 */
	protected void setHandle(final int textureHandle)
	{
		handle = textureHandle;
	}
}
