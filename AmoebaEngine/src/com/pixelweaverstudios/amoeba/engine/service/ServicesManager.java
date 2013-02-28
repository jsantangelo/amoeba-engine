package com.pixelweaverstudios.amoeba.engine.service;

public interface ServicesManager
{
	public Service getService(ServiceType service);
	public void start();
}
