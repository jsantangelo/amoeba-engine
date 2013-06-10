package org.amoeba.graphics.shader.impl;

import static org.amoeba.graphics.shader.ShaderConstants.ATTRIBUTE_COLOR;
import static org.amoeba.graphics.shader.ShaderConstants.ATTRIBUTE_POSITION;
import static org.amoeba.graphics.shader.ShaderConstants.ATTRIBUTE_TEXTURECOORDINATES;
import static org.amoeba.graphics.shader.ShaderConstants.UNIFORM_MVPMATRIX;
import static org.amoeba.graphics.shader.ShaderConstants.UNIFORM_TEXTURE;
import static org.amoeba.graphics.shader.ShaderConstants.VARYING_COLOR;
import static org.amoeba.graphics.shader.ShaderConstants.VARYING_TEXTURECOORDINATES;

import org.amoeba.graphics.shader.Shader.Type;
import org.amoeba.graphics.shader.ShaderProgram;

/**
 * TextureShaderProgram is a program that is used to display an unmodified texture.
 */
public final class TextureShaderProgram extends ShaderProgram
{
	private static TextureShaderProgram instance = null;

	public static final String VERTEX_SHADER_SOURCE =
			"uniform mat4 " + UNIFORM_MVPMATRIX + ";\n" +
			"attribute vec4 " + ATTRIBUTE_POSITION + ";\n" +
			"attribute vec4 " + ATTRIBUTE_COLOR + ";\n" +
			"attribute vec2 " + ATTRIBUTE_TEXTURECOORDINATES + ";\n" +
			"varying vec4 " + VARYING_COLOR + ";\n" +
			"varying vec2 " + VARYING_TEXTURECOORDINATES + ";\n" +
			"void main()\n" +
			"{\n" +
			"	" + VARYING_COLOR + " = " + ATTRIBUTE_COLOR + ";\n" +
			"	" + VARYING_TEXTURECOORDINATES + "=" + ATTRIBUTE_TEXTURECOORDINATES + ";\n" +
			"	gl_Position = " + UNIFORM_MVPMATRIX + "*" + ATTRIBUTE_POSITION + ";\n" +
			"}\n";

	public static final String FRAGMENT_SHADER_SOURCE =
			"precision mediump float;\n" +
			"uniform sampler2D " + UNIFORM_TEXTURE + ";\n" +
			"varying vec4 " + VARYING_COLOR + ";\n" +
			"varying vec2 " + VARYING_TEXTURECOORDINATES + ";\n" +
			"void main()\n" +
			"{\n" +
			"	gl_FragColor = (" + VARYING_COLOR + "* texture2D(" + UNIFORM_TEXTURE + ", " + VARYING_TEXTURECOORDINATES + "));\n" +
			"}\n";

	/**
	 * Constructor for TextureShaderProgram. (Hidden).
	 */
	private TextureShaderProgram()
	{
		setVertexShader(new SourceShader(VERTEX_SHADER_SOURCE, Type.VERTEX));
		setFragmentShader(new SourceShader(FRAGMENT_SHADER_SOURCE, Type.FRAGMENT));
	}

	/**
	 * Get access to the TextureShaderProgram.
	 * @return The TextureShaderProgram.
	 */
	public static TextureShaderProgram getInstance()
	{
		if (instance == null)
		{
			instance = new TextureShaderProgram();
		}

		return instance;
	}
}
