package com.pixelweaverstudios.amoeba.entity.shape;

import com.pixelweaverstudios.amoeba.entity.Entity;

public interface Shape extends Entity
{
	public boolean isColliding(Shape shape);
}
