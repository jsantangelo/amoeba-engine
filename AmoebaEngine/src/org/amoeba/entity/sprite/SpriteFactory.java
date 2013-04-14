package org.amoeba.entity.sprite;

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
}
