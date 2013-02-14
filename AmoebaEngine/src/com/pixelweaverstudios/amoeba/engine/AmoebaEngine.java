package com.pixelweaverstudios.amoeba.engine;

import android.content.Context;
//import android.opengl.GLSurfaceView;

import com.pixelweaverstudios.amoeba.engine.view.IAmoebaEngineView;

/**
 * The main class in which the AmoebaEngine is encapsulated. Provides access to
 * all major components of the Engine to the end-user.
 */
public class AmoebaEngine implements IAmoebaEngine
{
	private IAmoebaEngineView view;
	private IServicesManager services;
	//private IScreenManager screenManager;
	//private IGameLoop gameLoop;
	private static Context context;

	public AmoebaEngine(Context context)
	{
		services = new ServicesManager();
		AmoebaEngine.context = context;
	}

	public static Context getContext()
	{
		return context;
	}

	public void start()
	{
		//Below is questionable. Needs more thought.
		//glSurfaceView.start();
		//factory.getView().start();
	}

	/**
	 * Returns the ContentView of the Engine.
	 * @return the content view
	 */
	public IAmoebaEngineView getContentView()
	{
		return view;
	}
}
