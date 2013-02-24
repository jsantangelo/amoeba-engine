package com.pixelweaverstudios.amoeba.engine;

import android.content.Context;

import com.pixelweaverstudios.amoeba.engine.view.IAmoebaEngineView;

/**
 * An interface defining the publicly accessible methods of the AmoebaEngine.
 */
public interface IAmoebaEngine
{
	//Commented out below are likely services that the engine will expose to the game
	//activity.
	//public void addScreen();
	//public void setGameLoopType(SOME_ENUM);
	
	//Services for GestureDetection
	// public void enableGesture(GestureType type);
	// public void disableGesture(GestureType type);

	//public void start();

	/**
	 * Returns the ContentView instance of the Engine.
	 * @return the content view
	 */
	//public IAmoebaEngineView getContentView();
	
	public void setContext(Context context);
	public Context getContext();
}
