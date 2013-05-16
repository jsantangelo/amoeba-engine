package org.amoeba.examples.transitionsexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.engine.service.input.InputEvent;

import android.opengl.GLES20;

public class NoneScreen extends GameActivity
{
	private boolean alternateTransitionChosen;

	public NoneScreen()
	{
		alternateTransitionChosen = false;
	}

	@Override
	public void onDraw(final Camera camera)
	{
		super.onDraw(camera);
		GLES20.glClearColor(0.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public void onPause()
	{
		super.onPause();
		if (!alternateTransitionChosen)
		{
			overridePendingTransition(0, 0);
		}
	}

	@Override
	public void onInputEvent(final InputEvent event)
	{
		if (event.getEventType() == InputEvent.EventType.LONGPRESS)
		{
			alternateTransitionChosen = true;

			finish();
		}
	}
}
