package org.amoeba.graphics.shader.impl;

import org.amoeba.graphics.shader.Shader;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.utilities.ShaderUtilities;

import android.opengl.GLES20;


/**
 * TextureFragmentShader is a basic fragment shader that is used to display an unmodified texture.
 */
public class TextureFragmentShader extends Shader
{
	/**
	 * The constructor for TextureFragmentShader.
	 * @param shaderUtilities The utilities to be used with this shader.
	 */
	public TextureFragmentShader(final ShaderUtilities shaderUtilities)
	{
		setType(GLES20.GL_FRAGMENT_SHADER);
		setShaderUtilities(shaderUtilities);
		setHandle(-1);
		setSource(
			"precision mediump float;\n" +
			"uniform sampler2D " + ShaderConstants.UNIFORM_TEXTURE + ";\n" +
			"varying vec4 " + ShaderConstants.VARYING_COLOR + ";\n" +
			"varying vec2 " + ShaderConstants.VARYING_TEXTURECOORDINATES + ";\n" +
			"void main()\n" +
			"{\n" +
			"	gl_FragColor = (" + ShaderConstants.VARYING_COLOR + "* texture2D(" + ShaderConstants.UNIFORM_TEXTURE + ", " + ShaderConstants.VARYING_TEXTURECOORDINATES + "));\n" +
			"}\n");
	}
}
