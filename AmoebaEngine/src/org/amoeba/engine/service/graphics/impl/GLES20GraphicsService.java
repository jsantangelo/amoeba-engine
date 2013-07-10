package org.amoeba.engine.service.graphics.impl;

import org.amoeba.engine.routing.Router;
import org.amoeba.engine.service.graphics.GraphicsService;
import org.amoeba.entity.EntityManager;
import org.amoeba.entity.shape.ShapeFactory;
import org.amoeba.entity.shape.impl.DrawableShapeFactory;
import org.amoeba.entity.sprite.SpriteFactory;
import org.amoeba.entity.sprite.impl.TextureSpriteFactory;
import org.amoeba.graphics.shader.ShaderProgramManager;
import org.amoeba.graphics.texture.ResourceTextureManager;
import org.amoeba.graphics.texture.TextureFactory;
import org.amoeba.graphics.texture.TextureManager;
import org.amoeba.graphics.texture.impl.ResourceTextureFactory;
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
	private final EntityManager entityManager;
	private final ResourceTextureManager resourceManager;
	private final TextureManager textureManager;

	private final TextureFactory textureFactory;
	private final SpriteFactory spriteFactory;
	private final ShapeFactory shapeFactory;

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

		shaderProgramManager = new ShaderProgramManager(shaderUtilities);
		entityManager = new EntityManager();
		resourceManager = new ResourceTextureManager();
		textureManager = new TextureManager();

		textureFactory = new ResourceTextureFactory(resourceManager, textureManager, textureUtilities);
		spriteFactory = new TextureSpriteFactory(resourceManager, textureFactory, shaderProgramManager, bufferUtilities, entityManager);
		shapeFactory = new DrawableShapeFactory(shaderProgramManager, bufferUtilities, entityManager);

		renderer = new GLES20Renderer(router);

		router.registerForDraw(entityManager);
		router.registerForUpdate(entityManager);
		router.registerForSurfaceEvents(this);
	}

	@Override
	public SpriteFactory getSpriteFactory()
	{
		return spriteFactory;
	}

	@Override
	public ShapeFactory getShapeFactory()
	{
		return shapeFactory;
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

	@Override
	public void onSurfaceCreated()
	{
		shaderProgramManager.loadAll();
		textureManager.loadAll();
		entityManager.loadAll();
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{

	}
}
