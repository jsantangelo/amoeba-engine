package com.pixelweaverstudios.amoeba.engine.input;

import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.view.MotionEvent;

import com.pixelweaverstudios.amoeba.engine.IServicesManager;
import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;
import com.pixelweaverstudios.amoeba.engine.input.EngineEvent;

public class GestureListener implements GestureDetector.OnGestureListener,
	ScaleGestureDetector.OnScaleGestureListener
{
	private GestureDetector gestureDetector;
	private ScaleGestureDetector scaleGestureDetector;

	private IServicesManager services;

	private boolean scrollingInProgress;

	public GestureListener(IServicesManager services)
	{
		gestureDetector = new GestureDetector(AmoebaEngine.getContext(), this);
		scaleGestureDetector = new ScaleGestureDetector(AmoebaEngine.getContext(), this);

		this.services = services;

		scrollingInProgress = false;
	}

	//called by parent class, View
	public boolean onTouchEvent(MotionEvent event)
	{
		gestureDetector.onTouchEvent(event);
		scaleGestureDetector.onTouchEvent(event);

		if (event.getAction() == MotionEvent.ACTION_UP)
		{
			scrollingInProgress = false;
			services.handleInputEvent(new EngineEvent(EngineEvent.EventType.SCROLLEND));
		}
		return true;
	}

	//methods implementing OnGestureListener
	public boolean onDown(MotionEvent event)
	{
		EngineEvent inputEvent = new EngineEvent(EngineEvent.EventType.DOWN);
		inputEvent.setMotionEvent(event);
		services.handleInputEvent(inputEvent);
		return true;
	}

	public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY)
	{
		EngineEvent inputEvent = new EngineEvent(EngineEvent.EventType.FLING);
		inputEvent.setStartingEvent(event1);
		inputEvent.setEndingEvent(event2);
		inputEvent.setVelocityVector(velocityX, velocityY);
		services.handleInputEvent(inputEvent);
		return true;
	}

	public void onLongPress(MotionEvent event)
	{
		EngineEvent inputEvent = new EngineEvent(EngineEvent.EventType.LONGPRESS);
		inputEvent.setMotionEvent(event);
		services.handleInputEvent(inputEvent);
	}

	public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY)
	{
		if (!scaleGestureDetector.isInProgress())
		{
			scrollingInProgress = true;
			EngineEvent inputEvent = new EngineEvent(EngineEvent.EventType.SCROLL);
			inputEvent.setStartingEvent(event1);
			inputEvent.setEndingEvent(event2);
			inputEvent.setDistanceVector(distanceX, distanceY);
			services.handleInputEvent(inputEvent);
		}
		return true;
	}

	public void onShowPress(MotionEvent event)
	{
		EngineEvent inputEvent = new EngineEvent(EngineEvent.EventType.SHOWPRESS);
		inputEvent.setMotionEvent(event);
		services.handleInputEvent(inputEvent);
	}

	public boolean onSingleTapUp(MotionEvent event)
	{
		EngineEvent inputEvent = new EngineEvent(EngineEvent.EventType.SINGLETAP);
		inputEvent.setMotionEvent(event);
		services.handleInputEvent(inputEvent);
		return true;
	}

	//TODO - method to enable end users (Screens) to specify continuation of events
	//Methods implementing OnScaleGestureListener
	public boolean onScaleBegin(ScaleGestureDetector detector)
	{
		EngineEvent inputEvent = new EngineEvent(EngineEvent.EventType.SCALEBEGIN);
		inputEvent.setScaleDetector(detector);
		services.handleInputEvent(inputEvent);
		return true;
	}

	public boolean onScale(ScaleGestureDetector detector)
	{
		EngineEvent inputEvent = new EngineEvent(EngineEvent.EventType.SCALE);
		inputEvent.setScaleDetector(detector);
		services.handleInputEvent(inputEvent);
		return true;
	}

	public void onScaleEnd(ScaleGestureDetector detector)
	{
		EngineEvent inputEvent = new EngineEvent(EngineEvent.EventType.SCALEEND);
		inputEvent.setScaleDetector(detector);
		services.handleInputEvent(inputEvent);
	}
}
