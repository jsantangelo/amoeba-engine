package org.amoeba.engine.service.view;

import org.amoeba.engine.service.Service;

import android.view.SurfaceHolder;


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
}
