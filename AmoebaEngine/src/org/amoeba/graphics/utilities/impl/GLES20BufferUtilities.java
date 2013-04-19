package org.amoeba.graphics.utilities.impl;

import java.nio.Buffer;

import org.amoeba.graphics.utilities.BufferUtilities;
import org.amoeba.graphics.vbo.VertexBufferObjectAttribute;

import android.opengl.GLES20;

/**
 * GLES20BufferUtilities provides an implementation of the BufferUtilities routines
 * using OpenGL ES 2.0.
 */
public class GLES20BufferUtilities implements BufferUtilities
{
	/**
	 * Constructor for BufferUtilities.
	 */
	public GLES20BufferUtilities()
	{

	}

	/**
	 * Bind a Vertex Buffer Attribute in OpenGL.
	 * @param attribute The attribute to be bound.
	 * @param buffer The buffer containing the data.
	 * @param stride The stride bytes for the buffer.
	 */
	public void bindVertexAttribute(final VertexBufferObjectAttribute attribute, final Buffer buffer, final int stride)
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
	public void drawVertexBuffer(final int mode, final int offset, final int count)
	{
		GLES20.glDrawArrays(mode, offset, count);
	}
}
