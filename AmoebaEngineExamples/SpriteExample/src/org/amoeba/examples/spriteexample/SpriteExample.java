package org.amoeba.examples.spriteexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.entity.sprite.Sprite;
import org.amoeba.entity.sprite.TextureSprite;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.impl.TextureShaderProgram;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions.Preset;
import org.amoeba.graphics.texture.impl.BitmapTexture;
import org.amoeba.graphics.utilities.BufferUtilities;
import org.amoeba.graphics.utilities.ShaderUtilities;
import org.amoeba.graphics.utilities.TextureUtilities;
import org.amoeba.graphics.utilities.impl.GLES20BufferUtilities;
import org.amoeba.graphics.utilities.impl.GLES20ShaderUtilities;
import org.amoeba.graphics.utilities.impl.GLES20TextureUtilities;

import android.graphics.Color;
import android.os.SystemClock;

public class SpriteExample extends GameActivity
{
	private TextureShaderProgram program;
	private BufferUtilities bufferUtilities;
	private ShaderUtilities shaderUtilities;
	private TextureUtilities textureUtilities;
	private Texture texture;
	private Sprite sprite;

	private int screenWidth, screenHeight;

	public SpriteExample()
	{
		screenWidth = 1;
		screenHeight = 1;

		bufferUtilities = new GLES20BufferUtilities();
		shaderUtilities = new GLES20ShaderUtilities();
		textureUtilities = new GLES20TextureUtilities(this);

		program = new TextureShaderProgram(shaderUtilities);
		texture = new BitmapTexture(textureUtilities, textureUtilities.getTextureOptionsPreset(Preset.DEFAULT), R.drawable.happy);
		sprite = new TextureSprite(texture, program, bufferUtilities);
	}

	@Override
	public void onSurfaceCreated()
	{
		program.compile();
		program.link();

		texture.load();
		sprite.load();
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		screenWidth = width;
		screenHeight = height;

		sprite.setPosition(screenWidth / 2, screenHeight / 2);
		sprite.setScaleX(screenWidth / 2);
		sprite.setScaleY(screenHeight / 2);
		sprite.setColor(Color.BLUE, 10000L);
	}

	public void onDraw(final Camera camera)
	{
		sprite.onDraw(camera);
	}

	public void onUpdate()
	{
		long time = SystemClock.uptimeMillis() % 10000L;
		float angleInDegrees = (360.0f / 10000.0f) * ((int) time);

		sprite.setRotation(angleInDegrees);
		sprite.onUpdate();
	}

	public void onInputEvent(final InputEvent event)
	{

	}
}
