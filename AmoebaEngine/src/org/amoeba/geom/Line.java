package org.amoeba.geom;

import org.amoeba.geom.collision.Collidable;


/**
 * Line is a representation of a straight line between two points.
 */
public class Line extends Collidable
{
	private Point startPoint, endPoint;

	/**
	 * Default constructor for Line.
	 * Creates a line with both the start and end point at (0, 0).
	 */
	public Line()
	{
		this(0f, 0f, 0f, 0f);
	}

	/**
	 * Constructor for Line with a specific start and end point.
	 * @param start The start point.
	 * @param end The end point.
	 */
	public Line(final Point start, final Point end)
	{
		setStart(start);
		setEnd(end);
	}

	/**
	 * Constructor for Line with a specific start and end point.
	 * @param x1 The x coordinate of the start point.
	 * @param y1 The y coordinate of the start point.
	 * @param x2 The x coordinate of the end point.
	 * @param y2 The y coordinate of the end point.
	 */
	public Line(final float x1, final float y1, final float x2, final float y2)
	{
		setStart(x1, y1);
		setEnd(x2, y2);
	}

	/**
	 * Set the start point of the line.
	 * @param start Start point.
	 */
	public void setStart(final Point start)
	{
		startPoint = start;
	}

	/**
	 * Set the start point of the line.
	 * @param x The x coordinate of the start point.
	 * @param y The y coordinate of the start point.
	 */
	public void setStart(final float x, final float y)
	{
		startPoint.setPosition(x, y);
	}

	/**
	 * Set the end point of the line.
	 * @param end End point.
	 */
	public void setEnd(final Point end)
	{
		endPoint = end;
	}

	/**
	 * Set the end point of the line.
	 * @param x The x coordinate of the end point.
	 * @param y The y coordinate of the end point.
	 */
	public void setEnd(final float x, final float y)
	{
		endPoint.setPosition(x, y);
	}

	/**
	 * Get the start point of the line.
	 * @return The start point.
	 */
	public Point getStart()
	{
		return startPoint;
	}

	/**
	 * Get the end point of the line.
	 * @return The end point.
	 */
	public Point getEnd()
	{
		return endPoint;
	}
}
