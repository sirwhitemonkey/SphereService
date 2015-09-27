package com.xmdevelopments.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.factories.CustomerFactory;
import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;

public class CustomerController {

	final static Logger logger = Logger.getLogger(CustomerController.class);
	private static CustomerFactory customerFactory;

	static {
		try {
			logger.info("<CustomerFactory>initialised");
			BeanFactoryLocator factoryLocator = ContextSingletonBeanFactoryLocator
					.getInstance("classpath:beanRefContext.xml");
			BeanFactoryReference ref = factoryLocator.useBeanFactory("SphereBean");
			BeanFactory factory = ref.getFactory();
			customerFactory = factory.getBean(CustomerFactory.class);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public CustomerController() {
		logger.info("<CustomerController>initialised");
	}

	public Response getCustomers(int page, int limit) {
		logger.info("getCustomers()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = customerFactory.getCustomers(page, limit);
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
