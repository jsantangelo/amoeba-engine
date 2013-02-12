package com.pixelweaverstudios.amoeba.graphics.texture;

/**
 * @author Mike Testen
 * 
 */
public interface ITexture
{
	/**
	 * @param context
	 */
	public void load();

	/**
	 *
	 */
	public void unload();

	/**
	 * @return Whether the texture is loaded.
	 */
	public boolean isLoaded();

	/**
	 * @param width
	 */
	public void setWidth(final int width);

	/**
	 * @param height
	 */
	public void setHeight(final int height);

	/**
	 * @param handle
	 */
	public void setHandle(final int handle);

	/**
	 * @param drawable
	 */
	public void setDrawable(final int drawable);

	/**
	 * @return The width of the texture.
	 */
	public int getWidth();

	/**
	 * @return The height of the texture.
	 */
	public int getHeight();

	/**
	 * @return The handle that represents the texture.
	 */
	public int getHandle();

	/**
	 * @return The drawable id number that was used to generate the texture.
	 */
	public int getDrawable();
}
