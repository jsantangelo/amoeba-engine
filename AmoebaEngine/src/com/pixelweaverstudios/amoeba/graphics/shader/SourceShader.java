package com.pixelweaverstudios.amoeba.graphics.shader;

/**
 * @author Mike Testen
 * 
 */
public class SourceShader extends Shader
{
	/**
	 * @param shaderSource
	 * @param shaderType
	 */
	public SourceShader(final String shaderSource, final int shaderType)
	{
		source = shaderSource;
		type = shaderType;
		handle = -1;
	}
}
