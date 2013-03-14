package org.amoeba.graphics.vbo;

import java.nio.Buffer;

import org.amoeba.graphics.utilities.BufferUtilities;

/**
 * VertexBufferObjectAttributeList is a container for multiple VertexBufferObjectAttributes.
 */
public class VertexBufferObjectAttributeList
{
	private int strideBytes;
	private VertexBufferObjectAttribute[] attributes;
	private int numAttributes;

	/**
	 * Constructor for VertexBufferObjectAttributeList.
	 * @param size The number of attributes in the list.
	 */
	public VertexBufferObjectAttributeList(final int size)
	{
		attributes = new VertexBufferObjectAttribute[size];
		strideBytes = 0;
		numAttributes = 0;
	}

	/**
	 * Get the attributes in the list.
	 * @return The attributes in the list.
	 */
	public VertexBufferObjectAttribute[] getAttributes()
	{
		return attributes;
	}

	/**
	 * Get the number of stride bytes.
	 * @return The number of stride bytes for the VBO.
	 */
	public int getStrideBytes()
	{
		return strideBytes;
	}

	/**
	 * Add an attribute to the list.
	 * @param attribute The attribute to be added.
	 */
	public void add(final VertexBufferObjectAttribute attribute)
	{
		attributes[numAttributes] = attribute;
		strideBytes += attribute.getSize() * BufferConstants.BYTES_PER_FLOAT;
		++numAttributes;
	}

	/**
	 * Add an attribute to the list.
	 * @param attribLocation The location of the attribute.
	 * @param attribName The name of the attribute.
	 * @param attribSize The size of the attribute.
	 * @param attribType The type of the attribute.
	 * @param attribOffset The offset of the attribute.
	 * @param attribNormalized Whether the attribute is normalized.
	 */
	public void add(final int attribLocation, final String attribName, final int attribSize, final int attribType, final int attribOffset, final boolean attribNormalized)
	{
		this.add(new VertexBufferObjectAttribute(attribLocation, attribName, attribSize, attribType, attribOffset, attribNormalized));
	}

	/**
	 * Bind the attributes to OpenGL.
	 * @param buffer The buffer data.
	 */
	public void bind(final Buffer buffer)
	{
		for (VertexBufferObjectAttribute attribute : attributes)
		{
			buffer.position(attribute.getOffset());
			BufferUtilities.bindVertexAttribute(attribute, buffer, strideBytes);
		}
	}
}
