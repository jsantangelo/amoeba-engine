package org.amoeba.engine.service.thread.implementation;

import org.amoeba.engine.routing.Router;
import org.amoeba.engine.service.view.ViewService;

import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Implementation of the ConstantGameSpeedWithFrameSkipping type of game loop.
 */
public class ConstantGameSpeedWithFrameSkippingGameThread extends Thread
{
	private static final String TAG = "AmoebaEngine.ConstantSpeedFrameSkip";

	private SurfaceHolder surfaceHolder;
	private ViewService viewService;
	private Router callbackRouter;

	//Need to figure out what and why this number is 1000.
	private static final int ONE_THOUSAND = 1000;
	private static final int MAX_FPS = 60;
	private static final int MAX_FRAME_SKIPS = 5;
	private static final int FRAME_PERIOD = ONE_THOUSAND / MAX_FPS;

	/**
	 * Constructor.
	 * @param  router entity to be called on update events
	 * @param view view to be called on render requests
	 */
	public ConstantGameSpeedWithFrameSkippingGameThread(final Router router,
		final ViewService view)
	{
		super();

		callbackRouter = router;
		viewService = view;
		surfaceHolder = viewService.getSurfaceHolder();
	}

	/**
	 * The main executable body of the underlying thread, called when the
	 * thread starts.
	 */
	@Override
	public void run()
	{
		long beginTime, timeDiff;
		int sleepTime = 0, framesSkipped;

		while (!isInterrupted())
		{
			try
			{
				synchronized (surfaceHolder)
				{
					beginTime = System.currentTimeMillis();
					framesSkipped = 0;

					//Update game state.
					callbackRouter.invokeUpdate();

					//Request a render callback from the Renderer,
					//by way of the ViewService,
					viewService.onRequestRender();

					//Calculate how long this update cycle took
					timeDiff = System.currentTimeMillis() - beginTime;
					//Calculate length of time to sleep
					sleepTime = (int) (FRAME_PERIOD - timeDiff);

					//If the cycle took less time than the allotted frame
					//time length (the frame rate), sleep for the rest
					//of the time.
					if (sleepTime > 0)
					{
						try
						{
							Thread.sleep(sleepTime);
						}
						catch (InterruptedException e)
						{
							Log.e(TAG, "Thread interrupted: " + e);
						}
					}

					//If the cycle took more time than the allotted frame
					//time length (the frame rate), catch up on update cycles
					//by skipping render cycles.
					while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS)
					{
						callbackRouter.invokeUpdate();
						sleepTime += FRAME_PERIOD;
						++framesSkipped;
					}
				}
			}
			catch (Exception e)
			{
				Log.e(TAG, "Generic error: " + e);
			}
		}
	}
}
