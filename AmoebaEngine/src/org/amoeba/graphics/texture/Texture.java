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
	 * Set the width of the texture.
	 * @param width The new width of the texture.
	 */
	public void setWidth(final int width);

	/**
	 * Set the height of the texture.
	 * @param height The new height of the texture.
	 */
	public void setHeight(final int height);

	/**
	 * Set the OpenGL handle of the texture.
	 * @param handle The new handle of the texture.
	 */
	public void setHandle(final int handle);

	/**
	 * Set the options used to load this texture.
	 * @param options The options for this texture.
	 */
	public void setOptions(final TextureOptions options);

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
