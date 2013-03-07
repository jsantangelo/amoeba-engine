package org.amoeba.graphics.texture;

import org.amoeba.graphics.utilities.TextureUtilities;

/**
 * BitmapTexture is a texture implementation that uses bitmaps to load the texture.
 */
public class BitmapTexture implements Texture
{
	private final TextureUtilities utilities;
	private int handle;
	private int drawableID;
	private int width, height;

	/**
	 * The constructor for BitmapTexture.
	 * @param textureUtilities The utilities used to perform OpenGL functionality.
	 * @param id The id of the resource representing the texture.
	 */
	public BitmapTexture(final TextureUtilities textureUtilities, final int id)
	{
		this.utilities = textureUtilities;
		drawableID = id;

		handle = -1;
		width = 0;
		height = 0;
	}

	/**
	 * Load the texture into OpenGL.
	 */
	public void load()
	{
		utilities.loadTextureFromResource(this);
	}

	/**
	 * Unload the texture from OpenGL.
	 */
	public void unload()
	{
		utilities.unloadTexture(this);
	}

	/**
	 * Determine whether the texture is currently loaded.
	 * @return Whether the texture is loaded.
	 */
	public boolean isLoaded()
	{
		return utilities.isTextureLoaded(getHandle());
	}

	/**
	 * Set the width of the texture.
	 * @param textureWidth The new width of the texture.
	 */
	public void setWidth(final int textureWidth)
	{
		this.width = 0;
		if (width >= 0)
		{
			width = textureWidth;
		}
	}

	/**
	 * Set the height of the texture.
	 * @param textureHeight The new height of the texture.
	 */
	public void setHeight(final int textureHeight)
	{
		this.height = 0;
		if (height >= 0)
		{
			height = textureHeight;
		}
	}

	/**
	 * Set the OpenGL handle of the texture.
	 * @param textureHandle The new handle of the texture.
	 */
	public void setHandle(final int textureHandle)
	{
		handle = textureHandle;
	}

	/**
	 * Set the id of the texture.
	 * @param id The new id of the texture.
	 */
	public void setID(final int id)
	{
		drawableID = id;
	}

	/**
	 * Get the width of the texture.
	 * @return The width of the texture.
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * Get the height of the texture.
	 * @return The height of the texture.
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * Get the OpenGL handle of the texture.
	 * @return The handle that represents the texture.
	 */
	public int getHandle()
	{
		return handle;
	}

	/**
	 * Get the ID of the texture.
	 * @return The id number that was used to generate the texture.
	 */
	public int getID()
	{
		return drawableID;
	}
}
