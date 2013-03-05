package com.pixelweaverstudios.amoeba.engine.service.texture;

import android.util.SparseArray;

import com.pixelweaverstudios.amoeba.graphics.texture.Texture;

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

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#
	 * add(com.pixelweaverstudios.amoeba.graphics.texture.Texture)
	 */
	public void add(final Texture texture)
	{
		if (texture != null && texture.getID() != -1)
		{
			textures.put(texture.getID(), texture);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#
	 * remove(int)
	 */
	public void remove(final int resource)
	{
		textures.remove(resource);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#
	 * loadTexture(int)
	 */
	public Texture loadTexture(final int resource)
	{
		Texture texture = getTexture(resource);
		texture.load();

		return texture;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#
	 * loadAllTextures()
	 */
	public void loadAllTextures()
	{
		for (int index = 0; index < textures.size(); index++)
		{
			textures.valueAt(index).load();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#
	 * unloadTexture(int)
	 */
	public Texture unloadTexture(final int resource)
	{
		Texture texture = getTexture(resource);
		texture.unload();

		return texture;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#
	 * unloadAllTextures()
	 */
	public void unloadAllTextures()
	{
		for (int index = 0; index < textures.size(); index++)
		{
			textures.valueAt(index).unload();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#
	 * getTexture(int)
	 */
	public Texture getTexture(final int resource)
	{
		return textures.get(resource);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#
	 * getTextureID(int)
	 */
	public int getTextureID(final int resource)
	{
		return textures.get(resource).getHandle();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.pixelweaverstudios.amoeba.engine.service.Service#start()
	 */
	public void start()
	{

	}
}
