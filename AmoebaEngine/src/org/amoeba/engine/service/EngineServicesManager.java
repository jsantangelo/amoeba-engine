package org.amoeba.engine.service;

import java.util.EnumMap;

import org.amoeba.engine.service.gamethread.ConstantGameSpeedWithFrameSkippingGameThread;
import org.amoeba.engine.service.gamethread.GameThreadService;
import org.amoeba.engine.service.input.EngineInput;
import org.amoeba.engine.service.input.GestureListener;
import org.amoeba.engine.service.input.InputService;


/**
 * Implementation of the ServicesManager component of AmoebaEngine. Responsible
 * for creating, maintaining and providing access to any/all services provided
 * by AmoebaEngine.
 */
public class EngineServicesManager implements ServicesManager
{
	private EnumMap<ServiceType, Service> services;

	/**
	 * Constructor.
	 */
	public EngineServicesManager()
	{
		createDefaultServices();
	}

	/**
	 * Creates the services of the AmoebaEngine with the default implementations
	 * provided with the Engine. Ties together all services if necessary.
	 */
	public void createDefaultServices()
	{
		//Input Services
		InputService inputServices = new EngineInput();
		GestureListener gestureListener = new GestureListener(inputServices);
		services.put(ServiceType.INPUT, inputServices);

		//Renderer renderer = new Renderer();

		//View view = new View();

		//Thread Services
		GameThreadService gameThread = new ConstantGameSpeedWithFrameSkippingGameThread();
	}

	/**
	 * Retrieves a service specified by a service type.
	 * @param  service service type
	 * @return         request service provided by AmoebaEngine
	 */
	public Service getService(final ServiceType service)
	{
		return services.get(service);
	}

	/**
	 * Notifies all services to prepare for execution (and therefore finalize all
	 * setup).
	 */
	public void start()
	{
		for (Service service : services.values())
		{
			service.start();
		}
	}
}
