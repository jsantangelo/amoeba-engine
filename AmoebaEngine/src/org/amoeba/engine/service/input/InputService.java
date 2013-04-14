package org.amoeba.engine.service.input;

import android.view.MotionEvent;

import org.amoeba.engine.service.Service;

/**
 * Service maintained by AmoebaEngine, responsible for the initial handling
 * and interpretation of input events from the View.
 */
public interface InputService extends Service
{
	/**
	 * Callback for processed input events by gesture interpreters.
	 * @param event processed AmoebaEngine input event
	 */
	public void handleProcessedInputEvent(InputEvent event);

	/**
	 * Handles raw Motion events from the Android OS.
	 * @param event raw MotionEvent from Android OS
	 */
	public void handleRawInputEvent(MotionEvent event);

	/**
	 * Enables or disables detection of LONGPRESS events.
	 * @param enabled whether or not longpress gesture is enabled
	 */
	public void setLongpressEnabled(boolean enabled);
}
