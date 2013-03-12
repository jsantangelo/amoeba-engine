package org.amoeba.engine.routing;

import java.util.HashSet;
import java.util.Set;

import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.graphics.camera.Camera;

/**
 * Responsible for accepting invocations from services, and routing them to
 * relevant, registered listeners.
 */
public class EngineRouter implements Router
{
	private Set<DrawListener> drawListeners = null;
	private Set<UpdateListener> updateListeners = null;
	private Set<InputListener> inputListeners = null;
	private Set<SurfaceListener> surfaceListeners = null;

	/**
	 * Constructor. Responsible for creating the listener collections.
	 */
	public EngineRouter()
	{
		drawListeners = new HashSet<DrawListener>();
		updateListeners = new HashSet<UpdateListener>();
		inputListeners = new HashSet<InputListener>();
		surfaceListeners = new HashSet<SurfaceListener>();
	}

	/**
	 * Resets all listener collections to empty collections.
	 */
	public void resetListeners()
	{
		drawListeners.clear();
		updateListeners.clear();
		inputListeners.clear();
		surfaceListeners.clear();
	}

	/**
	 * Registers an UpdateListener to be called back.
	 * @param listener entity to be called back
	 */
	public void registerForUpdate(final UpdateListener listener)
	{
		updateListeners.add(listener);
	}

	/**
	 * Called by services triggering update callbacks.
	 */
	public void invokeUpdate()
	{
		notifyUpdateListeners();
	}

	/**
	 * Notifies any registered update listeners of the update callback.
	 */
	private void notifyUpdateListeners()
	{
		for (UpdateListener listener : updateListeners)
		{
			listener.onUpdate();
		}
	}

	/**
	 * Registers a DrawListener to be called back.
	 * @param listener entity to be called back
	 */
	public void registerForDraw(final DrawListener listener)
	{
		drawListeners.add(listener);
	}

	/**
	 * Called by services triggering draw callbacks.
	 * @param camera The camera.
	 */
	public void invokeDraw(final Camera camera)
	{
		notifyDrawListeners(camera);
	}

	/**
	 * Notifies any registered draw listeners of the draw callback.
	 * @param camera The camera.
	 */
	private void notifyDrawListeners(final Camera camera)
	{
		for (DrawListener listener : drawListeners)
		{
			listener.onDraw(camera);
		}
	}

	/**
	 * Registers an InputListener to be called back.
	 * @param listener entity to be called back.
	 */
	public void registerForInputEvents(final InputListener listener)
	{
		inputListeners.add(listener);
	}

	/**
	 * Called by services triggering input callbacks.
	 * @param inputEvent the packaged input event from AmoebaEngine
	 */
	public void invokeInputEvent(final InputEvent inputEvent)
	{
		notifyInputListeners(inputEvent);
	}

	/**
	 * Notifies any registered input listeners of the input callback.
	 * @param inputEvent packaged input event from AmoebaEngine
	 */
	private void notifyInputListeners(final InputEvent inputEvent)
	{
		for (InputListener listener : inputListeners)
		{
			listener.onInputEvent(inputEvent);
		}
	}

	/**
	 * Registers a SurfaceListener to be called back.
	 * @param listener entity to be called back
	 */
	public void registerForSurfaceEvents(final SurfaceListener listener)
	{
		surfaceListeners.add(listener);
	}

	/**
	 * Called by services triggering SurfaceCreation events.
	 */
	public void invokeSurfaceCreationEvent()
	{
		notifySurfaceListenersOfSurfaceCreation();
	}

	/**
	 * Called by services triggering SurfaceChange events.
	 * @param width  width of new screen dimensions
	 * @param height height of new screen dimensions
	 */
	public void invokeSurfaceChangedEvent(final int width, final int height)
	{
		notifySurfaceListenersOfSurfaceChange(width, height);
	}

	/**
	 * Notifies any registered surface listeners of the surface creation callback.
	 */
	private void notifySurfaceListenersOfSurfaceCreation()
	{
		for (SurfaceListener listener : surfaceListeners)
		{
			listener.onSurfaceCreated();
		}
	}

	/**
	 * Notifies any registered surface listeners of the surface change callback.
	 * @param width  width of new screen dimensions
	 * @param height height of new screen dimensions
	 */
	private void notifySurfaceListenersOfSurfaceChange(final int width, final int height)
	{
		for (SurfaceListener listener : surfaceListeners)
		{
			listener.onSurfaceChanged(width, height);
		}
	}
}
