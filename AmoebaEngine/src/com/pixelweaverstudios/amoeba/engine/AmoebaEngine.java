package com.pixelweaverstudios.amoeba.engine;

import android.content.Context;

import com.pixelweaverstudios.amoeba.engine.service.ServicesManager;
import com.pixelweaverstudios.amoeba.engine.service.EngineServicesManager;
import com.pixelweaverstudios.amoeba.engine.service.ServiceType;
import com.pixelweaverstudios.amoeba.engine.service.Service;

/**
 * The main class in which the AmoebaEngine is encapsulated. Provides access to
 * all major components of the Engine to the end-user.
 */
public class AmoebaEngine
{
	private static AmoebaEngine instance = null;

	private ServicesManager services;
	private Context currentContext;

	/**
	 * Constructor.
	 */
	public AmoebaEngine()
	{
		services = new EngineServicesManager();
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
		//create services and tie together all services for callbacks
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
		return context;
	}
}
