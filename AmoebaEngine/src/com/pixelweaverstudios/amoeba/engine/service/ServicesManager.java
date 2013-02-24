package com.pixelweaverstudios.amoeba.engine.service;

//Input
import com.pixelweaverstudios.amoeba.engine.input.InputServices;
import com.pixelweaverstudios.amoeba.engine.input.GestureListener;

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
		IInputServices inputServices = new InputServices(gestureListener);
		IGestureListener gestureListener = new GestureListener(inputServices);
		services.put(INPUT, inputServices);
		
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
