package org.amoeba.entity.sprite;

import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.entity.Coordinates;
import org.amoeba.entity.shape.Rectangle;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.source.TextureShaderProgram;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.utilities.MatrixHelper;

import android.opengl.GLES20;

/**
 *
 */
public class Sprite extends Rectangle implements UpdateListener, DrawListener
{
	private static final int NUMBER_OF_VERTICES = 4;
	private Texture texture;
	private SpriteVertexBufferObject spriteBuffer;
	private TextureShaderProgram program;

	/**
	 * Constructor for Sprite.
	 * @param spriteTexture The texture on this sprite.
	 * @param textureProgram The program used to draw this sprite.
	 */
	public Sprite(final Texture spriteTexture, final TextureShaderProgram textureProgram)
	{
		this(new Coordinates(0, 0), spriteTexture, textureProgram);
	}

	/**
	 * Constructor for Sprite.
	 * @param position The position of the sprite.
	 * @param spriteTexture The texture on this sprite.
	 * @param textureProgram The program used to draw this sprite.
	 */
	public Sprite(final Coordinates position, final Texture spriteTexture, final TextureShaderProgram textureProgram)
	{
		super(position);
		texture = spriteTexture;
		program = textureProgram;
	}

	/**
	 *
	 */
	public void load()
	{
		spriteBuffer = new SpriteVertexBufferObject(program);
	}

	/**
	 * Pack the color into the sprite buffer.
	 * @param color The new color of the sprite.
	 */
	public void setColor(final int color)
	{
		spriteBuffer.setColor(color);
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
		spriteBuffer.setColor(red, green, blue, alpha);
	}

	/**
	 *
	 */
	public void onUpdate()
	{

	}

	/**
	 * @param camera The camera.
	 */
	public void onDraw(final Camera camera)
	{
		program.use();

		final float[] modelMatrix = MatrixHelper.createMatrix(
				getPosition(),
				new Coordinates(getScaleX(), getScaleY()),
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
