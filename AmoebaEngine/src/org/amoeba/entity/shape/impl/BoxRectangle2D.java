package org.amoeba.entity.shape.impl;

import org.amoeba.entity.EntityVertexBufferObject;
import org.amoeba.entity.shape.Rectangle2D;
import org.amoeba.geom.Dimension;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.ShaderProgram;
import org.amoeba.graphics.utilities.MatrixHelper;

import android.opengl.GLES20;

/**
 * BoxRectangle2D is a 2D rectangle with square corners.
 */
public class BoxRectangle2D extends Rectangle2D
{
	private ShaderProgram program;

	/**
	 * Constructor for Sprite.
	 * @param shaderProgram The program used to draw this shape.
	 * @param vbo The vertex buffer object for the shape.
	 */
	public BoxRectangle2D(final ShaderProgram shaderProgram, final EntityVertexBufferObject vbo)
	{
		this(0f, 0f, 1f, 1f, shaderProgram, vbo);
	}

	/**
	 * Constructor for Sprite.
	 * @param x The x position of the sprite (center).
	 * @param y The y position of the sprite (center).
	 * @param shaderProgram The program used to draw this shape.
	 * @param vbo The vertex buffer object for the shape.
	 */
	public BoxRectangle2D(final float x, final float y, final ShaderProgram shaderProgram, final EntityVertexBufferObject vbo)
	{
		this(x, y, 1f, 1f, shaderProgram, vbo);
	}

	/**
	 * Constructor for Sprite.
	 * @param x The x position of the sprite (center).
	 * @param y The y position of the sprite (center).
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 * @param shaderProgram The program used to draw this shape.
	 * @param vbo The vertex buffer object for the shape.
	 */
	public BoxRectangle2D(final float x, final float y, final float w, final float h, final ShaderProgram shaderProgram, final EntityVertexBufferObject vbo)
	{
		super(x, y, w, h, vbo);
		program = shaderProgram;
	}

	@Override
	public void load()
	{
		super.load();
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

		getBuffer().bind();

		final float[] mvpMatrix = camera.calculateMVPMatrix(modelMatrix);
		int mvpMatrixHandle = program.getUniformLocation(ShaderConstants.UNIFORM_MVPMATRIX);
		GLES20.glUniformMatrix4fv(mvpMatrixHandle, 1, false, mvpMatrix, 0);

		getBuffer().draw();

		program.stopUsing();
	}
}
