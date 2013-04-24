package org.amoeba.engine.service.graphics.impl;

import org.amoeba.engine.routing.Router;
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
import android.opengl.GLSurfaceView;

/**
 * GLES20GraphicsService is an implementation of a GraphicsService for OpenGL ES 2.0.
 */
public class GLES20GraphicsService implements GraphicsService
{
	private static final int GLES_VERSION = 2;

	private final Context activityContext;

	private final BufferUtilities bufferUtilities;
	private final ShaderUtilities shaderUtilities;
	private final TextureUtilities textureUtilities;

	private final ShaderProgramManager shaderProgramManager;
	private final SpriteManager spriteManager;
	private final TextureManager textureManager;

	private final TextureFactory textureFactory;
	private final SpriteFactory spriteFactory;

	private final GLSurfaceView.Renderer renderer;

	/**
	 * Constructor for GLES20GraphicsService.
	 * @param context The activity context.
	 * @param router The callback router.
	 */
	public GLES20GraphicsService(final Context context, final Router router)
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

		renderer = new GLES20Renderer(router);
	}

	@Override
	public SpriteFactory getSpriteFactory()
	{
		return spriteFactory;
	}

	@Override
	public GLSurfaceView.Renderer getRenderer()
	{
		return renderer;
	}

	@Override
	public int getGLVersion()
	{
		return GLES_VERSION;
	}
}
