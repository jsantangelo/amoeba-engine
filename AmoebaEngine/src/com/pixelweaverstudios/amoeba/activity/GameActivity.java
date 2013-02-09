package com.pixelweaverstudios.amoeba.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.pixelweaverstudios.amoeba.engine.IAmoebaEngine;
import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;

/**
 * An extension of Activity meant to be inherited by the end-user's main Activity.
 * @see Activity
 */
public abstract class GameActivity extends Activity
{
	private IAmoebaEngine engine;

	/**
	 * Is invoked when the Android OS system creates this Activity. onCreate
	 * is the entry point for all Android applications.
	 *
	 * @param savedInstanceState object that holds the instance state of an
	 *  application for later recreation if necessary
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	public void start()
	{
		engine.start();
		setWindowFeatures();
		setContentView();
	}

	public void setWindowFeatures()
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	public void setContentView()
	{
		setContentView(getEngine().getContentView());
	}

	/**
	 * Returns a single instance of the engine.
	 * @return IAmoebaEngine
	 */
	public IAmoebaEngine getEngine()
	{
		if (engine == null)
		{
			engine = new AmoebaEngine(this);
		}
		return engine;
	}
}
