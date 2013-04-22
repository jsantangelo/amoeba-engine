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

	/**
	 * Get a program given the vertex and fragment shaders' source.
	 * @param vertexShader The source of the vertex shader.
	 * @param fragmentShader The source of the fragment shader.
	 * @return The program if it was found in the collection.
	 */
	public ShaderProgram getProgram(final String vertexShader, final String fragmentShader)
	{
		ShaderProgram foundProgram = null;

		for (ShaderProgram program : programs)
		{
			if (program.getVertexShader().getSource() == vertexShader &&
					program.getFragmentShader().getSource() == fragmentShader)
			{
				foundProgram = program;
				break;
			}
		}

		return foundProgram;
	}
}
