package org.amoeba.graphics.utilities.impl;

import org.amoeba.graphics.shader.Shader;
import org.amoeba.graphics.shader.Shader.Type;
import org.amoeba.graphics.utilities.ShaderUtilities;

import android.opengl.GLES20;
import android.util.Log;

/**
 * GLES20ShaderUtilities provides an implementation of the ShaderUtilities routines
 * using OpenGL ES 2.0.
 */
public class GLES20ShaderUtilities implements ShaderUtilities
{
	private static final String TAG = "GLES20ShaderUtilities";
	private final int[] glIntStorage;

	/**
	 * Constructor for ShaderUtilities.
	 */
	public GLES20ShaderUtilities()
	{
		glIntStorage = new int[1];
	}

	@Override
	public int compileShaderFromSource(final String shaderSource, final Type shaderType)
	{
		int type = getShaderType(shaderType);
		int handle = GLES20.glCreateShader(type);
		if (handle == 0)
		{
			throw new RuntimeException("Error creating shader.");
		}
		else
		{
			GLES20.glShaderSource(handle, shaderSource);
			GLES20.glCompileShader(handle);

			GLES20.glGetShaderiv(handle, GLES20.GL_COMPILE_STATUS, glIntStorage, 0);
			if (glIntStorage[0] == 0)
			{
				Log.e(TAG, "Error compiling shader: " + GLES20.glGetShaderInfoLog(handle));
				GLES20.glDeleteShader(handle);
				handle = 0;
			}
		}

		return handle;
	}

	@Override
	public int generateProgramHandle()
	{
		int handle = GLES20.glCreateProgram();
		if (handle == 0)
		{
			throw new RuntimeException("Error creating program.");
		}

		return handle;
	}

	@Override
	public void attachShaderToProgram(final int programHandle, final Shader shader)
	{
		GLES20.glAttachShader(programHandle, shader.getHandle());
	}

	@Override
	public boolean linkProgram(final int handle)
	{
		boolean result = true;

		GLES20.glLinkProgram(handle);
		GLES20.glGetProgramiv(handle, GLES20.GL_LINK_STATUS, glIntStorage, 0);

		if (glIntStorage[0] == 0)
		{
			Log.e(TAG, "Error linking program: " + GLES20.glGetProgramInfoLog(handle));
		}

		return result;
	}

	@Override
	public void useProgram(final int programHandle)
	{
		GLES20.glUseProgram(programHandle);
	}

	@Override
	public boolean isProgramInUse(final int programHandle)
	{
		GLES20.glGetIntegerv(GLES20.GL_CURRENT_PROGRAM, glIntStorage, 0);

		return (glIntStorage[0] == programHandle);
	}

	@Override
	public void deleteProgram(final int programHandle)
	{
		GLES20.glDeleteProgram(programHandle);
	}

	@Override
	public int getAttributeLocation(final int programHandle, final String attributeName)
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

	@Override
	public int getUniformLocation(final int programHandle, final String uniformName)
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

	@Override
	public int getShaderType(final Type shaderType)
	{
		int type = 0;
		switch (shaderType)
		{
			case VERTEX:
				type = GLES20.GL_VERTEX_SHADER;
				break;
			case FRAGMENT:
				type = GLES20.GL_FRAGMENT_SHADER;
				break;
			default:
				type = GLES20.GL_NONE;
		}

		return type;
	}
}
