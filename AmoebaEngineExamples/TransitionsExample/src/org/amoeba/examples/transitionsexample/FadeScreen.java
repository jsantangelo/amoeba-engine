package org.amoeba.examples.transitionsexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.graphics.utilities.GLES20TextureUtilities;
import org.amoeba.graphics.shader.source.TextureShaderProgram;
import org.amoeba.graphics.utilities.TextureUtilities;
import org.amoeba.graphics.camera.Camera;

import android.util.Log;
import android.opengl.GLES20;

public class FadeScreen extends GameActivity
{
	private static final String TAG = "Amoeba.FadeScreen";

	private TextureShaderProgram program;
	private TextureUtilities textureUtilities;

	public FadeScreen()
	{
		textureUtilities = new GLES20TextureUtilities(this);
		program = new TextureShaderProgram();
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
		GLES20.glClearColor(1.0f, 1.0f, 0.0f, 1.0f);
	}

	@Override
	public void onPause()
	{
		super.onPause();
		overridePendingTransition(R.anim.hold, R.anim.fade_out);
	}
}
