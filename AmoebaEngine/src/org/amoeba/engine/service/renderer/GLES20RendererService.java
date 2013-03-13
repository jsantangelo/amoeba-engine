package org.amoeba.engine.service.renderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import org.amoeba.engine.routing.Router;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.camera.Camera2D;

import android.opengl.GLES20;

/**
 * GLES20RendererService is an implementation of RendererService using OpenGL ES 2.0.
 */
public class GLES20RendererService implements RendererService
{
	private Camera camera;

	private int screenWidth, screenHeight;

	private Router callbackRouter;

	/**
	 * Constructor.
	 * @param  router entity to be called on draw events
	 */
	public GLES20RendererService(final Router router)
	{
		callbackRouter = router;

		screenWidth = 1;
		screenHeight = 1;

		camera = new Camera2D(0.0f, 0.0f, screenWidth, screenHeight);
	}

	/**
	 * Callback to handle render requests when triggered on the attached View
	 * (ViewService).
	 * @param unused unused GL10 handle
	 */
	public void onDrawFrame(final GL10 unused)
	{
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        callbackRouter.invokeDraw(camera);
	}

	/**
	 * Callback when Surface to which this RendererService is attached is changed.
	 * @param unused unused GL10 handle
	 * @param width  width of new screen dimensions
	 * @param height height of new screen dimensions
	 */
	public void onSurfaceChanged(final GL10 unused, final int width, final int height)
	{
        screenWidth = width;
        screenHeight = height;

        GLES20.glViewport(0, 0, screenWidth, screenHeight);
        camera.setBounds(screenWidth, screenHeight);
        camera.update();

        callbackRouter.invokeSurfaceChangedEvent(width, height);
	}

	/**
	 * Callback when Surface to which this RendererService is attached is created.
	 * @param unused unused GL10 handle
	 * @param config GL config
	 */
	public void onSurfaceCreated(final GL10 unused, final EGLConfig config)
	{
		GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1f);
        GLES20.glDisable(GLES20.GL_DEPTH_TEST);
        GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
        GLES20.glEnable(GLES20.GL_BLEND);

        callbackRouter.invokeSurfaceCreationEvent();
	}
}
