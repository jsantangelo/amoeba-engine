package org.amoeba.entity;

import android.util.Pair;

/**
 * Entity is an object in a scene.
 */
public interface Entity
{
	/**
	 * Get the position of the entity.
	 * @return The position of the entity.
	 */
	public Pair<Float, Float> getPosition();

	/**
	 * Set the coordinates of the entity.
	 * @param x The x position of the entity.
	 * @param y The y position of the entity.
	 */
	public void setPosition(final float x, final float y);

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
	public Pair<Float, Float> getScale();

	/**
	 * Get the scale of the entity in the X-direction.
	 * @return The X scale of the entity.
	 */
	public float getScaleX();

	/**
	 * Get the scale of the entity in the Y-direction.
	 * @return The Y scale of the entity.
	 */
	public float getScaleY();

	/**
	 * Set the both the X and Y scale of the entity.
	 * @param scalingFactor The new scale of the entity.
	 */
	public void setScale(final float scalingFactor);

	/**
	 * Set the X scale of the entity.
	 * @param scaleX The new X scale of the entity.
	 */
	public void setScaleX(final float scaleX);

	/**
	 * Set the Y scale of the entity.
	 * @param scaleY The new Y scale of the entity.
	 */
	public void setScaleY(final float scaleY);
}
