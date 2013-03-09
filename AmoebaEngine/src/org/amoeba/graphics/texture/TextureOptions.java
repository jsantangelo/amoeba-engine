package org.amoeba.graphics.texture;


/**
 * TextureOptions provides storage for various texture options.
 */
public class TextureOptions
{
	/**
	 * The various types of preset TextureOptions.
	 */
	public enum Preset
	{
		DEFAULT,
		CLAMP_NEAREST,
		CLAMP_LINEAR
	};

	private final int minFilter;
	private final int magFilter;
	private final float wrapS;
	private final float wrapT;

	/**
	 * Constructor for TextureOptions.
	 * @param textureMinFilter A GL_TEXTURE_MIN_FILTER parameter for a texture.
	 * @param textureMagFilter A GL_TEXTURE_MAG_FILTER parameter for a texture.
	 * @param textureWrapS A GL_TEXTURE_WRAP_S parameter for a texture.
	 * @param textureWrapT A GL_TEXTURE_WRAP_T parameter for a texture.
	 */
	public TextureOptions(final int textureMinFilter, final int textureMagFilter, final int textureWrapS, final int textureWrapT)
	{
		minFilter = textureMinFilter;
		magFilter = textureMagFilter;
		wrapS = textureWrapS;
		wrapT = textureWrapT;
	}

	/**
	 * Get the GL_TEXTURE_MIN_FILTER parameter.
	 * @return The GL_TEXTURE_MIN_FILTER parameter.
	 */
	public int getMinFilter()
	{
		return minFilter;
	}

	/**
	 * Get the GL_TEXTURE_MAG_FILTER parameter.
	 * @return The GL_TEXTURE_MAG_FILTER parameter.
	 */
	public int getMagFilter()
	{
		return magFilter;
	}

	/**
	 * Get the GL_TEXTURE_WRAP_S parameter.
	 * @return The GL_TEXTURE_WRAP_S parameter.
	 */
	public float getWrapS()
	{
		return wrapS;
	}

	/**
	 * Get the GL_TEXTURE_WRAP_T parameter.
	 * @return The GL_TEXTURE_WRAP_T parameter.
	 */
	public float getWrapT()
	{
		return wrapT;
	}
}
