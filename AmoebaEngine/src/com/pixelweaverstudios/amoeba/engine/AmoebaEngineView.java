package com.pixelweaverstudios.amoeba.engine;

public class AmoebaEngineView extends GLSurfaceView
	implements IAmoebaEngineView//, SurfaceHolder.Callback
{
	private GLRenderer glRenderer;
	private GestureListener gestureListener;

	IAmoebaEngine engine;

	public AmoebaEngineView(Context context, IAmoebaEngine engine)
	{
		super(context);

		this.engine = engine;

		getHolder().addCallback(this);
		glRenderer = new GLRenderer(this);
		setRenderer(glRenderer);
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

		setFocusable(true);
	}

	//Methods from GLSurfaceView (who implements SurfaceHolder.Callback)
	@Override
	public boolean surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
		super.surfaceChanged(holder, format, width, height);
	}

	@Override
	public boolean surfaceCreated(SurfaceHolder holder)
	{
		super.surfaceCreated(holder);
	}

	@Override
	public boolean surfaceDestroyed(SurfaceHolder holder)
	{
		super.surfaceDestroyed(holder);
	}

	public void enableGesture(int motionEventType)
	{

	}

	public void disableGesture(int motionEventType)
	{

	}

}