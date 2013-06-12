package org.amoeba.entity.shape.impl;

import org.amoeba.entity.EntityManager;
import org.amoeba.entity.shape.Rectangle2D;
import org.amoeba.entity.shape.ShapeFactory;
import org.amoeba.geom.Dimension;
import org.amoeba.geom.Point;
import org.amoeba.graphics.shader.ShaderProgramManager;
import org.amoeba.graphics.shader.impl.ColorShaderProgram;
import org.amoeba.graphics.utilities.BufferUtilities;

/**
 * DrawableShapeFactory provides functionality to create drawable shapes.
 */
public class DrawableShapeFactory implements ShapeFactory
{
	private final ShaderProgramManager shaderProgramManager;
	private final BufferUtilities bufferUtilities;
	private final EntityManager entityManager;

	/**
	 * Constructor for TextureSpriteFactory.
	 * @param programManager The shader program manager.
	 * @param bufUtilities The buffer utilities.
	 * @param entManager The entity manager.
	 */
	public DrawableShapeFactory(final ShaderProgramManager programManager, final BufferUtilities bufUtilities, final EntityManager entManager)
	{
		shaderProgramManager = programManager;
		bufferUtilities = bufUtilities;
		entityManager = entManager;
	}

	@Override
	public Rectangle2D createRectangle()
	{
		return createRectangle(0f, 0f, 1f, 1f);
	}

	@Override
	public Rectangle2D createRectangle(final Dimension dimensions)
	{
		return createRectangle(0f, 0f, dimensions.getWidth(), dimensions.getHeight());
	}

	@Override
	public Rectangle2D createRectangle(final float w, final float h)
	{
		return createRectangle(0f, 0f, w, h);
	}

	@Override
	public Rectangle2D createRectangle(final Point position, final Dimension dimensions)
	{
		return createRectangle(position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight());
	}

	@Override
	public Rectangle2D createRectangle(final float x, final float y, final float w, final float h)
	{
		Rectangle2D rectangle = null;

		ColorShaderProgram program = ColorShaderProgram.getInstance();
		shaderProgramManager.add(program);

		RectangleVertexBufferObject vbo = new RectangleVertexBufferObject(program, bufferUtilities);
		rectangle = new BoxRectangle2D(x, y, w, h, program, vbo);
		entityManager.add(rectangle);

		return rectangle;
	}
}
