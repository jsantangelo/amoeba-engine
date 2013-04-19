package org.amoeba.graphics.shader.impl;

import org.amoeba.graphics.shader.Shader;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.utilities.ShaderUtilities;

import android.opengl.GLES20;


/**
 * TextureVertexShader is a basic vertex shader that is used to display an unmodified texture.
 */
public class TextureVertexShader extends Shader
{
	/**
	 * Constructor for TextureVertexShader.
	 * @param shaderUtilities The utilities to be used with this shader.
	 */
	public TextureVertexShader(final ShaderUtilities shaderUtilities)
	{
		setType(GLES20.GL_VERTEX_SHADER);
		setShaderUtilities(shaderUtilities);
		setHandle(-1);
		setSource(
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
			"}\n");
	}
}
