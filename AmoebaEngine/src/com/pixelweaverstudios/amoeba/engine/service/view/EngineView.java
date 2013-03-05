package com.pixelweaverstudios.amoeba.engine.service.view;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.content.Context;
import android.view.SurfaceHolder;

import com.pixelweaverstudios.amoeba.engine.service.ServicesManager;
import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;
import com.pixelweaverstudios.amoeba.engine.service.ServiceType;

/**
 * Implements the ViewService service component provided by AmoebaEngine.
 * Responsible for acting as the View to which draws are made. Also the
 * entry point for raw MotionEvents from the Android OS.
 */
public class EngineView extends GLSurfaceView implements ViewService
{
	private Context context;

	/**
	 * Constructor.
	 */
	public EngineView()
	{
		super(AmoebaEngine.getInstance().getContext());
		
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
		//Renderer creation must happen before this call
		setRenderer((GLSurfaceView.Renderer)(AmoebaEngine.getInstance().getService(ServiceType.RENDERER)));
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
	public boolean onTouchEvent(MotionEvent event)
	{
		//return gestureListener.onTouchEvent(event);
		//View needs to route to InputService, who routes to GestureListener,
		//who routes back to InputService, and down to whoever needs input
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
