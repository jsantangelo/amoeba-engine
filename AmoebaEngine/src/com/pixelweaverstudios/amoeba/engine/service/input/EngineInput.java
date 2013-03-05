package com.pixelweaverstudios.amoeba.engine.service.input;

/**
 * Implementation of the service responsible for input interpretation.
 */
public class EngineInput implements InputService
{
	/**
	 * Constructor.
	 */
	public EngineInput()
	{
		//will eventually save off reference to whowever needs to be called back
		//by input events. InputServices is essentially an event router.
	}

	/**
	 * Processes an input event.
	 * @param event and InputEvent from the core Android OS
	 */
	public void handleInputEvent(InputEvent event)
	{

	}

	/**
	 * Notifies the service that the game application is ready to start execution.
	 */
	public void start()
	{
		
	}
}