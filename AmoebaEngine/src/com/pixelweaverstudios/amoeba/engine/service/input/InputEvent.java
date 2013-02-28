package com.pixelweaverstudios.amoeba.engine.service.input;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class InputEvent
{

	public class InputVector<X, Y>
	{
		public final X x;
		public final Y y;
		public InputVector(X x, Y y)
		{
			this.x = x;
			this.y = y;
		}
	}

	public enum EventType
	{
		DOWN, FLING, LONGPRESS, SCROLL, SCROLLEND, SHOWPRESS,
		SINGLETAP, SCALEBEGIN, SCALE, SCALEEND
	}

	private EventType eventType;
	private MotionEvent event1, event2;
	private InputVector<Float, Float> vector;
	private ScaleGestureDetector scaleGestureDetector;

	public InputEvent(EventType type)
	{
		eventType = type;

		event1 = event2 = null;
		vector = null;
		scaleGestureDetector = null;
	}

	public EventType getEventType()
	{
		return eventType;
	}

	//DOWN, LONGPRESS, SHOWPRESS, SINGLETAP
	public void setMotionEvent(MotionEvent event)
	{
		event1 = event;
	}

	public MotionEvent getMotionEvent()
	{
		return event1;
	}

	//FLING, SCROLL
	public void setStartingEvent(MotionEvent event)
	{
		event1 = event;
	}

	public void setEndingEvent(MotionEvent event)
	{
		event2 = event;
	}

	public MotionEvent getStartingEvent()
	{
		return event1;
	}

	public MotionEvent getEndingEvent()
	{
		return event2;
	}

	//FLING
	public void setVelocityVector(float velocityX, float velocityY)
	{
		vector = new InputVector<Float, Float>(velocityX, velocityY);
	}

	public InputVector<Float, Float> getVelocityVector()
	{
		return vector;
	}

	//SCROLL
	public void setDistanceVector(float velocityX, float velocityY)
	{
		vector = new InputVector<Float, Float>(velocityX, velocityY);
	}

	public InputVector<Float, Float> getDistanceVector()
	{
		return vector;
	}

	//SCALEBEGIN, SCALE, SCALEEND
	public void setScaleDetector(ScaleGestureDetector scaleGestureDetector)
	{
		this.scaleGestureDetector = scaleGestureDetector;
	}

	public ScaleGestureDetector getScaleDetector()
	{
		return scaleGestureDetector;
	}
}
