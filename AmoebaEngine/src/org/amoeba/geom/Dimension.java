package org.amoeba.geom;

/**
 * Dimension holds a width and height.
 */
public class Dimension
{
	private float width, height;

	/**
	 * Default constructor for Dimension.
	 * Initializes the dimension with both width and height 0.0f.
	 */
	public Dimension()
	{
		setSize(0f, 0f);
	}

	/**
	 * Constructor for Dimension with a specific width and height.
	 * @param w The width
	 * @param h The height
	 */
	public Dimension(final float w, final float h)
	{
		setSize(w, h);
	}

	/**
	 * Constructor for Dimension with a specific width and height.
	 * @param size The width and height
	 */
	public Dimension(final Dimension size)
	{
		setSize(size);
	}

	/**
	 * Set both width and height.
	 * @param w The width
	 * @param h The height
	 */
	public void setSize(final float w, final float h)
	{
		setWidth(w);
		setHeight(h);
	}

	/**
	 * Set both width and height.
	 * @param size The width and height
	 */
	public void setSize(final Dimension size)
	{
		setWidth(size.getWidth());
		setHeight(size.getHeight());
	}

	/**
	 * Set the width.
	 * @param w The width
	 */
	public void setWidth(final float w)
	{
		width = w;
	}

	/**
	 * Set the height.
	 * @param h The height
	 */
	public void setHeight(final float h)
	{
		height = h;
	}

	/**
	 * Get the width.
	 * @return The width
	 */
	public float getWidth()
	{
		return width;
	}

	/**
	 * Get the height.
	 * @return The height
	 */
	public float getHeight()
	{
		return height;
	}
}
