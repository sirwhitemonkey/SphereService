package com.xmdevelopments.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.factories.ManagementTransactionsFactory;
import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.model.Transaction;

public class ManagementTransactionsController {

	final static Logger logger = Logger.getLogger(ManagementTransactionsController.class);
	private static ManagementTransactionsFactory managementTransactionsFactory;
	
	static {
		try {
			logger.info("<ManagementTransactionsFactory>initialised");
			BeanFactoryLocator factoryLocator = ContextSingletonBeanFactoryLocator
					.getInstance("classpath:beanRefContext.xml");
			BeanFactoryReference ref = factoryLocator.useBeanFactory("SphereBean");
			BeanFactory factory = ref.getFactory();
			managementTransactionsFactory = factory.getBean(ManagementTransactionsFactory.class);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public ManagementTransactionsController() {
		logger.info("<ManagementTransactionsController>initialised");
	}

	public Response submit(Transaction transaction) {
		logger.info("submit()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = managementTransactionsFactory.submit(transaction);
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
