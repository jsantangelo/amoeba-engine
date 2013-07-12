package org.amoeba.graphics.texture;

/**
 * TextureFactory provides functionality to create textures.
 */
public interface TextureFactory
{
	/**
	 * Create a texture from drawable resources.
	 * @param drawableId The id of the bitmap in drawable resources.
	 * @return The new texture.
	 */
	public Texture createTexture(final int drawableId);

	/**
	 * Create a texture from a string of text and options which describe
	 * how to draw that text.
	 * @param text The text to display on the texture.
	 * @param options The options used to display the texture.
	 * @return The new texture.
	 */
	public Texture createTexture(final String text, final TextOptions options);
}
