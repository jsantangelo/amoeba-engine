package org.amoeba.examples.spriteexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.entity.sprite.Sprite;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;

public class SpriteExample extends GameActivity
{
	private Sprite sprite;

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		sprite = getGraphicsService().getSpriteFactory().createSprite(R.drawable.happy);
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		sprite.setPosition(width / 2, height / 2);
		sprite.setColor(Color.BLUE, 10000L);
	}

	@Override
	public void onUpdate()
	{
		long time = SystemClock.uptimeMillis() % 10000L;
		float angleInDegrees = (360.0f / 10000.0f) * ((int) time);

		sprite.setRotation(angleInDegrees);
	}
}
