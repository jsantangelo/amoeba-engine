package com.pixelweaverstudios.amoeba.engine.service.view;

import android.view.SurfaceHolder;

import com.pixelweaverstudios.amoeba.engine.service.Service;

public interface ViewService extends Service
{
	public void onRequestRender();
	public SurfaceHolder getSurfaceHolder();
}