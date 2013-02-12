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
	//private AmoebaEngineFactory factory;
	private EngineServices services;
	//private IScreenManager screenManager;
	//private IGameLoop gameLoop;
	private static Context context;

	public AmoebaEngine(Context context)
	{

		//factory = new AmoebaEngineFactory(context, this);
		services = new EngineServices();
		AmoebaEngine.context = context;

		//factory.createDefaultComponents();

		//Line below should be in factory
		//view = new AmoebaEngineView(context, this);
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
