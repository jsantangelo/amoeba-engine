package org.amoeba.engine.service.graphics.impl;

import org.amoeba.engine.service.graphics.GraphicsService;
import org.amoeba.entity.sprite.SpriteFactory;
import org.amoeba.entity.sprite.SpriteManager;
import org.amoeba.entity.sprite.impl.TextureSpriteFactory;
import org.amoeba.graphics.shader.ShaderProgramManager;
import org.amoeba.graphics.texture.TextureFactory;
import org.amoeba.graphics.texture.TextureManager;
import org.amoeba.graphics.texture.impl.BitmapTextureFactory;
import org.amoeba.graphics.utilities.BufferUtilities;
import org.amoeba.graphics.utilities.ShaderUtilities;
import org.amoeba.graphics.utilities.TextureUtilities;
import org.amoeba.graphics.utilities.impl.GLES20BufferUtilities;
import org.amoeba.graphics.utilities.impl.GLES20ShaderUtilities;
import org.amoeba.graphics.utilities.impl.GLES20TextureUtilities;

import android.content.Context;

/**
 * GLES20GraphicsService is an implementation of a GraphicsService for OpenGL ES 2.0.
 */
public class GLES20GraphicsService implements GraphicsService
{
	private final Context activityContext;

	private final BufferUtilities bufferUtilities;
	private final ShaderUtilities shaderUtilities;
	private final TextureUtilities textureUtilities;

	private final ShaderProgramManager shaderProgramManager;
	private final SpriteManager spriteManager;
	private final TextureManager textureManager;

	private final TextureFactory textureFactory;
	private final SpriteFactory spriteFactory;

	/**
	 * Constructor for GLES20GraphicsService.
	 * @param context The activity context.
	 */
	public GLES20GraphicsService(final Context context)
	{
		activityContext = context;

		bufferUtilities = new GLES20BufferUtilities();
		shaderUtilities = new GLES20ShaderUtilities();
		textureUtilities = new GLES20TextureUtilities(activityContext);

		shaderProgramManager = new ShaderProgramManager();
		spriteManager = new SpriteManager();
		textureManager = new TextureManager();

		textureFactory = new BitmapTextureFactory(textureManager, textureUtilities);
		spriteFactory = new TextureSpriteFactory(textureManager, textureFactory, shaderProgramManager, shaderUtilities, bufferUtilities, spriteManager);
	}

	@Override
	public SpriteFactory getSpriteFactory()
	{
		return spriteFactory;
	}

}
