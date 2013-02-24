package com.pixelweaverstudios.amoeba.engine.input;

import com.pixelweaverstudios.amoeba.engine.IServicesManager;

public class InputServices implements IInputServices
{
	IGestureListener gestureListener;

	public InputServices(IGestureListener gestureListener)
	{
		this.services = services;
		this.gestureListener = gestureListener;
	}
}