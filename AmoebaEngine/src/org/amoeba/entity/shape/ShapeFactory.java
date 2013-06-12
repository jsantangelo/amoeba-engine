package org.amoeba.entity.shape;

import org.amoeba.geom.Dimension;
import org.amoeba.geom.Point;

/**
 * ShapeFactory provides functionality to create shapes.
 */
public interface ShapeFactory
{
	/**
	 * Create a 2d rectangle.
	 * @return A 2d rectangle.
	 */
	public Rectangle2D createRectangle();

	/**
	 * Create a 2d rectangle.
	 * @param dimensions The dimensions (width, height) of the rectangle.
	 * @return A 2d rectangle.
	 */
	public Rectangle2D createRectangle(final Dimension dimensions);

	/**
	 * Create a 2d rectangle.
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 * @return A 2d rectangle.
	 */
	public Rectangle2D createRectangle(final float w, final float h);

	/**
	 * Create a 2d rectangle.
	 * @param position The position (x, y) of the rectangle.
	 * @param dimensions The dimensions (width, height) of the rectangle.
	 * @return A 2d rectangle.
	 */
	public Rectangle2D createRectangle(final Point position, final Dimension dimensions);

	/**
	 * Create a 2d rectangle.
	 * @param x The x position of the rectangle (center).
	 * @param y The y position of the rectangle (center).
	 * @param w The width of the rectangle.
	 * @param h The height of the rectangle.
	 * @return A 2d rectangle.
	 */
	public Rectangle2D createRectangle(final float x, final float y, final float w, final float h);
}
