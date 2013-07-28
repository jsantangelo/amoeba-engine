package org.amoeba.geom.collision;

import org.amoeba.geom.Point;

/**
 * CollisionMath provides math functions for collision between shapes.
 */
public class CollisionMath
{
	/**
	 * Calculates the distance between two points.
	 * @param point1 The first point.
	 * @param point2 The second point.
	 * @return The distance between the two points.
	 */
	public float calcDistance(final Point point1, final Point point2)
	{
		double xDiff = (double) (point2.getX() - point1.getX());
		double yDiff = (double) (point2.getY() - point1.getY());
		float distance = (float) Math.sqrt((Math.pow(xDiff, 2)) + (Math.pow(yDiff, 2)));
		return distance;
	}
}
