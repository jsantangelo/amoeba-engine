package org.amoeba.examples.transitionsexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.entity.sprite.Sprite;
import org.amoeba.entity.Coordinates;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.source.TextureShaderProgram;
import org.amoeba.graphics.texture.BitmapTexture;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions.Preset;
import org.amoeba.graphics.utilities.GLES20TextureUtilities;
import org.amoeba.graphics.utilities.TextureUtilities;

import android.util.Log;
import android.opengl.GLES20;
import android.content.Intent;
import android.os.SystemClock;
import android.view.animation.Animation;
import android.view.animation.AlphaAnimation;
import android.view.View;

public class SplashScreen extends GameActivity
{
	private static final String TAG = "Amoeba.SplashScreen";

	private TextureShaderProgram program;
	private TextureUtilities textureUtilities;
	private Texture amoeba_splash_texture;

	private Sprite amoeba_splash;

	private static int screenWidth, screenHeight;

	//Duration of the splash screen in milliseconds.
	private static final int splashScreenDuration = 5000;
	private static long timeToTransition = 0;
	private static boolean transitioned = false;

	Animation fadeInAnimation = null;
	Animation fadeOutAnimation = null;

	public SplashScreen()
	{
		screenWidth = 1;
		screenHeight = 1;

		textureUtilities = new GLES20TextureUtilities(this);
		program = new TextureShaderProgram();
		amoeba_splash_texture = new BitmapTexture(textureUtilities,
			textureUtilities.getTextureOptionsPreset(Preset.DEFAULT),
			R.drawable.amoeba_splash);
		amoeba_splash = new Sprite(amoeba_splash_texture, program);

		fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
		fadeInAnimation.setDuration(300);

		fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
		fadeOutAnimation.setDuration(300);
	}

	@Override
	public void onSurfaceCreated()
	{
		Log.d(TAG, "activity is doing surface created tasks...");

		program.compile();
		program.link();

		amoeba_splash_texture.load();
		amoeba_splash.load();

		transitioned = false;
		timeToTransition = SystemClock.uptimeMillis() + splashScreenDuration;
		Log.d(TAG, "current time = " + SystemClock.uptimeMillis());
		Log.d(TAG, "time to transition = " + timeToTransition);
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		screenWidth = width;
		screenHeight = height;

		amoeba_splash.setPosition(new Coordinates(screenWidth/2, screenHeight/2));
		amoeba_splash.setScaleX(350.0f);
		amoeba_splash.setScaleY(150.0f);
	}

	@Override
	public void onDraw(final Camera camera)
	{
		GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

		amoeba_splash.onDraw(camera);
	}

	@Override
	public void onUpdate()
	{
		//Log.d(TAG, "transitioned = " + transitioned);
		if (!transitioned &&
			timeToTransition != 0 &&
			SystemClock.uptimeMillis() > timeToTransition)
		{
			Log.d(TAG, "transitioning to mainscreen");
			transitioned = true;
			Intent intent = new Intent(this, MainMenuScreen.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			finish();
		}
	}

	@Override
	public void onInputEvent(final InputEvent event)
	{

	}
}
