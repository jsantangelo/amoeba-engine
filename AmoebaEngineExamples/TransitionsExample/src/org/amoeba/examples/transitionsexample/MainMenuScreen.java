package org.amoeba.examples.transitionsexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.service.input.InputEvent;
import org.amoeba.entity.sprite.Sprite;
import org.amoeba.entity.sprite.TextureSprite;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.graphics.shader.ShaderConstants;
import org.amoeba.graphics.shader.source.TextureShaderProgram;
import org.amoeba.graphics.texture.BitmapTexture;
import org.amoeba.graphics.texture.Texture;
import org.amoeba.graphics.texture.TextureOptions.Preset;
import org.amoeba.graphics.utilities.GLES20TextureUtilities;
import org.amoeba.graphics.utilities.TextureUtilities;

import android.util.Log;
import android.opengl.GLES20;
import android.content.Intent;
import android.view.View;
import android.view.MotionEvent;

import java.util.Map;
import java.util.HashMap;

public class MainMenuScreen extends GameActivity
{
	private class Pair<X, Y> {
		public final X first;
		public final Y second;
		public Pair(X x, Y y) {
			first = x;
			second = y;
		}
	}

	private static final String TAG = "Amoeba.MainMenuScreen";

	private TextureShaderProgram program;
	private TextureUtilities textureUtilities;

	private Texture background_texture;
	private Sprite background;

	private Texture title_texture;
	private Sprite title;

	private Map<Integer, Pair<Texture, Sprite> > buttons;

	public MainMenuScreen()
	{
		textureUtilities = new GLES20TextureUtilities(this);
		program = new TextureShaderProgram();

		background_texture = new BitmapTexture(textureUtilities,
			textureUtilities.getTextureOptionsPreset(Preset.DEFAULT),
			R.drawable.mainmenu_bg);
		background = new TextureSprite(background_texture, program);

		title_texture = new BitmapTexture(textureUtilities,
			textureUtilities.getTextureOptionsPreset(Preset.DEFAULT),
			R.drawable.transition_title);
		title = new TextureSprite(title_texture, program);

		buttons = new HashMap<Integer, Pair<Texture, Sprite> >();

		createButton(R.drawable.none_button, textureUtilities, program);
		createButton(R.drawable.slide_button, textureUtilities, program);
		createButton(R.drawable.fade_button, textureUtilities, program);
	}

	private void createButton(int resource, TextureUtilities textureUtilities,
		TextureShaderProgram program)
	{
		Texture texture = new BitmapTexture(textureUtilities,
			textureUtilities.getTextureOptionsPreset(Preset.DEFAULT),
			resource);
		Sprite sprite = new TextureSprite(texture, program);
		buttons.put(resource, new Pair<Texture, Sprite>(texture, sprite));
	}

	@Override
	public void onSurfaceCreated()
	{
		program.compile();
		program.link();

		background_texture.load();
		background.load();

		title_texture.load();
		title.load();

		for (Pair<Texture, Sprite> pair : buttons.values())
		{
			pair.first.load();
			pair.second.load();
		}
	}

	@Override
	public void onSurfaceChanged(final int width, final int height)
	{
		background.setPosition(width/2, height/2);
		background.setScaleX(width);
		background.setScaleY(height);

		title.setPosition(width/2, height/6);
		title.setScaleX(350.0f);
		title.setScaleY(150.0f);

		for (Pair<Texture, Sprite> pair : buttons.values())
		{
			pair.second.setScaleX(250.0f);
			pair.second.setScaleY(100.0f);
		}

		buttons.get(R.drawable.none_button).second.setPosition(width/2,
			height/12*6);
		buttons.get(R.drawable.slide_button).second.setPosition(width/2,
			height/12*8);
		buttons.get(R.drawable.fade_button).second.setPosition(width/2,
			height/12*10);
	}

	@Override
	public void onDraw(final Camera camera)
	{
		GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

		background.onDraw(camera);
		title.onDraw(camera);
		for (Pair<Texture, Sprite> pair : buttons.values())
		{
			pair.second.onDraw(camera);
		}
	}

	@Override
	public void onUpdate()
	{

	}

	@Override
	public void onInputEvent(final InputEvent event)
	{
		if (event.getEventType() == InputEvent.EventType.SINGLETAP)
		{
			MotionEvent touchPoint = event.getMotionEvent();
			Log.d(TAG, "Single tap, coords: (" + touchPoint.getX() +
				"," + touchPoint.getY() + ")");

			if (checkForButtonCollision(touchPoint) != 0)
			{
				for (Pair<Texture, Sprite> pair : buttons.values())
				{
					pair.second.onDraw(camera);
				}
			}
		}
	}

	private Integer checkForButtonCollision(MotionEvent event)
	{
		return 0;
	}
}
