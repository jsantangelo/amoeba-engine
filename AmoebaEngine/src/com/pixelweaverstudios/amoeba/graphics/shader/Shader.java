package com.pixelweaverstudios.amoeba.graphics.shader;

import android.opengl.GLES20;
import android.util.Log;

public class Shader
{
    private static final String TAG = "Program";
    private int handle;
    
    public Shader(final String shaderSource, final int shaderType)
    {
        handle = GLES20.glCreateShader(shaderType);
        if (handle == 0)
        {           
            throw new RuntimeException("Error creating shader.");
        }

        if (handle != 0) 
        {
            GLES20.glShaderSource(handle, shaderSource);

            GLES20.glCompileShader(handle);

            final int[] compileStatus = new int[1];
            GLES20.glGetShaderiv(handle, GLES20.GL_COMPILE_STATUS, compileStatus, 0);

            if (compileStatus[0] == 0) 
            {
                Log.e(TAG, "Error compiling shader: " + GLES20.glGetShaderInfoLog(handle));
                GLES20.glDeleteShader(handle);
                handle = 0;
            }
        }
    }
    
    public int getHandle()
    {
        return handle;
    }
}
