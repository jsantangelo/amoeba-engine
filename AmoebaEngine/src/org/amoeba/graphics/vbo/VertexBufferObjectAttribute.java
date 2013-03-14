package org.amoeba.graphics.vbo;

/**
 * VertexBufferObjectAttribute holds the values of a single attribute.
 */
public class VertexBufferObjectAttribute
{
	private final int location;
	private final String name;
	private final int size;
	private final int type;
	private final int offset;
	private final boolean normalized;

	/**
	 * Constructor for VertexBufferObjectAttribute.
	 * @param attribLocation The location of the attribute.
	 * @param attribName The name of the attribute.
	 * @param attribSize The size of the attribute.
	 * @param attribType The type of the attribute.
	 * @param attribOffset The offset of the attribute.
	 * @param attribNormalized Whether the attribute is normalized.
	 */
	public VertexBufferObjectAttribute(final int attribLocation, final String attribName, final int attribSize, final int attribType, final int attribOffset, final boolean attribNormalized)
	{
		location = attribLocation;
		name = attribName;
		size = attribSize;
		type = attribType;
		offset = attribOffset;
		normalized = attribNormalized;
	}

	/**
	 * Get the location of the attribute.
	 * @return The location of the attribute.
	 */
	public int getLocation()
	{
		return location;
	}

	/**
	 * Get the name of the attribute.
	 * @return The name of the attribute.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Get the size of the attribute.
	 * @return The size of the attribute.
	 */
	public int getSize()
	{
		return size;
	}

	/**
	 * Get the offset of the attribute.
	 * @return The offset of the attribute.
	 */
	public int getOffset()
	{
		return offset;
	}

	/**
	 * Get the type of the attribute.
	 * @return The type of the attribute.
	 */
	public int getType()
	{
		return type;
	}

	/**
	 * Get whether the attribute is normalized.
	 * @return Whether the attribute is normalized.
	 */
	public boolean isNormalized()
	{
		return normalized;
	}
}
