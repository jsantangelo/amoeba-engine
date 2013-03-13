package org.amoeba.examples.spriteexample;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
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
import android.util.Log;

public class SpriteExample extends GameActivity
{
	private float[] modelMatrix = new float[16];
	private TextureShaderProgram program;
	private TextureUtilities textureUtilities;
	private Texture texture;

	private final FloatBuffer positionBuffer;
	private final FloatBuffer colorBuffer;
	private final FloatBuffer textureCoordBuffer;

	private final int BYTES_PER_FLOAT = 4;
	private final int positionOffset = 0;
	private final int positionDataSize = 3;
	private final int positionStrideBytes = positionDataSize * BYTES_PER_FLOAT;
	private final int colorOffset = 0;
	private final int colorDataSize = 4;
	private final int colorStrideBytes = colorDataSize * BYTES_PER_FLOAT;
	private final int textureOffset = 0;
	private final int textureDataSize = 2;
	private final int textureStrideBytes = textureDataSize * BYTES_PER_FLOAT;

	private int screenWidth, screenHeight;

	public SpriteExample()
	{
		screenWidth = 0;
		screenHeight = 0;
		final float[] positionData =
		{
			// X, Y, Z
			-0.5f, 0.50f, 0.0f,
			-0.5f, -0.5f, 0.0f,
			0.50f, 0.50f, 0.0f,
			0.50f, -0.5f, 0.0f,
		};
		final float[] colorData =
		{
			// R, G, B, A
			1.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 1.0f, 1.0f, 1.0f
		};

		final float[] textureCoordData =
		{
			// U, V
			0.0f, 0.0f,
			0.0f, 1.0f,
			1.0f, 0.0f,
			1.0f, 1.0f
		};

		positionBuffer = ByteBuffer.allocateDirect(positionData.length * BYTES_PER_FLOAT).order(ByteOrder.nativeOrder()).asFloatBuffer();
		positionBuffer.put(positionData).position(0);

		colorBuffer = ByteBuffer.allocateDirect(colorData.length * BYTES_PER_FLOAT).order(ByteOrder.nativeOrder()).asFloatBuffer();
		colorBuffer.put(colorData).position(0);

		textureCoordBuffer = ByteBuffer.allocateDirect(textureCoordData.length * BYTES_PER_FLOAT).order(ByteOrder.nativeOrder()).asFloatBuffer();
		textureCoordBuffer.put(textureCoordData).position(0);

		program = new TextureShaderProgram();

		textureUtilities = new GLES20TextureUtilities(this);
		texture = new BitmapTexture(textureUtilities, textureUtilities.getTextureOptionsPreset(Preset.DEFAULT), R.drawable.happy);
	}

	@Override
	public void onSurfaceCreated()
	{
		Log.e("SpriteExample", "Compiling program.");
		program.compile();
		program.link();
		texture.load();
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		screenWidth = width;
		screenHeight = height;
	}

	public void onDraw(final Camera camera)
	{
		Log.e("SpriteExample", "drawing");
		program.use();
		Matrix.setIdentityM(modelMatrix, 0);
		Matrix.translateM(modelMatrix, 0, screenWidth / 2, screenHeight /2, 0);
        Matrix.scaleM(modelMatrix, 0, 100f, 100f, 1.0f);

		GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
		GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, texture.getHandle());
		GLES20.glUniform1i(program.getUniformLocation(ShaderConstants.UNIFORM_TEXTURE), 0);

		// Pass in the position information
		int positionHandle = program.getAttributeLocation(ShaderConstants.ATTRIBUTE_POSITION);
		positionBuffer.position(positionOffset);
		GLES20.glVertexAttribPointer(positionHandle, positionDataSize, GLES20.GL_FLOAT, false, positionStrideBytes, positionBuffer);
		GLES20.glEnableVertexAttribArray(positionHandle);

		// Pass in the color information
		int colorHandle = program.getAttributeLocation(ShaderConstants.ATTRIBUTE_COLOR);
		colorBuffer.position(colorOffset);
		GLES20.glVertexAttribPointer(colorHandle, colorDataSize, GLES20.GL_FLOAT, false, colorStrideBytes, colorBuffer);
		GLES20.glEnableVertexAttribArray(colorHandle);

		// Pass in the texture coordinate information
		int textureCoordHandle = program.getAttributeLocation(ShaderConstants.ATTRIBUTE_TEXTURECOORDINATES);
		textureCoordBuffer.position(textureOffset);
		GLES20.glVertexAttribPointer(textureCoordHandle, textureDataSize, GLES20.GL_FLOAT, false, textureStrideBytes, textureCoordBuffer);
		GLES20.glEnableVertexAttribArray(textureCoordHandle);

		int mvpMatrixHandle = program.getUniformLocation(ShaderConstants.UNIFORM_MVPMATRIX);
		GLES20.glUniformMatrix4fv(mvpMatrixHandle, 1, false, camera.calculateMVPMatrix(modelMatrix), 0);
		GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
		program.stopUsing();
	}

	public void onUpdate()
	{

	}

	public void onInputEvent(final InputEvent event)
	{

	}
}
