package org.amoeba.geom.collision;

import static org.junit.Assert.assertEquals;

import org.amoeba.geom.Circle;
import org.amoeba.geom.Point;
import org.junit.Before;
import org.junit.Test;

public class CollisionHelperPointTest
{
	private Point point1 = null;
	private Point point2 = null;
	private Circle circle = null;

	@Before
	public void setup()
	{
		point1 = new Point();
		point2 = new Point();
		circle = new Circle();
	}

	@Test
	public void testIsCollidingPointPointWithStackedPoints()
	{
		// Arrange Pre-conditions
		point1.setPosition(0f, 0f);
		point2.setPosition(0f, 0f);

		// Act
		boolean result = CollisionHelper.isColliding(point1, point2);

		// Assert Post-conditions
		assertEquals(true, result);
	}

	@Test
	public void testIsCollidingPointPointWithSeparatedPoints()
	{
		// Arrange Pre-conditions
		point1.setPosition(0f, 0f);
		point2.setPosition(5f, 5f);

		// Act
		boolean result = CollisionHelper.isColliding(point1, point2);

		// Assert Post-conditions
		assertEquals(false, result);
	}
	
	@Test
	public void testIsCollidingStackedPointCircle()
	{
		// Arrange Pre-conditions
		point1.setPosition(0f, 0f);
		circle.setPosition(0f, 0f);
		circle.setRadius(1f);

		// Act
		boolean result = CollisionHelper.isColliding(point1, circle);

		// Assert Post-conditions
		assertEquals(true, result);
	}

	@Test
	public void testIsCollidingSeparatedPointCircle()
	{
		// Arrange Pre-conditions
		point1.setPosition(0f, 0f);
		circle.setPosition(5f, 5f);
		circle.setRadius(1f);

		// Act
		boolean result = CollisionHelper.isColliding(point1, circle);

		// Assert Post-conditions
		assertEquals(false, result);
	}
}
