package org.amoeba.engine.service.input;

import android.view.MotionEvent;

import org.amoeba.engine.routing.Router;

/**
 * Implementation of the service responsible for input interpretation.
 */
public class EngineInput implements InputService
{
	private Router callbackRouter;
	private GestureListener gestureListener;

	/**
	 * Constructor. Responsible for creating the MotionEvent interpreter (Gesture
	 * Listener).
	 * @param  router entity to be called back on processed input events
	 */
	public EngineInput(final Router router)
	{
		callbackRouter = router;
		gestureListener = new GestureListener(this);
	}

	/**
	 * Processes an input event after it has been interpreted by the GestureListener.
	 * @param event and InputEvent from the core Android OS
	 */
	public void handleProcessedInputEvent(final InputEvent event)
	{
		callbackRouter.invokeInputEvent(event);
	}

	/**
	 * Passes raw MotionEvents from the View (and Android OS) to the
	 * interpreter (GestureListener).
	 * @param event raw MotionEvent from Android OS
	 */
	public void handleRawInputEvent(final MotionEvent event)
	{
		gestureListener.onTouchEvent(event);
	}

	/**
	 * Notifies the service that the game application is ready to start execution.
	 */
	public void start()
	{

	}
}
