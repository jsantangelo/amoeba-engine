package org.amoeba.engine.service;

/**
 * Defines all services provided by AmoebaEngine.
 */
public enum ServiceType
{
	// We might want to consider limiting some of these to be only
	// those that should be able to be retrieved by the end-user.
	THREAD, INPUT, GRAPHICS, VIEW
}
