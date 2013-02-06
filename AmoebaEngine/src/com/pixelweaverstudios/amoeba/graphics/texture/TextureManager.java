package com.pixelweaverstudios.amoeba.graphics.texture;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import android.content.Context;
import android.opengl.GLES20;
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
		if(texture.getDrawable() != -1)
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
        texture.load();
        
        return texture;
    }
	
	/**
	 * 
	 */
	public void loadAllTextures()
	{
		for(int index = 0; index < textures.size(); index++)
		{
		    loadTexture(textures.keyAt(index));
		}
	}
	
    /**
     * @param resource
     */
    public void unloadTexture(int resource)
    {
    	Integer id = getTextureID(resource);
		if(id != null)
		{
			IntBuffer texBuffer;
	    	int tempID[] = new int[1]; 
	    	tempID[0] = id.intValue();
	    	
			ByteBuffer bb = ByteBuffer.allocateDirect(4);
			bb.order(ByteOrder.nativeOrder());
			texBuffer = bb.asIntBuffer();
			texBuffer.put(tempID);
			texBuffer.position(0);
	    	
			GLES20.glDeleteTextures(1, texBuffer);
    		
			textures.remove(resource);
		}
    }
    
	/**
	 * 
	 */
	public void unloadAllTextures()
	{
		
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
