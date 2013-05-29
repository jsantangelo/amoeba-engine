package org.amoeba.entity.sprite.impl;

import org.amoeba.entity.EntityVertexBufferObject;
import org.amoeba.entity.sprite.Sprite;
import org.amoeba.geom.Dimension;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.impl.TextureShaderProgram;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.utilities.MatrixHelper;

import android.opengl.GLES20;

/**
 *
 */
public class TextureSprite extends Sprite
{
	private Texture texture;
	private EntityVertexBufferObject spriteBuffer;
	private TextureShaderProgram program;

	/**
	 * Constructor for Sprite.
	 * @param spriteTexture The texture on this sprite.
	 * @param textureProgram The program used to draw this sprite.
	 * @param vbo The vertex buffer object for the sprite.
	 */
	public TextureSprite(final Texture spriteTexture, final TextureShaderProgram textureProgram, final EntityVertexBufferObject vbo)
	{
		this(0f, 0f, spriteTexture, textureProgram, vbo);
	}

	/**
	 * Constructor for Sprite.
	 * @param x The x position of the sprite (left).
	 * @param y The y position of the sprite (top).
	 * @param spriteTexture The texture on this sprite.
	 * @param textureProgram The program used to draw this sprite.
	 * @param vbo The vertex buffer object for the sprite.
	 */
	public TextureSprite(final float x, final float y, final Texture spriteTexture, final TextureShaderProgram textureProgram, final EntityVertexBufferObject vbo)
	{
		super(x, y);
		texture = spriteTexture;
		program = textureProgram;
		spriteBuffer = vbo;
	}

	@Override
	public void load()
	{
		spriteBuffer.load();

		if (getWidth() == 0)
		{
			setWidth(texture.getWidth());
		}

		if (getHeight() == 0)
		{
			setHeight(texture.getHeight());
		}
	}

	@Override
	public void setColor(final int color)
	{
		spriteBuffer.setColor(color);
	}

	@Override
	public void setColor(final float red, final float green, final float blue, final float alpha)
	{
		spriteBuffer.setColor(red, green, blue, alpha);
	}

	@Override
	public int getColor()
	{
		return spriteBuffer.getColor();
	}

	@Override
	public void onDraw(final Camera camera)
	{
		program.use();

		final float[] modelMatrix = MatrixHelper.createMatrix(
				getPosition(),
				new Dimension(1.0f, 1.0f),
				0.0f);

		int textureUniformHandle = program.getUniformLocation(ShaderConstants.UNIFORM_TEXTURE);
		GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
		GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, texture.getHandle());
		GLES20.glUniform1i(textureUniformHandle, 0);

		spriteBuffer.bind();

		final float[] mvpMatrix = camera.calculateMVPMatrix(modelMatrix);
		int mvpMatrixHandle = program.getUniformLocation(ShaderConstants.UNIFORM_MVPMATRIX);
		GLES20.glUniformMatrix4fv(mvpMatrixHandle, 1, false, mvpMatrix, 0);

		spriteBuffer.draw();

		program.stopUsing();
	}
}
