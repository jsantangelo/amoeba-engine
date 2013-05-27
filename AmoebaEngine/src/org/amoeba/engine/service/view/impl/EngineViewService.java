package org.amoeba.engine.service.view.impl;

import org.amoeba.engine.service.graphics.GraphicsService;
import org.amoeba.engine.service.input.InputService;
import org.amoeba.engine.service.thread.ThreadService;
import org.amoeba.engine.service.thread.ThreadType;
import org.amoeba.engine.service.view.ViewService;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * Implements the ViewService service component provided by AmoebaEngine.
 * Responsible for acting as the View to which draws are made. Also the
 * entry point for raw MotionEvents from the Android OS.
 */
public class EngineViewService extends GLSurfaceView
	implements ViewService, SurfaceHolder.Callback
{
	private static final String TAG = "AmoebaEngine.EngineView";

	private GraphicsService graphicsService;
	private InputService inputService;
	private ThreadService threadService;

	/**
	 * Constructor.
	 * @param context current Activity context
	 * @param graphics Graphics service
	 * @param input Service to be called on raw MotionEvent receipt from
	 *              the Android OS
	 * @param thread thread to be managed by the view
	 */
	public EngineViewService(final Context context, final GraphicsService graphics,
		final InputService input, final ThreadService thread)
	{
		super(context);

		graphicsService = graphics;
		inputService = input;
		threadService = thread;

		setFocusable(true);

		getSurfaceHolder().addCallback(this);
		initializeRenderer();
	}

	/**
	 * Callback from the GameThreadService to request a render on the attached
	 * RendererService.
	 */
	public void onRequestRender()
	{
		requestRender();
	}

	/**
	 * Returns the SurfaceHolder of this View.
	 * @return the Surface Holder attached to this View
	 */
	public SurfaceHolder getSurfaceHolder()
	{
		return getHolder();
	}

	/**
	 * Prepares the RendererService for game execution.
	 */
	private void initializeRenderer()
	{
		setDebugFlags(DEBUG_CHECK_GL_ERROR | DEBUG_LOG_GL_CALLS);
		setEGLContextClientVersion(graphicsService.getGLVersion());
		setRenderer(graphicsService.getRenderer());
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}

	/**
	 * Callback when the Surface to which this View is attached changes.
	 * @param holder Reporting holder
	 * @param format format
	 * @param width  width of new dimensions
	 * @param height height of new dimensions
	 */
	public void surfaceChanged(final SurfaceHolder holder, final int format,
		final int width, final int height)
	{
		Log.d(TAG, "Surface changed...");
		super.surfaceChanged(holder, format, width, height);
	}

	/**
	 * Callback when the Surface to which this View is attached is created.
	 * @param holder Reporting holder
	 */
	public void surfaceCreated(final SurfaceHolder holder)
	{
		Log.d(TAG, "Surface created...");
		super.surfaceCreated(holder);
	}

	/**
	 * Callback when the Surface to which this View is attached is destroyed.
	 * @param holder Reporting holder
	 */
	public void surfaceDestroyed(final SurfaceHolder holder)
	{
		Log.d(TAG, "Surface destroyed...");
		super.surfaceDestroyed(holder);
	}

	/**
	 * Overrides GLSurfaceView's callback on motion events from the Android OS.
	 * Responsible for defering to the InputService.
	 * @param  event raw motion event, yet to be processed
	 * @return       whether or not the motion event was consumed
	 */
	@Override
	public boolean onTouchEvent(final MotionEvent event)
	{
		inputService.handleRawInputEvent(event);
		return true;
	}

	/**
	 * Overrides GLSurfaceView's callback on View pause. Stops the
	 * GameThreadService thread execution.
	 */
	@Override
	public void onPause()
	{
		Log.d(TAG, "View pausing...");
		setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
		threadService.stopThread();
		super.onPause();
	}

	/**
	 * Overrides GLSurfaceView's callback on View resume. Starts the
	 * GameThreadService thread execution.
	 */
	@Override
	public void onResume()
	{
		Log.d(TAG, "View resuming...");
		super.onResume();
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

		threadService.setViewService(this);
		threadService.startThread(ThreadType.CONSTANTSPEEDFRAMESKIP);
	}
}
