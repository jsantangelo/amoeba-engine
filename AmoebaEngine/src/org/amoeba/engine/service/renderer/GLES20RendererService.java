package org.amoeba.engine.service.renderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.Matrix;

/**
 * GLES20RendererService is an implementation of RendererService using OpenGL ES 2.0.
 */
public class GLES20RendererService implements RendererService
{
	private static final int MATRIX_SIZE = 16;
	private float[] viewMatrix = new float[MATRIX_SIZE];
	private float[] projectionMatrix = new float[MATRIX_SIZE];
	//private float[] modelMatrix = new float[MATRIX_SIZE];
	//private float[] mvpMatrix = new float[MATRIX_SIZE];

	private int screenWidth, screenHeight;

	/**
	 * Constructor for GLES20RendererService.
	 */
	public GLES20RendererService()
	{
		screenWidth = 1;
		screenHeight = 1;
	}

	@Override
	public void attachEngine()
	{
		// Not sure what this does.
	}

	/**
	 * Callback to handle render requests when triggered on the attached View
	 * (ViewService).
	 * @param unused unused GL10 handle
	 */
	@Override
	public void onDrawFrame(final GL10 unused)
	{
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        // Call back engine with MVP matrix.
	}

	/**
	 * Callback when Surface to which this RendererService is attached is changed.
	 * @param unused unused GL10 handle
	 * @param width  width of new screen dimensions
	 * @param height height of new screen dimensions
	 */
	@Override
	public void onSurfaceChanged(final GL10 unused, final int width, final int height)
	{
        screenWidth = width;
        screenHeight = height;

        GLES20.glViewport(0, 0, screenWidth, screenHeight);

        final float left = 0f;
        final float right = screenWidth;
        final float bottom = screenHeight;
        final float top = 0f;
        final float near = 0.0f;
        final float far = 2.0f;
        Matrix.orthoM(projectionMatrix, 0, left, right, bottom, top, near, far);
	}

	/**
	 * Callback when Surface to which this RendererService is attached is created.
	 * @param unused unused GL10 handle
	 * @param config GL config
	 */
	@Override
	public void onSurfaceCreated(final GL10 unused, final EGLConfig config)
	{
		GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1f);
        GLES20.glDisable(GLES20.GL_DEPTH_TEST);
        GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
        GLES20.glEnable(GLES20.GL_BLEND);

        final float eyeX = 0.0f;
        final float eyeY = 0.0f;
        final float eyeZ = 1.5f;
        final float lookX = 0.0f;
        final float lookY = 0.0f;
        final float lookZ = -5.0f;
        final float upX = 0.0f;
        final float upY = 1.0f;
        final float upZ = 0.0f;
        Matrix.setLookAtM(viewMatrix, 0, eyeX, eyeY, eyeZ, lookX, lookY, lookZ, upX, upY, upZ);
	}

}
