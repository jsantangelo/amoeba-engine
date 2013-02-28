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
	private IAmoebaEngine engine;

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
		//new activity starts, example:
		//AmoebaEngine.getInstance().attachToEngine(this);
		engine = AmoebaEngine.getInstance();
		engine.setContext((Context)this);

		registerForCallbacks();
		setWindowFeatures();
		setContentView();
	}

	//register for callbacks here, example:
	//engine.register(myInputHandler, CallbackType.INPUT);
	//This is to be implemented by sub classes, ie user-land (hence abstract)
	abstract public void registerForCallbacks();

	public void setWindowFeatures()
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	public void setContentView()
	{
		//This starts the engine/game. When the content view is created, we will
		//get surface created callbacks which will start the thread, input systems, etc.
		//This is the end of the line.
		setContentView(engine.getService<GLSurfaceView>(ServiceType.VIEW));
	}
}
