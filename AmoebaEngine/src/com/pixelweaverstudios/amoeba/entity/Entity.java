package com.pixelweaverstudios.amoeba.entity;

public interface Entity
{
	public float getX();
	public float getY();
	public void setX(final float x);
	public void setY(final float y);

	public float getRotation();
	public void setRotation(final float rotation);

	public boolean isScaled();
	public float getScale();
	public float getScaleX();
	public float getScaleY();
	public void setScale(final float scale);
	public void setScaleX(final float scaleX);
	public void setScaleY(final float scaleY);
}
