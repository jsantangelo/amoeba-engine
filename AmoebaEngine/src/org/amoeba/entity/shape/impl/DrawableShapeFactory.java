package org.amoeba.entity.shape.impl;

import org.amoeba.entity.shape.Rectangle2D;
import org.amoeba.entity.shape.ShapeFactory;
import org.amoeba.geom.Dimension;
import org.amoeba.geom.Point;
import org.amoeba.graphics.shader.ShaderProgramManager;
import org.amoeba.graphics.shader.impl.ColorShaderProgram;
import org.amoeba.graphics.utilities.BufferUtilities;
import org.amoeba.graphics.utilities.ShaderUtilities;

/**
 * DrawableShapeFactory provides functionality to create drawable shapes.
 */
public class DrawableShapeFactory implements ShapeFactory
{
	private final ShaderProgramManager shaderProgramManager;
	private final ShaderUtilities shaderUtilities;
	private final BufferUtilities bufferUtilities;

	/**
	 * Constructor for TextureSpriteFactory.
	 * @param programManager The shader program manager.
	 * @param shaUtilities The shader utilities.
	 * @param bufUtilities The buffer utilities.
	 */
	public DrawableShapeFactory(final ShaderProgramManager programManager, final ShaderUtilities shaUtilities, final BufferUtilities bufUtilities)
	{
		shaderProgramManager = programManager;
		shaderUtilities = shaUtilities;
		bufferUtilities = bufUtilities;
	}

	@Override
	public Rectangle2D createRectangle(final Point position, final Dimension dimensions)
	{
		Rectangle2D rectangle = null;

		ColorShaderProgram program = (ColorShaderProgram) shaderProgramManager.getProgram(ColorShaderProgram.VERTEX_SHADER_SOURCE, ColorShaderProgram.FRAGMENT_SHADER_SOURCE);
		if (program == null)
		{
			program = new ColorShaderProgram(shaderUtilities);
			shaderProgramManager.add(program);
		}

		RectangleVertexBufferObject vbo = new RectangleVertexBufferObject(program, bufferUtilities);
		rectangle = new BoxRectangle2D(position.getX(), position.getY(), dimensions.getWidth(), dimensions.getHeight(), program, vbo);
		//entityManager.add(rectangle);

		return rectangle;
	}
}
