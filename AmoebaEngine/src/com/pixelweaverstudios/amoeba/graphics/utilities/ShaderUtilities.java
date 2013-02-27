package com.pixelweaverstudios.amoeba.graphics.utilities;

import java.util.ArrayList;

import com.pixelweaverstudios.amoeba.graphics.shader.Shader;

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
	public static int compileShaderFromSource(String shaderSource, int shaderType)
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
	
	/**
	 * @return
	 */
	public static int generateProgramHandle()
	{
		int handle = GLES20.glCreateProgram();
		if (handle == 0)
		{
			throw new RuntimeException("Error creating program.");
		}
		
		return handle;
	}
	
	/**
	 * @param programHandle
	 * @param shaders
	 */
	public static void attachShadersToProgram(int programHandle, ArrayList<Shader> shaders)
	{
		for (int i = 0; i < shaders.size(); i++)
		{
			GLES20.glAttachShader(programHandle, shaders.get(i).getHandle());
		}
	}
	
	/**
	 * @param handle
	 * @return
	 */
	public static boolean linkProgram(int handle)
	{
		boolean result = true;
		final int[] linkStatus = new int[1];
		
		GLES20.glLinkProgram(handle);
		GLES20.glGetProgramiv(handle, GLES20.GL_LINK_STATUS, linkStatus, 0);

		if (linkStatus[0] == 0)
		{
			Log.e(TAG, "Error linking program: " + GLES20.glGetProgramInfoLog(handle));
		}
		
		return result;
	}
	
	/**
	 * @param programHandle
	 */
	public static void useProgram(int programHandle)
	{
		GLES20.glUseProgram(programHandle);
	}
	
	/**
	 * @param programHandle
	 * @return
	 */
	public static boolean isProgramInUse(int programHandle)
	{
		final int[] currentProgram = new int[1];
		GLES20.glGetIntegerv(GLES20.GL_CURRENT_PROGRAM, currentProgram, 0);

		return (currentProgram[0] == programHandle);
	}
	
	/**
	 * @param programHandle
	 */
	public static void deleteProgram(int programHandle)
	{
		GLES20.glDeleteProgram(programHandle);
	}
	
	/**
	 * @param programHandle
	 * @param attributeName
	 * @return
	 */
	public static int getAttributeLocation(int programHandle, final String attributeName)
	{
		if (attributeName == null)
		{
			throw new RuntimeException("attributeName is null");
		}

		int attribute = GLES20.glGetAttribLocation(programHandle, attributeName);
		if (attribute == -1)
		{
			throw new RuntimeException("Attribute '" + attributeName + "' not found.");
		}

		return attribute;
	}
	
	/**
	 * @param programHandle
	 * @param uniformName
	 * @return
	 */
	public static int getUniformLocation(int programHandle, final String uniformName)
	{
		if (uniformName == null)
		{
			throw new RuntimeException("uniformName is null");
		}

		int uniform = GLES20.glGetUniformLocation(programHandle, uniformName);
		if (uniform == -1)
		{
			throw new RuntimeException("Uniform '" + uniformName + "' not found.");
		}

		return uniform;
	}
}
