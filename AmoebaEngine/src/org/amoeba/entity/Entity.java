package org.amoeba.entity;

import org.amoeba.geom.Dimension;
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
	 * Get the rotation of the entity.
	 * @return The rotation of the entity.
	 */
	public float getRotation();

	/**
	 * Set the rotation angle in degrees of the entity.
	 * @param angle The new rotation angle in degrees of the entity.
	 */
	public void setRotation(final float angle);

	/**
	 * Determine whether the entity is scaled.
	 * @return Whether the entity is scaled.
	 */
	public boolean isScaled();

	/**
	 * Get the scale of the entity.
	 * @return The scale of the entity in both the X and Y direction.
	 */
	public Dimension getScale();

	/**
	 * Set the both the X and Y scale of the entity.
	 * @param scalingFactor The new scale of the entity.
	 */
	public void setScale(final float scalingFactor);

	/**
	 * Set the scale of the entity.
	 * @param scale The scale of the entity.
	 */
	public void setScale(final Dimension scale);
}
