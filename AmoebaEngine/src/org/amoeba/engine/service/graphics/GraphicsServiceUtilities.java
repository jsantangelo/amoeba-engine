package org.amoeba.engine.service.graphics;

import org.amoeba.engine.routing.SurfaceListener;

/**
 * GraphicsServiceUtilities provides processing during surface events
 * in the graphics service.
 */
public interface GraphicsServiceUtilities extends SurfaceListener
{
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
