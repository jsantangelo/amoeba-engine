package com.pixelweaverstudios.amoeba.engine;

import com.pixelweaverstudios.amoeba.engine.input.EngineEvent;
import com.pixelweaverstudios.amoeba.engine.input.InputServices;
import com.pixelweaverstudios.amoeba.engine.input.GestureListener;

public class ServicesManager implements IServicesManager
{
	public ServicesManager()
	{
		createDefaultServices();
	}

	public void createDefaultServices()
	{	
		//ScreenManager screenManager = new ScreenManager();
		
		//Input Services
		GestureListener gestureListener = new GestureListener(this);
		InputServices inputServices = new InputServices(this, gestureListener);
		
		//Renderer renderer = new Renderer();
		//GameLoop gameLoop = new GameLoop();
		//View view = new View();
	}

	public void handleInputEvent(EngineEvent inputEvent)
	{
		
	}
}
