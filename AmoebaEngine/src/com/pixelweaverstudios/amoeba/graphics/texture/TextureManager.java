package com.pixelweaverstudios.amoeba.graphics.texture;

import android.util.SparseArray;

/**
 * @author Mike Testen
 * 
 */
public class TextureManager
{
	private SparseArray<ITexture> textures;

	/**
	 * @param context
	 */
	public TextureManager()
	{
		this.textures = new SparseArray<ITexture>();
	}

	/**
	 * @param texture
	 */
	public void add(ITexture texture)
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
	public ITexture loadTexture(int resource)
	{
		ITexture texture = getTexture(resource);
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
	public ITexture unloadTexture(int resource)
	{
		ITexture texture = getTexture(resource);
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
	public ITexture getTexture(int resource)
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
