package com.pixelweaverstudios.amoeba.engine;

import com.pixelweaverstudios.amoeba.engine.input.EngineEvent;
import com.pixelweaverstudios.amoeba.engine.input.InputManager;

public class ServicesManager implements IServicesManager
{
	public ServicesManager()
	{
		createDefaultServices();
	}

	public void createDefaultServices()
	{	
		//ScreenManager screenManager = new ScreenManager();
		//InputManager inputManager = new InputManager(this);
		//Renderer renderer = new Renderer();
		//GameLoop gameLoop = new GameLoop();
		//View view = new View();
	}

	public void handleInputEvent(EngineEvent inputEvent)
	{
		
	}
}
