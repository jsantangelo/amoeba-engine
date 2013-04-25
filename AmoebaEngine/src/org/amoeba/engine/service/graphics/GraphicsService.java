package org.amoeba.engine.service.graphics;

import org.amoeba.engine.routing.SurfaceListener;
import org.amoeba.engine.service.Service;
import org.amoeba.entity.sprite.SpriteFactory;

import android.opengl.GLSurfaceView;

/**
 * Service provided by AmoebaEngine, responsible for preparing the
 * graphics framework.
 */
public interface GraphicsService extends Service, SurfaceListener
{
	/**
	 * Get a Sprite Factory, used to create sprites.
	 * @return A Sprite Factory.
	 */
	public SpriteFactory getSpriteFactory();

	/**
	 * Get a OpenGL Renderer.
	 * @return An OpenGL Renderer.
	 */
	public GLSurfaceView.Renderer getRenderer();

	/**
	 * Get the version of OpenGL ES, used as the EGLContext client version.
	 * @return The current version of OpenGL ES.
	 */
	public int getGLVersion();
}
