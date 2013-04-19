package org.amoeba.graphics.shader.impl;

import java.util.ArrayList;

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
	 * @param shaders The collection of shaders in the program.
	 * @param shaderUtilities The utilities to be used with this shader.
	 */
	public CustomShaderProgram(final ArrayList<Shader> shaders, final ShaderUtilities shaderUtilities)
	{
		if (shaders.size() <= 0)
		{
			throw new RuntimeException("No shaders were provided to create the program.");
		}

		setShaders(shaders);
		setShaderUtilities(shaderUtilities);
	}
}
