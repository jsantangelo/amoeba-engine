package org.amoeba.engine;

import android.content.Context;

import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.EngineRouter;
import org.amoeba.engine.routing.InputListener;
import org.amoeba.engine.routing.Router;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.engine.service.EngineServicesManager;
import org.amoeba.engine.service.Service;
import org.amoeba.engine.service.ServicesManager;
import org.amoeba.engine.service.ServiceType;

/**
 * The main class in which the AmoebaEngine is encapsulated. Provides access to
 * all major components of the Engine to the end-user.
 */
public class AmoebaEngine
{
	private Router router;
	private ServicesManager services;

	/**
	 * Constructor. Responsible for creating the EngineRouter and ServicesManager.
	 * @param context the current Activity context
	 */
	public AmoebaEngine(final Context context)
	{
		router = new EngineRouter();
		services = new EngineServicesManager(context, router);
	}

	/**
	 * Returns a service provided by AmoebaEngine, specified by a type.
	 * @param  service service type
	 * @return         the requested service
	 */
	public Service getService(final ServiceType service)
	{
		return services.getService(service);
	}

	/**
	 * Registers a listener for draw callbacks.
	 * @param listener entity that wishes to recieve draw callbacks
	 */
	public void registerForDraw(final DrawListener listener)
	{
		router.registerForDraw(listener);
	}

	/**
	 * Registers a listener for update callbacks.
	 * @param listener entity that wishes to recieve update callbacks.
	 */
	public void registerForUpdate(final UpdateListener listener)
	{
		router.registerForUpdate(listener);
	}

	/**
	 * Registers a listener for input event callbacks.
	 * @param listener entity that wishes to recieve input callbacks.
	 */
	public void registerForInput(final InputListener listener)
	{
		router.registerForInput(listener);
	}
}
