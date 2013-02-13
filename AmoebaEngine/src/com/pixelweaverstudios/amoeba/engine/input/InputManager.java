package com.pixelweaverstudios.amoeba.engine.input;

import com.pixelweaverstudios.amoeba.engine.IEngineServices;

public class InputManager
{
	IGestureListener gestureListener;
	IEngineServices services;

	public InputManager(IEngineServices services, IGestureListener gestureListener)
	{
		this.services = services;
		this.gestureListener = gestureListener;
	}
}