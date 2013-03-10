package org.amoeba.engine.service.texture;

import android.util.SparseArray;

import org.amoeba.graphics.texture.Texture;

/**
 * The texture service maintains a collection of textures.
 */
public class EngineTextureService implements TextureService
{
	private final SparseArray<Texture> textures;

	/**
	 * Constructor for EngineTextureService.
	 */
	public EngineTextureService()
	{
		this.textures = new SparseArray<Texture>();
	}

	/**
	 * Add a texture to be managed by the texture service.
	 * @param texture Texture to be added to the collection.
	 */
	public void add(final Texture texture)
	{
		if (texture != null && texture.getID() != -1)
		{
			textures.put(texture.getID(), texture);
		}
	}

	/**
	 * Remove a texture from the texture service.
	 * @param resource The resource ID representing the texture to be removed.
	 */
	public void remove(final int resource)
	{
		textures.remove(resource);
	}

	/**
	 * Load a texture in the texture service collection.
	 * @param resource The resource ID representing the texture to be loaded.
	 * @return The loaded texture object.
	 */
	public Texture loadTexture(final int resource)
	{
		Texture texture = getTexture(resource);
		texture.load();

		return texture;
	}

	/**
	 * Load all textures currently maintained by the texture service.
	 */
	public void loadAllTextures()
	{
		for (int index = 0; index < textures.size(); index++)
		{
			textures.valueAt(index).load();
		}
	}

	/**
	 * Unload a texture in the texture service collection.
	 * @param resource The resource ID representing the texture to be loaded.
	 * @return The unloaded texture object.
	 */
	public Texture unloadTexture(final int resource)
	{
		Texture texture = getTexture(resource);
		texture.unload();

		return texture;
	}

	/**
	 * Unload all texture currently maintained by the texture service.
	 */
	public void unloadAllTextures()
	{
		for (int index = 0; index < textures.size(); index++)
		{
			textures.valueAt(index).unload();
		}
	}

	/**
	 * Get a texture from the texture service using its resource ID.
	 * @param resource The resource ID representing the texture.
	 * @return The texture associated with the resource ID.
	 */
	public Texture getTexture(final int resource)
	{
		return textures.get(resource);
	}

	/**
	 * Get the handle of a texture from its resource ID.
	 * @param resource The resource ID representing the texture.
	 * @return The texture handle associated with the resource ID.
	 */
	public int getTextureID(final int resource)
	{
		return textures.get(resource).getHandle();
	}

}
