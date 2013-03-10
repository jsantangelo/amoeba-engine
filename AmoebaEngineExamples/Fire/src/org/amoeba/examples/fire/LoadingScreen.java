package org.amoeba.examples.fire;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.InputListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.engine.service.input.InputEvent;

import android.opengl.GLES20;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;

public class LoadingScreen extends GameActivity
	implements DrawListener, UpdateListener, InputListener
{
	private static final String TAG = "Amoeba.Fire";

	private static int someNumber = 0;

	//Must be implemented. Use to do anything needed before game starts.
	public void initialize()
	{
		registerForCallbacks();
	}

	private void registerForCallbacks()
	{
		getEngine().registerForDraw(this);
		getEngine().registerForUpdate(this);
		getEngine().registerForInput(this);
	}

	public void onDraw()
	{
		if (someNumber < 100)
		{
			GLES20.glClearColor(0.371f, 0.617f, 0.625f, 1.0f);
		}
		else
		{
			GLES20.glClearColor(0.273f, 0.507f, 0.703f, 1.0f);
		}
	}

	public void onUpdate()
	{
		++someNumber;
		if (someNumber > 200)
		{
			someNumber = 0;
		}
	}

	public void onInputEvent(final InputEvent event)
	{
		Log.d(TAG, "onInputEvent handled");

		if (event.getEventType() == InputEvent.EventType.LONGPRESS)
		{
			Intent intent = new Intent(this, MainMenuScreen.class);
			startActivity(intent);
		}
	}
}
