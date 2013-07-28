package org.amoeba.geom.collision;

import org.amoeba.geom.Circle;
import org.amoeba.geom.Line;
import org.amoeba.geom.Point;
import org.amoeba.geom.Rectangle;

/**
 * CollisionHelper provides helper functions for collision between shapes.
 */
public final class CollisionHelper
{
	/**
	 * Determine whether two shapes are colliding.
	 * @param shape1 The first shape.
	 * @param shape2 The second shape.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Collidable shape1, final Collidable shape2)
	{
		boolean result = false;

		if (shape1 instanceof Circle)
		{
			result = isColliding((Circle) shape1, shape2);
		}
		else if (shape1 instanceof Line)
		{
			result = isColliding((Line) shape1, shape2);
		}
		else if (shape1 instanceof Point)
		{
			result = isColliding((Point) shape1, shape2);
		}
		else if (shape1 instanceof Rectangle)
		{
			result = isColliding((Rectangle) shape1, shape2);
		}

		return result;
	}

	/**
	 * Determine whether a circle is colliding with another shape.
	 * @param circle The circle.
	 * @param shape The other shape.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Circle circle, final Collidable shape)
	{
		boolean result = false;

		if (shape instanceof Circle)
		{
			result = isColliding(circle, (Circle) shape);
		}
		else if (shape instanceof Line)
		{
			result = isColliding(circle, (Line) shape);
		}
		else if (shape instanceof Point)
		{
			result = isColliding(circle, (Point) shape);
		}
		else if (shape instanceof Rectangle)
		{
			result = isColliding(circle, (Rectangle) shape);
		}

		return result;
	}

	/**
	 * Determine whether a line is colliding with another shape.
	 * @param line The line.
	 * @param shape The other shape.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Line line, final Collidable shape)
	{
		boolean result = false;

		if (shape instanceof Circle)
		{
			result = isColliding((Circle) shape, line);
		}
		else if (shape instanceof Line)
		{
			result = isColliding((Line) shape, line);
		}
		else if (shape instanceof Point)
		{
			result = isColliding(line, (Point) shape);
		}
		else if (shape instanceof Rectangle)
		{
			result = isColliding(line, (Rectangle) shape);
		}

		return result;
	}

	/**
	 * Determine whether a point is colliding with another shape.
	 * @param point The point.
	 * @param shape The other shape.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Point point, final Collidable shape)
	{
		boolean result = false;

		if (shape instanceof Circle)
		{
			result = isColliding((Circle) shape, point);
		}
		else if (shape instanceof Line)
		{
			result = isColliding((Line) shape, point);
		}
		else if (shape instanceof Point)
		{
			result = isColliding((Point) shape, point);
		}
		else if (shape instanceof Rectangle)
		{
			result = isColliding(point, (Rectangle) shape);
		}

		return result;
	}

	/**
	 * Determine whether a rectangle is colliding with another shape.
	 * @param rectangle The rectangle.
	 * @param shape The other shape.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Rectangle rectangle, final Collidable shape)
	{
		boolean result = false;

		if (shape instanceof Circle)
		{
			result = isColliding((Circle) shape, rectangle);
		}
		else if (shape instanceof Line)
		{
			result = isColliding((Line) shape, rectangle);
		}
		else if (shape instanceof Point)
		{
			result = isColliding((Point) shape, rectangle);
		}
		else if (shape instanceof Rectangle)
		{
			result = isColliding((Rectangle) shape, rectangle);
		}

		return result;
	}

	/**
	 * Determine whether a circle is colliding with another circle.
	 * @param circle1 The first circle.
	 * @param circle2 The second circle.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Circle circle1, final Circle circle2)
	{
		boolean colliding = false;
		CollisionMath collisionMath = new CollisionMath();
		float distanceBetween = collisionMath.calcDistance(circle1.getPosition(), circle2.getPosition());
		if ((distanceBetween - circle1.getRadius() - circle2.getRadius()) < 0)
		{
			colliding = true;
		}
		return colliding;
	}

	/**
	 * Determine whether a circle is colliding with a line.
	 * @param circle The circle.
	 * @param line The line.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Circle circle, final Line line)
	{
		return false;
	}

	/**
	 * Determine whether a circle is colliding with a point.
	 * @param circle The circle.
	 * @param point The point.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Circle circle, final Point point)
	{
		boolean colliding = false;
		CollisionMath collisionMath = new CollisionMath();
		float distanceBetween = collisionMath.calcDistance(circle.getPosition(), point);
		if ((distanceBetween - circle.getRadius()) < 0)
		{
			colliding = true;
		}
		return colliding;
	}

	/**
	 * Determine whether a circle is colliding with a rectangle.
	 * @param circle The circle.
	 * @param rectangle The rectangle.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Circle circle, final Rectangle rectangle)
	{
		return false;
	}

	/**
	 * Determine whether a line is colliding with another line.
	 * @param line1 The first line.
	 * @param line2 The second line.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Line line1, final Line line2)
	{
		return false;
	}

	/**
	 * Determine whether a line is colliding with a point.
	 * @param line The line.
	 * @param point The point.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Line line, final Point point)
	{
		return false;
	}

	/**
	 * Determine whether a line is colliding with a rectangle.
	 * @param line The line.
	 * @param rectangle The rectangle.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Line line, final Rectangle rectangle)
	{
		return false;
	}

	/**
	 * Determine whether a point is colliding with another point.
	 * @param point1 The first point.
	 * @param point2 The second point.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Point point1, final Point point2)
	{
		boolean colliding = false;
		if (point1.getX() == point2.getX() && point1.getY() == point2.getY())
		{
			colliding = true;
		}
		return colliding;
	}

	/**
	 * Determine whether a point is colliding with a rectangle.
	 * @param point The point.
	 * @param rectangle The rectangle.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Point point, final Rectangle rectangle)
	{
		return false;
	}

	/**
	 * Determine whether a rectangle is colliding with another rectangle.
	 * @param rectangle1 The first rectangle.
	 * @param rectangle2 The second rectangle.
	 * @return Whether the shapes are colliding.
	 */
	public static boolean isColliding(final Rectangle rectangle1, final Rectangle rectangle2)
	{
		return false;
	}

	/**
	 * Constructor for CollisionHelper. (Hidden)
	 */
	private CollisionHelper()
	{

	}
}
