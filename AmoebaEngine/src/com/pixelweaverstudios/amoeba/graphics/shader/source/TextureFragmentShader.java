package com.pixelweaverstudios.amoeba.graphics.shader.source;

import android.opengl.GLES20;

import com.pixelweaverstudios.amoeba.graphics.shader.Shader;
import com.pixelweaverstudios.amoeba.graphics.shader.ShaderConstants;

/**
 * @author Mike Testen
 *
 */
public class TextureFragmentShader extends Shader
{
	/**
	 * 
	 */
	public TextureFragmentShader()
	{
		type = GLES20.GL_FRAGMENT_SHADER;
		handle = -1;
		source = 
			"precision mediump float;\n" +
			"uniform sampler2D " + ShaderConstants.UNIFORM_TEXTURE + ";\n" +
			"varying vec4 " + ShaderConstants.VARYING_COLOR + ";\n" +
			"varying vec2 " + ShaderConstants.VARYING_TEXTURECOORDINATES + ";\n" +
			"void main()\n" +
			"{\n" +
			"	gl_FragColor = (" + ShaderConstants.VARYING_COLOR + "* texture2D(" + ShaderConstants.UNIFORM_TEXTURE + ", " + ShaderConstants.VARYING_TEXTURECOORDINATES + "));\n" +
			"}\n";
	}
}
