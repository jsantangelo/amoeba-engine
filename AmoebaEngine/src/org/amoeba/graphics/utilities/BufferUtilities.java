package org.amoeba.graphics.utilities;

import java.nio.Buffer;

import org.amoeba.graphics.vbo.VertexBufferObjectAttribute;

/**
 * BufferUtilities contains OpenGL functions for VBOs.
 */
public interface BufferUtilities
{
	/**
	 * Bind a Vertex Buffer Attribute in OpenGL.
	 * @param attribute The attribute to be bound.
	 * @param buffer The buffer containing the data.
	 * @param stride The stride bytes for the buffer.
	 */
	public void bindVertexAttribute(final VertexBufferObjectAttribute attribute, final Buffer buffer, final int stride);

	/**
	 * Render primitives from the stored data.
	 * @param mode The kind of primitives to render.
	 * @param offset The offset to the data to be rendered.
	 * @param count The number of vertices to be rendered.
	 */
	public void drawVertexBuffer(final int mode, final int offset, final int count);
}
