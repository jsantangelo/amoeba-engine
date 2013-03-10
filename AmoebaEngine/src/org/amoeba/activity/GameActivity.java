package org.amoeba.activity;

import android.app.Activity;
import android.opengl.GLSurfaceView;
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
	 * Returnes the AmoebaEngine for this Activity.
	 * @return the engine
	 */
	protected AmoebaEngine getEngine()
	{
		return engine;
	}

	/**
	 * Returns the ViewService for this Activity.
	 * @return the ViewService
	 */
	protected ViewService getView()
	{
		return view;
	}

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

		initialize();

		setContentView((GLSurfaceView) view);
	}

	/**
	 * Initialization/setup meant to be done by any sub classes (end-user).
	 */
	public abstract void initialize();

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
