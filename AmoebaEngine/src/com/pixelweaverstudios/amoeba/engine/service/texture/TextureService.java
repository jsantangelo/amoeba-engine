package com.pixelweaverstudios.amoeba.engine.service.texture;

import com.pixelweaverstudios.amoeba.engine.service.Service;
import com.pixelweaverstudios.amoeba.graphics.texture.Texture;

public interface TextureService extends Service
{
	/**
	 * @param texture
	 */
	public void add(Texture texture);
	
	/**
	 * @param resource
	 */
	public void remove(int resource);
	
	/**
	 * @param resource
	 * @return
	 */
	public Texture loadTexture(int resource);
	
	/**
	 * 
	 */
	public void loadAllTextures();
	
	/**
	 * @param resource
	 */
	public Texture unloadTexture(int resource);

	/**
	 * 
	 */
	public void unloadAllTextures();

	/**
	 * @param resource
	 * @return
	 */
	public Texture getTexture(int resource);

	/**
	 * @param resource
	 * @return
	 */
	public int getTextureID(int resource);
}
