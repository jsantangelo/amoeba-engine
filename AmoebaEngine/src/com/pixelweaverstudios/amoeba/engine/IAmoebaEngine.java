package com.pixelweaverstudios.amoeba.engine;

import android.opengl.GLSurfaceView;

/**
 * An interface defining the publicly accessible methods of the AmoebaEngine.
 */
public interface IAmoebaEngine
{
	/**
	 * Adds a Screen to the ScreenManager of the Engine.
	 * @see Screen
	 * @see ScreenManager
	 */
	public void addScreen();

	/**
	 * Returns the ContentView instance of the Engine.
	 * @return the content view
	 */
	public GLSurfaceView getContentView();
}
