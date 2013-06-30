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
		this.textures = new HashSet<Texture>();
	}

	/**
	 * Add a texture to be managed by the texture manager.
	 * @param texture Texture to be added to the collection.
	 */
	public void add(final Texture texture)
	{
		if (texture != null)
		{
			textures.add(texture);
		}
	}

	/**
	 * Remove a texture from the texture manager.
	 * @param texture Texture to be removed from the collection.
	 */
	public void remove(final Texture texture)
	{
		textures.remove(texture);
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
}
