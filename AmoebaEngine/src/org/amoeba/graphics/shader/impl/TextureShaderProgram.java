package org.amoeba.graphics.shader.impl;

import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.ShaderProgram;
import org.amoeba.graphics.utilities.ShaderUtilities;

/**
 * TextureShaderProgram is a program that is used to display an unmodified texture.
 */
public class TextureShaderProgram extends ShaderProgram
{
	public static final String VERTEX_SHADER_SOURCE =
			"uniform mat4 " + ShaderConstants.UNIFORM_MVPMATRIX + ";\n" +
			"attribute vec4 " + ShaderConstants.ATTRIBUTE_POSITION + ";\n" +
			"attribute vec4 " + ShaderConstants.ATTRIBUTE_COLOR + ";\n" +
			"attribute vec2 " + ShaderConstants.ATTRIBUTE_TEXTURECOORDINATES + ";\n" +
			"varying vec4 " + ShaderConstants.VARYING_COLOR + ";\n" +
			"varying vec2 " + ShaderConstants.VARYING_TEXTURECOORDINATES + ";\n" +
			"void main()\n" +
			"{\n" +
			"	" + ShaderConstants.VARYING_COLOR + " = " + ShaderConstants.ATTRIBUTE_COLOR + ";\n" +
			"	" + ShaderConstants.VARYING_TEXTURECOORDINATES + "=" + ShaderConstants.ATTRIBUTE_TEXTURECOORDINATES + ";\n" +
			"	gl_Position = " + ShaderConstants.UNIFORM_MVPMATRIX + "*" + ShaderConstants.ATTRIBUTE_POSITION + ";\n" +
			"}\n";

	public static final String FRAGMENT_SHADER_SOURCE =
			"precision mediump float;\n" +
			"uniform sampler2D " + ShaderConstants.UNIFORM_TEXTURE + ";\n" +
			"varying vec4 " + ShaderConstants.VARYING_COLOR + ";\n" +
			"varying vec2 " + ShaderConstants.VARYING_TEXTURECOORDINATES + ";\n" +
			"void main()\n" +
			"{\n" +
			"	gl_FragColor = (" + ShaderConstants.VARYING_COLOR + "* texture2D(" + ShaderConstants.UNIFORM_TEXTURE + ", " + ShaderConstants.VARYING_TEXTURECOORDINATES + "));\n" +
			"}\n";

	/**
	 * Constructor for TextureShaderProgram.
	 * @param shaderUtilities The utilities to be used with this shader.
	 */
	public TextureShaderProgram(final ShaderUtilities shaderUtilities)
	{
		setVertexShader(new SourceShader(VERTEX_SHADER_SOURCE, shaderUtilities.getVertexShaderId(), shaderUtilities));
		setFragmentShader(new SourceShader(FRAGMENT_SHADER_SOURCE, shaderUtilities.getFragmentShaderId(), shaderUtilities));
		setShaderUtilities(shaderUtilities);
	}
}
