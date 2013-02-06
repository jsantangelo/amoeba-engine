package com.pixelweaverstudios.amoeba.graphics.texture;

import android.content.Context;
import android.util.SparseArray;

/**
 * @author Mike Testen
 *
 */
public class TextureManager
{
	private Context context;
	
	private SparseArray<ITexture> textures;
	
	/**
	 * @param context
	 */
	public TextureManager(Context context)
	{
		this.context = context;
		this.textures = new SparseArray<ITexture>();
	}
	
	/**
	 * @param texture
	 */
	public void add(ITexture texture)
	{
		if(texture != null && texture.getDrawable() != -1)
		{
		    textures.put(texture.getDrawable(), texture);
		}
	}
	
	/**
	 * @param resource
	 * @return
	 */
	public ITexture loadTexture(int resource) 
    {
		ITexture texture = getTexture(resource);
        texture.load(context);
        
        return texture;
    }
	
	/**
	 * 
	 */
	public void loadAllTextures()
	{
		for(int index = 0; index < textures.size(); index++)
		{
		    textures.valueAt(index).load(context);
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
		for(int index = 0; index < textures.size(); index++)
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
