package org.amoeba.entity.shape;

import org.amoeba.entity.Entity;

/**
 * Shape is an object in a scene that has a size and can collide with other objects.
 */
public interface Shape extends Entity
{
	/**
	 * Determine whether the shape is colliding with another shape.
	 * @param shape The shape with which the current shape may be colliding with.
	 * @return Whether the shape is colliding with the other shape.
	 */
	public boolean isColliding(Shape shape);
}
