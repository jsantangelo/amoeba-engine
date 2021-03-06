package org.amoeba.graphics.shader;

import org.amoeba.graphics.utilities.ShaderUtilities;

/**
 * Shader is a base class for all shaders.
 */
public abstract class Shader
{
	/**
	 * Types of shaders (Vertex or Fragment).
	 */
	public enum Type
	{
		VERTEX,
		FRAGMENT
	};

	private String source;
	private int handle;
	private Type type;

	/**
	 * Get the source code for the shader.
	 * @return The source code of the shader.
	 */
	public String getSource()
	{
		return source;
	}

	/**
	 * Get the type of the shader.
	 * @return The type of the shader (Vertex or Fragment).
	 */
	public Type getType()
	{
		return type;
	}

	/**
	 * Get the handle of the shader.
	 * @return The handle that represents the shader.
	 */
	public int getHandle()
	{
		return handle;
	}

	/**
	 * Compile the shader.
	 * @param shaderUtilities The utilities used to compile the shader.
	 */
	public void compile(final ShaderUtilities shaderUtilities)
	{
		handle = shaderUtilities.compileShaderFromSource(source, type);
	}

	/**
	 * Set the source of the shader.
	 * @param shaderSource The new shader source.
	 */
	protected void setSource(final String shaderSource)
	{
		source = shaderSource;
	}

	/**
	 * Set the type of the shader.
	 * @param shaderType The new shader type.
	 */
	protected void setType(final Type shaderType)
	{
		type = shaderType;
	}

	/**
	 * Set the handle of the shader.
	 * @param shaderHandle The new shader handle.
	 */
	protected void setHandle(final int shaderHandle)
	{
		handle = shaderHandle;
	}
}
