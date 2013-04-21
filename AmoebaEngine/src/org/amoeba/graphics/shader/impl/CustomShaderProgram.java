package org.amoeba.graphics.shader.impl;

import org.amoeba.graphics.shader.Shader;
import org.amoeba.graphics.shader.ShaderProgram;
import org.amoeba.graphics.utilities.ShaderUtilities;

/**
 * CustomShaderProgram is a ShaderProgram that is provided a collection of shaders.
 */
public class CustomShaderProgram extends ShaderProgram
{
	/**
	 * Constructor for CustomShaderProgram.
	 * @param vertexShader The vertex shader for the program.
	 * @param fragmentShader The fragment shader for the program.
	 * @param shaderUtilities The utilities to be used with this shader.
	 */
	public CustomShaderProgram(final Shader vertexShader, final Shader fragmentShader, final ShaderUtilities shaderUtilities)
	{
		setVertexShader(vertexShader);
		setFragmentShader(fragmentShader);
		setShaderUtilities(shaderUtilities);
	}
}
