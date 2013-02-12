package com.pixelweaverstudios.amoeba.engine.input;

import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.view.MotionEvent;

import com.pixelweaverstudios.amoeba.engine.IAmoebaEngine;
import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;

public class GestureListener implements GestureDetector.OnGestureListener,
	ScaleGestureDetector.OnScaleGestureListener
{
	private GestureDetector gestureDetector;
	private ScaleGestureDetector scaleGestureDetector;

	private IAmoebaEngine engine;

	public GestureListener(IAmoebaEngine engine)
	{
		gestureDetector = new GestureDetector(AmoebaEngine.getContext(), this);
		scaleGestureDetector = new ScaleGestureDetector(AmoebaEngine.getContext(), this);

		this.engine = engine;
	}

	//called by parent class, View
	public boolean onTouchEvent(MotionEvent event)
	{
		gestureDetector.onTouchEvent(event);
		scaleGestureDetector.onTouchEvent(event);

		return false;
	}

	//TODO - these methods will callback the engine with information, and allow the
	//engine to determine what to do with the touch events

	//methods implementing OnGestureListener
	public boolean onDown(MotionEvent event)
	{
		return false;
	}

	public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY)
	{
		return false;
	}

	public void onLongPress(MotionEvent event)
	{

	}

	public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY)
	{
		return false;
	}

	public void onShowPress(MotionEvent event)
	{

	}

	public boolean onSingleTapUp(MotionEvent event)
	{
		return false;
	}

	//Methods implementing OnScaleGestureListener
	public boolean onScale(ScaleGestureDetector detector)
	{
		return false;
	}

	public boolean onScaleBegin(ScaleGestureDetector detector)
	{
		return false;
	}

	public void onScaleEnd(ScaleGestureDetector detector)
	{

	}
}