package org.amoeba.graphics.texture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TextureManagerTest
{
	private TextureManager textureManager;

	@Before
	public void setUp() throws Exception
	{
		textureManager = new TextureManager();
	}

	@Test
	public void testSizeInInitialState()
	{
		// Arrange Pre-conditions
		int expectedSize = 0;

		// Act
		int actualSize = textureManager.size();

		// Assert Post-conditions
		assertEquals(expectedSize, actualSize);
	}

	@Test
	public void testAddOneTexture()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testRemove()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testLoadAll()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testUnloadAll()
	{
		fail("Not yet implemented");
	}

}
