package org.amoeba.graphics.texture;

/**
 * TextureFactory provides functionality to create textures.
 */
public final class TextureFactory
{
	/**
	 * Constructor for TextureFactory. (Hidden)
	 */
	private TextureFactory()
	{

	}

	/**
	 * Create a texture from drawable resources.
	 * @param drawableId The id of the bitmap in drawable resources.
	 * @return The new texture.
	 */
	public static Texture createTexture(final int drawableId)
	{
		Texture texture = null;

		//texture = new BitmapTexture(TextureUtilities, drawableId);
		//TextureManager.add(texture);

		return texture;
	}
}
