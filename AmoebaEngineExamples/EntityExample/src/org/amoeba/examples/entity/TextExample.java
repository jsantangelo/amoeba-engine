package org.amoeba.examples.entity;

import org.amoeba.activity.GameActivity;
import org.amoeba.entity.sprite.TextSprite;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;

public class TextExample extends GameActivity
{
	private TextSprite text;

	@Override
	public void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		text = getGraphicsService().getTextFactory().createTextSprite("Hello!");
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		text.setPosition(width / 2, height / 2);
		text.setColor(Color.BLUE, 10000L);
	}

	@Override
	public void onUpdate()
	{
		long time = SystemClock.uptimeMillis() % 10000L;
		float angleInDegrees = (360.0f / 10000.0f) * ((int) time);

		text.setRotation(angleInDegrees);
	}
}
