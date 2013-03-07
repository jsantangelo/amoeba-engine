package org.amoeba.engine.routing;

/**
 * Interface to be fulfilled by any class that wishes to recieve game thread
 * update callbacks.
 */
public interface UpdateListener
{
	/**
	 * Notifies the UpdateListener of a game thread update call invocation.
	 */
	public void onUpdate();
}
