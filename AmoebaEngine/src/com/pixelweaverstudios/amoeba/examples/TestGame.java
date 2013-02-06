package com.pixelweaverstudios.amoeba.examples;

import android.os.Bundle;

import com.pixelweaverstudios.amoeba.activity.GameActivity;
import com.pixelweaverstudios.amoeba.engine.IAmoebaEngine;

/**
 * A basic game written to prove, through use, the interface of the AmoebaEngine.
 * @see AmoebaEngine
 */
public class TestGame extends GameActivity
{
	/**
	 * Is invoked when the Android OS system creates this Activity. onCreate
	 * is the entry point for all Android applications.
	 *
	 * @param savedInstanceState object that holds the instance state of an
	 *  application for later recreation if necessary
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		IAmoebaEngine myEngine = getEngine();
		//Screen mainMenu = createMainMenuScreen();
		//myEngine.addScreen(mainMenu);
		//myEngine.setGameLoop(somegameloop);
		//myEngine.completeInitialization();

		//Engine initialization should be done before we call the next line
		super.onCreate(savedInstanceState);
	}
}
