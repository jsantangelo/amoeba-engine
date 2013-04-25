package org.amoeba.activity;

import org.amoeba.engine.AmoebaEngine;
import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.InputListener;
import org.amoeba.engine.routing.SurfaceListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.engine.service.ServiceType;
import org.amoeba.engine.service.graphics.GraphicsService;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.engine.service.input.InputService;
import org.amoeba.engine.service.view.ViewService;
import org.amoeba.graphics.camera.Camera;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * An extension of Activity meant to be inherited.
 * @see Activity
 */
public class GameActivity extends Activity
	implements DrawListener, UpdateListener, InputListener, SurfaceListener
{
	private static final String TAG = "Amoeba.GameActivity";

	private AmoebaEngine engine;
	private ViewService view;
	private InputService input;
	private GraphicsService graphics;

	/**
	 * Returns the AmoebaEngine for this Activity.
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
	 * Returns the InputService for this Activity.
	 * @return the InputService
	 */
	protected InputService getInputService()
	{
		return input;
	}

	/**
	 * Returns the GraphicsService for this Activity.
	 * @return the GraphicsService
	 */
	protected GraphicsService getGraphicsService()
	{
		return graphics;
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
	protected void onCreate(final Bundle savedInstanceState)
	{
		Log.d(TAG, "GameActivity onCreate...");

		super.onCreate(savedInstanceState);

		engine = new AmoebaEngine(this);

		view = (ViewService) engine.getService(ServiceType.VIEW);
		input = (InputService) engine.getService(ServiceType.INPUT);
		graphics = (GraphicsService) engine.getService(ServiceType.GRAPHICS);

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

	@Override
	protected void onStart()
	{
		Log.d(TAG, "GameActivity onStart...");
		super.onStart();
	}

	@Override
	protected void onRestart()
	{
		Log.d(TAG, "GameActivity onRestart...");
		super.onRestart();
	}

	@Override
	protected void onStop()
	{
		Log.d(TAG, "GameActivity onStop...");
		super.onStop();
	}

	@Override
	protected void onDestroy()
	{
		Log.d(TAG, "GameActivity onDestroy...");
		getEngine().deregisterForAll();
		super.onDestroy();
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
		Log.d(TAG, "GameActivity onResume...");
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
		Log.d(TAG, "GameActivity onPause...");
		super.onPause();
		view.onPause();
	}
}
