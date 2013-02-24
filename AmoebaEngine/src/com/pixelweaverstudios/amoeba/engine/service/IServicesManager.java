package com.pixelweaverstudios.amoeba.engine.service;

public interface IServicesManager
{
	public Service getService(ServiceType service);
	public void start();
}
