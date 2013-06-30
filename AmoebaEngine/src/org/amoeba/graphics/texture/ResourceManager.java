package org.amoeba.graphics.texture;

import android.util.SparseArray;

/**
 * ResourceManager maintains a collection of resource textures.
 */
public class ResourceManager
{
	private final SparseArray<Texture> textures;

	/**
	 * Constructor for ResourceManager.
	 */
	public ResourceManager()
	{
		this.textures = new SparseArray<Texture>();
	}

	/**
	 * Add a texture to the resource manager.
	 * @param texture Texture to be added to the collection.
	 * @param resource The resource ID representing the texture.
	 */
	public void add(final Texture texture, final int resource)
	{
		if (texture != null)
		{
			textures.put(resource, texture);
		}
	}

	/**
	 * Remove a texture from the resource manager.
	 * @param resource The resource ID representing the texture to be removed.
	 */
	public void remove(final int resource)
	{
		textures.remove(resource);
	}

	/**
	 * Get a texture from the resource manager using its ID.
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
	public int getTextureHandle(final int resource)
	{
		return textures.get(resource).getHandle();
	}

}
