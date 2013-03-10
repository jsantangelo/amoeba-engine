package org.amoeba.engine.service.renderer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.egl.EGLConfig;

import android.opengl.GLSurfaceView;

import org.amoeba.engine.service.Service;

/**
 * Service provided by AmoebaEngine, responsible for acting as the "renderer"
 * of the main View (ViewService) of a given Activity.
 */
public interface RendererService extends Service, GLSurfaceView.Renderer
{
	/**
	 * Callback to handle render requests when triggered on the attached View
	 * (ViewService).
	 * @param unused unused GL10 handle
	 */
	public void onDrawFrame(GL10 unused);

	/**
	 * Callback when Surface to which this RendererService is attached is changed.
	 * @param unused unused GL10 handle
	 * @param width  width of new screen dimensions
	 * @param height height of new screen dimensions
	 */
	public void onSurfaceChanged(GL10 unused, int width, int height);

	/**
	 * Callback when Surface to which this RendererService is attached is created.
	 * @param unused unused GL10 handle
	 * @param config GL config
	 */
	public void onSurfaceCreated(GL10 unused, EGLConfig config);
}
