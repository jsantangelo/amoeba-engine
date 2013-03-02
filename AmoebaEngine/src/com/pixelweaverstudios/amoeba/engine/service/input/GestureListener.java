package com.pixelweaverstudios.amoeba.engine.service.input;

import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.view.MotionEvent;
import android.content.Context;

import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;

public class GestureListener implements GestureDetector.OnGestureListener,
	ScaleGestureDetector.OnScaleGestureListener
{
	private GestureDetector gestureDetector;
	private ScaleGestureDetector scaleGestureDetector;

	private InputService inputService;

	private boolean scrollingInProgress;

	private Context context;

	public GestureListener(InputService inputService)
	{
		context = AmoebaEngine.getInstance().getContext();
		gestureDetector = new GestureDetector(context, this);
		scaleGestureDetector = new ScaleGestureDetector(context, this);

		this.inputService = inputService;

		scrollingInProgress = false;
	}

	//called by parent class, View
	public boolean onTouchEvent(MotionEvent event)
	{
		gestureDetector.onTouchEvent(event);
		scaleGestureDetector.onTouchEvent(event);

		if (event.getAction() == MotionEvent.ACTION_UP && scrollingInProgress)
		{
			scrollingInProgress = false;
			inputService.handleInputEvent(new InputEvent(InputEvent.EventType.SCROLLEND));
		}
		return true;
	}

	//methods implementing OnGestureListener
	public boolean onDown(MotionEvent event)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.DOWN);
		inputEvent.setMotionEvent(event);
		inputService.handleInputEvent(inputEvent);
		return true;
	}

	public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.FLING);
		inputEvent.setStartingEvent(event1);
		inputEvent.setEndingEvent(event2);
		inputEvent.setVelocityVector(velocityX, velocityY);
		inputService.handleInputEvent(inputEvent);
		return true;
	}

	public void onLongPress(MotionEvent event)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.LONGPRESS);
		inputEvent.setMotionEvent(event);
		inputService.handleInputEvent(inputEvent);
	}

	public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY)
	{
		if (!scaleGestureDetector.isInProgress())
		{
			scrollingInProgress = true;
			InputEvent inputEvent = new InputEvent(InputEvent.EventType.SCROLL);
			inputEvent.setStartingEvent(event1);
			inputEvent.setEndingEvent(event2);
			inputEvent.setDistanceVector(distanceX, distanceY);
			inputService.handleInputEvent(inputEvent);
		}
		return true;
	}

	public void onShowPress(MotionEvent event)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.SHOWPRESS);
		inputEvent.setMotionEvent(event);
		inputService.handleInputEvent(inputEvent);
	}

	public boolean onSingleTapUp(MotionEvent event)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.SINGLETAP);
		inputEvent.setMotionEvent(event);
		inputService.handleInputEvent(inputEvent);
		return true;
	}

	//TODO - method to enable end users (Screens) to specify continuation of events
	//Methods implementing OnScaleGestureListener
	public boolean onScaleBegin(ScaleGestureDetector detector)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.SCALEBEGIN);
		inputEvent.setScaleDetector(detector);
		inputService.handleInputEvent(inputEvent);
		return true;
	}

	public boolean onScale(ScaleGestureDetector detector)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.SCALE);
		inputEvent.setScaleDetector(detector);
		inputService.handleInputEvent(inputEvent);
		return true;
	}

	public void onScaleEnd(ScaleGestureDetector detector)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.SCALEEND);
		inputEvent.setScaleDetector(detector);
		inputService.handleInputEvent(inputEvent);
	}
}