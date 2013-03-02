package com.pixelweaverstudios.amoeba.engine.service.texture;

import com.pixelweaverstudios.amoeba.graphics.texture.Texture;

import android.util.SparseArray;

public class EngineTextureService implements TextureService
{
	private SparseArray<Texture> textures;

	/**
	 * 
	 */
	public EngineTextureService()
	{
		this.textures = new SparseArray<Texture>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#add
	 * (com.pixelweaverstudios.amoeba.graphics.texture.Texture)
	 */
	public void add(Texture texture)
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
	 * com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#remove
	 * (int)
	 */
	public void remove(int resource)
	{
		textures.remove(resource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#
	 * loadTexture(int)
	 */
	public Texture loadTexture(int resource)
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
	public Texture unloadTexture(int resource)
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
	public Texture getTexture(int resource)
	{
		return textures.get(resource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.engine.service.texture.TextureService#
	 * getTextureID(int)
	 */
	public int getTextureID(int resource)
	{
		return textures.get(resource).getHandle();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.engine.service.Service#start()
	 */
	@Override
	public void start()
	{

	}
}
