package com.pixelweaverstudios.amoeba.engine;

public class AmoebaEngineView extends GLSurfaceView
	implements IAmoebaEngineView
{
	private IAmoebaEngineRenderer renderer;
	private GestureListener gestureListener;

	IAmoebaEngine engine;

	public AmoebaEngineView(Context context, IAmoebaEngine engine)
	{
		super(context);
		this.engine = engine;

		//TODO: Investigate if the following commented out line is necessary.
		//I have a suspicion that it isn't, because we already get onTouchEvent via
		//GLSurfaceView.
		//getHolder().addCallback(this);
		
		setFocusable(true);
		initializeGestureListener();
	}

	private void initializeGestureListener()
	{
		gestureListener = new GestureListener(context, engine);
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
		gestureListener.onTouchEvent(event);
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

	// public void enableGesture(int motionEventType)
	// {

	// }

	// public void disableGesture(int motionEventType)
	// {

	// }

}