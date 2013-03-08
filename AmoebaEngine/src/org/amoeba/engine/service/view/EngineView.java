package org.amoeba.engine.service.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import org.amoeba.engine.AmoebaEngine;
import org.amoeba.engine.service.input.InputService;
import org.amoeba.engine.service.renderer.RendererService;

/**
 * Implements the ViewService service component provided by AmoebaEngine.
 * Responsible for acting as the View to which draws are made. Also the
 * entry point for raw MotionEvents from the Android OS.
 */
public class EngineView extends GLSurfaceView implements ViewService
{
	private Context context;
	private RendererService rendererService;
	private InputService inputService;

	/**
	 * Constructor.
	 * @param  renderer     GLRenderer to be attached to this view
	 * @param  input Service to be called on raw MotionEvent receipt from
	 *                      the Android OS
	 */
	public EngineView(final RendererService renderer, final InputService input)
	{
		super(AmoebaEngine.getInstance().getContext());

		rendererService = renderer;
		inputService = input;

		setFocusable(true);
	}

	/**
	 * Notifies the View that the parent Activity is ready to begin
	 * game execution. Prepares/finishe all setup.
	 */
	public void start()
	{
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
		setRenderer((GLSurfaceView.Renderer) rendererService);
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}

	//TODO - need to determine when/where/who will register themselves with
	//the SurfaceHolder as a SurfaceHolder.Callback, to do the following:
	//* handle onSurfaceChanged (for screen dimension change handling, ie device rotation)
	//* handle onSurfaceDestroyed (to stop the game loop thread)

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
		//Start GameThreadService here
	}
}
