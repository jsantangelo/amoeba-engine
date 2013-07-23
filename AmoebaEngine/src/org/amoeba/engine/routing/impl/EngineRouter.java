package org.amoeba.engine.routing.impl;

import java.util.HashSet;
import java.util.Set;

import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.InputListener;
import org.amoeba.engine.routing.Router;
import org.amoeba.engine.routing.SurfaceListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.graphics.camera.Camera;

import android.annotation.SuppressLint;

/**
 * Responsible for accepting invocations from services, and routing them to
 * relevant, registered listeners.
 */
public class EngineRouter implements Router
{
	private Object listenerMutex = null;

	private Set<DrawListener> drawListeners = null;
	private Set<UpdateListener> updateListeners = null;
	private Set<InputListener> inputListeners = null;
	private Set<SurfaceListener> surfaceListeners = null;

	/**
	 * Constructor. Responsible for creating the listener collections.
	 */
	public EngineRouter()
	{
		listenerMutex = new Object();

		drawListeners = new HashSet<DrawListener>();
		updateListeners = new HashSet<UpdateListener>();
		inputListeners = new HashSet<InputListener>();
		surfaceListeners = new HashSet<SurfaceListener>();
	}

	/**
	 * Deregisters all listeners from invocations.
	 */
	public void deregisterForAll()
	{
		resetListeners();
	}

	/**
	 * Resets all listener collections to empty collections.
	 */
	private void resetListeners()
	{
		synchronized (listenerMutex)
		{
			drawListeners.clear();
			updateListeners.clear();
			inputListeners.clear();
			surfaceListeners.clear();
		}
	}

	/**
	 * Registers an UpdateListener to be called back.
	 * @param listener entity to be called back
	 */
	public void registerForUpdate(final UpdateListener listener)
	{
		synchronized (listenerMutex)
		{
			updateListeners.add(listener);
		}
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
		synchronized (listenerMutex)
		{
			for (UpdateListener listener : updateListeners)
			{
				listener.onUpdate();
			}
		}
	}

	/**
	 * Registers a DrawListener to be called back.
	 * @param listener entity to be called back
	 */
	public void registerForDraw(final DrawListener listener)
	{
		synchronized (listenerMutex)
		{
			drawListeners.add(listener);
		}
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
	@SuppressLint("WrongCall")
	private void notifyDrawListeners(final Camera camera)
	{
		synchronized (listenerMutex)
		{
			for (DrawListener listener : drawListeners)
			{
				listener.onDraw(camera);
			}
		}
	}

	/**
	 * Registers an InputListener to be called back.
	 * @param listener entity to be called back.
	 */
	public void registerForInputEvents(final InputListener listener)
	{
		synchronized (listenerMutex)
		{
			inputListeners.add(listener);
		}
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
		synchronized (listenerMutex)
		{
			for (InputListener listener : inputListeners)
			{
				listener.onInputEvent(inputEvent);
			}
		}
	}

	/**
	 * Registers a SurfaceListener to be called back.
	 * @param listener entity to be called back
	 */
	public void registerForSurfaceEvents(final SurfaceListener listener)
	{
		synchronized (listenerMutex)
		{
			surfaceListeners.add(listener);
		}
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
		synchronized (listenerMutex)
		{
			for (SurfaceListener listener : surfaceListeners)
			{
				listener.onSurfaceCreated();
			}
		}
	}

	/**
	 * Notifies any registered surface listeners of the surface change callback.
	 * @param width  width of new screen dimensions
	 * @param height height of new screen dimensions
	 */
	private void notifySurfaceListenersOfSurfaceChange(final int width, final int height)
	{
		synchronized (listenerMutex)
		{
			for (SurfaceListener listener : surfaceListeners)
			{
				listener.onSurfaceChanged(width, height);
			}
		}
	}
}
