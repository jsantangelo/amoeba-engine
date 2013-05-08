package org.amoeba.geom.collision;

import org.amoeba.geom.Rectangle;


/**
 * CollisionHelper provides helper functions for collision between shapes.
 */
public final class CollisionHelper
{
	/**
	 * Determine whether two shapes are colliding.
	 * @param shape1 The first shape.
	 * @param shape2 The second shape.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Collidable shape1, final Collidable shape2)
	{
		return false;
	}

	/**
	 * Determine whether a rectangle is colliding with another shape.
	 * @param rect The rectangle.
	 * @param shape The other shape.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Rectangle rect, final Collidable shape)
	{
		return false;
	}

	/**
	 * Constructor for CollisionHelper. (Hidden)
	 */
	private CollisionHelper()
	{

	}
}
