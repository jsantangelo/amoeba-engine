package com.pixelweaverstudios.amoeba.graphics.texture;

import android.util.SparseArray;

public class TextureManager
{
	private SparseArray<Texture> textures;

	/**
	 * @param context
	 */
	public TextureManager()
	{
		this.textures = new SparseArray<Texture>();
	}

	/**
	 * @param texture
	 */
	public void add(Texture texture)
	{
		if (texture != null && texture.getID() != -1)
		{
			textures.put(texture.getID(), texture);
		}
	}

	/**
	 * @param resource
	 */
	public void remove(int resource)
	{
		textures.remove(resource);
	}

	/**
	 * @param resource
	 * @return
	 */
	public Texture loadTexture(int resource)
	{
		Texture texture = getTexture(resource);
		texture.load();

		return texture;
	}

	/**
	 * 
	 */
	public void loadAllTextures()
	{
		for (int index = 0; index < textures.size(); index++)
		{
			textures.valueAt(index).load();
		}
	}

	/**
	 * @param resource
	 */
	public Texture unloadTexture(int resource)
	{
		Texture texture = getTexture(resource);
		texture.unload();

		return texture;
	}

	/**
	 * 
	 */
	public void unloadAllTextures()
	{
		for (int index = 0; index < textures.size(); index++)
		{
			textures.valueAt(index).unload();
		}
	}

	/**
	 * @param resource
	 * @return
	 */
	public Texture getTexture(int resource)
	{
		return textures.get(resource);
	}

	/**
	 * @param resource
	 * @return
	 */
	public Integer getTextureID(int resource)
	{
		return textures.get(resource).getHandle();
	}
}
