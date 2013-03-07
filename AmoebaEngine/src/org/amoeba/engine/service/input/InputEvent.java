package org.amoeba.engine.service.input;

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
	public class InputVector<T>
	{
		private final T x;
		private final T y;

		/**
		 * Constructor.
		 * @param  xVar some "x" value
		 * @param  yVar some "y" value
		 */
		public InputVector(final T xVar, final T yVar)
		{
			x = xVar;
			y = yVar;
		}

		/**
		 * Returns the "x" value of the InputVector.
		 * @return the "x" value
		 */
		public T getX()
		{
			return x;
		}

		/**
		 * Returns the "y" value of the InputVector.
		 * @return the "y" value
		 */
		public T getY()
		{
			return y;
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
	private InputVector<Float> vector;
	private ScaleGestureDetector scaleGestureDetector;

	/**
	 * Constructor. Initializes all values to empty or null, except for type.
	 * @param  type type of event
	 */
	public InputEvent(final EventType type)
	{
		eventType = type;

		event1 = null;
		event2 = null;
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
	public void setMotionEvent(final MotionEvent event)
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
	public void setStartingEvent(final MotionEvent event)
	{
		event1 = event;
	}

	/**
	 * Sets the ending event of a two-event input event. Used by FLING and
	 * SCROLL events.
	 * @param event the motion event
	 */
	public void setEndingEvent(final MotionEvent event)
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
	public void setVelocityVector(final float velocityX, final float velocityY)
	{
		vector = new InputVector<Float>(velocityX, velocityY);
	}

	/**
	 * Returns the velocity vector of FLING events.
	 * @return the velocity vector
	 */
	public InputVector<Float> getVelocityVector()
	{
		return vector;
	}

	/**
	 * Sets the distance vector of a SCROLL event.
	 * @param distanceX distance along the x-axis
	 * @param distanceY distance along the y-axis
	 */
	public void setDistanceVector(final float distanceX, final float distanceY)
	{
		vector = new InputVector<Float>(distanceX, distanceY);
	}

	/**
	 * Returns the distance vector of a SCROLL event.
	 * @return the distance vector
	 */
	public InputVector<Float> getDistanceVector()
	{
		return vector;
	}

	/**
	 * Sets the scale detector of a scale-type input event. Used by SCALEBEGIN,
	 * SCALE, and SCALEEND events.
	 * @param detector the reporting detector
	 */
	public void setScaleDetector(final ScaleGestureDetector detector)
	{
		scaleGestureDetector = detector;
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
