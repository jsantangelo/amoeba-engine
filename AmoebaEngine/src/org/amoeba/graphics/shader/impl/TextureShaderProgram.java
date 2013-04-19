package org.amoeba.graphics.shader.impl;

import java.util.ArrayList;

import org.amoeba.graphics.shader.Shader;
import org.amoeba.graphics.shader.ShaderProgram;
import org.amoeba.graphics.utilities.ShaderUtilities;


/**
 * TextureShaderProgram is a program that is used to display an unmodified texture.
 */
public class TextureShaderProgram extends ShaderProgram
{
	/**
	 * Constructor for TextureShaderProgram.
	 * @param shaderUtilities The utilities to be used with this shader.
	 */
	public TextureShaderProgram(final ShaderUtilities shaderUtilities)
	{
		ArrayList<Shader> shaders = new ArrayList<Shader>();
		shaders.add(new TextureVertexShader(shaderUtilities));
		shaders.add(new TextureFragmentShader(shaderUtilities));
		setShaders(shaders);
	}
}
