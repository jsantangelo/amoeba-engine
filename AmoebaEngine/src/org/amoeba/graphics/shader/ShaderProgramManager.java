package org.amoeba.graphics.shader;

import java.util.ArrayList;

import org.amoeba.graphics.utilities.ShaderUtilities;

/**
 * ShaderProgramManager maintains a collection of shader programs.
 */
public class ShaderProgramManager
{
	private final ArrayList<ShaderProgram> programs;
	private final ShaderUtilities utilities;

	/**
	 * Constructor for ShaderProgramManager.
	 * @param shaderUtilities The utilities to use with shaders.
	 */
	public ShaderProgramManager(final ShaderUtilities shaderUtilities)
	{
		programs = new ArrayList<ShaderProgram>();
		utilities = shaderUtilities;
	}

	/**
	 * Add a program to the collection.
	 * @param program The shader program to be added to the collection.
	 */
	public void add(final ShaderProgram program)
	{
		if (program != null)
		{
			programs.add(program);
		}
	}

	/**
	 * Load all programs in the collection.
	 */
	public void loadAll()
	{
		for (ShaderProgram program : programs)
		{
			program.initialize(utilities);
			program.compile();
			program.link();
		}
	}

	/**
	 * Return whether a program is maintained by the ShaderProgramManager.
	 * @param shaderProgram The program to search for.
	 * @return Whether the program exists in the collection.
	 */
	public boolean hasProgram(final ShaderProgram shaderProgram)
	{
		boolean found = false;
		for (ShaderProgram program : programs)
		{
			if (program == shaderProgram)
			{
				found = true;
				break;
			}
		}

		return found;
	}
}
