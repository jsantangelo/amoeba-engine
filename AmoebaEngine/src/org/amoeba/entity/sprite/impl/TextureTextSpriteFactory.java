package org.amoeba.entity.sprite.impl;

import org.amoeba.entity.EntityManager;
import org.amoeba.entity.sprite.TextFactory;
import org.amoeba.entity.sprite.TextSprite;
import org.amoeba.geom.Point;
import org.amoeba.graphics.shader.ShaderProgramManager;
import org.amoeba.graphics.shader.impl.TextureShaderProgram;
import org.amoeba.graphics.texture.TextOptions;
import org.amoeba.graphics.texture.TextureFactory;
import org.amoeba.graphics.texture.impl.TextTexture;
import org.amoeba.graphics.utilities.BufferUtilities;

import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Typeface;

/**
 * TextureTextSpriteFactory provides an implementation of TextFactory using TextTextures.
 */
public class TextureTextSpriteFactory implements TextFactory
{
	private static final TextOptions DEFAULT_OPTIONS = new TextOptions(12, Color.BLACK, Align.CENTER, Typeface.DEFAULT, true);

	private final BufferUtilities bufferUtilities;
	private final EntityManager entityManager;
	private final ShaderProgramManager shaderProgramManager;
	private final TextureFactory textureFactory;
	private TextOptions defaultOptions;

	/**
	 * Constructor for TextureSpriteFactory.
	 * @param texFactory The texture factory.
	 * @param programManager The shader program manager.
	 * @param bufUtilities The buffer utilities.
	 * @param entManager The entity manager.
	 */
	public TextureTextSpriteFactory(final TextureFactory texFactory, final ShaderProgramManager programManager, final BufferUtilities bufUtilities, final EntityManager entManager)
	{
		textureFactory = texFactory;
		shaderProgramManager = programManager;
		bufferUtilities = bufUtilities;
		entityManager = entManager;
		defaultOptions = new TextOptions(DEFAULT_OPTIONS);
	}

	@Override
	public void setDefaultTextOptions(final TextOptions options)
	{
		defaultOptions = options;
	}

	@Override
	public TextSprite createTextSprite(final String text)
	{
		return createTextSprite(text, defaultOptions, 0.0f, 0.0f);
	}

	@Override
	public TextSprite createTextSprite(final String text, final Point position)
	{
		return createTextSprite(text, defaultOptions, position.getX(), position.getY());
	}

	@Override
	public TextSprite createTextSprite(final String text, final float x, final float y)
	{
		return createTextSprite(text, defaultOptions, x, y);
	}

	@Override
	public TextSprite createTextSprite(final String text, final TextOptions textOptions)
	{
		return createTextSprite(text, textOptions, 0.0f, 0.0f);
	}

	@Override
	public TextSprite createTextSprite(final String text, final TextOptions textOptions, final Point position)
	{
		return createTextSprite(text, textOptions, position.getX(), position.getY());
	}

	@Override
	public TextSprite createTextSprite(final String text, final TextOptions textOptions, final float x, final float y)
	{
		TextSprite textSprite = null;

		TextTexture texture = (TextTexture) textureFactory.createTexture(text, textOptions);

		TextureShaderProgram program = TextureShaderProgram.getInstance();
		shaderProgramManager.add(program);

		TextureSpriteVertexBufferObject vbo = new TextureSpriteVertexBufferObject(program, bufferUtilities);

		textSprite = new TextTextureSprite(texture, program, vbo);
		entityManager.add(textSprite);

		return textSprite;
	}
}
