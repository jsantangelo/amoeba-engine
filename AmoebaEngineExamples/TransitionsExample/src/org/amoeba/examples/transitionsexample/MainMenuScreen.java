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
import android.util.Pair;
import android.opengl.GLES20;
import android.content.Intent;
import android.view.View;
import android.view.MotionEvent;

import java.util.Map;
import java.util.HashMap;

public class MainMenuScreen extends GameActivity
{
	private static final String TAG = "Amoeba.MainMenuScreen";

	private TextureShaderProgram program;
	private TextureUtilities textureUtilities;

	private Texture background_texture;
	private Sprite background;

	private Texture title_texture;
	private Sprite title;

	private Map<Integer, Pair<Texture, Sprite> > buttons;
	private Map<Integer, Class> destinations;

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
		destinations = new HashMap<Integer, Class>();

		createButton(R.drawable.none_button, NoneScreen.class);
		createButton(R.drawable.slide_button, SlideScreen.class);
		createButton(R.drawable.fade_button, FadeScreen.class);
	}

	private void createButton(int resource, Class destination)
	{
		Texture texture = new BitmapTexture(textureUtilities,
			textureUtilities.getTextureOptionsPreset(Preset.DEFAULT),
			resource);
		Sprite sprite = new TextureSprite(texture, program);
		buttons.put(resource, new Pair<Texture, Sprite>(texture, sprite));
		destinations.put(resource, destination);
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
	public void onInputEvent(final InputEvent event)
	{
		if (event.getEventType() == InputEvent.EventType.SINGLETAP ||
			event.getEventType() == InputEvent.EventType.LONGPRESS)
		{
			MotionEvent touchPoint = event.getMotionEvent();
			Log.d(TAG, "Single tap, coords: (" + touchPoint.getX() +
				"," + touchPoint.getY() + ")");

			Integer clickedResource = checkForButtonCollision(touchPoint);

			if (destinations.containsKey(clickedResource))
			{
				Intent intent = new Intent(this, destinations.get(clickedResource));

				startActivity(intent);

				overrideTransition(event.getEventType(), clickedResource);
			}
		}
	}

	private Integer checkForButtonCollision(MotionEvent event)
	{
		for (Map.Entry<Integer, Pair<Texture, Sprite> > entry : buttons.entrySet())
		{
			Pair<Float, Float> position = entry.getValue().second.getPosition();
			float width = entry.getValue().second.getWidth();
			float height = entry.getValue().second.getHeight();

			if ((event.getX() > position.first - width/2.0f) &&
				(event.getX() < position.first + width/2.0f))
			{
				if ((event.getY() > position.second - height/2.0f) &&
					(event.getY() < position.second + height/2.0f))
				{
					return entry.getKey();
				}
			}
		}
		return 0;
	}

	private void overrideTransition(InputEvent.EventType eventType, Integer resource)
	{
		switch(resource)
		{
			case R.drawable.none_button:
				if (eventType == InputEvent.EventType.SINGLETAP)
				{
					//No transitions at all
					overridePendingTransition(R.anim.hold, R.anim.hold);
				}
				else
				{
					//OS defaults
				}
				break;
			case R.drawable.slide_button:
				if (eventType == InputEvent.EventType.SINGLETAP)
				{
					//Incoming slides from left
					overridePendingTransition(R.anim.slide_from_left, R.anim.hold);
				}
				else
				{
					//Incoming slides from left, as outgoing slides to right
					overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
				}
				break;
			case R.drawable.fade_button:
				if (eventType == InputEvent.EventType.SINGLETAP)
				{
					//Incoming fades in
					overridePendingTransition(R.anim.fade_in, R.anim.hold);
				}
				else
				{
					//OS defaults
				}
				break;
			default:
				break;
		}
	}
}
