package org.amoeba.engine.routing;

/**
 * Interface to be fulfilled by any class that wishes to receive game thread draw
 * callbacks.
 */
public interface DrawListener
{
	/**
	 * Notifies the DrawListener of a game thread call invocation.
	 */
	public void onDraw();
}
