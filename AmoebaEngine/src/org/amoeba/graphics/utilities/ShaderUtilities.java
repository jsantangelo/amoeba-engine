package org.amoeba.graphics.utilities;

import org.amoeba.graphics.shader.Shader;

/**
 * ShaderUtilities provides a wrapper around common texture related OpenGL functions.
 */
public interface ShaderUtilities
{

	/**
	 * Compile a shader given the source code and type.
	 * @param shaderSource The source code of the shader.
	 * @param shaderType The type of shader (e.g. Fragment or Vertex).
	 * @return The handle to the shader.
	 */
	public int compileShaderFromSource(final String shaderSource, final int shaderType);

	/**
	 * Generate a program handle.
	 * @return The OpenGL program handle.
	 */
	public int generateProgramHandle();

	/**
	 * Attach a shader to a program.
	 * @param programHandle The program with which the shader will be attached.
	 * @param shader The shader to be attached.
	 */
	public void attachShaderToProgram(final int programHandle, final Shader shader);

	/**
	 * Link a program with a given OpenGL program handle.
	 * @param handle The handle representing the program to be linked.
	 * @return Whether the linking was successful.
	 */
	public boolean linkProgram(final int handle);

	/**
	 * Use a program of a given handle.
	 * @param programHandle The handle representing the program to be used.
	 */
	public void useProgram(final int programHandle);

	/**
	 * Query OpenGL whether a given program is in use.
	 * @param programHandle The handle representing the program to be checked.
	 * @return Whether the program is currently in use.
	 */
	public boolean isProgramInUse(final int programHandle);

	/**
	 * Delete a program of a given handle.
	 * @param programHandle The handle representing the program to be deleted.
	 */
	public void deleteProgram(final int programHandle);

	/**
	 * Get the location of an attribute in a given program.
	 * @param programHandle The handle representing the program that contains the attribute.
	 * @param attributeName The name of the attribute that is being retrieved.
	 * @return The OpenGL handle of the attribute.
	 */
	public int getAttributeLocation(final int programHandle, final String attributeName);

	/**
	 * Get the location of a uniform in a given program.
	 * @param programHandle The handle representing the program that contains the uniform.
	 * @param uniformName The name of the uniform that is being retrieved.
	 * @return The OpenGL handle of the uniform.
	 */
	public int getUniformLocation(final int programHandle, final String uniformName);

	/**
	 * Get the OpenGL integer value for a Fragment Shader.
	 * @return The integer value representing GL_FRAGMENT_SHADER.
	 */
	public int getFragmentShaderId();

	/**
	 * Get the OpenGL integer value for a Vertex Shader.
	 * @return The integer value representing GL_VERTEX_SHADER.
	 */
	public int getVertexShaderId();
}
