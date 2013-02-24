package com.pixelweaverstudios.amoeba.application;

import android.app.Application;

import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;

/**
 * A subclass of Application meant to be inherited by the end-user's main Application.
 * @see Application
 */
public abstract class GameApplication extends Application
{
	/**
	 * Invoked when the Android OS system creates this Application. onCreate
	 * is the entry point for all Android applications.
	 */
	@Override
	public void onCreate()
	{
		super.onCreate();

		AmoebaEngine.getInstance();
		//customize engine here if desired
		//add/start loading screen activity
	}
}
