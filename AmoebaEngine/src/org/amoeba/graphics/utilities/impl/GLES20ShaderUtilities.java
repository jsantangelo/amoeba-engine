package org.amoeba.graphics.utilities.impl;

import java.util.ArrayList;

import org.amoeba.graphics.shader.Shader;
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

	/**
	 * Compile a shader given the source code and type.
	 * @param shaderSource The source code of the shader.
	 * @param shaderType The type of shader (e.g. Fragment or Vertex).
	 * @return The handle to the shader.
	 */
	public int compileShaderFromSource(final String shaderSource, final int shaderType)
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

	/**
	 * Generate a program handle.
	 * @return The OpenGL program handle.
	 */
	public int generateProgramHandle()
	{
		int handle = GLES20.glCreateProgram();
		if (handle == 0)
		{
			throw new RuntimeException("Error creating program.");
		}

		return handle;
	}

	/**
	 * Attach a collection of shaders to a program.
	 * @param programHandle The program with which the shaders will attach.
	 * @param shaders The collections of shaders to be attached.
	 */
	public void attachShadersToProgram(final int programHandle, final ArrayList<Shader> shaders)
	{
		for (int i = 0; i < shaders.size(); i++)
		{
			GLES20.glAttachShader(programHandle, shaders.get(i).getHandle());
		}
	}

	/**
	 * Link a program with a given OpenGL program handle.
	 * @param handle The handle representing the program to be linked.
	 * @return Whether the linking was successful.
	 */
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

	/**
	 * Use a program of a given handle.
	 * @param programHandle The handle representing the program to be used.
	 */
	public void useProgram(final int programHandle)
	{
		GLES20.glUseProgram(programHandle);
	}

	/**
	 * Query OpenGL whether a given program is in use.
	 * @param programHandle The handle representing the program to be checked.
	 * @return Whether the program is currently in use.
	 */
	public boolean isProgramInUse(final int programHandle)
	{
		GLES20.glGetIntegerv(GLES20.GL_CURRENT_PROGRAM, glIntStorage, 0);

		return (glIntStorage[0] == programHandle);
	}

	/**
	 * Delete a program of a given handle.
	 * @param programHandle The handle representing the program to be deleted.
	 */
	public void deleteProgram(final int programHandle)
	{
		GLES20.glDeleteProgram(programHandle);
	}

	/**
	 * Get the location of an attribute in a given program.
	 * @param programHandle The handle representing the program that contains the attribute.
	 * @param attributeName The name of the attribute that is being retrieved.
	 * @return The OpenGL handle of the attribute.
	 */
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

	/**
	 * Get the location of a uniform in a given program.
	 * @param programHandle The handle representing the program that contains the uniform.
	 * @param uniformName The name of the uniform that is being retrieved.
	 * @return The OpenGL handle of the uniform.
	 */
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
}
