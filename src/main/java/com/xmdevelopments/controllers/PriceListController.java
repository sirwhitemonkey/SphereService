package com.xmdevelopments.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.factories.PriceListFactory;
import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;

public class PriceListController {

	final static Logger logger = Logger.getLogger(PriceListController.class);
	private static PriceListFactory priceListFactory;

	static {
		try {
			logger.info("<CustomerFactory>initialised");
			BeanFactoryLocator factoryLocator = ContextSingletonBeanFactoryLocator
					.getInstance("classpath:beanRefContext.xml");
			BeanFactoryReference ref = factoryLocator.useBeanFactory("SphereBean");
			BeanFactory factory = ref.getFactory();
			priceListFactory = factory.getBean(PriceListFactory.class);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public PriceListController() {
		logger.info("<PriceListController>initialised");
	}

	public Response getPriceLists(String date_last_updated, int page, int limit) {
		logger.info("getPriceLists()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = priceListFactory.getPriceLists(date_last_updated, page, limit);
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setData(responseError);
			logger.error(ex);
		}
		return response;
	}
	
	public Response getPriceLists(String date_last_updated, String code, int page, int limit) {
		logger.info("getPriceLists()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = priceListFactory.getPriceLists(date_last_updated, code,page, limit);
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
