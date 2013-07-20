package org.amoeba.examples.entity;

import java.util.LinkedHashMap;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.examples.entity.menu.Button;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainMenu extends GameActivity
{
	private LinkedHashMap<Button, Class<?>> menuItems;

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		menuItems = new LinkedHashMap<Button, Class<?>>();
		menuItems.put(new Button("Sprites", Color.RED, getGraphicsService()), SpriteExample.class);
		menuItems.put(new Button("Shapes", Color.GREEN, getGraphicsService()), ShapeExample.class);
		menuItems.put(new Button("Text", Color.BLUE, getGraphicsService()), TextExample.class);
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		int index = 0;
		for(Button button : menuItems.keySet())
		{
			button.setSize(width, height / menuItems.size());
			button.setPosition(width / 2, height * (index * 2 + 1) / (menuItems.size() * 2));
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
			for(Button button : menuItems.keySet())
			{
				if(button.isColliding(touchPoint.getX(), touchPoint.getY()))
				{
					startActivity(new Intent(this, menuItems.get(button)));
					break;
				}
			}
			overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
		}
	}
}
