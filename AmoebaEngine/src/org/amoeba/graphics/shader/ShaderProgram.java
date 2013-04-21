package org.amoeba.graphics.shader;

import org.amoeba.graphics.utilities.ShaderUtilities;

/**
 * ShaderProgram is the base class for all programs.
 */
public abstract class ShaderProgram
{
	private ShaderUtilities shaderUtilities;
	private Shader fragmentShader;
	private Shader vertexShader;
	private int handle;

	/**
	 * Compile all shaders in the program.
	 */
	public void compile()
	{
		fragmentShader.compile();
		vertexShader.compile();
	}

	/**
	 * Link the shaders in the program.
	 * @return The handle that represents the program.
	 */
	public int link()
	{
		handle = shaderUtilities.generateProgramHandle();
		shaderUtilities.attachShaderToProgram(handle, vertexShader);
		shaderUtilities.attachShaderToProgram(handle, fragmentShader);

		if (!shaderUtilities.linkProgram(handle))
		{
			shaderUtilities.deleteProgram(handle);
			handle = 0;
		}

		return handle;
	}

	/**
	 * Use the program.
	 */
	public void use()
	{
		shaderUtilities.useProgram(handle);
	}

	/**
	 * Determine whether the program is currently in use.
	 * @return Whether the program is currently in use.
	 */
	public boolean isInUse()
	{
		return (shaderUtilities.isProgramInUse(handle));
	}

	/**
	 * Stop using the program if it is currently in use.
	 */
	public void stopUsing()
	{
		if (isInUse())
		{
			shaderUtilities.useProgram(0);
		}
	}

	/**
	 * Retrieve the location of an attribute in the program.
	 * @param attributeName The name of the attribute to be retrieved.
	 * @return The location handle of the attribute.
	 */
	public int getAttributeLocation(final String attributeName)
	{
		return shaderUtilities.getAttributeLocation(handle, attributeName);
	}

	/**
	 * Retrieve the location of a uniform in the program.
	 * @param uniformName The name of the uniform to be retrieved.
	 * @return The location handle of the uniform.
	 */
	public int getUniformLocation(final String uniformName)
	{
		return shaderUtilities.getUniformLocation(handle, uniformName);
	}

	/**
	 * Get the handle for the program.
	 * @return The handle that represents the program.
	 */
	public int getHandle()
	{
		return handle;
	}

	/**
	 * Get the fragment shader for the program.
	 * @return The fragment shader for this program.
	 */
	protected Shader getFragmentShader()
	{
		return fragmentShader;
	}

	/**
	 * Get the vertex shader for the program.
	 * @return The vertex shader for this program.
	 */
	protected Shader getVertexShader()
	{
		return vertexShader;
	}

	/**
	 * Set the handle that represents this program.
	 * @param programHandle The handle that represents this program.
	 */
	protected void setHandle(final int programHandle)
	{
		handle = programHandle;
	}

	/**
	 * Set the fragment shader for this program.
	 * @param shader The fragment shader for this program.
	 */
	protected void setFragmentShader(final Shader shader)
	{
		fragmentShader = shader;
	}

	/**
	 * Set the vertex shader for this program.
	 * @param shader The vertex shader for this program.
	 */
	protected void setVertexShader(final Shader shader)
	{
		vertexShader = shader;
	}

	/**
	 * Set the shader utilities to use with this program.
	 * @param utilities The shader utilities to use.
	 */
	protected void setShaderUtilities(final ShaderUtilities utilities)
	{
		shaderUtilities = utilities;
	}
}
