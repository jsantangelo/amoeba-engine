package com.pixelweaverstudios.amoeba.graphics.shader.source;

import java.util.ArrayList;

import com.pixelweaverstudios.amoeba.graphics.shader.ShaderProgram;
import com.pixelweaverstudios.amoeba.graphics.shader.Shader;

/**
 * @author Mike Testen
 * 
 */
public class CustomShaderProgram extends ShaderProgram
{
	/**
	 * @param shaders
	 */
	public CustomShaderProgram(final ArrayList<Shader> shaders)
	{
		if (shaders.size() <= 0)
		{
			throw new RuntimeException("No shaders were provided to create the program.");
		}

		this.shaders = shaders;
	}
}
