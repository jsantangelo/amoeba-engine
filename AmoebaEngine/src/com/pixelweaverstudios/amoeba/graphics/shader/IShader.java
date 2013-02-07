package com.pixelweaverstudios.amoeba.graphics.shader;

/**
 * @author Mike Testen
 * 
 */
public interface IShader
{
	/**
	 * @return The source code of the shader.
	 */
	public String getSource();

	/**
	 * @return The type of the shader (Vertex or Fragment).
	 */
	public int getType();

	/**
	 * @return The handle that represents the shader.
	 */
	public int getHandle();
}
