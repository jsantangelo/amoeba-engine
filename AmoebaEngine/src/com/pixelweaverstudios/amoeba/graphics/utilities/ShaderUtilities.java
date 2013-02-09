package com.pixelweaverstudios.amoeba.graphics.utilities;

import android.opengl.GLES20;
import android.util.Log;

/**
 * @author Mike Testen
 * 
 */
public class ShaderUtilities
{
	private static final String TAG = "ShaderUtilities";

	/**
	 * @param shaderSource
	 * @param shaderType
	 * @return
	 */
	public static int createShaderFromSource(String shaderSource, int shaderType)
	{
		int handle = GLES20.glCreateShader(shaderType);
		if (handle == 0)
		{
			throw new RuntimeException("Error creating shader.");
		}
		else
		{
			GLES20.glShaderSource(handle, shaderSource);
	
			GLES20.glCompileShader(handle);
	
			final int[] compileStatus = new int[1];
			GLES20.glGetShaderiv(handle, GLES20.GL_COMPILE_STATUS, compileStatus, 0);
	
			if (compileStatus[0] == 0)
			{
				Log.e(TAG, "Error compiling shader: " + GLES20.glGetShaderInfoLog(handle));
				GLES20.glDeleteShader(handle);
				handle = 0;
			}
		}
		return handle;
	}
}
