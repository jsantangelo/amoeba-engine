package com.pixelweaverstudios.amoeba.engine.service.gamethread;

import com.pixelweaverstudios.amoeba.engine.service.Service;

/**
 * Service responsible for the main game loop thread,
 */
public interface GameThreadService extends Service
{
	/**
	 * Sets the state of the game loop thread.
	 * @param running whether or not thread should be running
	 */
	public void setRunning(boolean running);
}
