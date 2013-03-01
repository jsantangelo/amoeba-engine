package com.pixelweaverstudios.amoeba.graphics.shader.source;

import java.util.ArrayList;

import com.pixelweaverstudios.amoeba.graphics.shader.Shader;
import com.pixelweaverstudios.amoeba.graphics.shader.ShaderProgram;

public class TextureShaderProgram extends ShaderProgram
{
	public TextureShaderProgram()
	{
		shaders = new ArrayList<Shader>();
		shaders.add(new TextureVertexShader());
		shaders.add(new TextureFragmentShader());
	}
}
