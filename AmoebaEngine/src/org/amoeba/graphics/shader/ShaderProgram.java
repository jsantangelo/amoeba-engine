package org.amoeba.graphics.shader;

import java.util.ArrayList;

import org.amoeba.graphics.utilities.ShaderUtilities;


/**
 * ShaderProgram is the base class for all programs.
 */
public abstract class ShaderProgram
{
	private ArrayList<Shader> shaders;
	private int handle;

	/**
	 * Compile all shaders in the program.
	 */
	public void compile()
	{
		for (Shader shader : shaders)
		{
			if (shader.getHandle() > 0)
			{
				shader.compile();
			}
		}
	}

	/**
	 * Link the shaders in the program.
	 * @return The handle that represents the program.
	 */
	public int link()
	{
		handle = ShaderUtilities.generateProgramHandle();
		ShaderUtilities.attachShadersToProgram(handle, shaders);

		if (!ShaderUtilities.linkProgram(handle))
		{
			ShaderUtilities.deleteProgram(handle);
			handle = 0;
		}

		return handle;
	}

	/**
	 * Use the program.
	 */
	public void use()
	{
		ShaderUtilities.useProgram(handle);
	}

	/**
	 * Determine whether the program is currently in use.
	 * @return Whether the program is currently in use.
	 */
	public boolean isInUse()
	{
		return (ShaderUtilities.isProgramInUse(handle));
	}

	/**
	 * Stop using the program if it is currently in use.
	 */
	public void stopUsing()
	{
		if (isInUse())
		{
			ShaderUtilities.useProgram(0);
		}
	}

	/**
	 * Retrieve the location of an attribute in the program.
	 * @param attributeName The name of the attribute to be retrieved.
	 * @return The location handle of the attribute.
	 */
	public int getAttributeLocation(final String attributeName)
	{
		return ShaderUtilities.getAttributeLocation(handle, attributeName);
	}

	/**
	 * Retrieve the location of a uniform in the program.
	 * @param uniformName The name of the uniform to be retrieved.
	 * @return The location handle of the uniform.
	 */
	public int getUniformLocation(final String uniformName)
	{
		return ShaderUtilities.getUniformLocation(handle, uniformName);
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
	 * Get the shaders for the program.
	 * @return The shaders of this program.
	 */
	protected ArrayList<Shader> getShaders()
	{
		return shaders;
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
	 * Set the shaders that make up this program.
	 * @param programShaders The shaders that make up the program.
	 */
	protected void setShaders(final ArrayList<Shader> programShaders)
	{
		shaders = programShaders;
	}
}
