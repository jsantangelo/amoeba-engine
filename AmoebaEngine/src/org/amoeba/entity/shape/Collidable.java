package org.amoeba.entity.shape;


/**
 * Shape is an object in a scene that has a size and can collide with other objects.
 */
public interface Collidable
{
	/**
	 * Determine whether an entity is colliding with another entity.
	 * @param entity The entity with which this entity may be colliding with.
	 * @return Whether the entity is colliding with the other entity.
	 */
	public boolean isColliding(Collidable entity);
}
