package com.pixelweaverstudios.amoeba.graphics.shader;

import com.pixelweaverstudios.amoeba.graphics.utilities.ShaderUtilities;

/**
 * @author Mike Testen
 * 
 */
public abstract class Shader
{
	protected String source;
	protected int handle, type;

	/**
	 * @return The source code of the shader.
	 */
	public String getSource()
	{
		return source;
	}

	/**
	 * @return The type of the shader (Vertex or Fragment).
	 */
	public int getType()
	{
		return type;
	}

	/**
	 * @return The handle that represents the shader.
	 */
	public int getHandle()
	{
		return handle;
	}
	
	/**
	 * 
	 */
	public void compile()
	{
		handle = ShaderUtilities.compileShaderFromSource(source, type);
	}
}
