package org.amoeba.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import org.amoeba.engine.AmoebaEngine;
import org.amoeba.engine.service.ServiceType;
import org.amoeba.engine.service.view.ViewService;

/**
 * An extension of Activity meant to be inherited.
 * @see Activity
 */
public abstract class GameActivity extends Activity
{
	private AmoebaEngine engine;
	private ViewService view;

	/**
	 * Invoked when the Android OS system creates this Activity. Responsible
	 * for making a new AmoebaEngine, and saving key values to be used
	 * by end-users.
	 *
	 * @param savedInstanceState object that holds the instance state of an
	 *  application for later recreation if necessary
	 */
	@Override
	public void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		engine = new AmoebaEngine(this);

		view = (ViewService) engine.getService(ServiceType.VIEW);

		setWindowFeatures();
	}

	/**
	 * Sets window features of the Activity.
	 */
	private void setWindowFeatures()
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	/**
	 * Callback from the Android OS when this Activity is resumed. This includes
	 * the initial start. Responsible for notifying the view.
	 */
	@Override
	public void onResume()
	{
		super.onResume();
		view.onResume();
	}

	/**
	 * Callback from the Android OS when this Activity is paused. Responsible
	 * for notifying the view.
	 */
	@Override
	public void onPause()
	{
		super.onPause();
		view.onPause();
	}
}
