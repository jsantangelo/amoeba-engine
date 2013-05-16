package org.amoeba.examples.transitionsexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.graphics.camera.Camera;

import android.opengl.GLES20;

public class FadeScreen extends GameActivity
{

	@Override
	public void onDraw(final Camera camera)
	{
		super.onDraw(camera);
		GLES20.glClearColor(1.0f, 1.0f, 0.0f, 1.0f);
	}

	@Override
	public void onPause()
	{
		super.onPause();
		overridePendingTransition(R.anim.hold, R.anim.fade_out);
	}
}
