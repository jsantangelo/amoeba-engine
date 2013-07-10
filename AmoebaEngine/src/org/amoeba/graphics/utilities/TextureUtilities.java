package org.amoeba.graphics.utilities;

import org.amoeba.graphics.texture.TextOptions;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions;
import org.amoeba.graphics.texture.TextureOptions.Preset;

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
	 * @param resource The id of the resource to load.
	 * @param options The texture options with which to load.
	 * @param handle The texture's handle if there is one already.
	 * @return The texture, whether it was loaded or not.
	 */
	public Texture loadTextureFromResource(final int resource, final TextureOptions options, final int handle);

	/**
	 * Create a texture that displays text.
	 * @param text The text to display on the texture.
	 * @param textureOptions The texture options with which to load.
	 * @param textOptions The text options to use.
	 * @param handle The texture's handle if there is one already.
	 * @return The texture, whether it was loaded or not.
	 */
	public Texture loadTextTexture(final String text, final TextureOptions textureOptions, final TextOptions textOptions, final int handle);

	/**
	 * Unload a texture from OpenGL.
	 * @param texture The texture to be unloaded.
	 */
	public void unloadTexture(Texture texture);

	/**
	 * Get a preset TextureOptions.
	 * @param preset The requested type of texture options.
	 * @return The requested texture options.
	 */
	public TextureOptions getTextureOptionsPreset(Preset preset);

	/**
	 * Apply OpenGL texture options.
	 * @param options The options to be applied.
	 */
	public void applyTextureOptions(TextureOptions options);
}
