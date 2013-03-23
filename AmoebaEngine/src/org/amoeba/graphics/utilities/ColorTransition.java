package org.amoeba.graphics.utilities;

import android.graphics.Color;


/**
 * ColorTransition provides a smooth transition between colors.
 */
public class ColorTransition
{
	private long transitionStart, transitionDuration;
	private int previousColor, targetColor;
	private boolean transitionComplete;

	/**
	 * Constructor for ColorTransition.
	 * @param currentColor The initial color that is being transitioned from.
	 * @param requestedColor The final color after the transition.
	 * @param duration The time in milliseconds that it takes to transition.
	 */
	public ColorTransition(final int currentColor, final int requestedColor, final long duration)
	{
		transitionStart = System.currentTimeMillis();
		transitionDuration = duration;
		previousColor = currentColor;
		targetColor = requestedColor;
		transitionComplete = false;
	}

	/**
	 * Return whether the color is in transition.
	 * @return Whether or not the color is in transition.
	 */
	public boolean isTransitionComplete()
	{
		return transitionComplete;
	}

	/**
	 * Retrieve the current color if in a transition.
	 * @return The current color of the transition.
	 */
	public int getCurrentColor()
	{
		int currentColor = targetColor;

		if (!transitionComplete)
		{
			long currentTime = System.currentTimeMillis();
			if (currentTime >= transitionStart + transitionDuration)
			{
				currentTime = transitionStart + transitionDuration;
			}

			float transition = ((float) (currentTime - transitionStart)) / (float) transitionDuration;
			if (transition >= 1.0f)
			{
				currentColor = targetColor;
				transitionComplete = true;
			}
			else
			{
				int red = Color.red(previousColor) + (int) ((Color.red(targetColor) - Color.red(previousColor)) * transition);
				int green = Color.green(previousColor) + (int) ((Color.green(targetColor) - Color.green(previousColor)) * transition);
				int blue = Color.blue(previousColor) + (int) ((Color.blue(targetColor) - Color.blue(previousColor)) * transition);
				int alpha = Color.alpha(previousColor) + (int) ((Color.alpha(targetColor) - Color.alpha(previousColor)) * transition);
				currentColor = Color.argb(alpha, red, green, blue);
			}
		}

		return currentColor;
	}
}
