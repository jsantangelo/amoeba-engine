package com.pixelweaverstudios.amoeba.engine.service.gameloop;

public class StandardGameThread implements GameThreadService
{
	private ViewService viewService;
	private SurfaceHolder surfaceHolder;

	private boolean running = false;

	private static final int MAX_FPS = 60;
	private static final int MAX_FRAME_SKIPS = 5;
	private static final int FRAME_PERIOD = 1000 / MAX_FPS;

	public StandardGameLoop()
	{
		super();

		viewService = AmoebaEngine.getInstance().getService<ViewService>(ServiceType.VIEW);
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
					viewService.requestRender();

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

					while (sleepTime < 0 && framsSkipped < MAX_FRAME_SKIPS)
					{
						viewService.onUpdate();
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