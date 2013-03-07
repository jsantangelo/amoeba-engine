package com.pixelweaverstudios.amoeba.graphics.shader;

/**
 * ShaderConstants is a collection of variables used in shaders.
 */
public final class ShaderConstants
{
	/**
	 * Constructor for ShaderConstants. (Hidden).
	 */
	private ShaderConstants()
	{

	}

	public static final String ATTRIBUTE_COLOR = "a_Color";
	public static final String ATTRIBUTE_POSITION = "a_Position";
	public static final String ATTRIBUTE_TEXTURECOORDINATES = "a_TextureCoordinates";

	public static final String UNIFORM_COLOR = "u_Color";
	public static final String UNIFORM_MVPMATRIX = "u_MVPMatrix";
	public static final String UNIFORM_MODELVIEWMATRIX = "u_ModelViewMatrix";
	public static final String UNIFORM_PROJECTIONMATRIX = "u_ProjectionMatrix";
	public static final String UNIFORM_TEXTURE = "u_Texture";

	public static final String VARYING_COLOR = "v_Color";
	public static final String VARYING_POSITION = "v_Position";
	public static final String VARYING_TEXTURECOORDINATES = "v_TextureCoordinates";
}
