package org.amoeba.engine.service;

/**
 * Defines all services provided by AmoebaEngine.
 */
public enum ServiceType
{
	//NOTE: Because we are (properly) using dep. inj. to link all services,
	//we might want to consider limiting some of these enums to be only
	//those that should be able to be retrieved by the end-user.
	THREAD, INPUT, RENDERER, VIEW
}
