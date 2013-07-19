package org.amoeba.examples.entity;

import org.amoeba.activity.GameActivity;
import org.amoeba.entity.sprite.TextSprite;
import org.amoeba.graphics.texture.TextOptions;

import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;

public class TextExample extends GameActivity
{
	private TextSprite text;

	@Override
	public void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextOptions options = new TextOptions(64, Color.BLUE, Align.CENTER, Typeface.DEFAULT, true);
		text = getGraphicsService().getTextFactory().createTextSprite("Hello!", options);
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		text.setPosition(width / 2, height / 2);
	}

	@Override
	public void onUpdate()
	{
		long time = SystemClock.uptimeMillis() % 10000L;
		float angleInDegrees = (360.0f / 10000.0f) * ((int) time);

		text.setRotation(angleInDegrees);
	}
}
