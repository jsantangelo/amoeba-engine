package com.pixelweaverstudios.amoeba.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.opengl.GLSurfaceView;
import android.content.Context;

import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;
import com.pixelweaverstudios.amoeba.engine.IAmoebaEngine;

/**
 * An extension of Activity meant to be inherited.
 * @see Activity
 */
public abstract class GameActivity extends Activity
{
	/**
	 * Invoked when the Android OS system starts this Activity (potentially
	 * invoked from an Intent). onCreate is the entry point for all Android
	 * activities.
	 *
	 * @param savedInstanceState object that holds the instance state of an
	 *  application for later recreation if necessary
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//TODO: make more generic? other things need to be done when
		//new activity starts
		AmoebaEngine.getInstance().setContext((Context)this);

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
		//setContentView((GLSurfaceView)getEngine().getContentView());
	}
}
