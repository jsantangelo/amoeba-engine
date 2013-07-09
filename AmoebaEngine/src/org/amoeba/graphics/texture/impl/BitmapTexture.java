package org.amoeba.graphics.texture.impl;

import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions;
import org.amoeba.graphics.utilities.TextureUtilities;

/**
 * BitmapTexture is a texture implementation that uses bitmaps to load the texture.
 */
public class BitmapTexture extends BaseTexture
{
	private int drawableID;

	/**
	 * The constructor for BitmapTexture.
	 * @param textureUtilities The utilities used to perform OpenGL functionality.
	 * @param textureOptions The options used to load the texture.
	 * @param id The id of the resource representing the texture.
	 */
	public BitmapTexture(final TextureUtilities textureUtilities, final TextureOptions textureOptions, final int id)
	{
		super(textureUtilities, textureOptions, -1, 0, 0);
		drawableID = id;
	}

	@Override
	public void load()
	{
		Texture result = getUtilities().loadTextureFromResource(drawableID, getOptions(), getHandle());
		if (result != null)
		{
			setHandle(result.getHandle());
			setWidth(result.getWidth());
			setHeight(result.getHeight());
		}
	}

	@Override
	public void unload()
	{
		getUtilities().unloadTexture(this);
		setHandle(-1);
		setWidth(0);
		setHeight(0);
	}
}
