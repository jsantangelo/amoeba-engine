package org.amoeba.entity.sprite;

import org.amoeba.geom.Point;

/**
 * SpriteFactory provides various ways to create Sprites.
 */
public interface SpriteFactory
{
	/**
	 * Create a sprite out of a drawable resource.
	 * @param drawableID The id of the drawable resource.
	 * @return The sprite created.
	 */
	public Sprite createSprite(final int drawableID);

	/**
	 * Create a sprite out of a drawable resource.
	 * @param drawableID The id of the drawable resource.
	 * @param position The location of the sprite (center).
	 * @return The sprite created.
	 */
	public Sprite createSprite(final int drawableID, final Point position);

	/**
	 * Create a sprite out of a drawable resource.
	 * @param drawableID The id of the drawable resource.
	 * @param x The x location of the sprite.
	 * @param y The y location of the sprite.
	 * @return The sprite created.
	 */
	public Sprite createSprite(final int drawableID, final float x, final float y);
}
