package com.xmdevelopments.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.factories.PriceFactory;
import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;

public class PriceController {

	final static Logger logger = Logger.getLogger(PriceController.class);
	private static PriceFactory priceFactory;

	static {
		try {
			logger.info("<PriceFactory>initialised");
			BeanFactoryLocator factoryLocator = ContextSingletonBeanFactoryLocator
					.getInstance("classpath:beanRefContext.xml");
			BeanFactoryReference ref = factoryLocator.useBeanFactory("SphereBean");
			BeanFactory factory = ref.getFactory();
			priceFactory = factory.getBean(PriceFactory.class);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public PriceController() {
		logger.info("<PriceController>initialised");
	}

	public Response getPrices(String date_last_updated, int page, int limit) {
		logger.info("getPrices()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = priceFactory.getPrices(date_last_updated, page, limit);
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setData(responseError);
			logger.error(ex);
		}
		return response;
	}

}
