package com.pixelweaverstudios.amoeba.engine;

import android.opengl.GLSurfaceView;

import com.pixelweaverstudios.amoeba.engine.IAmoebaEngine;

/**
 * The main class in which the AmoebaEngine is encapsulated. Provides access to
 * all major components of the Engine to the end-user.
 */
public class AmoebaEngine implements IAmoebaEngine
{
	private IAmoebaEngineView view;
	private AmoebaEngineFactory factory;
	//private IScreenManager screenManager;
	//private IGameLoop gameLoop;

	public AmoebaEngine(Context context)
	{

		factory = new AmoebaEngineFactory(context, this);

		factory.createDefaultComponents();

		//Line below should be in factory
		//view = new AmoebaEngineView(context, this);
	}

	public void start()
	{
		//Below is questionable. Needs more thought.
		//glSurfaceView.start();
		factory.getView().start();
	}

	// public void enableGesture()
	// {
	// 	glSurfaceView.enableGesture(type);
	// }

	// public void disableGesture()
	// {
	// 	glSurfaceView.disableGesture(type);
	// }

	/**
	 * Returns the ContentView of the Engine.
	 * @return the content view
	 */
	public IAmoebaEngineView getContentView()
	{
		return view;
	}
}
