package com.pixelweaverstudios.amoeba.graphics.shader.source;

import android.opengl.GLES20;

import com.pixelweaverstudios.amoeba.graphics.shader.Shader;
import com.pixelweaverstudios.amoeba.graphics.shader.ShaderConstants;

public class TextureVertexShader extends Shader
{
	/**
	 * 
	 */
	public TextureVertexShader()
	{
		type = GLES20.GL_VERTEX_SHADER;
		handle = -1;
		source = 
			"uniform mat4 " + ShaderConstants.UNIFORM_MVPMATRIX + ";\n" +
			"attribute vec4 " + ShaderConstants.ATTRIBUTE_POSITION + ";\n" +
			"attribute vec4 " + ShaderConstants.ATTRIBUTE_COLOR + ";\n" +
			"attribute vec2 " + ShaderConstants.ATTRIBUTE_TEXTURECOORDINATES + ";\n" +
			"varying vec4" + ShaderConstants.VARYING_COLOR + ";\n" +
			"varying vec2" + ShaderConstants.VARYING_TEXTURECOORDINATES + ";\n" +
			"void main()\n" +
			"{\n" +
			"	" + ShaderConstants.VARYING_COLOR + " = " + ShaderConstants.ATTRIBUTE_COLOR + ";\n" +
			"	" + ShaderConstants.VARYING_TEXTURECOORDINATES + "=" + ShaderConstants.ATTRIBUTE_TEXTURECOORDINATES + ";\n" +
			"	gl_Position = " + ShaderConstants.UNIFORM_MVPMATRIX + "*" + ShaderConstants.ATTRIBUTE_POSITION + ";\n" +
			"}\n";
	}
}
