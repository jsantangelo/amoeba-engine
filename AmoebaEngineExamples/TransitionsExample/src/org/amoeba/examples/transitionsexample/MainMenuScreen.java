package org.amoeba.examples.transitionsexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.entity.sprite.Sprite;

import android.util.Log;
import android.util.Pair;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;

import java.util.Map;
import java.util.HashMap;

public class MainMenuScreen extends GameActivity
{
	private static final String TAG = "Amoeba.MainMenuScreen";

	private Sprite background;
	private Sprite title;

	private Map<Class, Sprite> buttons;

	public MainMenuScreen()
	{
		buttons = new HashMap<Class, Sprite>();
	}

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		background = getGraphicsService().getSpriteFactory().createSprite(R.drawable.mainmenu_bg);
		title = getGraphicsService().getSpriteFactory().createSprite(R.drawable.transition_title);

		createButton(R.drawable.none_button, NoneScreen.class);
		createButton(R.drawable.slide_button, SlideScreen.class);
		createButton(R.drawable.fade_button, FadeScreen.class);
	}

	private void createButton(int resource, Class destination)
	{
		buttons.put(destination, getGraphicsService().getSpriteFactory().createSprite(resource));
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		background.setPosition(width/2, height/2);
		title.setPosition(width/2, height/6);

		buttons.get(NoneScreen.class).setPosition(width/2, height/12*6);
		buttons.get(SlideScreen.class).setPosition(width/2, height/12*8);
		buttons.get(FadeScreen.class).setPosition(width/2, height/12*10);
	}

	@Override
	public void onInputEvent(final InputEvent event)
	{
		if (event.getEventType() == InputEvent.EventType.SINGLETAP ||
			event.getEventType() == InputEvent.EventType.LONGPRESS)
		{
			MotionEvent touchPoint = event.getMotionEvent();

			for (Map.Entry<Class, Sprite> entry : buttons.entrySet())
			{
				Pair<Float, Float> position = entry.getValue().getPosition();
				float width = entry.getValue().getWidth();
				float height = entry.getValue().getHeight();

				if ((touchPoint.getX() > position.first - width/2.0f) &&
					(touchPoint.getX() < position.first + width/2.0f))
				{
					if ((touchPoint.getY() > position.second - height/2.0f) &&
						(touchPoint.getY() < position.second + height/2.0f))
					{
						Intent intent = new Intent(this, entry.getKey());

						startActivity(intent);

						overrideTransition(event.getEventType(), entry.getKey());
					}
				}
			}
		}
	}

	private void overrideTransition(InputEvent.EventType eventType, Class destination)
	{
		if (destination == NoneScreen.class)
		{
			if (eventType == InputEvent.EventType.SINGLETAP)
			{
				//No transitions at all
				overridePendingTransition(R.anim.hold, R.anim.hold);
			}
			else
			{
				//OS defaults
			}
		}
		else if (destination == SlideScreen.class)
		{
			if (eventType == InputEvent.EventType.SINGLETAP)
			{
				//Incoming slides from left
				overridePendingTransition(R.anim.slide_from_left, R.anim.hold);
			}
			else
			{
				//Incoming slides from left, as outgoing slides to right
				overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
			}
		}
		else if (destination == FadeScreen.class)
		{
			if (eventType == InputEvent.EventType.SINGLETAP)
			{
				//Incoming fades in
				overridePendingTransition(R.anim.fade_in, R.anim.hold);
			}
			else
			{
				//OS defaults
			}
		}
	}
}
