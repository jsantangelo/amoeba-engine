package com.pixelweaverstudios.amoeba.engine.service;

import java.util.EnumMap;

import com.pixelweaverstudios.amoeba.engine.service.input.InputService;
import com.pixelweaverstudios.amoeba.engine.service.input.EngineInput;
import com.pixelweaverstudios.amoeba.engine.service.input.GestureListener;
import com.pixelweaverstudios.amoeba.engine.service.gamethread.GameThreadService;
import com.pixelweaverstudios.amoeba.engine.service.gamethread.StandardGameThread;

public class EngineServicesManager implements ServicesManager
{
	private EnumMap<ServiceType, Service> services;

	public EngineServicesManager()
	{
		createDefaultServices();
	}

	public void createDefaultServices()
	{			
		//Input Services
		InputService inputServices = new EngineInput();
		GestureListener gestureListener = new GestureListener(inputServices);
		services.put(ServiceType.INPUT, inputServices);
		
		//Renderer renderer = new Renderer();
		
		//View view = new View();

		//Thread Services
		GameThreadService gameThread = new StandardGameThread();

		
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
