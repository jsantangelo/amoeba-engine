package org.amoeba.examples.entity;

import java.util.LinkedHashMap;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.entity.shape.Rectangle2D;

import android.content.Intent;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainMenu extends GameActivity
{
	private LinkedHashMap<Rectangle2D, Class<?>> menuItems;

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		menuItems = new LinkedHashMap<Rectangle2D, Class<?>>();
		menuItems.put(getGraphicsService().getSpriteFactory().createSprite(R.drawable.happy), SpriteExample.class);
		menuItems.put(getGraphicsService().getShapeFactory().createRectangle(), ShapeExample.class);
		menuItems.put(getGraphicsService().getTextFactory().createTextSprite("Text"), TextExample.class);
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		int index = 0;
		GLES20.glClearColor(0.5f, 0.5f, 0.5f, 0f);
		for(Rectangle2D entity : menuItems.keySet())
		{
			entity.setWidth(width);
			entity.setHeight(height / menuItems.size());
			entity.setPosition(width / 2, height * (index * 2 + 1) / (menuItems.size() * 2));
			index++;
		}
	}

	@Override
	public void onInputEvent(final InputEvent event)
	{
		if(event.getEventType() == InputEvent.EventType.SINGLETAP ||
				event.getEventType() == InputEvent.EventType.LONGPRESS)
		{
			MotionEvent touchPoint = event.getMotionEvent();
			float inputY = touchPoint.getY();
			for(Rectangle2D entity : menuItems.keySet())
			{
				//TODO: Add Collidable to Entity and use the isColliding function instead
				//if(entity.isColliding(inputX, inputY))
				if(((entity.getPosition().getY() - entity.getHeight() / 2) <= inputY) &&
						((entity.getPosition().getY() + entity.getHeight() / 2) >= inputY))
				{
					startActivity(new Intent(this, menuItems.get(entity)));
					break;
				}
			}
			overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
		}
	}
}
