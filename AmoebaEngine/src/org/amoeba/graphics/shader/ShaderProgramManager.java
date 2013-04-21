package org.amoeba.graphics.shader;

import java.util.ArrayList;

/**
 * ShaderProgramManager maintains a collection of shader programs.
 */
public class ShaderProgramManager
{
	private final ArrayList<ShaderProgram> programs;

	/**
	 * Constructor for ShaderProgramManager.
	 */
	public ShaderProgramManager()
	{
		programs = new ArrayList<ShaderProgram>();
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
	public void loadPrograms()
	{
		for (ShaderProgram program : programs)
		{
			program.compile();
			program.link();
		}
	}
}
