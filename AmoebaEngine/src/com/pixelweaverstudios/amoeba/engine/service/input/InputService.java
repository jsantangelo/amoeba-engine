package com.pixelweaverstudios.amoeba.engine.service.input;

import com.pixelweaverstudios.amoeba.engine.service.Service;

/**
 * Service maintained by AmoebaEngine, responsible for the initial handling
 * and interpretation of input events from the View.
 */
public interface InputService extends Service
{
	/**
	 * Callback for processed input events by gesture interpreters.
	 * @param event processed AmoebaEngine input event
	 */
	public void handleInputEvent(InputEvent event);
}
