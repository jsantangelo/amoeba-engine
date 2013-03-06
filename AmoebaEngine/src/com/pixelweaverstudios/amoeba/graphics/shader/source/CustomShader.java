package com.pixelweaverstudios.amoeba.graphics.shader.source;

import com.pixelweaverstudios.amoeba.graphics.shader.Shader;

/**
 * CustomShader is a Shader that is provided with a source and type.
 */
public class CustomShader extends Shader
{
	/**
	 * Constructor for CustomShader.
	 * @param shaderSource The source code of the shader.
	 * @param shaderType The type of the shader (e.g. Vertex or Fragment).
	 */
	public CustomShader(final String shaderSource, final int shaderType)
	{
		source = shaderSource;
		type = shaderType;
		handle = -1;
	}
}
