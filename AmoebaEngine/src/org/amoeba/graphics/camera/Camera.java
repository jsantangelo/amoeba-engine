package org.amoeba.graphics.camera;

/**
 * Camera is used to draw objects to the correct location on the screen.
 */
public interface Camera
{
	public static final int MATRIX_SIZE = 16;

	/**
	 * Updates the matrices due to any changes.
	 */
	public void update();

	/**
	 * Get the x-position of the surface (Left).
	 * @return The left most point of the surface.
	 */
	public float getX();

	/**
	 * Get the y-position of the surface (Top).
	 * @return The top most point of the surface.
	 */
	public float getY();

	/**
	 * Set the position of the surface (Top-left).
	 * @param x The left-most point of the surface.
	 * @param y The top-most point of the surface.
	 */
	public void setPosition(final float x, final float y);

	/**
	 * Get the width of the surface.
	 * @return The horizontal size of the surface.
	 */
	public float getWidth();

	/**
	 * Get the height of the surface.
	 * @return The vertical size of the surface.
	 */
	public float getHeight();

	/**
	 * Set the width and height of the surface.
	 * @param width The horizontal size of the surface.
	 * @param height The vertical size of the surface.
	 */
	public void setBounds(final float width, final float height);

	/**
	 * Set the center point of the surface.
	 * @param centerX The center most point in the horizontal direction.
	 * @param centerY The center most point in the vertical direction.
	 */
	public void setCenter(final float centerX, final float centerY);

	/**
	 * Get the view matrix, which represents the position and direction of the camera.
	 * @return The View Matrix.
	 */
	public float[] getViewMatrix();

	/**
	 * Get the projection matrix, which is used to project location of objects to where they should appear on the screen.
	 * @return The Projection Matrix.
	 */
	public float[] getProjectionMatrix();

	/**
	 * Given a model matrix, calculate the model, view, projection matrix.
	 * @param modelMatrix The Model Matrix, which represents an object.
	 * @return The product of the model, view and projection matrices.
	 */
	public float[] calculateMVPMatrix(float[] modelMatrix);
}
