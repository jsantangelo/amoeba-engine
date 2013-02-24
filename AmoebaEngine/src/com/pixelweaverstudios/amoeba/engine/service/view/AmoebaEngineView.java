package com.pixelweaverstudios.amoeba.engine.service.view;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.content.Context;

import com.pixelweaverstudios.amoeba.engine.service.renderer.IAmoebaEngineRenderer;
import com.pixelweaverstudios.amoeba.engine.service.IServicesManager;
import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;
import com.pixelweaverstudios.amoeba.engine.IAmoebaEngine;

public class AmoebaEngineView extends GLSurfaceView
	implements IAmoebaEngineView
{
	private IAmoebaEngineRenderer renderer;
	//private IGestureListener gestureListener;
	private Context context;

	IServicesManager services;

	public AmoebaEngineView(IServicesManager services)
	{
		super(AmoebaEngine.getInstance().getContext());
		this.services = services;
		
		setFocusable(true);
		//initializeGestureListener();
	}

	private void initializeGestureListener()
	{
		//gestureListener = new GestureListener(services);
	}

	public void start()
	{
		initializeRenderer();
	}

	private void initializeRenderer()
	{
		//renderer = new GLES20Renderer(engine); - TODO (Mike)
		//Renderer creation can be (should be?) separate from setting the renderer for this
		//surface. setRenderer() should not be moved from this function though.
		setRenderer(renderer);
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}

	//TODO - need to determine when/where/who will register themselves with
	//the SurfaceHolder as a SurfaceHolder.Callback, to do the following:
	//* handle onSurfaceChanged (for screen dimension change handling, ie device rotation)
	//* handle onSurfaceDestroyed (to stop the game loop thread)

	//Methods from GLSurfaceView/SurfaceView/View
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		//return gestureListener.onTouchEvent(event);
		//View needs to route to InputService, who routes to GestureListener,
		//who routes back to InputService, and down to whoever needs input
		return true;
	}

	@Override
	public void onPause()
	{
		setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
		super.onPause();
	}

	@Override
	public void onResume()
	{
		super.onResume();
		//Start my thread here
	}
}
