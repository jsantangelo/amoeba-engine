package org.amoeba.examples.inputexample;

import org.amoeba.activity.GameActivity;
import org.amoeba.graphics.camera.Camera;
import org.amoeba.engine.service.input.InputEvent;

import android.app.Activity;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class InputExample extends GameActivity
{
	private static final String TAG = "AmoebaEngine.InputExample";

    private TextView eventList = null;

    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Removing the Engine's GLSurfaceView's parent, so it can be reused in another layout.
        ((ViewGroup) ((GLSurfaceView) getView()).getParent()).removeView((GLSurfaceView) getView());

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.addView((GLSurfaceView) getView());
        eventList = new TextView(this);
        eventList.setMovementMethod(new ScrollingMovementMethod());
        eventList.setWidth(120);

        LayoutParams layoutParameters = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParameters.addRule(RelativeLayout.ALIGN_TOP);
        eventList.setLayoutParams(layoutParameters);
        eventList.setText("Touch the screen to see data on your inputs.\n\n");
        eventList.setBackgroundColor(0x07000000);
        relativeLayout.addView(eventList);

        setContentView(relativeLayout);
    }

    @Override
    public void onDraw(final Camera camera)
    {
        GLES20.glClearColor(0.0f, 0.0f, 1.0f, 1f);
    }

    @Override
	public void onInputEvent(final InputEvent event)
	{
        eventList.append(event.getEventType().toString() + "\n");
        scrollText();
	}

    @Override
    public void onBackPressed() {
        eventList.append("BACK KEY PRESSED\n");
        scrollText();
    }

    private void scrollText() {
        eventList.post(new Runnable()
        {
            public void run()
            {
                final int scrollAmount = eventList.getLayout().getLineTop(eventList.getLineCount())
                    - eventList.getHeight();

                if (scrollAmount > 0)
                {
                    eventList.scrollTo(0, scrollAmount);
                }
                else
                {
                    eventList.scrollTo(0, 0);
                }    
            }
        });
    }
}
