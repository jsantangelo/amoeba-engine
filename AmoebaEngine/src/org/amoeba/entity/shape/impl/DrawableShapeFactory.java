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
	public Rectangle2D createRectangle(final Point position, final Dimension dimensions)
	{
		Rectangle2D rectangle = null;

		ColorShaderProgram program = ColorShaderProgram.getInstance();
		shaderProgramManager.add(program);

		RectangleVertexBufferObject vbo = new RectangleVertexBufferObject(program, bufferUtilities);
		rectangle = new BoxRectangle2D(position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight(), program, vbo);
		entityManager.add(rectangle);

		return rectangle;
	}
}
