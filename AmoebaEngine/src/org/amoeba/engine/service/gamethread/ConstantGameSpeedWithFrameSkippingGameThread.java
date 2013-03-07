package org.amoeba.engine.service.gamethread;

import org.amoeba.engine.AmoebaEngine;
import org.amoeba.engine.service.ServiceType;
import org.amoeba.engine.service.view.ViewService;

import android.view.SurfaceHolder;
import android.util.Log;


/**
 * Implementation of the ConstantGameSpeedWithFrameSkipping type of game loop.
 */
public class ConstantGameSpeedWithFrameSkippingGameThread extends Thread implements GameThreadService
{
	private ViewService viewService;
	private SurfaceHolder surfaceHolder;

	private static final String TAG = GameThreadService.class.getSimpleName();

	private boolean isRunning = false;

	//Need to figure out what and why this number is 1000.
	private static final int ONE_THOUSAND = 1000;

	private static final int MAX_FPS = 60;
	private static final int MAX_FRAME_SKIPS = 5;
	private static final int FRAME_PERIOD = ONE_THOUSAND / MAX_FPS;

	/**
	 * Constructor.
	 */
	public ConstantGameSpeedWithFrameSkippingGameThread()
	{
		super();

		viewService = (ViewService) AmoebaEngine.getInstance().getService(ServiceType.VIEW);
		surfaceHolder = viewService.getSurfaceHolder();
	}

	/**
	 * Starts the game thread.
	 */
	public void start()
	{
		//Figure how out this service starts.
	}

	/**
	 * Sets the state (running or not-running) of the game thread.
	 * @param running whether or not the thread should be running
	 */
	public void setRunning(final boolean running)
	{
		isRunning = running;
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

		while (isRunning)
		{
			try
			{
				synchronized (surfaceHolder)
				{
					beginTime = System.currentTimeMillis();
					framesSkipped = 0;

					//Update game state.
					//viewService.onUpdate();

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
						//viewService.onUpdate();
						//want to invoke onUpdate on the callbackrouter, not view
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
