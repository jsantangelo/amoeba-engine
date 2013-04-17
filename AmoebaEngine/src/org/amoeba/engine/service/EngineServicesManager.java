package org.amoeba.engine.service;

import java.util.EnumMap;

import org.amoeba.engine.routing.Router;
import org.amoeba.engine.service.input.EngineInput;
import org.amoeba.engine.service.input.InputService;
import org.amoeba.engine.service.renderer.GLES20RendererService;
import org.amoeba.engine.service.renderer.RendererService;
import org.amoeba.engine.service.thread.EngineThreadService;
import org.amoeba.engine.service.thread.ThreadService;
import org.amoeba.engine.service.view.EngineView;
import org.amoeba.engine.service.view.ViewService;

import android.content.Context;

/**
 * Implementation of the ServicesManager component of AmoebaEngine. Responsible
 * for creating, maintaining and providing access to any/all services provided
 * by AmoebaEngine.
 */
public class EngineServicesManager implements ServicesManager
{
	private EnumMap<ServiceType, Service> services;
	private Router callbackRouter;
	private Context currentContext;

	/**
	 * Constructor. Responsible for creating default services.
	 * @param  context current Activity context
	 * @param  router will accept callbacks and notify listeners
	 */
	public EngineServicesManager(final Context context, final Router router)
	{
		currentContext = context;
		callbackRouter = router;
		services = new EnumMap<ServiceType, Service>(ServiceType.class);
		createDefaultServices();
	}

	/**
	 * Creates the services of the AmoebaEngine with the default implementations
	 * provided with the Engine. Ties together all services if necessary.
	 */
	private void createDefaultServices()
	{
		//Input Services
		InputService inputService = new EngineInput(currentContext, callbackRouter);
		services.put(ServiceType.INPUT, inputService);

		//Renderer Services
		RendererService rendererService = new GLES20RendererService(callbackRouter);
		services.put(ServiceType.RENDERER, rendererService);

		//Thread Services
		ThreadService threadService = new EngineThreadService(callbackRouter);
		services.put(ServiceType.THREAD, threadService);

		//View Services
		ViewService viewService = new EngineView(currentContext, rendererService, inputService, threadService);
		services.put(ServiceType.VIEW, viewService);
	}

	/**
	 * Retrieves a service specified by a service type.
	 * @param  service service type
	 * @return         request service provided by AmoebaEngine
	 */
	public Service getService(final ServiceType service)
	{
		return services.get(service);
	}

}
