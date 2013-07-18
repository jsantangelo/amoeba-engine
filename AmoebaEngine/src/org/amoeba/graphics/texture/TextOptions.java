package org.amoeba.graphics.texture;

import android.graphics.Paint.Align;
import android.graphics.Typeface;

/**
 * TextOptions provides storage for various Text options.
 */
public class TextOptions
{
	private int size;
	private int color;
	private Align alignment;
	private Typeface typeface;
	private boolean antiAlias;

	/**
	 * Constructor for TextOptions.
	 * @param textSize Font size of the text.
	 * @param textColor Color of the text.
	 * @param textAlignment Alignment of the text.
	 * @param textTypeface Typeface font of the text.
	 * @param textAntiAlias Whether the text is Anti-Aliased.
	 */
	public TextOptions(final int textSize, final int textColor, final Align textAlignment, final Typeface textTypeface, final boolean textAntiAlias)
	{
		size = textSize;
		color = textColor;
		alignment = textAlignment;
		typeface = textTypeface;
		antiAlias = textAntiAlias;
	}

	/**
	 * Get the size of the text.
	 * @return The text size.
	 */
	public int getSize()
	{
		return size;
	}

	/**
	 * Set the size of the text.
	 * @param textSize The text size.
	 */
	public void setSize(final int textSize)
	{
		size = textSize;
	}

	/**
	 * Get the color of the text.
	 * @return The text color.
	 */
	public int getColor()
	{
		return color;
	}

	/**
	 * Set the color of the text.
	 * @param textColor The text color.
	 */
	public void setColor(final int textColor)
	{
		color = textColor;
	}

	/**
	 * Get the alignment of the text.
	 * @return The text alignment.
	 */
	public Align getAlignment()
	{
		return alignment;
	}

	/**
	 * Set the alignment of the text.
	 * @param textAlignment The text alignment.
	 */
	public void setAlignment(final Align textAlignment)
	{
		alignment = textAlignment;
	}

	/**
	 * Get the typeface of the text.
	 * @return The text typeface.
	 */
	public Typeface getTypeface()
	{
		return typeface;
	}

	/**
	 * Set the typeface of the text.
	 * @param textTypeface The text typeface.
	 */
	public void setTypeface(final Typeface textTypeface)
	{
		typeface = textTypeface;
	}

	/**
	 * Get whether the text is anti-aliased.
	 * @return Whether the text is anti-aliased.
	 */
	public boolean isAntiAliased()
	{
		return antiAlias;
	}

	/**
	 * Set whether the text is anti-aliased.
	 * @param textAntiAlias Whether the text should be anti-aliased.
	 */
	public void setAntiAlias(final boolean textAntiAlias)
	{
		antiAlias = textAntiAlias;
	}
}
