package org.amoeba.examples.transitionsexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.engine.service.input.InputEvent;

import android.opengl.GLES20;

public class SlideScreen extends GameActivity
{
	private boolean alternateTransitionChosen;

	public SlideScreen()
	{
		alternateTransitionChosen = false;
	}

	@Override
	public void onDraw(final Camera camera)
	{
		super.onDraw(camera);
		GLES20.glClearColor(1.0f, 0.0f, 1.0f, 1.0f);
	}

	@Override
	public void onPause()
	{
		super.onPause();
		if (!alternateTransitionChosen)
		{
			overridePendingTransition(R.anim.hold, R.anim.slide_to_left);
		}
	}

	@Override
	public void onInputEvent(final InputEvent event)
	{
		if (event.getEventType() == InputEvent.EventType.LONGPRESS)
		{
			alternateTransitionChosen = true;

			finish();
			overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
		}
	}
}
