package com.pixelweaverstudios.amoeba.engine.service.input;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/**
 * Holds all information about an AmoebaEngine input event, to be passed to the
 * game application for handling.
 */
public class InputEvent
{

	/**
	 * Helper class to hold vector information.
	 */
	public class InputVector<X, Y>
	{
		public final X x;
		public final Y y;

		/**
		 * Constructor.
		 * @param  x some "x" value
		 * @param  y some "y" value
		 */
		public InputVector(X x, Y y)
		{
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * Enum denoting the types of input events that can be generated
	 * by AmoebaEngine.
	 */
	public enum EventType
	{
		DOWN, FLING, LONGPRESS, SCROLL, SCROLLEND, SHOWPRESS,
		SINGLETAP, SCALEBEGIN, SCALE, SCALEEND
	}

	private EventType eventType;
	private MotionEvent event1, event2;
	private InputVector<Float, Float> vector;
	private ScaleGestureDetector scaleGestureDetector;

	/**
	 * Constructor. Initializes all values to empty or null, except for type.
	 * @param  type type of event
	 */
	public InputEvent(EventType type)
	{
		eventType = type;

		event1 = event2 = null;
		vector = null;
		scaleGestureDetector = null;
	}

	/**
	 * Returns the event type of the input event.
	 * @return the event type
	 */
	public EventType getEventType()
	{
		return eventType;
	}

	/**
	 * Sets the motion event of the input event. Used by DOWN, LONGPRESS,
	 * SHOWPRESS, and SINGLETAP events.
	 * @param event the motion event
	 */
	public void setMotionEvent(MotionEvent event)
	{
		event1 = event;
	}

	/**
	 * Returns the motion event of an input event.
	 * @return the motion event
	 */
	public MotionEvent getMotionEvent()
	{
		return event1;
	}

	/**
	 * Sets the starting event of a two-event input event. Used by FLING and
	 * SCROLL events.
	 * @param event the motion event
	 */
	public void setStartingEvent(MotionEvent event)
	{
		event1 = event;
	}

	/**
	 * Sets the ending event of a two-event input event. Used by FLING and
	 * SCROLL events.
	 * @param event the motion event
	 */
	public void setEndingEvent(MotionEvent event)
	{
		event2 = event;
	}

	/**
	 * Returns the starting event of a two-event input event.
	 * @return the starting event
	 */
	public MotionEvent getStartingEvent()
	{
		return event1;
	}

	/**
	 * Returns the ending event of a two-event input event.
	 * @return the ending event
	 */
	public MotionEvent getEndingEvent()
	{
		return event2;
	}

	/**
	 * Sets the velocity vector of FLING events.
	 * @param velocityX velocity on the x-axis
	 * @param velocityY velocity on the y-axis
	 */
	public void setVelocityVector(float velocityX, float velocityY)
	{
		vector = new InputVector<Float, Float>(velocityX, velocityY);
	}

	/**
	 * Returns the velocity vector of FLING events.
	 * @return the velocity vector
	 */
	public InputVector<Float, Float> getVelocityVector()
	{
		return vector;
	}

	/**
	 * Sets the distance vector of a SCROLL event.
	 * @param distanceX distance along the x-axis
	 * @param distanceY distance along the y-axis
	 */
	public void setDistanceVector(float distanceX, float distanceY)
	{
		vector = new InputVector<Float, Float>(distanceX, distanceY);
	}

	/**
	 * Returns the distance vector of a SCROLL event.
	 * @return the distance vector
	 */
	public InputVector<Float, Float> getDistanceVector()
	{
		return vector;
	}

	/**
	 * Sets the scale detector of a scale-type input event. Used by SCALEBEGIN,
	 * SCALE, and SCALEEND events.
	 * @param scaleGestureDetector the reporting detector
	 */
	public void setScaleDetector(ScaleGestureDetector scaleGestureDetector)
	{
		this.scaleGestureDetector = scaleGestureDetector;
	}

	/**
	 * Returns the scale detector of a scale-type input event.
	 * @return the reporting detector
	 */
	public ScaleGestureDetector getScaleDetector()
	{
		return scaleGestureDetector;
	}
}
