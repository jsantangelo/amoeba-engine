package org.amoeba.engine.service;

import java.util.EnumMap;

import org.amoeba.engine.routing.Router;
import org.amoeba.engine.service.gamethread.ConstantGameSpeedWithFrameSkippingGameThread;
import org.amoeba.engine.service.gamethread.GameThreadService;
import org.amoeba.engine.service.input.EngineInput;
import org.amoeba.engine.service.input.InputService;
import org.amoeba.engine.service.renderer.RendererService;
import org.amoeba.engine.service.renderer.GLES20RendererService;
import org.amoeba.engine.service.texture.EngineTextureService;
import org.amoeba.engine.service.texture.TextureService;
import org.amoeba.engine.service.view.EngineView;
import org.amoeba.engine.service.view.ViewService;

/**
 * Implementation of the ServicesManager component of AmoebaEngine. Responsible
 * for creating, maintaining and providing access to any/all services provided
 * by AmoebaEngine.
 */
public class EngineServicesManager implements ServicesManager
{
	private EnumMap<ServiceType, Service> services;
	private Router callbackRouter;

	/**
	 * Constructor. Responsible for creating default services.
	 * @param  router will accept callbacks and notify listeners
	 */
	public EngineServicesManager(final Router router)
	{
		callbackRouter = router;
		createDefaultServices();
	}

	/**
	 * Creates the services of the AmoebaEngine with the default implementations
	 * provided with the Engine. Ties together all services if necessary.
	 */
	public void createDefaultServices()
	{
		//Input Services
		InputService inputService = new EngineInput(callbackRouter);
		services.put(ServiceType.INPUT, inputService);

		//Renderer Services
		RendererService rendererService = new GLES20RendererService(callbackRouter);
		services.put(ServiceType.RENDERER, rendererService);

		//View Services
		ViewService viewService = new EngineView(rendererService, inputService);
		services.put(ServiceType.VIEW, viewService);

		//Thread Services
		GameThreadService threadService =
			new ConstantGameSpeedWithFrameSkippingGameThread(callbackRouter, viewService);
		services.put(ServiceType.THREAD, threadService);

		//Texture Services
		TextureService textureService = new EngineTextureService();
		services.put(ServiceType.TEXTURE, textureService);
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

	/**
	 * Notifies all services to prepare for execution (and therefore finalize all
	 * setup).
	 */
	public void start()
	{
		for (Service service : services.values())
		{
			service.start();
		}
	}
}
