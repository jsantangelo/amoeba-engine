package com.pixelweaverstudios.amoeba.graphics.shader.source;

import java.util.ArrayList;

import com.pixelweaverstudios.amoeba.graphics.shader.Shader;
import com.pixelweaverstudios.amoeba.graphics.shader.ShaderProgram;

/**
 * TextureShaderProgram is a program that is used to display an unmodified texture.
 */
public class TextureShaderProgram extends ShaderProgram
{
	/**
	 * Constructor for TextureShaderProgram.
	 */
	public TextureShaderProgram()
	{
		ArrayList<Shader> shaders = new ArrayList<Shader>();
		shaders.add(new TextureVertexShader());
		shaders.add(new TextureFragmentShader());
		setShaders(shaders);
	}
}
