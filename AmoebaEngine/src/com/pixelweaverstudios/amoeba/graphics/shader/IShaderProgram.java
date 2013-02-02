package com.pixelweaverstudios.amoeba.graphics.shader;

/**
 * @author Mike Testen
 * 
 */
public interface IShaderProgram
{
    /**
     * @return The handle that represents the program.
     */
    public int compileAndLink();

    /**
     * Tell OpenGL to start using this program.
     */
    public void use();

    /**
     * @return Whether the program is currently in use.
     */
    public boolean isInUse();

    /**
     * @param attributeName
     * @return The location handle of the attribute.
     */
    public int getAttributeLocation(final String attributeName);

    /**
     * @param uniformName
     * @return The location handle of the uniform.
     */
    public int getUniformLocation(final String uniformName);

    /**
     * @return The handle that represents the program.
     */
    public int getHandle();
}
