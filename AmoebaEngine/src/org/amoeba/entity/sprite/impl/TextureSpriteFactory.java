package org.amoeba.entity.sprite.impl;

import org.amoeba.entity.EntityManager;
import org.amoeba.entity.sprite.Sprite;
import org.amoeba.entity.sprite.SpriteFactory;
import org.amoeba.geom.Point;
import org.amoeba.graphics.shader.ShaderProgramManager;
import org.amoeba.graphics.shader.impl.TextureShaderProgram;
import org.amoeba.graphics.texture.ResourceTextureManager;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureFactory;
import org.amoeba.graphics.utilities.BufferUtilities;

/**
 * TextureSpriteFactory provides an implementation of SpriteFactory for Textured sprites.
 */
public class TextureSpriteFactory implements SpriteFactory
{
	private final ResourceTextureManager resourceManager;
	private final TextureFactory textureFactory;
	private final ShaderProgramManager shaderProgramManager;
	private final EntityManager entityManager;
	private final BufferUtilities bufferUtilities;

	/**
	 * Constructor for TextureSpriteFactory.
	 * @param resManager The resource manager.
	 * @param texFactory The texture factory.
	 * @param programManager The shader program manager.
	 * @param bufUtilities The buffer utilities.
	 * @param entManager The entity manager.
	 */
	public TextureSpriteFactory(final ResourceTextureManager resManager, final TextureFactory texFactory, final ShaderProgramManager programManager, final BufferUtilities bufUtilities, final EntityManager entManager)
	{
		resourceManager = resManager;
		textureFactory = texFactory;
		shaderProgramManager = programManager;
		bufferUtilities = bufUtilities;
		entityManager = entManager;
	}

	@Override
	public Sprite createSprite(final int drawableID)
	{
		return createSprite(drawableID, 0.0f, 0.0f);
	}

	@Override
	public Sprite createSprite(final int drawableID, final Point position)
	{
		return createSprite(drawableID, position.getX(), position.getY());
	}

	@Override
	public Sprite createSprite(final int drawableID, final float x, final float y)
	{
		Sprite sprite = null;

		Texture texture = resourceManager.getTexture(drawableID);
		if (texture == null)
		{
			texture = textureFactory.createTexture(drawableID);
		}

		TextureShaderProgram program = TextureShaderProgram.getInstance();
		shaderProgramManager.add(program);

		TextureSpriteVertexBufferObject vbo = new TextureSpriteVertexBufferObject(program, bufferUtilities);
		sprite = new TextureSprite(x, y, texture, program, vbo);
		entityManager.add(sprite);

		return sprite;
	}
}
