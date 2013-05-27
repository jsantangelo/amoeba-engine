package org.amoeba.engine.service.manager;

import org.amoeba.engine.service.Service;
import org.amoeba.engine.service.ServiceType;

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
}
