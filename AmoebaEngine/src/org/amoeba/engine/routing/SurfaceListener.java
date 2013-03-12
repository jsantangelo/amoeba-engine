package org.amoeba.engine.routing;

/**
 * Interface to be fulfilled by any class that wishes to recieve surface events
 * from the renderer service.
 */
public interface SurfaceListener
{
	/**
	 * Notifies the SurfaceListener of the surface creation event.
	 */
	public void onSurfaceCreated();

	/**
	 * Notifies the SurfaceListener of the surface changed event.
	 * @param width  width of new screen dimensions
	 * @param height height of new screen dimensions
	 */
	public void onSurfaceChanged(int width, int height);
}
