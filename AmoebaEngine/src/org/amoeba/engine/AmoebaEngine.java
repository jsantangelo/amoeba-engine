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
	private static AmoebaEngine instance = null;

	private Router router;
	private ServicesManager services;
	private Context currentContext;

	/**
	 * Constructor.
	 */
	public AmoebaEngine()
	{
		router = new EngineRouter();

		services = new EngineServicesManager(router);
	}

	/**
	 * Returns the static instance of AmoebaEngine.
	 * @return the instance of AmoebaEngine
	 */
	public static AmoebaEngine getInstance()
	{
		if (instance == null)
		{
			instance = new AmoebaEngine();
		}
		return instance;
	}

	/**
	 * Prepares the engine for a newly created Activity. To be called by
	 * an Activity on creation before the engine is used.
	 * @param context the Android context
	 */
	public void attachToEngine(final Context context)
	{
		setContext(context);
	}

	/**
	 * Set the context held by AmoebaEngine to the provided context for use by
	 * AmoebaEngine services.
	 * @param context the Android context
	 */
	public void setContext(final Context context)
	{
		currentContext = context;
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
	 * Retrieve the context held by the AmoebaEngine.
	 * @return the current Android context saved by AmoebaEngine
	 */
	public Context getContext()
	{
		return currentContext;
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
