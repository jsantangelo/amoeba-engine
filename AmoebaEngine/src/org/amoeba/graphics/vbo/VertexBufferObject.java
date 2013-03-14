package org.amoeba.graphics.vbo;

/**
 * A VertexBufferObject is a container for vertex data.
 */
public interface VertexBufferObject
{
	/**
	 * Get the capacity of the VBO.
	 * @return The capacity of the VBO.
	 */
	public int getCapacity();

	/**
	 * Get the capacity of the VBO in bytes.
	 * @return The capacity of the VBO in bytes.
	 */
	public int getByteCapacity();

	/**
	 * Bind the VBO attributes to hardware.
	 */
	public void bind();

	/**
	 * Render primitives from the stored data.
	 * @param mode The kind of primitives to render.
	 * @param count The number of vertices to be rendered.
	 */
	public void draw(final int mode, final int count);

	/**
	 * Render primitives from the stored data.
	 * @param mode The kind of primitives to render.
	 * @param offset The offset to the data to be rendered.
	 * @param count The number of vertices to be rendered.
	 */
	public void draw(final int mode, final int offset, final int count);
}
