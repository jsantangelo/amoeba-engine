package com.pixelweaverstudios.amoeba.engine;

import android.content.Context;

import com.pixelweaverstudios.amoeba.engine.;

/**
 * The main class in which the AmoebaEngine is encapsulated. Provides access to
 * all major components of the Engine to the end-user.
 */
public class AmoebaEngine implements IAmoebaEngine
{
	private static IAmoebaEngine instance = null;

	private IServicesManager services;
	private Context context;

	public AmoebaEngine()
	{
		services = new ServicesManager();
	}

	public static IAmoebaEngine getInstance()
	{
		if (instance == null)
		{
			instance = new AmoebaEngine();
		}
		return instance;
	}

	public setContext(Context context)
	{
		this.context = context;
	}

	public <T> T getService(ServiceTypes service)
	{
		return (T)(services.getService(service));
	}
}
