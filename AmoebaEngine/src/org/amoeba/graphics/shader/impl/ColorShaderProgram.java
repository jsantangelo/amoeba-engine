package org.amoeba.graphics.shader.impl;

import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.ShaderProgram;
import org.amoeba.graphics.utilities.ShaderUtilities;

/**
 * ColorShaderProgram is a program that is used to display a color.
 */
public class ColorShaderProgram extends ShaderProgram
{
	public static final String VERTEX_SHADER_SOURCE =
			"uniform mat4 " + ShaderConstants.UNIFORM_MVPMATRIX + ";\n" +
			"attribute vec4 " + ShaderConstants.ATTRIBUTE_POSITION + ";\n" +
			"attribute vec4 " + ShaderConstants.ATTRIBUTE_COLOR + ";\n" +
			"varying vec4 " + ShaderConstants.VARYING_COLOR + ";\n" +
			"void main()\n" +
			"{\n" +
			"	" + ShaderConstants.VARYING_COLOR + " = " + ShaderConstants.ATTRIBUTE_COLOR + ";\n" +
			"	gl_Position = " + ShaderConstants.UNIFORM_MVPMATRIX + "*" + ShaderConstants.ATTRIBUTE_POSITION + ";\n" +
			"}\n";

	public static final String FRAGMENT_SHADER_SOURCE =
			"precision mediump float;\n" +
			"varying vec4 " + ShaderConstants.VARYING_COLOR + ";\n" +
			"void main()\n" +
			"{\n" +
			"	gl_FragColor = " + ShaderConstants.VARYING_COLOR + ";\n" +
			"}\n";

	/**
	 * Constructor for TextureShaderProgram.
	 * @param shaderUtilities The utilities to be used with this shader.
	 */
	public ColorShaderProgram(final ShaderUtilities shaderUtilities)
	{
		setVertexShader(new SourceShader(VERTEX_SHADER_SOURCE, shaderUtilities.getVertexShaderId(), shaderUtilities));
		setFragmentShader(new SourceShader(FRAGMENT_SHADER_SOURCE, shaderUtilities.getFragmentShaderId(), shaderUtilities));
		setShaderUtilities(shaderUtilities);
	}
}
