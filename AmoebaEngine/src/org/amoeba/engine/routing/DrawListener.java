package org.amoeba.engine.routing;

import org.amoeba.graphics.camera.Camera;

/**
 * Interface to be fulfilled by any class that wishes to receive game thread draw
 * callbacks.
 */
public interface DrawListener
{
	/**
	 * Notifies the DrawListener of a game thread call invocation.
	 * @param camera The camera.
	 */
	public void onDraw(Camera camera);
}
