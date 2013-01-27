package com.pixelweaverstudios.amoeba.graphics.shader;

import java.util.ArrayList;

import android.opengl.GLES20;
import android.util.Log;

public class ShaderProgram
{
    private static final String TAG = "Program";
    private int handle;
    
    public ShaderProgram(final ArrayList<Shader> shaders)
    {
        if(shaders.size() <= 0)
        {
            throw new RuntimeException("No shaders were provided to create the program.");
        }
        
        handle = GLES20.glCreateProgram();
        if (handle == 0)
        {
            throw new RuntimeException("Error creating program.");
        }

        if (handle != 0) 
        {
            for(int i = 0; i < shaders.size(); i++)
            {
                GLES20.glAttachShader(handle, shaders.get(i).getHandle());
            }

            GLES20.glLinkProgram(handle);

            final int[] linkStatus = new int[1];
            GLES20.glGetProgramiv(handle, GLES20.GL_LINK_STATUS, linkStatus, 0);

            if (linkStatus[0] == 0) 
            {               
                Log.e(TAG, "Error compiling program: " + GLES20.glGetProgramInfoLog(handle));
                GLES20.glDeleteProgram(handle);
                handle = 0;
            }
        }
    }
    
    public int getHandle()
    {
        return handle;
    }
    
    public void use()
    {
        GLES20.glUseProgram(handle);
    }
    
    public boolean isInUse()
    {
        final int[] currentProgram = new int[1];
        GLES20.glGetIntegerv(GLES20.GL_CURRENT_PROGRAM, currentProgram, 0);
        
        return (currentProgram[0] == handle);
    }
    
    public void stopUsing()
    {
        if(isInUse())
        {
            GLES20.glUseProgram(0);
        }
    }
    
    public int getAttribute(final String attributeName)
    {
        if(attributeName == null)
        {
            throw new RuntimeException("attributeName is null");
        }
        
        int attribute = GLES20.glGetAttribLocation(handle, attributeName);
        if(attribute == -1)
        {
            throw new RuntimeException("Attribute '" + attributeName + "' not found.");
        }
        
        return attribute;
    }
    
    public int getUniform(final String uniformName)
    {
        if(uniformName == null)
        {
            throw new RuntimeException("uniformName is null");
        }
        
        int uniform = GLES20.glGetUniformLocation(handle, uniformName);
        if(uniform == -1)
        {
            throw new RuntimeException("Uniform '" + uniformName + "' not found.");
        }
        
        return uniform;
    }
}
