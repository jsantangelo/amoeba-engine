package org.amoeba.engine.routing;

import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.graphics.camera.Camera;

/**
 * Responsible for accepting callbacks from various services and routing them
 * to any listener registered that type of callback.
 */
public interface Router
{
	/**
	 * Invokes a draw callback, notifying all listeners of a draw event.
	 * @param camera The camera.
	 */
	public void invokeDraw(Camera camera);

	/**
	 * Registers a DrawListener to be called back.
	 * @param listener entity to be called back
	 */
	public void registerForDraw(final DrawListener listener);

	/**
	 * Invokes an update callback, notifying all listeners of an update event.
	 */
	public void invokeUpdate();

	/**
	 * Registers an UpdateListener to be called back.
	 * @param listener entity to be called back
	 */
	public void registerForUpdate(final UpdateListener listener);

	/**
	 * Invoke an input event callback, notifing all listeners of an input event.
	 * @param inputEvent contains all information about the input event
	 */
	public void invokeInputEvent(InputEvent inputEvent);

	/**
	 * Registers an InputListener to be called back.
	 * @param listener entity to be called back.
	 */
	public void registerForInput(final InputListener listener);
}
