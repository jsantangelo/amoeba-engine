package com.pixelweaverstudios.amoeba.engine.input;

import com.pixelweaverstudios.amoeba.engine.IServicesManager;

public class InputManager
{
	IGestureListener gestureListener;
	IServicesManager services;

	public InputManager(IServicesManager services, IGestureListener gestureListener)
	{
		this.services = services;
		this.gestureListener = gestureListener;
	}
}