package org.amoeba.entity;

import java.util.ArrayList;

import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.graphics.camera.Camera;

/**
 * EntityManager maintains a collection of entities.
 */
public class EntityManager implements DrawListener, UpdateListener
{
	private final ArrayList<Entity> entities;

	/**
	 * Constructor for EntityManager.
	 */
	public EntityManager()
	{
		entities = new ArrayList<Entity>();
	}

	/**
	 * Add an entity to the collection.
	 * @param entity Entity to be added to the collection.
	 */
	public void add(final Entity entity)
	{
		if (entity != null)
		{
			entities.add(entity);
		}
	}

	/**
	 * Load all entities in the collection.
	 */
	public void loadAll()
	{
		for (Entity entity : entities)
		{
			entity.load();
		}
	}

	@Override
	public void onUpdate()
	{
		for (Entity entity : entities)
		{
			entity.onUpdate();
		}
	}

	@Override
	public void onDraw(final Camera camera)
	{
		for (Entity entity : entities)
		{
			if (!entity.isHidden())
			{
				entity.onDraw(camera);
			}
		}
	}
}
