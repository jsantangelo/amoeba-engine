package com.pixelweaverstudios.amoeba.graphics.shader.source;

import com.pixelweaverstudios.amoeba.graphics.shader.Shader;

public class CustomShader extends Shader
{
	/**
	 * @param shaderSource
	 * @param shaderType
	 */
	public CustomShader(final String shaderSource, final int shaderType)
	{
		source = shaderSource;
		type = shaderType;
		handle = -1;
	}
}
