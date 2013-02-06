package com.pixelweaverstudios.amoeba.engine;

public class GestureListener implements OnGestureListener, OnScaleGestureListener
	//IGestureListener
{
	private GestureDetector gestureDetector;
	private ScaleGestureDetector scaleGestureDetector;

	private IAmoebaEngine engine;

	public GestureListener(Context context, IAmoebaEngine engine)
	{
		gestureDetector = new GestureDetector(context, this);
		scaleGestureDetector = new ScaleGestureDetector(context, this);

		this.engine = engine;
	}

	//called by parent class, View
	public boolean onTouchEvent(MotionEvent event)
	{
		gestureDetector.onTouchEvent(event);
		scaleGestureDetector.onTouchEvent(event);
	}

	//methods implementing OnGestureListener
	public boolean onDown(MotionEvent event)
	{

	}

	public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY)
	{

	}

	public void onLongPress(MotionEvent event)
	{

	}

	public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY)
	{

	}

	public void onShowPress(MotionEvent event)
	{

	}

	public void onSingleTapUp(MotionEvent event)
	{

	}

	//Methods implementing OnScaleGestureListener
	public boolean onScale(ScaleGestureDetector detector)
	{

	}

	public boolean onScaleBegin(ScaleGestureDetector detector)
	{

	}

	public void onScaleEnd(ScaleGestureDetector detector)
	{
		
	}
}