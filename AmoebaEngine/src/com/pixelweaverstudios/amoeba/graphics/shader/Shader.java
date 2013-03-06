package com.pixelweaverstudios.amoeba.graphics.shader;

import com.pixelweaverstudios.amoeba.graphics.utilities.ShaderUtilities;

/**
 * Shader is a base class for all shaders.
 */
public abstract class Shader
{
	protected String source;
	protected int handle, type;

	/**
	 * Get the source code for the shader.
	 * @return The source code of the shader.
	 */
	public String getSource()
	{
		return source;
	}

	/**
	 * Get the type of the shader.
	 * @return The type of the shader (Vertex or Fragment).
	 */
	public int getType()
	{
		return type;
	}

	/**
	 * Get the handle of the shader.
	 * @return The handle that represents the shader.
	 */
	public int getHandle()
	{
		return handle;
	}

	/**
	 * Compile the shader.
	 */
	public void compile()
	{
		handle = ShaderUtilities.compileShaderFromSource(source, type);
	}
}
