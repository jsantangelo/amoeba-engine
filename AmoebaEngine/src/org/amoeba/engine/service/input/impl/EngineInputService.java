package org.amoeba.engine.service.input.impl;

import android.content.Context;
import android.view.MotionEvent;

import org.amoeba.engine.routing.Router;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.engine.service.input.InputService;

/**
 * Implementation of the service responsible for input interpretation.
 */
public class EngineInputService implements InputService
{
	private Router callbackRouter;
	private GestureListener gestureListener;

	/**
	 * Constructor. Responsible for creating the MotionEvent interpreter (Gesture
	 * Listener).
	 * @param context current Activity context
	 * @param  router entity to be called back on processed input events
	 */
	public EngineInputService(final Context context, final Router router)
	{
		callbackRouter = router;
		gestureListener = new GestureListener(context, this);
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
	 * Enables or disables detection of LONGPRESS events.
	 * @param enabled whether or not longpress gesture is enabled
	 */
	public void setLongpressEnabled(final boolean enabled)
	{
		if (!enabled)
		{
			gestureListener.disableLongpress();
		}
		else
		{
			gestureListener.enableLongpress();
		}
	}

}
