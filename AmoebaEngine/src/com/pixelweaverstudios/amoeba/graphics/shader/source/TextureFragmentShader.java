package com.pixelweaverstudios.amoeba.graphics.shader.source;

import android.opengl.GLES20;

import com.pixelweaverstudios.amoeba.graphics.shader.Shader;
import com.pixelweaverstudios.amoeba.graphics.shader.ShaderConstants;

/**
 * TextureFragmentShader is a basic fragment shader that is used to display an unmodified texture.
 */
public class TextureFragmentShader extends Shader
{
	/**
	 * The constructor for TextureFragmentShader.
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
