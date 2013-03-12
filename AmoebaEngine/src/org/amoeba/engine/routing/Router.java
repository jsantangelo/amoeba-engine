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
	 * Invoke an input event callback, notifying all listeners of an input event.
	 * @param inputEvent contains all information about the input event
	 */
	public void invokeInputEvent(InputEvent inputEvent);

	/**
	 * Registers an InputListener to be called back.
	 * @param listener entity to be called back
	 */
	public void registerForInputEvents(final InputListener listener);

	/**
	 * Registers a SurfaceListener to be called back.
	 * @param listener entity to be called back
	 */
	public void registerForSurfaceEvents(final SurfaceListener listener);

	/**
	 * Invoke a surface creation callback, notifying all listeners of the event.
	 */
	public void invokeSurfaceCreationEvent();

	/**
	 * Invoke a surface change callback, notifying all listeners of the event.
	 * @param width  width of new screen dimensions
	 * @param height height of new screen dimensions
	 */
	public void invokeSurfaceChangedEvent(final int width, final int height);
}
