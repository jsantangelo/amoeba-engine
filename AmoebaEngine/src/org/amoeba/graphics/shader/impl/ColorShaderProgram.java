package org.amoeba.graphics.shader.impl;

import static org.amoeba.graphics.shader.ShaderConstants.ATTRIBUTE_COLOR;
import static org.amoeba.graphics.shader.ShaderConstants.ATTRIBUTE_POSITION;
import static org.amoeba.graphics.shader.ShaderConstants.UNIFORM_MVPMATRIX;
import static org.amoeba.graphics.shader.ShaderConstants.VARYING_COLOR;

import org.amoeba.graphics.shader.Shader.Type;
import org.amoeba.graphics.shader.ShaderProgram;

/**
 * ColorShaderProgram is a program that is used to display a color.
 */
public final class ColorShaderProgram extends ShaderProgram
{

	private static ColorShaderProgram instance = null;

	public static final String VERTEX_SHADER_SOURCE =
			"uniform mat4 " + UNIFORM_MVPMATRIX + ";\n" +
			"attribute vec4 " + ATTRIBUTE_POSITION + ";\n" +
			"attribute vec4 " + ATTRIBUTE_COLOR + ";\n" +
			"varying vec4 " + VARYING_COLOR + ";\n" +
			"void main()\n" +
			"{\n" +
			"	" + VARYING_COLOR + " = " + ATTRIBUTE_COLOR + ";\n" +
			"	gl_Position = " + UNIFORM_MVPMATRIX + "*" + ATTRIBUTE_POSITION + ";\n" +
			"}\n";

	public static final String FRAGMENT_SHADER_SOURCE =
			"precision mediump float;\n" +
			"varying vec4 " + VARYING_COLOR + ";\n" +
			"void main()\n" +
			"{\n" +
			"	gl_FragColor = " + VARYING_COLOR + ";\n" +
			"}\n";

	/**
	 * Constructor for ColorShaderProgram.
	 */
	private ColorShaderProgram()
	{
		setVertexShader(new SourceShader(VERTEX_SHADER_SOURCE, Type.VERTEX));
		setFragmentShader(new SourceShader(FRAGMENT_SHADER_SOURCE, Type.FRAGMENT));
	}

	/**
	 * Get access to the ColorShaderProgram.
	 * @return The ColorShaderProgram.
	 */
	public static ColorShaderProgram getInstance()
	{
		if (instance == null)
		{
			instance = new ColorShaderProgram();
		}

		return instance;
	}
}
