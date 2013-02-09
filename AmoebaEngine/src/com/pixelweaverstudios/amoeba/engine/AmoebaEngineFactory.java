package com.pixelweaverstudios.amoeba.engine;

public class AmoebaEngineFactory
{
	Context context;
	IAmoebaEngine engine;

	//Components created by the factory
	IGameLoop gameLoop;
	GestureListener gestureListener;
	AmoebaEngineView view;
	AmoebaEngineSurfaceListener surfaceListener;
	AmoebaEngineRenderer renderer;

	public AmoebaEngineFactory(Context context, IAmoebaEngine engine)
	{
		this.context = context;
		this.engine = engine;
	}

	public createDefaultComponents()
	{
		//Create default components and tie them together
		//Factory is responsible for replacing and retying pieces should one be
		//replaced by end user
	}

	//Setters and getters
	//TODO - add getters for all components if necessary

}