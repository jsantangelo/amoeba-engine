package org.amoeba.examples.entity;

import org.amoeba.activity.GameActivity;
import org.amoeba.entity.shape.Rectangle2D;
import org.amoeba.entity.sprite.Sprite;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;

public class SpriteExample extends GameActivity
{
	private Sprite sprite;
	private Rectangle2D rectangle;
	private boolean flipped = false;

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		sprite = getGraphicsService().getSpriteFactory().createSprite(R.drawable.happy);
		rectangle = getGraphicsService().getShapeFactory().createRectangle(500f, 500f);
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		sprite.setPosition(width / 2, height * 3 /4);
		sprite.setColor(Color.BLUE, 10000L);
		sprite.setDepth(-1);

		rectangle.setPosition(width / 2, height / 4);
		rectangle.setColor(Color.RED, 10000L);
		rectangle.setDepth(1);
	}

	@Override
	public void onUpdate()
	{
		long time = SystemClock.uptimeMillis() % 10000L;
		float angleInDegrees = (360.0f / 10000.0f) * ((int) time);

		sprite.setRotation(angleInDegrees);
		rectangle.setRotation(angleInDegrees);

		if (angleInDegrees > 355.0f && !flipped)
		{
			sprite.setDepth(sprite.getDepth() * -1);
			rectangle.setDepth(rectangle.getDepth() * -1);
			flipped = true;
		}

		if (angleInDegrees < 355.0f)
		{
			flipped = false;
		}
	}
}
