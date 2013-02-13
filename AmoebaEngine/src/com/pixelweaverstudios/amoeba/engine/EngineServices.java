package com.pixelweaverstudios.amoeba.engine;

import com.pixelweaverstudios.amoeba.engine.input.EngineEvent;
import com.pixelweaverstudios.amoeba.engine.input.InputManager;

public class EngineServices implements IEngineServices
{
	public EngineServices()
	{
		createDefaultComponents();
	}

	public void createDefaultComponents()
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
