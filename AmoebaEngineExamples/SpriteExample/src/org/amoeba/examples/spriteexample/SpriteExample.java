package org.amoeba.examples.spriteexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.entity.sprite.Sprite;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.source.TextureShaderProgram;
import org.amoeba.graphics.texture.BitmapTexture;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions.Preset;
import org.amoeba.graphics.utilities.GLES20TextureUtilities;
import org.amoeba.graphics.utilities.TextureUtilities;

import android.graphics.Color;
import android.os.SystemClock;

public class SpriteExample extends GameActivity
{
	private TextureShaderProgram program;
	private TextureUtilities textureUtilities;
	private Texture texture;
	private Sprite sprite;

	private int screenWidth, screenHeight;

	public SpriteExample()
	{
		screenWidth = 1;
		screenHeight = 1;

		textureUtilities = new GLES20TextureUtilities(this);

		program = new TextureShaderProgram();
		texture = new BitmapTexture(textureUtilities, textureUtilities.getTextureOptionsPreset(Preset.DEFAULT), R.drawable.happy);
		sprite = new Sprite(texture, program);
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
		sprite.setColor(Color.BLUE);
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
	}

	public void onInputEvent(final InputEvent event)
	{

	}
}
