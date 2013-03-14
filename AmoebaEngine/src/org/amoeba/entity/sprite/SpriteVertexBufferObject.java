package org.amoeba.entity.sprite;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.source.TextureShaderProgram;
import org.amoeba.graphics.utilities.BufferUtilities;
import org.amoeba.graphics.vbo.BufferConstants;
import org.amoeba.graphics.vbo.VertexBufferObject;
import org.amoeba.graphics.vbo.VertexBufferObjectAttribute;
import org.amoeba.graphics.vbo.VertexBufferObjectAttributeList;

import android.opengl.GLES20;

/**
 * SpriteVertexBufferObject provides a VBO that is used for sprites.
 */
public class SpriteVertexBufferObject implements VertexBufferObject
{
	private static final int POSITION_DATA_SIZE = 3;
	private static final int POSITION_OFFSET = 0;
	private static final int TEXTURE_COORDINATE_DATA_SIZE = 2;
	private static final int TEXTURE_COORDINATE_OFFSET = 3;
	private static final int COLOR_DATA_SIZE = 4;
	private static final int COLOR_OFFSET = 5;
	private static final int NUMBER_SPRITE_ATTRIBUTES = 3;
	private static final float[] DEFAULT_SPRITE_DATA = new float[]
	{
		// X,     Y,    Z,    U,    V,    R,    G,    B,    A
		-0.5f, 0.50f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f,
		-0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
		0.50f, 0.50f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f,
		0.50f, -0.5f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f
	};

	private float[] spriteData;
	private int capacity;
	private final FloatBuffer spriteBuffer;
	private VertexBufferObjectAttributeList attributeList;

	/**
	 * Constructor for SpriteVertexBufferObject.
	 * @param program A shader program used to display textures.
	 */
	public SpriteVertexBufferObject(final TextureShaderProgram program)
	{
		spriteData = DEFAULT_SPRITE_DATA;
		capacity = spriteData.length;

		attributeList = new VertexBufferObjectAttributeList(NUMBER_SPRITE_ATTRIBUTES);
		attributeList.add(new VertexBufferObjectAttribute(
				program.getAttributeLocation(ShaderConstants.ATTRIBUTE_POSITION),
				ShaderConstants.ATTRIBUTE_POSITION,
				POSITION_DATA_SIZE,
				GLES20.GL_FLOAT,
				POSITION_OFFSET,
				false));
		attributeList.add(new VertexBufferObjectAttribute(
				program.getAttributeLocation(ShaderConstants.ATTRIBUTE_COLOR),
				ShaderConstants.ATTRIBUTE_COLOR,
				COLOR_DATA_SIZE,
				GLES20.GL_FLOAT,
				COLOR_OFFSET,
				false));
		attributeList.add(new VertexBufferObjectAttribute(
				program.getAttributeLocation(ShaderConstants.ATTRIBUTE_TEXTURECOORDINATES),
				ShaderConstants.ATTRIBUTE_TEXTURECOORDINATES,
				TEXTURE_COORDINATE_DATA_SIZE,
				GLES20.GL_FLOAT,
				TEXTURE_COORDINATE_OFFSET,
				false));

		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(capacity * BufferConstants.BYTES_PER_FLOAT);
		byteBuffer.order(ByteOrder.nativeOrder());
		spriteBuffer = byteBuffer.asFloatBuffer();
		spriteBuffer.put(spriteData).position(0);
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
		attributeList.bind(spriteBuffer);
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
