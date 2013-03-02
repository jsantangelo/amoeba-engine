package com.pixelweaverstudios.amoeba.engine.service.renderer;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.egl.EGLConfig;

public interface RendererService extends GLSurfaceView.Renderer
{
	public void attachEngine();
	public void onDrawFrame(GL10 unused);
	public void onSurfaceChanged(GL10 unused, int width, int height);
	public void onSurfaceCreated(GL10 unused, EGLConfig config);
}