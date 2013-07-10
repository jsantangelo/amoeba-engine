package org.amoeba.graphics.texture;

import android.graphics.Paint.Align;
import android.graphics.Typeface;

/**
 * TextOptions provides storage for various Text options.
 */
public class TextOptions
{
	private final int size;
	private final int color;
	private final Align alignment;
	private final Typeface typeface;
	private final boolean antiAlias;

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
	 * Get the color of the text.
	 * @return The text color.
	 */
	public int getColor()
	{
		return color;
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
	 * Get the typeface of the text.
	 * @return The text typeface.
	 */
	public Typeface getTypeface()
	{
		return typeface;
	}

	/**
	 * Get whether the text is anti-aliased.
	 * @return Whether the text is anti-aliased.
	 */
	public boolean isAntiAliased()
	{
		return antiAlias;
	}
}
