package org.amoeba.engine.service.graphics;

import org.amoeba.entity.sprite.SpriteFactory;

/**
 * Service provided by AmoebaEngine, responsible for preparing the
 * graphics framework.
 */
public interface GraphicsService
{
	/**
	 * Get a Sprite Factory, used to create sprites.
	 * @return A Sprite Factory.
	 */
	public SpriteFactory getSpriteFactory();
}
