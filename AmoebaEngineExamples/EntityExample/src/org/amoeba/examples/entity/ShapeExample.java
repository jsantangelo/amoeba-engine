package org.amoeba.examples.entity;

import org.amoeba.activity.GameActivity;
import org.amoeba.entity.shape.Rectangle2D;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;

public class ShapeExample extends GameActivity
{
	private Rectangle2D rectangle;

	@Override
	public void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		rectangle = getGraphicsService().getShapeFactory().createRectangle(500f, 500f);
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		rectangle.setPosition(width / 2, height / 2);
		rectangle.setColor(Color.RED, 10000L);
	}

	@Override
	public void onUpdate()
	{
		long time = SystemClock.uptimeMillis() % 10000L;
		float angleInDegrees = (360.0f / 10000.0f) * ((int) time);

		rectangle.setRotation(angleInDegrees);
	}
}
