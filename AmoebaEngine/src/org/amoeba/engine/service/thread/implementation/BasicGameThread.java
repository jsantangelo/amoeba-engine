package org.amoeba.engine.service.thread;

import android.view.SurfaceHolder;
import android.util.Log;

import org.amoeba.engine.routing.Router;
import org.amoeba.engine.service.view.ViewService;

/**
 * Implementation of the ConstantGameSpeedWithFrameSkipping type of game loop.
 */
public class BasicGameThread extends Thread
{
	private static final String TAG = "AmoebaEngine.BasicThread";

	private SurfaceHolder surfaceHolder;
	private ViewService viewService;
	private Router callbackRouter;

	/**
	 * Constructor.
	 * @param router entity to be called on update events
	 * @param view view to be called on render requests
	 */
	public BasicGameThread(final Router router, final ViewService view)
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
		while (!isInterrupted())
		{
			try
			{
				synchronized (surfaceHolder)
				{
					//Update game state.
					callbackRouter.invokeUpdate();

					//Request a render callback from the Renderer,
					//by way of the ViewService,
					viewService.onRequestRender();
				}
			}
			catch (Exception e)
			{
				Log.e(TAG, "Generic error: " + e);
			}
		}
	}
}
