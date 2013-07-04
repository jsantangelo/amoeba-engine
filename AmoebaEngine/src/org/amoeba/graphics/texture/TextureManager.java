package org.amoeba.graphics.texture;

import java.util.HashSet;
import java.util.Set;

/**
 * TextureManager maintains a collection of textures.
 */
public class TextureManager
{
	private final Set<Texture> textures;

	/**
	 * Constructor for TextureManager.
	 */
	public TextureManager()
	{
		textures = new HashSet<Texture>();
	}

	/**
	 * Add a texture to be managed by the texture manager.
	 * @param texture Texture to be added to the collection.
	 * @return Whether the texture was added to the collection.
	 */
	public boolean add(final Texture texture)
	{
		boolean added = false;

		if (texture != null)
		{
			added = textures.add(texture);
		}

		return added;
	}

	/**
	 * Remove a texture from the texture manager.
	 * @param texture Texture to be removed from the collection.
	 * @return Whether the texture was removed.
	 */
	public boolean remove(final Texture texture)
	{
		return textures.remove(texture);
	}

	/**
	 * Load all textures currently maintained by the texture manager.
	 */
	public void loadAll()
	{
		for (Texture texture : textures)
		{
			texture.load();
		}
	}

	/**
	 * Unload all textures currently maintained by the texture manager.
	 */
	public void unloadAll()
	{
		for (Texture texture : textures)
		{
			texture.unload();
		}
	}

	/**
	 * Get the number of textures maintained by the texture manager.
	 * @return The number of textures in the collection.
	 */
	public int size()
	{
		return textures.size();
	}
}
