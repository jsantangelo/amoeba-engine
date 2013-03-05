package com.pixelweaverstudios.amoeba.engine.service.gamethread;

import android.view.SurfaceHolder;

import com.pixelweaverstudios.amoeba.engine.service.ServiceType;
import com.pixelweaverstudios.amoeba.engine.service.view.ViewService;
import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;

/**
 * Implementation of the {SOMETYPE} of game loop.
 */
public class StandardGameThread extends Thread implements GameThreadService
{
	private ViewService viewService;
	private SurfaceHolder surfaceHolder;

	private static final String TAG = this.getClass().getSimpleName();

	private boolean isRunning = false;

	//Need to figure out what and why this number is 1000.
	private static final int ONE_THOUSAND = 1000;

	private static final int MAX_FPS = 60;
	private static final int MAX_FRAME_SKIPS = 5;
	private static final int FRAME_PERIOD = ONE_THOUSAND / MAX_FPS;

	/**
	 * Constructor.
	 */
	public StandardGameThread()
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

					//Next commented out line likely not necessary.
					//viewService.onUpdate();
					//render requests must go to view. Renderer is responsible for
					//invoking onDraw on the callback router
					viewService.onRequestRender();

					timeDiff = System.currentTimeMillis() - beginTime;
					sleepTime = (int) (FRAME_PERIOD - timeDiff);

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
