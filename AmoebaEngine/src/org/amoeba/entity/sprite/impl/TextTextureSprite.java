package org.amoeba.entity.sprite.impl;

import org.amoeba.entity.EntityVertexBufferObject;
import org.amoeba.entity.sprite.TextSprite;
import org.amoeba.geom.Dimension;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.impl.TextureShaderProgram;
import org.amoeba.graphics.texture.impl.TextTexture;
import org.amoeba.graphics.utilities.MatrixHelper;

import android.opengl.GLES20;

/**
 * TextTextureSprite provides an implementation of TextSprite using textures.
 */
public class TextTextureSprite extends TextSprite
{
	private TextTexture texture;
	private TextureShaderProgram program;
	private boolean reloadNeeded;

	/**
	 * Constructor for TextTextureSprite.
	 * @param textTexture The texture on this sprite.
	 * @param textureProgram The program used to draw this sprite.
	 * @param vbo The vertex buffer object for the sprite.
	 */
	public TextTextureSprite(final TextTexture textTexture, final TextureShaderProgram textureProgram, final EntityVertexBufferObject vbo)
	{
		this(0f, 0f, textTexture, textureProgram, vbo);
	}

	/**
	 * Constructor for TextTextureSprite.
	 * @param x The x position of the sprite (center).
	 * @param y The y position of the sprite (center).
	 * @param textTexture The texture on this sprite.
	 * @param textureProgram The program used to draw this sprite.
	 * @param vbo The vertex buffer object for the sprite.
	 */
	public TextTextureSprite(final float x, final float y, final TextTexture textTexture, final TextureShaderProgram textureProgram, final EntityVertexBufferObject vbo)
	{
		super(textTexture.getText(), x, y, vbo);
		texture = textTexture;
		program = textureProgram;
		reloadNeeded = false;
	}

	@Override
	public void load()
	{
		super.load();

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
	public void onDraw(final Camera camera)
	{
		program.use();

		Dimension scale = new Dimension(getWidth() * getScale().getWidth(), getHeight() * getScale().getHeight());
		final float[] modelMatrix = MatrixHelper.createMatrix(
				getPosition(),
				scale,
				getRotation());

		int textureUniformHandle = program.getUniformLocation(ShaderConstants.UNIFORM_TEXTURE);
		GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
		GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, texture.getHandle());
		GLES20.glUniform1i(textureUniformHandle, 0);

		getBuffer().bind();

		final float[] mvpMatrix = camera.calculateMVPMatrix(modelMatrix);
		int mvpMatrixHandle = program.getUniformLocation(ShaderConstants.UNIFORM_MVPMATRIX);
		GLES20.glUniformMatrix4fv(mvpMatrixHandle, 1, false, mvpMatrix, 0);

		getBuffer().draw();

		program.stopUsing();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (reloadNeeded)
		{
			texture.unload();
			texture.load();

			if (getWidth() == 0)
			{
				setWidth(texture.getWidth());
			}

			if (getHeight() == 0)
			{
				setHeight(texture.getHeight());
			}

			reloadNeeded = false;
		}
	}

	@Override
	public void setText(final String text)
	{
		super.setText(text);
		texture.setText(text);
		reloadNeeded = true;
	}
}
