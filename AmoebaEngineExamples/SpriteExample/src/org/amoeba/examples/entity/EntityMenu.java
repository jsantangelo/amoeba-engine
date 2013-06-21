package org.amoeba.examples.entity;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.entity.shape.Rectangle2D;
import org.amoeba.entity.sprite.Sprite;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class EntityMenu extends GameActivity
{
	private int screenHeight = 0;
	private Sprite sprite;
	private Rectangle2D rectangle;

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		sprite = getGraphicsService().getSpriteFactory().createSprite(R.drawable.happy);
		rectangle = getGraphicsService().getShapeFactory().createRectangle();
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		screenHeight = height;

		sprite.setWidth(width);
		sprite.setHeight(height / 2);
		sprite.setPosition(width / 2, height / 4);

		rectangle.setWidth(width);
		rectangle.setHeight(height / 2);
		rectangle.setPosition(width / 2, height * 3 / 4);
	}

	@Override
	public void onInputEvent(final InputEvent event)
	{
		if(event.getEventType() == InputEvent.EventType.SINGLETAP ||
				event.getEventType() == InputEvent.EventType.LONGPRESS)
		{
			MotionEvent touchPoint = event.getMotionEvent();
			if(touchPoint.getY() < screenHeight / 2)
			{
				startActivity(new Intent(this, SpriteExample.class));
			}
			else
			{
				startActivity(new Intent(this, ShapeExample.class));
			}
			overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
		}
	}
}
