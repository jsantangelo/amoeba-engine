package org.amoeba.graphics.vbo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.amoeba.graphics.utilities.BufferUtilities;

/**
 * FloatVertexBufferObject is an implementation of a VBO for data made up of floats.
 */
public class FloatVertexBufferObject implements VertexBufferObject
{
	private float[] data;
	private final FloatBuffer floatBuffer;
	private int capacity;
	private VertexBufferObjectAttributeList attributeList;

	/**
	 * Constructor for FloatVertexBufferObject with no initial data.
	 * @param bufferCapacity The capacity of the buffer.
	 * @param attributes The list of attributes contained in this VBO.
	 */
	public FloatVertexBufferObject(final int bufferCapacity, final VertexBufferObjectAttributeList attributes)
	{
		this(bufferCapacity, attributes, new float[bufferCapacity]);
	}

	/**
	 * Constructor for FloatVertexBufferObject with an initial set of data.
	 * @param bufferCapacity The capacity of the buffer.
	 * @param attributes The list of attributes contained in this VBO.
	 * @param bufferData The initial data contained in the VBO.
	 */
	public FloatVertexBufferObject(final int bufferCapacity, final VertexBufferObjectAttributeList attributes, final float[] bufferData)
	{
		capacity = bufferCapacity;
		data = bufferData;
		attributeList = attributes;

		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(capacity * BufferConstants.BYTES_PER_FLOAT);
		byteBuffer.order(ByteOrder.nativeOrder());
		floatBuffer = byteBuffer.asFloatBuffer();
	}

	/**
	 * Get the buffer data for this VBO.
	 * @return The buffer data.
	 */
	public float[] getBufferData()
	{
		return data;
	}

	/**
	 * Set the buffer data for this VBO.
	 * @param bufferData The new buffer data.
	 */
	public void setBufferData(final float[] bufferData)
	{
		data = bufferData;
		floatBuffer.put(data);
		floatBuffer.position(0);
	}

	@Override
	public int getCapacity()
	{
		return capacity;
	}

	@Override
	public int getByteCapacity()
	{
		return capacity * BufferConstants.BYTES_PER_FLOAT;
	}

	@Override
	public void bind()
	{
		attributeList.bind(floatBuffer);
	}

	@Override
	public void draw(final int mode, final int count)
	{
		BufferUtilities.drawVertexBuffer(mode, 0, count);
	}

	@Override
	public void draw(final int mode, final int offset, final int count)
	{
		BufferUtilities.drawVertexBuffer(mode, offset, count);
	}
}
