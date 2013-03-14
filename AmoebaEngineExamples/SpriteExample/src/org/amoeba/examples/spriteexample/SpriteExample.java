package org.amoeba.examples.spriteexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.entity.sprite.SpriteVertexBufferObject;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.source.TextureShaderProgram;
import org.amoeba.graphics.texture.BitmapTexture;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions.Preset;
import org.amoeba.graphics.utilities.GLES20TextureUtilities;
import org.amoeba.graphics.utilities.TextureUtilities;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;

public class SpriteExample extends GameActivity
{
	private TextureShaderProgram program;
	private TextureUtilities textureUtilities;
	private Texture texture;

	private float[] modelMatrix = new float[16];

	private SpriteVertexBufferObject spriteBuffer;

	private int screenWidth, screenHeight;

	public SpriteExample()
	{
		screenWidth = 1;
		screenHeight = 1;

		textureUtilities = new GLES20TextureUtilities(this);

		program = new TextureShaderProgram();
		texture = new BitmapTexture(textureUtilities, textureUtilities.getTextureOptionsPreset(Preset.DEFAULT), R.drawable.happy);
	}

	@Override
	public void onSurfaceCreated()
	{
		program.compile();
		program.link();

		texture.load();

		spriteBuffer = new SpriteVertexBufferObject(program);
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		screenWidth = width;
		screenHeight = height;
	}

	public void onDraw(final Camera camera)
	{
		program.use();

		long time = SystemClock.uptimeMillis() % 10000L;
		float angleInDegrees = (360.0f / 10000.0f) * ((int) time);
		float scale = screenHeight / 2;

		Matrix.setIdentityM(modelMatrix, 0);
		Matrix.translateM(modelMatrix, 0, screenWidth / 2, screenHeight / 2, 0f);
		Matrix.scaleM(modelMatrix, 0, scale, scale, 1.0f);
		Matrix.rotateM(modelMatrix, 0, angleInDegrees, 0.0f, 0.0f, 1.0f);
		drawTexture(texture, camera);

		program.stopUsing();
	}

	private void drawTexture(final Texture texture, final Camera camera)
	{
		spriteBuffer.bind();

		final float[] mvpMatrix = camera.calculateMVPMatrix(modelMatrix);
		int mvpMatrixHandle = program.getUniformLocation(ShaderConstants.UNIFORM_MVPMATRIX);
		GLES20.glUniformMatrix4fv(mvpMatrixHandle, 1, false, mvpMatrix, 0);

		spriteBuffer.draw(GLES20.GL_TRIANGLE_STRIP, 4);
	}

	public void onUpdate()
	{

	}

	public void onInputEvent(final InputEvent event)
	{

	}
}
