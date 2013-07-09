package org.amoeba.graphics.texture;

/**
 * Texture is a container for an OpenGL texture.
 */
public interface Texture
{
	/**
	 * Load the texture into OpenGL.
	 */
	public void load();

	/**
	 * Unload the texture from OpenGL.
	 */
	public void unload();

	/**
	 * Determine whether the texture is currently loaded.
	 * @return Whether the texture is loaded.
	 */
	public boolean isLoaded();

	/**
	 * Get the width of the texture.
	 * @return The width of the texture.
	 */
	public int getWidth();

	/**
	 * Get the height of the texture.
	 * @return The height of the texture.
	 */
	public int getHeight();

	/**
	 * Get the OpenGL handle of the texture.
	 * @return The handle that represents the texture.
	 */
	public int getHandle();

	/**
	 * Get the options of this texture.
	 * @return The options used to load the texture.
	 */
	public TextureOptions getOptions();
}
