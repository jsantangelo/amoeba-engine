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
	private Context context;

	public AmoebaEngine()
	{
		services = new EngineServicesManager();
	}

	public static AmoebaEngine getInstance()
	{
		if (instance == null)
		{
			instance = new AmoebaEngine();
		}
		return instance;
	}

	public void attachToEngine(Context context)
	{
		setContext(context);
		//create services and tie together all services for callbacks
	}

	public void setContext(Context context)
	{
		this.context = context;
	}

	public Service getService(ServiceType service)
	{
		return services.getService(service);
	}

	public Context getContext()
	{
		return context;
	}
}
