package org.amoeba.entity.sprite;

import java.util.ArrayList;

import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.graphics.camera.Camera;

/**
 * SpriteManager maintains a collection of sprites.
 */
public class SpriteManager implements DrawListener, UpdateListener
{
	private final ArrayList<Sprite> sprites;

	/**
	 * Constructor for SpriteManager.
	 */
	public SpriteManager()
	{
		sprites = new ArrayList<Sprite>();
	}

	/**
	 * Add a sprite to the collection.
	 * @param sprite Sprite to be added to the collection.
	 */
	public void add(final Sprite sprite)
	{
		if (sprite != null)
		{
			sprites.add(sprite);
		}
	}

	/**
	 * Load all sprites in the collection.
	 */
	public void loadSprites()
	{
		for (Sprite sprite : sprites)
		{
			sprite.load();
		}
	}

	@Override
	public void onUpdate()
	{
		for (Sprite sprite : sprites)
		{
			sprite.onUpdate();
		}
	}

	@Override
	public void onDraw(final Camera camera)
	{
		for (Sprite sprite : sprites)
		{
			sprite.onDraw(camera);
		}
	}


}
