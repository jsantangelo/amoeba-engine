package org.amoeba.graphics.shader.impl;

import org.amoeba.graphics.shader.Shader;

/**
 * CustomShader is a Shader that is provided with a source and type.
 */
public class SourceShader extends Shader
{
	/**
	 * Constructor for CustomShader.
	 * @param shaderSource The source code of the shader.
	 * @param shaderType The type of the shader (e.g. Vertex or Fragment).
	 */
	public SourceShader(final String shaderSource, final Type shaderType)
	{
		setSource(shaderSource);
		setType(shaderType);
		setHandle(-1);
	}
}
