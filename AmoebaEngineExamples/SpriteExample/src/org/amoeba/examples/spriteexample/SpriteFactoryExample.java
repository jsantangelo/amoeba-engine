package org.amoeba.examples.spriteexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.entity.sprite.Sprite;
import org.amoeba.graphics.camera.Camera;

import android.graphics.Color;
import android.os.SystemClock;

public class SpriteFactoryExample extends GameActivity
{
	private Sprite sprite;

	private int screenWidth, screenHeight;

	public SpriteFactoryExample()
	{
		screenWidth = 1;
		screenHeight = 1;

		// sprite = spriteFactory.createSprite(R.drawable.happy);
	}

	@Override
	public void onSurfaceCreated()
	{

	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		screenWidth = width;
		screenHeight = height;

		sprite.setPosition(screenWidth / 2, screenHeight / 2);
		sprite.setScaleX(screenWidth / 2);
		sprite.setScaleY(screenHeight / 2);
		sprite.setColor(Color.BLUE, 10000L);
	}

	public void onDraw(final Camera camera)
	{

	}

	public void onUpdate()
	{
		long time = SystemClock.uptimeMillis() % 10000L;
		float angleInDegrees = (360.0f / 10000.0f) * ((int) time);

		sprite.setRotation(angleInDegrees);
	}

	public void onInputEvent(final InputEvent event)
	{

	}
}
