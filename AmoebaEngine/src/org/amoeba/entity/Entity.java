package org.amoeba.entity;

import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.geom.Point;

/**
 * Entity is an object in a scene.
 */
public interface Entity extends DrawListener, UpdateListener
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
	 * Get the depth of the entity. Used to order drawing of entities.
	 * @return The depth of the entity.
	 */
	public int getDepth();

	/**
	 * Set the depth of the entity. Used to order drawing of entities.
	 * @param depth The depth.
	 */
	public void setDepth(final int depth);
}
