package org.amoeba.engine.service.thread;

import org.amoeba.engine.service.Service;
import org.amoeba.engine.service.view.ViewService;

/**
 * Service responsible for the main game loop thread handling.
 */
public interface ThreadService extends Service
{
	/**
	 * Starts the game loop thread.
	 * @param type type of game loop implementation to run
	 */
	public void startThread(ThreadType type);

	/**
	 * Stops/kills the game loop thread.
	 */
	public void stopThread();

	/**
	 * Sets the ViewService for this ThreadService.
	 * @param view the ViewService to be called back for render requests
	 */
	public void setViewService(ViewService view);
}
