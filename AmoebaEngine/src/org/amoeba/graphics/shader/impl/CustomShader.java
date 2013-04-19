package org.amoeba.graphics.shader.impl;

import org.amoeba.graphics.shader.Shader;
import org.amoeba.graphics.utilities.ShaderUtilities;

/**
 * CustomShader is a Shader that is provided with a source and type.
 */
public class CustomShader extends Shader
{
	/**
	 * Constructor for CustomShader.
	 * @param shaderSource The source code of the shader.
	 * @param shaderType The type of the shader (e.g. Vertex or Fragment).
	 * @param shaderUtilities The utilities to be used with this shader.
	 */
	public CustomShader(final String shaderSource, final int shaderType, final ShaderUtilities shaderUtilities)
	{
		setSource(shaderSource);
		setType(shaderType);
		setShaderUtilities(shaderUtilities);
		setHandle(-1);
	}
}
