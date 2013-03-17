package org.amoeba.graphics.utilities;

import org.amoeba.entity.Coordinates;

import android.opengl.Matrix;

/**
 * Matrix helper provides functions to help use matrices.
 */
public final class MatrixHelper
{
	public static final int MATRIX_SIZE = 16;

	/**
	 * Create a matrix with given attributes.
	 * @param translation The translation in the matrix.
	 * @param scale The scale in the matrix.
	 * @param rotation The rotation in the matrix.
	 * @return A matrix with the given attributes.
	 */
	public static float[] createMatrix(final Coordinates translation, final Coordinates scale, final float rotation)
	{
		final float[] matrix = new float[MATRIX_SIZE];

		Matrix.setIdentityM(matrix, 0);
		Matrix.translateM(matrix, 0, translation.getX(), translation.getY(), 0f);
		Matrix.scaleM(matrix, 0, scale.getX(), scale.getY(), 1.0f);
		Matrix.rotateM(matrix, 0, rotation, 0.0f, 0.0f, 1.0f);

		return matrix;
	}

	/**
	 * Constructor for MatrixHelper. (Hidden)
	 */
	private MatrixHelper()
	{

	}
}
