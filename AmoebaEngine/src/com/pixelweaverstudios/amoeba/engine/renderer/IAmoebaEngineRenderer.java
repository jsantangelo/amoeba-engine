package com.pixelweaverstudios.amoeba.engine;

public interface IAmoebaEngineRenderer implements GLSurfaceView.Renderer
{
	public void attachEngine(IAmoebaEngine engine);
	public void onDrawFrame(GL10 unused);
	public void onSurfaceChanged(GL10 unused, int width, int height);
	public void onSurfaceCreated(GL10 unused, EGLConfig config);
}
