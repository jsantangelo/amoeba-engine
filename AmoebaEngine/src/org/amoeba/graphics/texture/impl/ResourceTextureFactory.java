package org.amoeba.graphics.texture.impl;

import org.amoeba.graphics.texture.ResourceTextureManager;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureFactory;
import org.amoeba.graphics.texture.TextureManager;
import org.amoeba.graphics.texture.TextureOptions.Preset;
import org.amoeba.graphics.utilities.TextureUtilities;

/**
 * ResourceTextureFactory is an implementation of a TextureFactory for textures from resources.
 */
public class ResourceTextureFactory implements TextureFactory
{
	private final ResourceTextureManager resourceManager;
	private final TextureManager textureManager;
	private final TextureUtilities textureUtilities;

	/**
	 * Constructor for ResourceTextureFactory.
	 * @param resManager Associates resources to textures.
	 * @param texManager The maintainer of the texture collection.
	 * @param utilities The texture utilities to use for texture operations.
	 */
	public ResourceTextureFactory(final ResourceTextureManager resManager, final TextureManager texManager, final TextureUtilities utilities)
	{
		resourceManager = resManager;
		textureManager = texManager;
		textureUtilities = utilities;
	}

	/**
	 * Create a texture from drawable resources.
	 * @param drawableId The id of the bitmap in drawable resources.
	 * @return The new texture.
	 */
	public Texture createTexture(final int drawableId)
	{
		Texture texture = resourceManager.getTexture(drawableId);
		if (texture == null)
		{
			texture = new ResourceTexture(textureUtilities, textureUtilities.getTextureOptionsPreset(Preset.DEFAULT), drawableId);
			textureManager.add(texture);
			resourceManager.add(texture, drawableId);
		}

		return texture;
	}
}
