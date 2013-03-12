package org.amoeba.activity;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import org.amoeba.engine.AmoebaEngine;
import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.InputListener;
import org.amoeba.engine.routing.SurfaceListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.engine.service.ServiceType;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.engine.service.view.ViewService;
import org.amoeba.graphics.camera.Camera;

/**
 * An extension of Activity meant to be inherited.
 * @see Activity
 */
public class GameActivity extends Activity
	implements DrawListener, UpdateListener, InputListener, SurfaceListener
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

		registerForCallbacks();

		setContentView((GLSurfaceView) view);
	}

	/**
	 * Register for all engine callbacks.
	 */
	private void registerForCallbacks()
	{
		getEngine().registerForDraw(this);
		getEngine().registerForUpdate(this);
		getEngine().registerForInputEvents(this);
		getEngine().registerForSurfaceEvents(this);
	}

	/**
	 * Empty, overridable draw callback.
	 * @param camera contains screen/GL information
	 */
	public void onDraw(final Camera camera)
	{
		//Nothing to do here.
	}

	/**
	 * Empty, overridable update callback.
	 */
	public void onUpdate()
	{
		//Nothing to do here.
	}

	/**
	 * Empty, overridable input event callback.
	 * @param event contains information on this motion event
	 */
	public void onInputEvent(final InputEvent event)
	{
		//Nothing to do here.
	}

	/**
	 * Empty, overridable surface creation callback.
	 */
	public void onSurfaceCreated()
	{
		//Nothing to do here.
	}

	/**
	 * Empty, overridable surface change callback.
	 * @param width  width of new screen dimensions
	 * @param height height of new screen dimensions
	 */
	public void onSurfaceChanged(final int width, final int height)
	{
		//Can save off screen dimensions in some sort of state.
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
