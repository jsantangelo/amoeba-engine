package org.amoeba.examples.transitionsexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.entity.sprite.Sprite;

import android.util.Log;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends GameActivity
{
	private static final String TAG = "Amoeba.SplashScreen";

	private Sprite splash_background;
	private Sprite amoeba_splash;

	//Duration of the splash screen in milliseconds.
	private static final int SPLASH_DISPLAY_TIME = 2500;

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		splash_background = getGraphicsService().getSpriteFactory().createSprite(R.drawable.splash_bg);
		amoeba_splash = getGraphicsService().getSpriteFactory().createSprite(R.drawable.amoeba_splash);

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
	public void onSurfaceChanged(final int width, final int height)
	{
		splash_background.setPosition(width/2, height/2);
		amoeba_splash.setPosition(width/2, height/2);
	}

}
