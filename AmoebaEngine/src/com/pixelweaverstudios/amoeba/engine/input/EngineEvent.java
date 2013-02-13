package com.pixelweaverstudios.amoeba.engine.input;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class EngineEvent
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

	public EngineEvent(EventType type)
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
		vector = new InputVector(velocityX, velocityY);
	}

	public InputVector getVelocityVector()
	{
		return vector;
	}

	//SCROLL
	public void setDistanceVector(float velocityX, float velocityY)
	{
		vector = new InputVector(velocityX, velocityY);
	}

	public InputVector getDistanceVector()
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
