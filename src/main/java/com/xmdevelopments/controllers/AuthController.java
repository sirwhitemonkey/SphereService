package com.xmdevelopments.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.factories.AuthFactory;
import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;

public class AuthController {

	final static Logger logger = Logger.getLogger(AuthController.class);
	private static AuthFactory authFactory;
	
	static {
		try {
			logger.info("<AuthFactory>initialised");
			BeanFactoryLocator factoryLocator = ContextSingletonBeanFactoryLocator
					.getInstance("classpath:beanRefContext.xml");
			BeanFactoryReference ref = factoryLocator.useBeanFactory("SphereBean");
			BeanFactory factory = ref.getFactory();
			authFactory = factory.getBean(AuthFactory.class);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public AuthController() {
		logger.info("<AuthController>initialised");
	}

	public Response submit() {
		logger.info("submit()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = authFactory.submit();
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
