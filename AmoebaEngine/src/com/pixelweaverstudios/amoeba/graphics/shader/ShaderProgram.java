package com.pixelweaverstudios.amoeba.graphics.shader;

import java.util.ArrayList;

import com.pixelweaverstudios.amoeba.graphics.utilities.ShaderUtilities;

/**
 * @author Mike Testen
 * 
 */
public class ShaderProgram implements IShaderProgram
{
	private ArrayList<Shader> shaders;
	private int handle;

	/**
	 * @param shaders
	 */
	public ShaderProgram(final ArrayList<Shader> shaders)
	{
		if (shaders.size() <= 0)
		{
			throw new RuntimeException("No shaders were provided to create the program.");
		}

		this.shaders = shaders;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.shader.IShaderProgram#compileAndLink()
	 */
	public int compileAndLink()
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
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.shader.IShaderProgram#use()
	 */
	public void use()
	{
		ShaderUtilities.useProgram(handle);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.shader.IShaderProgram#isInUse()
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
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.shader.IShaderProgram#getAttributeLocation(java.lang.String)
	 */
	public int getAttributeLocation(final String attributeName)
	{
		return ShaderUtilities.getAttributeLocation(handle, attributeName);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.shader.IShaderProgram#getUniformLocation(java.lang.String)
	 */
	public int getUniformLocation(final String uniformName)
	{
		return ShaderUtilities.getUniformLocation(handle, uniformName);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.pixelweaverstudios.amoeba.graphics.shader.IShaderProgram#getHandle()
	 */
	public int getHandle()
	{
		return handle;
	}
}
