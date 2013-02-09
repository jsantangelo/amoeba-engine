package com.pixelweaverstudios.amoeba.graphics.shader;

import com.pixelweaverstudios.amoeba.graphics.utilities.ShaderUtilities;

/**
 * @author Mike Testen
 * 
 */
public class Shader implements IShader
{
	private int handle, type;
	private String source;

	/**
	 * @param shaderSource
	 * @param shaderType
	 */
	public Shader(final String shaderSource, final int shaderType)
	{
		source = shaderSource;
		type = shaderType;
		handle = ShaderUtilities.createShaderFromSource(source, type);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.shader.IShader#getSource()
	 */
	public String getSource()
	{
		return source;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.shader.IShader#getType()
	 */
	public int getType()
	{
		return type;
	}

	/**
	 * @return
	 */
	public int getHandle()
	{
		return handle;
	}
}
