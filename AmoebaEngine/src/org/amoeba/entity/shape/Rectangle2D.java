package org.amoeba.entity.shape;

import org.amoeba.entity.Entity;
import org.amoeba.entity.EntityVertexBufferObject;
import org.amoeba.geom.Dimension;
import org.amoeba.geom.Point;
import org.amoeba.geom.Rectangle;
import org.amoeba.graphics.utilities.ColorTransition;

/**
 * Rectangle2D is Rectangle that can be drawn.
 */
public abstract class Rectangle2D extends Rectangle implements Entity
{
	private ColorTransition colorTransition;
	private int entityDepth;
	private boolean hidden;
	private EntityVertexBufferObject vertexBuffer;

	/**
	 * Default constructor for Rectangle2D.
	 * Creates the rectangle at (0, 0) with a width and height of 1.0f.
	 * @param vbo The vertex buffer object for the rectangle.
	 */
	public Rectangle2D(final EntityVertexBufferObject vbo)
	{
		this(0f, 0f, 1f, 1f, vbo);
	}

	/**
	 * Constructor for Rectangle2D for a specific width and height.
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 * @param vbo The vertex buffer object for the rectangle.
	 */
	public Rectangle2D(final float w, final float h, final EntityVertexBufferObject vbo)
	{
		this(0f, 0f, w, h, vbo);
	}

	/**
	 * Constructor for Rectangle2D for a specific width and height.
	 * @param dimension The width and height of the rectangle.
	 * @param vbo The vertex buffer object for the rectangle.
	 */
	public Rectangle2D(final Dimension dimension, final EntityVertexBufferObject vbo)
	{
		this(0f, 0f, dimension.getWidth(), dimension.getHeight(), vbo);
	}

	/**
	 * Constructor for Rectangle2D for a specific position and size.
	 * @param pos The position of the rectangle (center).
	 * @param dimension The width and height of the rectangle.
	 * @param vbo The vertex buffer object for the rectangle.
	 */
	public Rectangle2D(final Point pos, final Dimension dimension, final EntityVertexBufferObject vbo)
	{
		this(pos.getX(), pos.getY(), dimension.getWidth(), dimension.getHeight(), vbo);
	}

	/**
	 * Constructor for Rectangle2D for a specific position and size.
	 * @param x The x position of the rectangle (center).
	 * @param y The y position of the rectangle (center).
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 * @param vbo The vertex buffer object for the rectangle.
	 */
	public Rectangle2D(final float x, final float y, final float w, final float h, final EntityVertexBufferObject vbo)
	{
		super(x, y, w, h);
		setDepth(0);
		show();

		vertexBuffer = vbo;
	}

	/**
	 * Load the rectangle.
	 */
	public void load()
	{
		vertexBuffer.load();
	}

	/**
	 * Pack the color into the buffer.
	 * @param color The new color of the rectangle (as defined by android.graphics.Color).
	 */
	public void setColor(final int color)
	{
		vertexBuffer.setColor(color);
	}

	/**
	 * Pack the color into the buffer.
	 * @param red The red component of the color (0.0f - 1.0f).
	 * @param green The green component of the color (0.0f - 1.0f).
	 * @param blue The blue component of the color (0.0f - 1.0f).
	 * @param alpha The alpha component of the color (0.0f - 1.0f).
	 */
	public void setColor(final float red, final float green, final float blue, final float alpha)
	{
		vertexBuffer.setColor(red, green, blue, alpha);
	}

	/**
	 * Transition to a new color over a set time.
	 * @param color The new color of the (as defined by android.graphics.Color).
	 * @param duration The time it takes to transition to the new color (milliseconds).
	 */
	public void setColor(final int color, final long duration)
	{
		colorTransition = new ColorTransition(getColor(), color, duration);
	}

	/**
	 * Get the current color of the rectangle.
	 * @return The current color of the rectangle.
	 */
	public int getColor()
	{
		return vertexBuffer.getColor();
	}

	/**
	 * Get the vertex buffer object for the rectangle.
	 * @return The vertex buffer object for the rectangle.
	 */
	protected EntityVertexBufferObject getBuffer()
	{
		return vertexBuffer;
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
	public int getDepth()
	{
		return entityDepth;
	}

	@Override
	public void setDepth(final int depth)
	{
		entityDepth = depth;
	}

	@Override
	public void hide()
	{
		hidden = true;
	}

	@Override
	public void show()
	{
		hidden = false;
	}

	@Override
	public boolean isHidden()
	{
		return hidden;
	}
}
