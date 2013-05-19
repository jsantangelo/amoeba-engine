package org.amoeba.entity.sprite.impl;

import org.amoeba.entity.sprite.Sprite;
import org.amoeba.entity.sprite.SpriteFactory;
import org.amoeba.entity.sprite.SpriteManager;
import org.amoeba.graphics.shader.ShaderProgramManager;
import org.amoeba.graphics.shader.impl.TextureShaderProgram;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureFactory;
import org.amoeba.graphics.texture.TextureManager;
import org.amoeba.graphics.utilities.BufferUtilities;
import org.amoeba.graphics.utilities.ShaderUtilities;

/**
 * TextureSpriteFactory provides an implementation of SpriteFactory for Textured sprites.
 */
public class TextureSpriteFactory implements SpriteFactory
{
	private final TextureManager textureManager;
	private final TextureFactory textureFactory;
	private final ShaderProgramManager shaderProgramManager;
	private final SpriteManager spriteManager;
	private final ShaderUtilities shaderUtilities;
	private final BufferUtilities bufferUtilities;

	/**
	 * Constructor for TextureSpriteFactory.
	 * @param texManager The texture manager.
	 * @param texFactory The texture factory.
	 * @param programManager The shader program manager.
	 * @param shaUtilities The shader utilities.
	 * @param bufUtilities The buffer utilities.
	 * @param sprManager The sprite manager.
	 */
	public TextureSpriteFactory(final TextureManager texManager, final TextureFactory texFactory, final ShaderProgramManager programManager, final ShaderUtilities shaUtilities, final BufferUtilities bufUtilities, final SpriteManager sprManager)
	{
		textureManager = texManager;
		textureFactory = texFactory;
		shaderProgramManager = programManager;
		shaderUtilities = shaUtilities;
		bufferUtilities = bufUtilities;
		spriteManager = sprManager;
	}

	@Override
	public Sprite createSprite(final int drawableID)
	{
		Sprite sprite = null;

		Texture texture = textureManager.getTexture(drawableID);
		if (texture == null)
		{
			texture = textureFactory.createTexture(drawableID);
		}

		TextureShaderProgram program = (TextureShaderProgram) shaderProgramManager.getProgram(TextureShaderProgram.VERTEX_SHADER_SOURCE, TextureShaderProgram.FRAGMENT_SHADER_SOURCE);
		if (program == null)
		{
			program = new TextureShaderProgram(shaderUtilities);
			shaderProgramManager.add(program);
		}

		TextureSpriteVertexBufferObject vbo = new TextureSpriteVertexBufferObject(program, bufferUtilities);
		sprite = new TextureSprite(texture, program, vbo);
		spriteManager.add(sprite);

		return sprite;
	}
}
