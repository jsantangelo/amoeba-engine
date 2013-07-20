package org.amoeba.examples.entity.menu;

import org.amoeba.engine.service.graphics.GraphicsService;
import org.amoeba.entity.shape.Rectangle2D;
import org.amoeba.entity.sprite.TextSprite;
import org.amoeba.graphics.texture.TextOptions;

import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Typeface;

public class Button
{
	private Rectangle2D background;
	private TextSprite textSprite;
	private TextOptions textOptions;

	public Button(final String text, final int color, final GraphicsService graphics)
	{
		background = graphics.getShapeFactory().createRectangle();
		background.setColor(color);

		textOptions = new TextOptions(128, Color.BLACK, Align.CENTER, Typeface.DEFAULT, true);
		textSprite = graphics.getTextFactory().createTextSprite(text, textOptions);
	}

	public void setPosition(final float x, final float y)
	{
		background.setPosition(x, y);
		textSprite.setPosition(x, y);
	}

	public void setSize(final float width, final float height)
	{
		background.setWidth(width);
		background.setHeight(height);
	}

	public boolean isColliding(final float x, final float y)
	{
		boolean colliding = false;
		if(((background.getPosition().getY() - background.getHeight() / 2) <= y) &&
			((background.getPosition().getY() + background.getHeight() / 2) >= y) &&
			((background.getPosition().getX() - background.getWidth() / 2) <= x) &&
			((background.getPosition().getX() + background.getWidth() / 2) >= x))
		{
			colliding = true;
		}

		return colliding;
	}
}
