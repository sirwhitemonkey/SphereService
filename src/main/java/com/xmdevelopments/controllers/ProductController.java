package com.xmdevelopments.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.factories.ProductFactory;
import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;

public class ProductController {

	final static Logger logger = Logger.getLogger(ProductController.class);
	private static ProductFactory productFactory;

	static {
		try {
			logger.info("<ProductFactory>initialised");
			BeanFactoryLocator factoryLocator = ContextSingletonBeanFactoryLocator
					.getInstance("classpath:beanRefContext.xml");
			BeanFactoryReference ref = factoryLocator.useBeanFactory("SphereBean");
			BeanFactory factory = ref.getFactory();
			productFactory = factory.getBean(ProductFactory.class);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public ProductController() {
		logger.info("<ProductController>initialised");
	}

	public Response getProducts(String date_last_updated, boolean inActive, boolean inStock, int page, int limit) {
		logger.info("getProducts()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = productFactory.getProducts(date_last_updated, inActive, inStock, page, limit);
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
