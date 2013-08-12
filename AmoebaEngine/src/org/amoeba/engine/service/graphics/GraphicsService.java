package org.amoeba.engine.service.graphics;

import org.amoeba.engine.routing.SurfaceListener;
import org.amoeba.engine.service.Service;
import org.amoeba.entity.shape.ShapeFactory;
import org.amoeba.entity.sprite.SpriteFactory;
import org.amoeba.entity.sprite.TextFactory;

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
	 * Get a Shape Factory, used to create drawable shapes.
	 * @return A Shape Factory.
	 */
	public ShapeFactory getShapeFactory();

	/**
	 * get a Text Factory, used to create text sprites.
	 * @return A Text Factory.
	 */
	public TextFactory getTextFactory();

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

	/**
	 * Set the GL Clear Color.
	 * @param color The android.color to be used as the clear color.
	 */
	public void setClearColor(final int color);

	/**
	 * Set the GL Clear Color.
	 * @param red The red component of the new clear color.
	 * @param green The green component of the new clear color.
	 * @param blue The blue component of the new clear color.
	 * @param alpha The alpha component of the new clear color.
	 */
	public void setClearColor(final float red, final float green, final float blue, final float alpha);
}
