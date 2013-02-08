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
		setRenderer(renderer);
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}

	//Methods from GLSurfaceView
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		gestureListener.onTouchEvent(event);
	}

	// public void enableGesture(int motionEventType)
	// {

	// }

	// public void disableGesture(int motionEventType)
	// {

	// }

}