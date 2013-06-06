package org.amoeba.entity.shape.impl;

import org.amoeba.entity.EntityVertexBufferObject;
import org.amoeba.entity.shape.Rectangle2D;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.ShaderProgram;

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
		this(0f, 0f, shaderProgram, vbo);
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
		super(x, y, vbo);
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
		// TODO Auto-generated method stub

	}
}
