package com.pixelweaverstudios.amoeba.graphics.utilities;

import com.pixelweaverstudios.amoeba.graphics.texture.ITexture;

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
	public void loadTextureFromResource(ITexture texture);

	/**
	 * @param texture
	 */
	public void unloadTexture(ITexture texture);
}
