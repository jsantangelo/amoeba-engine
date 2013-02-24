package com.pixelweaverstudios.amoeba.engine.service;

import java.util.EnumMap;

//Input
import com.pixelweaverstudios.amoeba.engine.service.input.*;

public class ServicesManager implements IServicesManager
{
	private EnumMap<ServiceType, Service> services;

	public ServicesManager()
	{
		createDefaultServices();
	}

	public void createDefaultServices()
	{			
		//Input Services
		IInputServices inputServices = new InputServices();
		IGestureListener gestureListener = new GestureListener(inputServices);
		services.put(ServiceType.INPUT, inputServices);
		
		//Renderer renderer = new Renderer();
		//GameLoop gameLoop = new GameLoop();
		//View view = new View();
	}
	
	public Service getService(ServiceType service)
	{
		return services.get(service);
	}

	public void start()
	{
		for (Service service : services.values())
		{
			service.start();
		}
	}
}
