package org.amoeba.examples.fire;

import org.amoeba.activity.GameActivity;
import org.amoeba.engine.routing.DrawListener;
import org.amoeba.engine.routing.UpdateListener;
import org.amoeba.engine.routing.InputListener;
import org.amoeba.engine.service.input.InputEvent;

import android.util.Log;
import android.app.Activity;
import android.os.Bundle;
import android.opengl.GLSurfaceView;
import android.opengl.GLES20;

public class LoadingScreen extends GameActivity
	implements DrawListener, UpdateListener, InputListener
{
    private static final String TAG = "Amoeba.Fire";

	private static int someNumber = 0;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       
        registerForCallbacks();

        setContentView((GLSurfaceView) getView());
    }

    private void registerForCallbacks()
	{
		getEngine().registerForDraw(this);
		getEngine().registerForUpdate(this);
		getEngine().registerForInput(this);
	}

    public void onDraw()
    {
    	Log.d(TAG, "onDraw handled");
    }

    public void onUpdate()
    {
    	Log.d(TAG, "onUpdate handled");
    }

    public void onInputEvent(InputEvent event)
    {
        Log.d(TAG, "onInputEvent handled");

    	someNumber++;
    	if (someNumber > 20)
    	{
    		someNumber = 0;
    	}
    	
    	if (someNumber < 10)
        {
            GLES20.glClearColor(0.0f, 0.0f, 1.0f, 1.0f);
        }
 		else if (someNumber > 10)
        {
            GLES20.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
        }
    }
}
