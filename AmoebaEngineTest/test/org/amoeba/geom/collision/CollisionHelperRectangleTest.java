package org.amoeba.geom.collision;

import static org.junit.Assert.assertEquals;

import org.amoeba.geom.Rectangle;
import org.junit.Before;
import org.junit.Test;

public class CollisionHelperRectangleTest
{
	private Rectangle rectangle1 = null;
	private Rectangle rectangle2 = null;

	@Before
	public void setup()
	{
		rectangle1 = new Rectangle();
		rectangle2 = new Rectangle();
	}

	@Test
	public void testIsCollidingRectangleRectangleWithStackedRectangles()
	{
		// Arrange Pre-conditions
		rectangle1.setWidth(10f);
		rectangle1.setHeight(10f);
		rectangle2.setWidth(10f);
		rectangle2.setHeight(10f);

		// Act
		boolean result = CollisionHelper.isColliding(rectangle1, rectangle2);

		// Assert Post-conditions
		assertEquals(true, result);
	}

	@Test
	public void testIsCollidingRectangleRectangleWithSeparatedRectangles()
	{
		// Arrange Pre-conditions
		rectangle1.setPosition(0f, 0f);
		rectangle1.setWidth(10f);
		rectangle1.setHeight(10f);

		rectangle2.setPosition(20f, 20f);
		rectangle2.setWidth(10f);
		rectangle2.setHeight(10f);

		// Act
		boolean result = CollisionHelper.isColliding(rectangle1, rectangle2);

		// Assert Post-conditions
		assertEquals(true, result);
	}
}
