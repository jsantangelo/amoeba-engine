package org.amoeba.engine.service;

/**
 * Manages all Services provided by AmoebaEngine. Responsible for creating,
 * maintaining, and retrieving Services if requested.
 */
public interface ServicesManager
{
	/**
	 * Returns the requested Service by type.
	 * @param  service service type
	 * @return         a Service provided by AmoebaEngine
	 */
	public Service getService(ServiceType service);

	/**
	 * Notifies maintained Services that the Activity is ready to begin game
	 * execution.
	 */
	public void start();
}
