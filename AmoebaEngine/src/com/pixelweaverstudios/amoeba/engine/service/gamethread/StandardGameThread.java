package com.pixelweaverstudios.amoeba.engine.service.gamethread;

import android.view.SurfaceHolder;

import com.pixelweaverstudios.amoeba.engine.service.ServiceType;
import com.pixelweaverstudios.amoeba.engine.service.view.ViewService;
import com.pixelweaverstudios.amoeba.engine.AmoebaEngine;

public class StandardGameThread extends Thread implements GameThreadService
{
	private ViewService viewService;
	private SurfaceHolder surfaceHolder;

	private boolean running = false;

	private static final int MAX_FPS = 60;
	private static final int MAX_FRAME_SKIPS = 5;
	private static final int FRAME_PERIOD = 1000 / MAX_FPS;

	public StandardGameThread()
	{
		super();

		viewService = (ViewService)AmoebaEngine.getInstance().getService(ServiceType.VIEW);
		surfaceHolder = viewService.getSurfaceHolder();
	}

	public void start()
	{
		//TODO: Figure how out this service starts.
	}

	public void setRunning(boolean running)
	{
		this.running = running;
	}

	@Override
	public void run()
	{
		long beginTime, timeDiff;
		int sleepTime = 0, framesSkipped;

		while (running)
		{
			try
			{
				synchronized(surfaceHolder)
				{
					beginTime = System.currentTimeMillis();
					framesSkipped = 0;

					//TODO: next line likely not necessary
					//viewService.onUpdate();
					//render requests must go to view. Renderer is responsible for
					//invoking onDraw on the callback router
					viewService.onRequestRender();

					timeDiff = System.currentTimeMillis() - beginTime;
					sleepTime = (int)(FRAME_PERIOD - timeDiff);

					if (sleepTime > 0)
					{
						try
						{
							Thread.sleep(sleepTime);
						}
						catch (InterruptedException e)
						{
							//Thread interrupted
						}
					}

					while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS)
					{
						//viewService.onUpdate();
						//want to invoke onUpdate on the callbackrouter, not view
						sleepTime =+ FRAME_PERIOD;
						++framesSkipped;
					}
				}
			}
			catch (Exception e)
			{
				//Exception during gameloop
			}
		}
	}
}