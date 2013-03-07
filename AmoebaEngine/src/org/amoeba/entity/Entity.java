package org.amoeba.entity;

/**
 * Entity is an object in a scene.
 */
public interface Entity
{
	/**
	 * Get the X-Position of the entity.
	 * @return The x-position of the entity.
	 */
	public float getX();

	/**
	 * Get the Y-Position of the entity.
	 * @return The y-position of the entity.
	 */
	public float getY();

	/**
	 * Set the X-Position of the entity.
	 * @param x The new x=position of the entity.
	 */
	public void setX(final float x);

	/**
	 * Set the Y-Position of the entity.
	 * @param y The new y-position of the entity.
	 */
	public void setY(final float y);

	/**
	 * Get the rotation of the entity.
	 * @return The rotation of the entity.
	 */
	public float getRotation();

	/**
	 * Set the rotation of the entity.
	 * @param rotation the new rotation of the entity.
	 */
	public void setRotation(final float rotation);

	/**
	 * Determine whether the entity is scaled.
	 * @return Whether the entity is scaled.
	 */
	public boolean isScaled();

	/**
	 * Get the overall scale of the entity.
	 * @return The scale of the entity.
	 */
	public float getScale();

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
	 * @param scale The new scale of the entity.
	 */
	public void setScale(final float scale);

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
