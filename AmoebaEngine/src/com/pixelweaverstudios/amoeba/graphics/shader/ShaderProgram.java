package com.pixelweaverstudios.amoeba.graphics.shader;

import java.util.ArrayList;

import com.pixelweaverstudios.amoeba.graphics.utilities.ShaderUtilities;

/**
 * @author Mike Testen
 * 
 */
public abstract class ShaderProgram
{
	protected ArrayList<Shader> shaders;
	protected int handle;

	/**
	 * 
	 */
	public void compile()
	{
		for(Shader shader : shaders)
		{
			if(shader.getHandle() > 0)
			{
				shader.compile();
			}
		}
	}
	
	/**
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
	 * 
	 */
	public void use()
	{
		ShaderUtilities.useProgram(handle);
	}

	/**
	 * @return Whether the program is currently in use.
	 */
	public boolean isInUse()
	{
		return(ShaderUtilities.isProgramInUse(handle));
	}
	
	/**
	 * 
	 */
	public void stopUsing()
	{
		if (isInUse())
		{
			ShaderUtilities.useProgram(0);
		}
	}

	/**
	 * @param attributeName
	 * @return The location handle of the attribute.
	 */
	public int getAttributeLocation(final String attributeName)
	{
		return ShaderUtilities.getAttributeLocation(handle, attributeName);
	}

	/**
	 * @param uniformName
	 * @return The location handle of the uniform.
	 */
	public int getUniformLocation(final String uniformName)
	{
		return ShaderUtilities.getUniformLocation(handle, uniformName);
	}

	/**
	 * @return The handle that represents the program.
	 */
	public int getHandle()
	{
		return handle;
	}
}
