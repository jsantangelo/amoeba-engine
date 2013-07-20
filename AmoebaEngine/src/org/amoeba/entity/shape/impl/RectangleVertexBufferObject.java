package org.amoeba.entity.shape.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.amoeba.entity.EntityVertexBufferObject;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.ShaderProgram;
import org.amoeba.graphics.utilities.BufferUtilities;
import org.amoeba.graphics.vbo.BufferConstants;
import org.amoeba.graphics.vbo.VertexBufferObjectAttribute;
import org.amoeba.graphics.vbo.VertexBufferObjectAttributeList;

import android.graphics.Color;
import android.opengl.GLES20;

/**
 * RectangleVertexBufferObject provides an implementation of a Entity VBO to be used for Rectangles.
 */
public class RectangleVertexBufferObject implements EntityVertexBufferObject
{
	private static final int NUMBER_VERTICES = 4;
	private static final int NUMBER_ATTRIBUTES = 2;
	private static final int POSITION_DATA_SIZE = 3;
	private static final int POSITION_OFFSET = 0;
	private static final int COLOR_DATA_SIZE = 4;
	private static final int COLOR_OFFSET = 3;
	private static final int RED_OFFSET = 0;
	private static final int GREEN_OFFSET = 1;
	private static final int BLUE_OFFSET = 2;
	private static final int ALPHA_OFFSET = 3;
	private static final int DATA_SIZE = POSITION_DATA_SIZE + COLOR_DATA_SIZE;
	private static final float MAX_COLOR_VALUE = 255.0f;
	private static final float[] DEFAULT_DATA = new float[]
	{
		// X,     Y,    Z,    R,    G,    B,    A
		-0.5f, 0.50f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f,
		-0.5f, -0.5f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f,
		0.50f, 0.50f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f,
		0.50f, -0.5f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f
	};

	private float[] shapeData;
	private int capacity;
	private FloatBuffer buffer;
	private VertexBufferObjectAttributeList attributeList;
	private boolean isLoaded;
	private final BufferUtilities bufferUtilities;
	private final ShaderProgram shaderProgram;

	/**
	 * Constructor for RectangleVertexBufferObject.
	 * @param program A shader program used to display shapes with only colors.
	 * @param utilities The utilities to be used.
	 */
	public RectangleVertexBufferObject(final ShaderProgram program, final BufferUtilities utilities)
	{
		shapeData = DEFAULT_DATA.clone();
		capacity = shapeData.length;
		bufferUtilities = utilities;
		shaderProgram = program;
		attributeList = null;
		buffer = null;
		isLoaded = false;
	}

	@Override
	public void load()
	{
		attributeList = new VertexBufferObjectAttributeList(NUMBER_ATTRIBUTES, bufferUtilities);
		attributeList.add(new VertexBufferObjectAttribute(
				shaderProgram.getAttributeLocation(ShaderConstants.ATTRIBUTE_POSITION),
				ShaderConstants.ATTRIBUTE_POSITION,
				POSITION_DATA_SIZE,
				GLES20.GL_FLOAT,
				POSITION_OFFSET,
				false));
		attributeList.add(new VertexBufferObjectAttribute(
				shaderProgram.getAttributeLocation(ShaderConstants.ATTRIBUTE_COLOR),
				ShaderConstants.ATTRIBUTE_COLOR,
				COLOR_DATA_SIZE,
				GLES20.GL_FLOAT,
				COLOR_OFFSET,
				false));

		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(capacity * BufferConstants.BYTES_PER_FLOAT);
		byteBuffer.order(ByteOrder.nativeOrder());
		buffer = byteBuffer.asFloatBuffer();
		buffer.put(shapeData).position(0);

		isLoaded = true;
	}

	@Override
	public void setColor(final int color)
	{
		if (color != getColor())
		{
			final float red = Color.red(color) / MAX_COLOR_VALUE;
			final float green = Color.green(color) / MAX_COLOR_VALUE;
			final float blue = Color.blue(color) / MAX_COLOR_VALUE;
			final float alpha = Color.alpha(color) / MAX_COLOR_VALUE;

			setColor(red, green, blue, alpha);
		}
	}

	@Override
	public void setColor(final float red, final float green, final float blue, final float alpha)
	{
		final int stride = DATA_SIZE;
		for (int i = 0; i < NUMBER_VERTICES; ++i)
		{
			shapeData[(i * stride) + COLOR_OFFSET + RED_OFFSET] = red;
			shapeData[(i * stride) + COLOR_OFFSET + GREEN_OFFSET] = green;
			shapeData[(i * stride) + COLOR_OFFSET + BLUE_OFFSET] = blue;
			shapeData[(i * stride) + COLOR_OFFSET + ALPHA_OFFSET] = alpha;
		}

		if (isLoaded)
		{
			buffer.position(0);
			buffer.put(shapeData).position(0);
		}
	}

	@Override
	public int getColor()
	{
		int red = (int) (shapeData[COLOR_OFFSET + RED_OFFSET] * MAX_COLOR_VALUE);
		int green = (int) (shapeData[COLOR_OFFSET + GREEN_OFFSET] * MAX_COLOR_VALUE);
		int blue = (int) (shapeData[COLOR_OFFSET + BLUE_OFFSET] * MAX_COLOR_VALUE);
		int alpha = (int) (shapeData[COLOR_OFFSET + ALPHA_OFFSET] * MAX_COLOR_VALUE);

		return Color.argb(alpha, red, green, blue);
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
		if (isLoaded)
		{
			attributeList.bind(buffer);
		}
	}

	@Override
	public void draw()
	{
		draw(GLES20.GL_TRIANGLE_STRIP, 0, NUMBER_VERTICES);
	}

	@Override
	public void draw(final int mode)
	{
		draw(mode, 0, NUMBER_VERTICES);
	}

	@Override
	public void draw(final int mode, final int count)
	{
		draw(mode, 0, count);
	}

	@Override
	public void draw(final int mode, final int offset, final int count)
	{
		if (isLoaded)
		{
			bufferUtilities.drawVertexBuffer(mode, offset, count);
		}
	}
}
