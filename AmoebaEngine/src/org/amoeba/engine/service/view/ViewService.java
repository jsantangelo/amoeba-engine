package org.amoeba.engine.service.view;

import android.view.SurfaceHolder;

import org.amoeba.engine.service.Service;

/**
 * Service provided by AmoebaEngine, responsible for acting as the View for a
 * given Activity.
 */
public interface ViewService extends Service
{
	/**
	 * Handles GameThreadService callback for Renderer render requests.
	 */
	public void onRequestRender();

	/**
	 * Returns the Surface Holder attached to this View (ViewService).
	 * @return the Surface Holder
	 */
	public SurfaceHolder getSurfaceHolder();

	/**
	 * Notifies the View that the owning Activity has been paused by the
	 * Android OS.
	 */
	public void onPause();

	/**
	 * Notifies the View that the owning Activity has been resumed by the
	 * Android OS.
	 */
	public void onResume();
}
