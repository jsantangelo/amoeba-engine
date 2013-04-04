package org.amoeba.examples.transitionsexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.graphics.utilities.GLES20TextureUtilities;
import org.amoeba.graphics.shader.source.TextureShaderProgram;
import org.amoeba.graphics.utilities.TextureUtilities;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.engine.service.input.InputEvent;

import android.util.Log;
import android.opengl.GLES20;

public class NoneScreen extends GameActivity
{
	private static final String TAG = "Amoeba.NoneScreen";

	private TextureShaderProgram program;
	private TextureUtilities textureUtilities;

	private boolean alternateTransitionChosen;

	public NoneScreen()
	{
		textureUtilities = new GLES20TextureUtilities(this);
		program = new TextureShaderProgram();

		alternateTransitionChosen = false;
	}

	@Override
	public void onSurfaceCreated()
	{
		program.compile();
		program.link();
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{

	}

	@Override
	public void onDraw(final Camera camera)
	{
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
