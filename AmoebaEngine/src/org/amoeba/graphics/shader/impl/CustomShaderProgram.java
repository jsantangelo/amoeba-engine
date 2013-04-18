package org.amoeba.graphics.shader.impl;

import java.util.ArrayList;

import org.amoeba.graphics.shader.Shader;
import org.amoeba.graphics.shader.ShaderProgram;


/**
 * CustomShaderProgram is a ShaderProgram that is provided a collection of shaders.
 */
public class CustomShaderProgram extends ShaderProgram
{
	/**
	 * Constructor for CustomShaderProgram.
	 * @param shaders The collection of shaders in the program.
	 */
	public CustomShaderProgram(final ArrayList<Shader> shaders)
	{
		if (shaders.size() <= 0)
		{
			throw new RuntimeException("No shaders were provided to create the program.");
		}

		setShaders(shaders);
	}
}
