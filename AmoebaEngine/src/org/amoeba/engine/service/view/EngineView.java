package org.amoeba.engine.service.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.util.Log;

import org.amoeba.engine.service.input.InputService;
import org.amoeba.engine.service.renderer.RendererService;
import org.amoeba.engine.service.gamethread.GameThreadService;

/**
 * Implements the ViewService service component provided by AmoebaEngine.
 * Responsible for acting as the View to which draws are made. Also the
 * entry point for raw MotionEvents from the Android OS.
 */
public class EngineView extends GLSurfaceView
	implements ViewService, SurfaceHolder.Callback
{
	private static final String TAG = "EngineView";

	private RendererService rendererService;
	private InputService inputService;
	private GameThreadService threadService;

	/**
	 * Constructor.
	 * @param context current Activity context
	 * @param renderer GLRenderer to be attached to this view
	 * @param input Service to be called on raw MotionEvent receipt from
	 *              the Android OS
	 * @param thread thread to be managed by the view
	 */
	public EngineView(final Context context, final RendererService renderer,
		final InputService input, final GameThreadService thread)
	{
		super(context);

		rendererService = renderer;
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
		Log.d("amoeba", "setting renderer");
		setRenderer((GLSurfaceView.Renderer) rendererService);
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
		super.surfaceChanged(holder, format, width, height);
	}

	/**
	 * Callback when the Surface to which this View is attached is created.
	 * @param holder Reporting holder
	 */
	public void surfaceCreated(final SurfaceHolder holder)
	{
		super.surfaceCreated(holder);
	}

	/**
	 * Callback when the Surface to which this View is attached is destroyed.
	 * @param holder Reporting holder
	 */
	public void surfaceDestroyed(final SurfaceHolder holder)
	{
		super.surfaceDestroyed(holder);
		boolean retry = true;
		threadService.setRunning(false);
		while (retry)
		{
			try
			{
				((Thread) threadService).join();
				retry = false;
			}
			catch (InterruptedException e)
			{
				Log.e(TAG, "Exception: " + e);
			}
		}
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
		setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
		super.onPause();
	}

	/**
	 * Overrides GLSurfaceView's callback on View resume. Starts the
	 * GameThreadService thread execution.
	 */
	@Override
	public void onResume()
	{
		super.onResume();

		threadService.setViewService(this);
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
		requestRender();

		try
		{
			threadService.setRunning(true);
			((Thread) threadService).start();
		}
		catch (Exception e)
		{
			Log.e(TAG, "Exception: " + e);
		}
	}
}
