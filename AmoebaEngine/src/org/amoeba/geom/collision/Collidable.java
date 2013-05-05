package org.amoeba.geom.collision;



/**
 * Collidable objects are shapes that can collide with other shapes.
 */
public abstract class Collidable
{
	/**
	 * Determine whether a shape is colliding with another shape.
	 * @param shape The shape with which this shape may be colliding.
	 * @return Whether the shape is colliding with the other shape.
	 */
	public boolean isColliding(final Collidable shape)
	{
		return CollisionHelper.isColliding(this, shape);
	}
}
