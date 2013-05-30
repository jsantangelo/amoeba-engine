package org.amoeba.entity.sprite;


/**
 * AnimatedSprite is an entity that is used to display an animation.
 */
public abstract class AnimatedSprite extends Sprite
{
	/**
	 * Constructor for Animated Sprite.
	 * @param x The x position of the sprite (center).
	 * @param y The y position of the sprite (center).
	 */
	public AnimatedSprite(final float x, final float y)
	{
		super(x, y);
	}

	/**
	 * Play the animated sprite with the default repetitions.
	 * @return Whether the animated sprite is playing.
	 */
	public abstract boolean play();

	/**
	 * Play the animated sprite with a specified number of repetitions.
	 * @param repetitions The number of times to play through the animation.
	 * @return Whether the animated sprite is playing.
	 */
	public abstract boolean play(int repetitions);

	/**
	 * Pause the animated sprite.
	 * @return Whether the animated sprite was paused.
	 */
	public abstract boolean pause();

	/**
	 * Stop the animated sprite.
	 * @return Whether the animated sprite was stopped.
	 */
	public abstract boolean stop();

	/**
	 * Determine whether the animated sprite is playing.
	 * @return Whether the animated sprite is playing or not.
	 */
	public abstract boolean isPlaying();
}
