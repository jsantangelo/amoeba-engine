package com.pixelweaverstudios.amoeba.graphics.texture;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

@SuppressLint("UseSparseArrays")
public class TextureManager
{
	private Context context;
	
	private HashMap<Integer, Texture> textureIdMap;
	
	public TextureManager(Context context)
	{
		this.context = context;
		this.textureIdMap = new HashMap<Integer, Texture>();
	}
	
	public void add(Texture t)
	{
		if(t.getDrawableID() != null)
		{
			textureIdMap.put(t.getDrawableID(), t);
		}
	}
	
	public Texture loadTexture(int resource) 
    {
		Texture tex = textureIdMap.get(resource);
        
        if(tex == null)
        {
        	tex = new Texture();
        	tex.setDrawable(resource);
        	textureIdMap.put(resource, tex);
        }
        
		Integer id = tex.getHandle();
		
		if(id == null)
        {
		    id = Integer.valueOf(newTextureID());
		    
		    BitmapFactory.Options opts = new BitmapFactory.Options();
		    opts.inScaled = false;
		    
		    Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), resource, opts);
		    
		    GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, id);
		    
		    GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR);
		    GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);
		    
		    GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_CLAMP_TO_EDGE);
		    GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_CLAMP_TO_EDGE);
		    
		    GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bmp, 0);
		    
		    tex.setWidth(bmp.getWidth());
		    tex.setHeight(bmp.getHeight());
		    tex.setTexture(id);
		    
		    bmp.recycle();
		    
		    tex.setTexture(id);
        }
		
		return tex;
    }
	
	public void loadAllTextures()
	{
		Iterator<Integer> it = textureIdMap.keySet().iterator();
		
		while(it.hasNext())
		{			
			loadTexture(it.next());
		}
	}
	
	public int newTextureID()
    {
        int[] temp = new int[1];

        GLES20.glGenTextures(1, temp, 0);
        if(temp[0] == 0)
        {
            throw new RuntimeException("Unable to generate a new texture id.");
        }

        return temp[0];
    }

	public Texture getTexture(int resource)
	{				
		return textureIdMap.get(resource);
	}
	
	public Integer getTextureID(int resource)
	{				
		return textureIdMap.get(resource).getHandle();
	}
	
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
    
	public void unloadAllTextures()
	{
		Iterator<Map.Entry<Integer, Texture>> it = textureIdMap.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<Integer, Texture> pairs = (Map.Entry<Integer, Texture>)it.next();
			
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
