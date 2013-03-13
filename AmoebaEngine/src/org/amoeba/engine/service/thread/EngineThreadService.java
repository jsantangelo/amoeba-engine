package org.amoeba.engine.service.thread;

import org.amoeba.engine.routing.Router;
import org.amoeba.engine.service.thread.implementation.BasicGameThread;
import org.amoeba.engine.service.thread.implementation.ConstantGameSpeedWithFrameSkippingGameThread;
import org.amoeba.engine.service.view.ViewService;

import android.util.Log;

/**
 * Service responsible for the main game loop thread handling.
 */
public class EngineThreadService implements ThreadService
{
	private static final String TAG = "AmoebaEngine.EngineThreadService";

	private ViewService viewService;
	private Router callbackRouter;

	private Thread gameLoop = null;

	/**
	 * Constructor.
	 * @param router router to be passed to the game loop
	 */
	public EngineThreadService(final Router router)
	{
		callbackRouter = router;
	}

	/**
	 * Sets the ViewService for this ThreadService.
	 * @param view the ViewService to be called back for render requests
	 */
	public void setViewService(final ViewService view)
	{
		viewService = view;
	}

	/**
	 * Starts the game loop thread.
	 * @param type type of game loop to start
	 */
	public void startThread(final ThreadType type)
	{
		if (gameLoop == null || !gameLoop.isAlive())
		{
			switch (type)
			{
				case BASIC:
					gameLoop = new BasicGameThread(callbackRouter, viewService);
					break;
				case CONSTANTSPEEDFRAMESKIP:
					gameLoop = new ConstantGameSpeedWithFrameSkippingGameThread(callbackRouter, viewService);
					break;
				default:
					gameLoop = new BasicGameThread(callbackRouter, viewService);
					break;
			}

			try
			{
				gameLoop.start();
			}
			catch (Exception e)
			{
				Log.e(TAG, "Exception: " + e);
			}
		}
	}

	/**
	 * Stops/kills the game loop thread.
	 */
	public void stopThread()
	{
		if (gameLoop != null)
		{
			gameLoop.interrupt();
			gameLoop = null;
		}
	}
}
