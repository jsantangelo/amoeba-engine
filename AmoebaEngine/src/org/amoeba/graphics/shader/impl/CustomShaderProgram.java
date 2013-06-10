package org.amoeba.graphics.shader.impl;

import org.amoeba.graphics.shader.Shader;
import org.amoeba.graphics.shader.ShaderProgram;

/**
 * CustomShaderProgram is a ShaderProgram that is provided vertex and fragment shaders.
 */
public class CustomShaderProgram extends ShaderProgram
{
	/**
	 * Constructor for CustomShaderProgram.
	 * @param vertexShader The vertex shader for the program.
	 * @param fragmentShader The fragment shader for the program.
	 */
	public CustomShaderProgram(final Shader vertexShader, final Shader fragmentShader)
	{
		setVertexShader(vertexShader);
		setFragmentShader(fragmentShader);
	}
}
