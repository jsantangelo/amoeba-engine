package com.pixelweaverstudios.amoeba.engine.service.view;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.content.Context;
import android.view.SurfaceHolder;

import com.pixelweaverstudios.amoeba.engine.service.IServicesManager;
import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;
import com.pixelweaverstudios.amoeba.engine.service.ServiceType;

public class EngineView extends GLSurfaceView
	implements ViewService
{
	//private IAmoebaEngineRenderer renderer;
	private Context context;

	public EngineView()
	{
		super(AmoebaEngine.getInstance().getContext());
		
		setFocusable(true);
	}

	public void start()
	{
		initializeRenderer();
	}

	public void onRequestRender()
	{
		requestRender();
	}

	public SurfaceHolder getSurfaceHolder()
	{
		return getHolder();
	}

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
		//Start GameThreadService here
	}
}
