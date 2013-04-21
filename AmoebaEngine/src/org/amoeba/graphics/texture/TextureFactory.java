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
}
