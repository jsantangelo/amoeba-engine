package org.amoeba.engine.service.texture;

import org.amoeba.engine.service.Service;
import org.amoeba.graphics.texture.Texture;


/**
 * The texture service maintains a collection of textures.
 */
public interface TextureService extends Service
{
	/**
	 * Add a texture to be managed by the texture service.
	 * @param texture Texture to be added to the collection.
	 */
	public void add(Texture texture);

	/**
	 * Remove a texture from the texture service.
	 * @param resource The resource ID representing the texture to be removed.
	 */
	public void remove(int resource);

	/**
	 * Load a texture in the texture service collection.
	 * @param resource The resource ID representing the texture to be loaded.
	 * @return The loaded texture object.
	 */
	public Texture loadTexture(int resource);

	/**
	 * Load all textures currently maintained by the texture service.
	 */
	public void loadAllTextures();

	/**
	 * Unload a texture in the texture service collection.
	 * @param resource The resource ID representing the texture to be loaded.
	 * @return The unloaded texture object.
	 */
	public Texture unloadTexture(int resource);

	/**
	 * Unload all texture currently maintained by the texture service.
	 */
	public void unloadAllTextures();

	/**
	 * Get a texture from the texture service using its resource ID.
	 * @param resource The resource ID representing the texture.
	 * @return The texture associated with the resource ID.
	 */
	public Texture getTexture(int resource);

	/**
	 * Get the handle of a texture from its resource ID.
	 * @param resource The resource ID representing the texture.
	 * @return The texture handle associated with the resource ID.
	 */
	public int getTextureID(int resource);
}
