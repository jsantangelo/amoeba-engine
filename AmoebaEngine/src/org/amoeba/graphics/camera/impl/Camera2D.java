package org.amoeba.graphics.camera.impl;

import org.amoeba.graphics.camera.Camera;

import android.opengl.Matrix;

/**
 * Camera2D is an implementation of a camera for 2D scenes.
 */
public class Camera2D implements Camera
{
	private float[] viewMatrix = new float[MATRIX_SIZE];
	private float[] projectionMatrix = new float[MATRIX_SIZE];

	private float surfaceX, surfaceY;
	private float surfaceWidth, surfaceHeight;

	private boolean updateRequired = false;

	/**
	 * Constructor for Camera2D.
	 * @param x The left-most point of the surface.
	 * @param y The top-most point of the surface.
	 * @param width The horizontal size of the surface.
	 * @param height The vertical size of the surface.
	 */
	public Camera2D(final float x, final float y, final float width, final float height)
	{
		setPosition(x, y);
		setBounds(width, height);
		update();
	}

	/**
	 * Updates the matrices due to any changes.
	 */
	public void update()
	{
		if (updateRequired)
		{
			calculateViewMatrix();
			calculateProjectionMatrix();
			updateRequired = false;
		}
	}

	/**
	 * Set the x-position of the surface (Left).
	 * @param x The left-most point of the surface.
	 */
	protected void setX(final float x)
	{
		if (x != surfaceX)
		{
			surfaceX = x;
			updateRequired = true;
		}
	}

	/**
	 * Set the y-position of the surface (Top).
	 * @param y The top-most point of the surface.
	 */
	protected void setY(final float y)
	{
		if (y != surfaceY)
		{
			surfaceY = y;
			updateRequired = true;
		}
	}

	/**
	 * Get the x-position of the surface (Left).
	 * @return The left most point of the surface.
	 */
	public float getX()
	{
		return surfaceX;
	}

	/**
	 * Get the y-position of the surface (Top).
	 * @return The top most point of the surface.
	 */
	public float getY()
	{
		return surfaceY;
	}

	/**
	 * Set the position of the surface (Top-left).
	 * @param x The left-most point of the surface.
	 * @param y The top-most point of the surface.
	 */
	public void setPosition(final float x, final float y)
	{
		setX(x);
		setY(y);
	}

	/**
	 * Set the width of the surface.
	 * @param width The horizontal size of the surface.
	 */
	protected void setWidth(final float width)
	{
		if (width != surfaceWidth)
		{
			surfaceWidth = width;
			updateRequired = true;
		}
	}

	/**
	 * Set the height of the surface.
	 * @param height The vertical size of the surface.
	 */
	protected void setHeight(final float height)
	{
		if (height != surfaceHeight)
		{
			surfaceHeight = height;
			updateRequired = true;
		}
	}

	/**
	 * Get the width of the surface.
	 * @return The horizontal size of the surface.
	 */
	public float getWidth()
	{
		return surfaceWidth;
	}

	/**
	 * Get the height of the surface.
	 * @return The vertical size of the surface.
	 */
	public float getHeight()
	{
		return surfaceHeight;
	}

	/**
	 * Set the width and height of the surface.
	 * @param width The horizontal size of the surface.
	 * @param height The vertical size of the surface.
	 */
	public void setBounds(final float width, final float height)
	{
		setWidth(width);
		setHeight(height);
	}

	/**
	 * Set the center point of the surface.
	 * @param centerX The center most point in the horizontal direction.
	 * @param centerY The center most point in the vertical direction.
	 */
	public void setCenter(final float centerX, final float centerY)
	{
		setX(centerX - getWidth() / 2f);
		setX(centerY - getHeight() / 2f);
	}

	/**
	 * Get the view matrix, which represents the position and direction of the camera.
	 * @return The View Matrix.
	 */
	public float[] getViewMatrix()
	{
		return viewMatrix;
	}

	/**
	 * Get the projection matrix, which is used to project location of objects to where they should appear on the screen.
	 * @return The Projection Matrix.
	 */
	public float[] getProjectionMatrix()
	{
		return projectionMatrix;
	}

	/**
	 * Given a model matrix, calculate the model, view, projection matrix.
	 * @param modelMatrix The Model Matrix, which represents an object.
	 * @return The product of the model, view and projection matrices.
	 */
	public float[] calculateMVPMatrix(final float[] modelMatrix)
	{
		float[] mvpMatrix = new float[Camera.MATRIX_SIZE];

        Matrix.multiplyMM(mvpMatrix, 0, viewMatrix, 0, modelMatrix, 0);
        Matrix.multiplyMM(mvpMatrix, 0, projectionMatrix, 0, mvpMatrix, 0);

        return mvpMatrix;
	}

	/**
	 * Calculate the projection matrix using the position and size of the surface.
	 */
	private void calculateProjectionMatrix()
	{
		final float left = getX();
        final float right = getWidth();
        final float bottom = getHeight();
        final float top = getY();
        final float near = 0.0f;
        final float far = 2.0f;

        Matrix.orthoM(projectionMatrix, 0, left, right, bottom, top, near, far);
	}

	/**
	 * Calculate the view matrix.
	 */
	private void calculateViewMatrix()
	{
		final float eyeX = 0.0f;
        final float eyeY = 0.0f;
        final float eyeZ = 1.5f;
        final float lookX = 0.0f;
        final float lookY = 0.0f;
        final float lookZ = -5.0f;
        final float upX = 0.0f;
        final float upY = 1.0f;
        final float upZ = 0.0f;
        Matrix.setLookAtM(viewMatrix, 0, eyeX, eyeY, eyeZ, lookX, lookY, lookZ, upX, upY, upZ);
	}
}
