package org.amoeba.entity.sprite;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.impl.TextureShaderProgram;
import org.amoeba.graphics.utilities.BufferUtilities;
import org.amoeba.graphics.vbo.BufferConstants;
import org.amoeba.graphics.vbo.VertexBufferObject;
import org.amoeba.graphics.vbo.VertexBufferObjectAttribute;
import org.amoeba.graphics.vbo.VertexBufferObjectAttributeList;

import android.graphics.Color;
import android.opengl.GLES20;

/**
 * SpriteVertexBufferObject provides a VBO that is used for sprites.
 */
public class SpriteVertexBufferObject implements VertexBufferObject
{
	private static final int NUMBER_VERTICES = 4;
	private static final int NUMBER_SPRITE_ATTRIBUTES = 3;
	private static final int POSITION_DATA_SIZE = 3;
	private static final int POSITION_OFFSET = 0;
	private static final int TEXTURE_COORDINATE_DATA_SIZE = 2;
	private static final int TEXTURE_COORDINATE_OFFSET = 3;
	private static final int COLOR_DATA_SIZE = 4;
	private static final int COLOR_OFFSET = 5;
	private static final int RED_OFFSET = 0;
	private static final int GREEN_OFFSET = 1;
	private static final int BLUE_OFFSET = 2;
	private static final int ALPHA_OFFSET = 3;
	private static final float MAX_COLOR_VALUE = 255.0f;
	private static final float[] DEFAULT_SPRITE_DATA = new float[]
	{
		// X,     Y,    Z,    U,    V,    R,    G,    B,    A
		-0.5f, 0.50f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
		-0.5f, -0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f,
		0.50f, 0.50f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
		0.50f, -0.5f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f
	};

	private float[] spriteData;
	private int capacity;
	private FloatBuffer spriteBuffer;
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

	/**
	 * Pack the color into the sprite buffer.
	 * @param color The new color of the sprite.
	 */
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

	/**
	 * Pack the color into the sprite buffer.
	 * @param red The red component of the color.
	 * @param green The green component of the color.
	 * @param blue The blue component of the color.
	 * @param alpha The alpha component of the color.
	 */
	public void setColor(final float red, final float green, final float blue, final float alpha)
	{
		final int stride = attributeList.getStrideBytes() / BufferConstants.BYTES_PER_FLOAT;
		for (int i = 0; i < NUMBER_VERTICES; ++i)
		{
			spriteData[(i * stride) + COLOR_OFFSET + RED_OFFSET] = red;
			spriteData[(i * stride) + COLOR_OFFSET + GREEN_OFFSET] = green;
			spriteData[(i * stride) + COLOR_OFFSET + BLUE_OFFSET] = blue;
			spriteData[(i * stride) + COLOR_OFFSET + ALPHA_OFFSET] = alpha;
		}
		spriteBuffer.position(0);
		spriteBuffer.put(spriteData).position(0);
	}

	/**
	 * Get the current color in the buffer.
	 * @return The color currently stored in the buffer in the form of android.graphics.Color.
	 */
	public int getColor()
	{
		int red = (int) (spriteData[COLOR_OFFSET + RED_OFFSET] * MAX_COLOR_VALUE);
		int green = (int) (spriteData[COLOR_OFFSET + GREEN_OFFSET] * MAX_COLOR_VALUE);
		int blue = (int) (spriteData[COLOR_OFFSET + BLUE_OFFSET] * MAX_COLOR_VALUE);
		int alpha = (int) (spriteData[COLOR_OFFSET + ALPHA_OFFSET] * MAX_COLOR_VALUE);

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
