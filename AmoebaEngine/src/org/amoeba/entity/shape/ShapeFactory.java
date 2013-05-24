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
	 * @param position The position (x, y) of the rectangle.
	 * @param dimensions The dimensions (width, height) of the rectangle.
	 * @return A 2d rectangle.
	 */
	public Rectangle2D createRectangle(final Point position, final Dimension dimensions);
}
