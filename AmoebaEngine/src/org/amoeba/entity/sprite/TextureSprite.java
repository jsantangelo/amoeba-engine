package org.amoeba.entity.sprite;

import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.source.TextureShaderProgram;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.utilities.ColorTransition;
import org.amoeba.graphics.utilities.MatrixHelper;

import android.opengl.GLES20;

/**
 *
 */
public class TextureSprite extends Sprite
{
	private static final int NUMBER_OF_VERTICES = 4;
	private Texture texture;
	private SpriteVertexBufferObject spriteBuffer;
	private TextureShaderProgram program;
	private ColorTransition colorTransition;

	/**
	 * Constructor for Sprite.
	 * @param spriteTexture The texture on this sprite.
	 * @param textureProgram The program used to draw this sprite.
	 */
	public TextureSprite(final Texture spriteTexture, final TextureShaderProgram textureProgram)
	{
		this(0f, 0f, spriteTexture, textureProgram);
	}

	/**
	 * Constructor for Sprite.
	 * @param x The x position of the sprite (left).
	 * @param y The y position of the sprite (top).
	 * @param spriteTexture The texture on this sprite.
	 * @param textureProgram The program used to draw this sprite.
	 */
	public TextureSprite(final float x, final float y, final Texture spriteTexture, final TextureShaderProgram textureProgram)
	{
		super(x, y, spriteTexture.getWidth(), spriteTexture.getHeight());
		texture = spriteTexture;
		program = textureProgram;
		colorTransition = null;
	}

	@Override
	public void load()
	{
		spriteBuffer = new SpriteVertexBufferObject(program);

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
	public void setColor(final int color, final long duration)
	{
		colorTransition = new ColorTransition(spriteBuffer.getColor(), color, duration);
	}

	@Override
	public void onUpdate()
	{
		if (colorTransition != null)
		{
			setColor(colorTransition.getCurrentColor());
			if (colorTransition.isTransitionComplete())
			{
				colorTransition = null;
			}
		}
	}

	@Override
	public void onDraw(final Camera camera)
	{
		program.use();

		final float[] modelMatrix = MatrixHelper.createMatrix(
				getPosition(),
				getScale(),
				getRotation());

		int textureUniformHandle = program.getUniformLocation(ShaderConstants.UNIFORM_TEXTURE);
		GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
		GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, texture.getHandle());
		GLES20.glUniform1i(textureUniformHandle, 0);

		spriteBuffer.bind();

		final float[] mvpMatrix = camera.calculateMVPMatrix(modelMatrix);
		int mvpMatrixHandle = program.getUniformLocation(ShaderConstants.UNIFORM_MVPMATRIX);
		GLES20.glUniformMatrix4fv(mvpMatrixHandle, 1, false, mvpMatrix, 0);

		spriteBuffer.draw(GLES20.GL_TRIANGLE_STRIP, NUMBER_OF_VERTICES);

		program.stopUsing();
	}
}
