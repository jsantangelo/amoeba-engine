package com.pixelweaverstudios.amoeba.graphics.texture;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLES20;

/**
 * @author Mike Testen
 *
 */
@SuppressLint("UseSparseArrays")
public class TextureManager
{
	private Context context;
	
	private HashMap<Integer, ITexture> textureIdMap;
	
	/**
	 * @param context
	 */
	public TextureManager(Context context)
	{
		this.context = context;
		this.textureIdMap = new HashMap<Integer, ITexture>();
	}
	
	/**
	 * @param texture
	 */
	public void add(ITexture texture)
	{
		if(texture.getDrawable() != -1)
		{
			textureIdMap.put(texture.getDrawable(), texture);
		}
	}
	
	/**
	 * @param resource
	 * @return
	 */
	public ITexture loadTexture(int resource) 
    {
		ITexture texture = textureIdMap.get(resource);
        
        if(texture == null)
        {
            texture = TextureFactory.createTexture(context, resource);
        	textureIdMap.put(resource, texture);
        }
        
        return texture;
    }
	
	/**
	 * 
	 */
	public void loadAllTextures()
	{
		Iterator<Integer> it = textureIdMap.keySet().iterator();
		
		while(it.hasNext())
		{			
			loadTexture(it.next());
		}
	}

	/**
	 * @param resource
	 * @return
	 */
	public ITexture getTexture(int resource)
	{				
		return textureIdMap.get(resource);
	}
	
	/**
	 * @param resource
	 * @return
	 */
	public Integer getTextureID(int resource)
	{				
		return textureIdMap.get(resource).getHandle();
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
    		
    		textureIdMap.remove(resource);
		}
    }
    
	/**
	 * 
	 */
	public void unloadAllTextures()
	{
		Iterator<Map.Entry<Integer, ITexture>> it = textureIdMap.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<Integer, ITexture> pairs = (Map.Entry<Integer, ITexture>)it.next();
			
			Integer id = pairs.getValue().getHandle();
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
	    		
	    		it.remove();
			}
		}
	}
}
