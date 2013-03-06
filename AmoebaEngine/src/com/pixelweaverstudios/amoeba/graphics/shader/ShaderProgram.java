package com.pixelweaverstudios.amoeba.graphics.shader;

import java.util.ArrayList;

import com.pixelweaverstudios.amoeba.graphics.utilities.ShaderUtilities;

/**
 * ShaderProgram is the base class for all programs.
 */
public abstract class ShaderProgram
{
	protected ArrayList<Shader> shaders;
	protected int handle;

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
}
