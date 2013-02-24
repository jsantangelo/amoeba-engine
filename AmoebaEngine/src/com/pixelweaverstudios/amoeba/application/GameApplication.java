package com.pixelweaverstudios.amoeba.application;

import android.app.Application;
import android.view.Window;
import android.view.WindowManager;
import android.opengl.GLSurfaceView;

import com.pixelweaverstudios.amoeba.engine.IAmoebaEngine;
import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;

/**
 * A subclass of Application meant to be inherited by the end-user's main Activity.
 * @see Activity
 */
public abstract class GameApplication extends Application
{
	/**
	 * Is invoked when the Android OS system creates this Application. onCreate
	 * is the entry point for all Android applications.
	 */
	@Override
	public void onCreate()
	{
		super.onCreate();

		//create engine
		//start first activity
	}
}
