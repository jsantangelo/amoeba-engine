package org.amoeba.examples.transitionsexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.entity.sprite.Sprite;
import org.amoeba.entity.sprite.TextureSprite;
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
import android.view.View;
import android.os.Handler;

public class SplashScreen extends GameActivity
{
	private static final String TAG = "Amoeba.SplashScreen";

	private TextureShaderProgram program;
	private TextureUtilities textureUtilities;

	private Texture splash_background_texture;
	private Sprite splash_background;

	private Texture amoeba_splash_texture;
	private Sprite amoeba_splash;

	//Duration of the splash screen in milliseconds.
	private static final int SPLASH_DISPLAY_TIME = 5000;

	public SplashScreen()
	{
		textureUtilities = new GLES20TextureUtilities(this);
		program = new TextureShaderProgram();

		splash_background_texture = new BitmapTexture(textureUtilities,
			textureUtilities.getTextureOptionsPreset(Preset.DEFAULT),
			R.drawable.splash_bg);
		splash_background = new TextureSprite(splash_background_texture, program);

		amoeba_splash_texture = new BitmapTexture(textureUtilities,
			textureUtilities.getTextureOptionsPreset(Preset.DEFAULT),
			R.drawable.amoeba_splash);
		amoeba_splash = new TextureSprite(amoeba_splash_texture, program);

		new Handler().postDelayed(new Runnable()
		{
			public void run()
			{
				Intent intent = new Intent(SplashScreen.this, MainMenuScreen.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

				SplashScreen.this.startActivity(intent);
				SplashScreen.this.finish();
				overridePendingTransition(R.anim.fade_in, R.anim.hold);
			}
		}, SPLASH_DISPLAY_TIME);
	}

	@Override
	public void onSurfaceCreated()
	{
		program.compile();
		program.link();

		splash_background_texture.load();
		splash_background.load();

		amoeba_splash_texture.load();
		amoeba_splash.load();
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		splash_background.setPosition(width/2, height/2);
		splash_background.setScaleX(width);
		splash_background.setScaleY(height);

		amoeba_splash.setPosition(width/2, height/2);
		amoeba_splash.setScaleX(350.0f);
		amoeba_splash.setScaleY(150.0f);
	}

	@Override
	public void onDraw(final Camera camera)
	{
		GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

		splash_background.onDraw(camera);
		amoeba_splash.onDraw(camera);
	}

}
