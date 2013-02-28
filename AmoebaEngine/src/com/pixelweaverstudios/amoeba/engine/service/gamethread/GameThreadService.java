package com.pixelweaverstudios.amoeba.engine.service.gameloop;

public interface GameLoop extends Service, Thread
{
	public void setRunning(boolean running);
}
