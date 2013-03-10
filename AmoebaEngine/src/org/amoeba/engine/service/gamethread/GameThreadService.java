package org.amoeba.engine.service.gamethread;

import org.amoeba.engine.service.Service;
import org.amoeba.engine.service.view.ViewService;

/**
 * Service responsible for the main game loop thread.
 */
public interface GameThreadService extends Service
{
	/**
	 * Sets the state of the game loop thread.
	 * @param running whether or not thread should be running
	 */
	public void setRunning(boolean running);

	/**
	 * Sets the ViewService for this GameThreadService.
	 * @param view the ViewService to be called back for render requests
	 */
	public void setViewService(ViewService view);
}
