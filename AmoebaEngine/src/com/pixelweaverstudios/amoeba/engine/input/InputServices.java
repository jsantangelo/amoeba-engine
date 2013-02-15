package com.pixelweaverstudios.amoeba.engine.input;

import com.pixelweaverstudios.amoeba.engine.IServicesManager;

public class InputServices
{
	IGestureListener gestureListener;
	IServicesManager services;

	public InputServices(IServicesManager services, IGestureListener gestureListener)
	{
		this.services = services;
		this.gestureListener = gestureListener;
	}
}