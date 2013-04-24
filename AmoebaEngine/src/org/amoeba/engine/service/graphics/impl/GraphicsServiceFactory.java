package org.amoeba.engine.service.graphics.impl;

import org.amoeba.engine.service.graphics.GraphicsService;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;

/**
 * GraphicsServiceFactory creates a Graphics service based on the version of OpenGL ES.
 */
public final class GraphicsServiceFactory
{
	private static final int GLES20 = 0x2000;

	/**
	 * Constructor for GraphicsServiceFactory. (Hidden)
	 */
	private GraphicsServiceFactory()
	{

	}

	/**
	 * Creates and returns a graphics service based off of the version of OpenGL.
	 * @param context The activity context.
	 * @return A graphics service.
	 */
	public static GraphicsService getGraphicsService(final Context context)
	{
		GraphicsService graphicsService = null;

		final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        if (configurationInfo.reqGlEsVersion >= GLES20)
        {
        	graphicsService = new GLES20GraphicsService(context);
        }

		return graphicsService;
	}
}
