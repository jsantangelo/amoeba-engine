package com.pixelweaverstudios.amoeba.graphics.utilities;

import com.pixelweaverstudios.amoeba.graphics.texture.Texture;

public interface ITextureUtilities
{
	/**
	 * @param handle
	 * @return Whether the texture is loaded.
	 */
	public boolean isTextureLoaded(int handle);

	/**
	 * @return A new handle to be used in the binding of a texture.
	 */
	public int generateTextureHandle();

	/**
	 * @param context
	 * @param texture
	 */
	public void loadTextureFromResource(Texture texture);

	/**
	 * @param texture
	 */
	public void unloadTexture(Texture texture);
}
