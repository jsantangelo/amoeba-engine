package org.amoeba.entity.sprite;

import org.amoeba.entity.shape.Rectangle;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.source.TextureShaderProgram;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.utilities.MatrixHelper;

import android.opengl.GLES20;
import android.util.Pair;

/**
 *
 */
public class TextureSprite implements Sprite
{
	private static final int NUMBER_OF_VERTICES = 4;
	private Texture texture;
	private SpriteVertexBufferObject spriteBuffer;
	private TextureShaderProgram program;
	private Rectangle hitbox;

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
		hitbox = new Rectangle(x, y);
		texture = spriteTexture;
		program = textureProgram;
	}

	@Override
	public void load()
	{
		spriteBuffer = new SpriteVertexBufferObject(program);
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
	public void onUpdate()
	{

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

	@Override
	public float getWidth()
	{
		return hitbox.getWidth();
	}

	@Override
	public float getHeight()
	{
		return hitbox.getHeight();
	}

	@Override
	public Rectangle getHitbox()
	{
		return hitbox;
	}

	@Override
	public void setWidth(final float w)
	{
		hitbox.setWidth(w);
	}

	@Override
	public void setHeight(final float h)
	{
		hitbox.setHeight(h);
	}

	@Override
	public Pair<Float, Float> getPosition()
	{
		return hitbox.getPosition();
	}

	@Override
	public void setPosition(final float x, final float y)
	{
		hitbox.setPosition(x, y);
	}

	@Override
	public float getRotation()
	{
		return hitbox.getRotation();
	}

	@Override
	public void setRotation(final float angle)
	{
		hitbox.setRotation(angle);
	}

	@Override
	public boolean isScaled()
	{
		return hitbox.isScaled();
	}

	@Override
	public Pair<Float, Float> getScale()
	{
		return hitbox.getScale();
	}

	@Override
	public float getScaleX()
	{
		return hitbox.getScaleX();
	}

	@Override
	public float getScaleY()
	{
		return hitbox.getScaleY();
	}

	@Override
	public void setScale(final float scalingFactor)
	{
		hitbox.setScale(scalingFactor);
	}

	@Override
	public void setScaleX(final float scaleX)
	{
		hitbox.setScaleX(scaleX);
	}

	@Override
	public void setScaleY(final float scaleY)
	{
		hitbox.setScaleY(scaleY);
	}
}
