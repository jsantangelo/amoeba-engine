package org.amoeba.examples.fire;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.graphics.camera.Camera;

import android.opengl.GLES20;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;

public class LoadingScreen extends GameActivity
{
	private static final String TAG = "Amoeba.Fire";

	private static int someNumber = 0;

	@Override
	public void onDraw(final Camera camera)
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

	@Override
	public void onUpdate()
	{
		++someNumber;
		if (someNumber > 200)
		{
			someNumber = 0;
		}
	}

	@Override
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
