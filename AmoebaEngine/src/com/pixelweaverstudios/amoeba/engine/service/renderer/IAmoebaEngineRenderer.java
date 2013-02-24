package com.pixelweaverstudios.amoeba.engine.service.renderer;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.egl.EGLConfig;

import com.pixelweaverstudios.amoeba.engine.IAmoebaEngine;

public interface IAmoebaEngineRenderer extends GLSurfaceView.Renderer
{
	public void attachEngine(IAmoebaEngine engine);
	public void onDrawFrame(GL10 unused);
	public void onSurfaceChanged(GL10 unused, int width, int height);
	public void onSurfaceCreated(GL10 unused, EGLConfig config);
}
