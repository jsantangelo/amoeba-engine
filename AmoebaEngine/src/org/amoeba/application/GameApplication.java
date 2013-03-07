package org.amoeba.application;

import org.amoeba.engine.AmoebaEngine;

import android.app.Application;


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
		//add/start loading screen activity via intent invocation
		//Application is now done; we won't be coming back here unless the application
		//is entirely destroyed (cleaned up) by the OS.
	}
}
