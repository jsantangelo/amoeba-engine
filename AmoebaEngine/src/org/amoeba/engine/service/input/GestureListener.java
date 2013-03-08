package org.amoeba.engine.service.input;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import org.amoeba.engine.AmoebaEngine;

/**
 * Responsible for interpreting raw touch events from the Android OS, and
 * returning usable information in the form of EngineEvents to game
 * applications.
 */
public class GestureListener implements GestureDetector.OnGestureListener,
	ScaleGestureDetector.OnScaleGestureListener
{
	private GestureDetector gestureDetector;
	private ScaleGestureDetector scaleGestureDetector;

	private InputService inputService;

	private boolean scrollingInProgress;

	private Context context;

	/**
	 * Constructor. Creates underlying Android gesture detectors.
	 * @param  service hook to main input service to be called back on
	 *                      input interpretation
	 */
	public GestureListener(final InputService service)
	{
		context = AmoebaEngine.getInstance().getContext();
		gestureDetector = new GestureDetector(context, this);
		scaleGestureDetector = new ScaleGestureDetector(context, this);

		inputService = service;

		scrollingInProgress = false;
	}

	/**
	 * Handles raw touch events, and passes them to the gesture detectors for
	 * interpretation. Will call back the main input service if necessary.
	 * @param  event raw motion event from the Android OS
	 * @return       whether or not to continue getting motion events
	 */
	public boolean onTouchEvent(final MotionEvent event)
	{
		gestureDetector.onTouchEvent(event);
		scaleGestureDetector.onTouchEvent(event);

		if (event.getAction() == MotionEvent.ACTION_UP && scrollingInProgress)
		{
			scrollingInProgress = false;
			inputService.handleProcessedInputEvent(new InputEvent(InputEvent.EventType.SCROLLEND));
		}
		return true;
	}

	/**
	 * Implements OnGestureListener's callback for "down" events. The "down"
	 * event precedes all other events.
	 * @param  event interpreted Android OS down event
	 * @return       whether or not the event was consumed
	 */
	public boolean onDown(final MotionEvent event)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.DOWN);
		inputEvent.setMotionEvent(event);
		inputService.handleProcessedInputEvent(inputEvent);
		return true;
	}

	/**
	 * Implements OnGestureListener's callback for "fling" events.
	 * @param  event1    starting down event
	 * @param  event2    motion event that triggered the "fling"
	 * @param  velocityX velocity along x-axis in pixels per second
	 * @param  velocityY velocity along y-axis in pixels per second
	 * @return           whether or not this event was consumed
	 */
	public boolean onFling(final MotionEvent event1, final MotionEvent event2,
		final float velocityX, final float velocityY)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.FLING);
		inputEvent.setStartingEvent(event1);
		inputEvent.setEndingEvent(event2);
		inputEvent.setVelocityVector(velocityX, velocityY);
		inputService.handleProcessedInputEvent(inputEvent);
		return true;
	}

	/**
	 * Implements OnGestureListener's callback for "long press" events.
	 * @param event interpreted Android OS down event
	 */
	public void onLongPress(final MotionEvent event)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.LONGPRESS);
		inputEvent.setMotionEvent(event);
		inputService.handleProcessedInputEvent(inputEvent);
	}

	/**
	 * Implements OnGestureListener's callback for "scroll" events.
	 * @param  event1    first down event in scroll gesture
	 * @param  event2    motion event that triggered "scroll"
	 * @param  distanceX distance along the x-axis since last "scroll" event
	 * @param  distanceY distance along the y-axis since last "scroll" event
	 * @return           whether this event was consumed
	 */
	public boolean onScroll(final MotionEvent event1, final MotionEvent event2,
		final float distanceX, final float distanceY)
	{
		if (!scaleGestureDetector.isInProgress())
		{
			scrollingInProgress = true;
			InputEvent inputEvent = new InputEvent(InputEvent.EventType.SCROLL);
			inputEvent.setStartingEvent(event1);
			inputEvent.setEndingEvent(event2);
			inputEvent.setDistanceVector(distanceX, distanceY);
			inputService.handleProcessedInputEvent(inputEvent);
		}
		return true;
	}

	/**
	 * Implements OnGestureListener's callback for "down but not finished" events.
	 * @param event interpreted Android OS event
	 */
	public void onShowPress(final MotionEvent event)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.SHOWPRESS);
		inputEvent.setMotionEvent(event);
		inputService.handleProcessedInputEvent(inputEvent);
	}

	/**
	 * Implements OnGestureListener's callback for "single tap" events.
	 * @param  event interpreted Android OS event
	 * @return       whether or not the event was consumed
	 */
	public boolean onSingleTapUp(final MotionEvent event)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.SINGLETAP);
		inputEvent.setMotionEvent(event);
		inputService.handleProcessedInputEvent(inputEvent);
		return true;
	}

	/**
	 * Implements OnScaleGestureListener's callback for "scale beginning" events.
	 * @param  detector detector reporting the event
	 * @return          whether or not to continue processing this scale event
	 */
	public boolean onScaleBegin(final ScaleGestureDetector detector)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.SCALEBEGIN);
		inputEvent.setScaleDetector(detector);
		inputService.handleProcessedInputEvent(inputEvent);
		return true;
	}

	/**
	 * Implements OnScaleGestureListener's callback for "scale continuing" events.
	 * @param  detector detector reporting the event
	 * @return          whether or not to continue processing this scale event
	 */
	public boolean onScale(final ScaleGestureDetector detector)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.SCALE);
		inputEvent.setScaleDetector(detector);
		inputService.handleProcessedInputEvent(inputEvent);
		return true;
	}

	/**
	 * Implements OnScaleGestureListener's callback for "scale ending" events.
	 * @param detector detector reporting the event
	 */
	public void onScaleEnd(final ScaleGestureDetector detector)
	{
		InputEvent inputEvent = new InputEvent(InputEvent.EventType.SCALEEND);
		inputEvent.setScaleDetector(detector);
		inputService.handleProcessedInputEvent(inputEvent);
	}
}
