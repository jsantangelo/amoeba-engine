package com.pixelweaverstudios.amoeba.engine;

import android.opengl.GLSurfaceView;

/**
 * An interface defining the publicly accessible methods of the AmoebaEngine.
 */
public interface IAmoebaEngine implements IGestureConfigurator
{
	//Commented out below are likely services that the engine will expose to the game
	//activity.
	//public void addScreen();
	//public void setGameLoopType(SOME_ENUM);
	
	//Services for GestureDetection
	// public void enableGesture(GestureType type);
	// public void disableGesture(GestureType type);

	public void start();

	/**
	 * Returns the ContentView instance of the Engine.
	 * @return the content view
	 */
	public GLSurfaceView getContentView();
}
