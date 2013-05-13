package org.amoeba.entity;

import org.amoeba.geom.Point;

/**
 * Entity is an object in a scene.
 */
public interface Entity
{
	/**
	 * Get the position of the entity.
	 * @return The position of the entity.
	 */
	public Point getPosition();

	/**
	 * Set the coordinates of the entity.
	 * @param x The x position of the entity.
	 * @param y The y position of the entity.
	 */
	public void setPosition(final float x, final float y);

	/**
	 * Set the coordinates of the entity.
	 * @param position The x and y coordinates of the entity.
	 */
	public void setPosition(final Point position);

	/**
	 * Rotate the entity by a specific angle in degrees.
	 * @param angle The amount in degrees in which the entity is rotated.
	 */
	public void rotate(final float angle);

	/**
	 * Scale the entity by a given amount.
	 * @param scalingFactor The new scale of the rectangle.
	 */
	public void scale(final float scalingFactor);
}
