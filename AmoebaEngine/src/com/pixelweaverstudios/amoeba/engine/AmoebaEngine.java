package com.pixelweaverstudios.amoeba.engine;

import android.opengl.GLSurfaceView;

import com.pixelweaverstudios.amoeba.engine.IAmoebaEngine;

/**
 * The main class in which the AmoebaEngine is encapsulated. Provides access to
 * all major components of the Engine to the end-user.
 */
public class AmoebaEngine implements IAmoebaEngine
{
	private GLSurfaceView glSurfaceView;

	/**
	 * Adds a Screen to the ScreenManager.
	 */
	public void addScreen()
	{

	}

	/**
	 * Returns the ContentView of the Engine.
	 * @return the content view
	 */
	public GLSurfaceView getContentView()
	{
		return glSurfaceView;
	}
}
