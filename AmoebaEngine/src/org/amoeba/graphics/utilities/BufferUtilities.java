package org.amoeba.graphics.utilities;

import java.nio.Buffer;

import org.amoeba.graphics.vbo.VertexBufferObjectAttribute;

import android.opengl.GLES20;

/**
 * BufferUtilities contains OpenGL functions for VBOs.
 */
public final class BufferUtilities
{
	/**
	 * Constructor for BufferUtilities. (Hidden)
	 */
	private BufferUtilities()
	{

	}

	/**
	 * Bind a Vertex Buffer Attribute in OpenGL.
	 * @param attribute The attribute to be bound.
	 * @param buffer The buffer containing the data.
	 * @param stride The stride bytes for the buffer.
	 */
	public static void bindVertexAttribute(final VertexBufferObjectAttribute attribute, final Buffer buffer, final int stride)
	{
		GLES20.glVertexAttribPointer(attribute.getLocation(), attribute.getSize(), attribute.getType(), attribute.isNormalized(), stride, buffer);
		GLES20.glEnableVertexAttribArray(attribute.getLocation());
	}

	/**
	 * Render primitives from the stored data.
	 * @param mode The kind of primitives to render.
	 * @param offset The offset to the data to be rendered.
	 * @param count The number of vertices to be rendered.
	 */
	public static void drawVertexBuffer(final int mode, final int offset, final int count)
	{
		GLES20.glDrawArrays(mode, offset, count);
	}
}
