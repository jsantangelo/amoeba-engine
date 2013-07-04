package org.amoeba.graphics.texture;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TextureManagerTest
{
	private TextureManager textureManager;
	@Mock private Texture mockTexture1;
	@Mock private Texture mockTexture2;

	@Before
	public void setUp() throws Exception
	{
		textureManager = new TextureManager();
		MockitoAnnotations.initMocks(this);
	}

	private void verifySize(final int expectedSize)
	{
		int actualSize = textureManager.size();
		assertEquals(expectedSize, actualSize);
	}

	@Test
	public void testSizeInInitialState()
	{
		// Assert Post-conditions
		verifySize(0);
	}

	@Test
	public void testAdditionOfOneTextureInEmptyCollection()
	{
		// Act
		boolean textureAdded = textureManager.add(mockTexture1);

		// Assert Post-conditions
		verifySize(1);
		assertEquals(true, textureAdded);
	}

	@Test
	public void testAdditionOfOneTextureInCollectionThatAlreadyContainsTheTexture()
	{
		// Arrange Pre-conditions
		textureManager.add(mockTexture1);

		// Act
		boolean textureAdded = textureManager.add(mockTexture1);

		// Assert Post-conditions
		verifySize(1);
		assertEquals(false, textureAdded);
	}

	@Test
	public void testAdditionOfOneTextureInCollectionThatContainsAnotherTexture()
	{
		// Arrange Pre-conditions
		textureManager.add(mockTexture1);

		// Act
		boolean result = textureManager.add(mockTexture2);

		// Assert Post-conditions
		verifySize(2);
		assertEquals(true, result);
	}

	@Test
	public void testAdditionOfNullTexture()
	{
		// Act
		boolean result = textureManager.add(null);

		// Assert Post-conditions
		verifySize(0);
		assertEquals(false, result);
	}

	@Test
	public void testRemoveTextureInCollection()
	{
		// Arrange Pre-conditions
		textureManager.add(mockTexture1);

		// Act
		boolean result = textureManager.remove(mockTexture1);

		// Assert Post-conditions
		verifySize(0);
		assertEquals(true, result);
	}

	@Test
	public void testRemoveTextureNotInCollectionWithEmptyCollection()
	{
		// Act
		boolean result = textureManager.remove(mockTexture1);

		// Assert Post-conditions
		verifySize(0);
		assertEquals(false, result);
	}

	@Test
	public void testRemoveTextureNotInCollectionWithOneOtherItemInCollection()
	{
		// Arrange Pre-conditions
		textureManager.add(mockTexture1);

		// Act
		boolean result = textureManager.remove(mockTexture2);

		// Assert Post-conditions
		verifySize(1);
		assertEquals(false, result);
	}

	@Test
	public void testLoadAllWithOneItemInCollection()
	{
		// Arrange Pre=conditions
		textureManager.add(mockTexture1);

		// Act
		textureManager.loadAll();

		// Assert Post-conditions
		verify(mockTexture1).load();
	}

	@Test
	public void testLoadAllWithTwoItemsInCollection()
	{
		// Arrange Pre=conditions
		textureManager.add(mockTexture1);
		textureManager.add(mockTexture2);

		// Act
		textureManager.loadAll();

		// Assert Post-conditions
		verify(mockTexture1).load();
		verify(mockTexture2).load();
	}

	@Test
	public void testUnloadAllWithOneItemInCollection()
	{
		// Arrange Pre=conditions
		textureManager.add(mockTexture1);

		// Act
		textureManager.unloadAll();

		// Assert Post-conditions
		verify(mockTexture1).unload();
	}

	@Test
	public void testUnloadAllWithTwoItemsInCollection()
	{
		// Arrange Pre=conditions
		textureManager.add(mockTexture1);
		textureManager.add(mockTexture2);

		// Act
		textureManager.unloadAll();

		// Assert Post-conditions
		verify(mockTexture1).unload();
		verify(mockTexture2).unload();
	}

}
