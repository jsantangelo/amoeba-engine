package org.amoeba.graphics.utilities;

import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions;

/**
 * TextureUtilities provides a wrapper around common texture related OpenGL functions.
 */
public interface TextureUtilities
{
	/**
	 * Determine whether a texture with a given handle is loaded into OpenGL.
	 * @param handle The OpenGL handle of the texture to check.
	 * @return Whether the texture is loaded.
	 */
	public boolean isTextureLoaded(int handle);

	/**
	 * Generate an OpenGL handle to be used for a texture.
	 * @return A new handle to be used in the binding of a texture.
	 */
	public int generateTextureHandle();

	/**
	 * Load a texture from a resource into OpenGL.
	 * @param texture The texture to be loaded.
	 */
	public void loadTextureFromResource(Texture texture);

	/**
	 * Unload a texture from OpenGL.
	 * @param texture The texture to be unloaded.
	 */
	public void unloadTexture(Texture texture);

	/**
	 * Apply OpenGL texture options.
	 * @param options The options to be applied.
	 */
	public void applyTextureOptions(TextureOptions options);
}
