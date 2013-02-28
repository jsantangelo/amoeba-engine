package com.pixelweaverstudios.amoeba.engine.service.input;

import com.pixelweaverstudios.amoeba.engine.service.Service;

public interface InputService extends Service
{
	public void handleInputEvent(EngineEvent event);
}