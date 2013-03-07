package org.amoeba.engine.service;

/**
 * Service provided by AmoebaEngine, accessed via the ServicesManager. Provides
 * a core service for AmoebaEngine game applications.
 */
public interface Service
{
	/**
	 * Signifies to the Service that the Activity is ready to begin. Notifies the
	 * Service to complete setup, and prepare for game execution.
	 */
	public void start();
}
