package org.amoeba.engine.routing;

import org.amoeba.engine.service.input.InputEvent;

/**
 * Interface to be fulfilled by any class that wishes to recieve input events.
 */
public interface InputListener
{
	/**
	 * Notifies the InputListener of an input event from the Android OS.
	 * @param inputEvent the motion event as supplied by the Android OS, and
	 * interpreted by the AmoebaEngine
	 */
	public void onInputEvent(InputEvent inputEvent);
}
