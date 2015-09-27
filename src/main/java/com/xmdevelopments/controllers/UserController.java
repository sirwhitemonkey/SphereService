package com.xmdevelopments.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.factories.UserFactory;
import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;

public class UserController {

	final static Logger logger = Logger.getLogger(UserController.class);
	private static UserFactory userFactory;

	static {
		try {
			logger.info("<UserFactory>initialised");
			BeanFactoryLocator factoryLocator = ContextSingletonBeanFactoryLocator
					.getInstance("classpath:beanRefContext.xml");
			BeanFactoryReference ref = factoryLocator.useBeanFactory("SphereBean");
			BeanFactory factory = ref.getFactory();
			userFactory = factory.getBean(UserFactory.class);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public UserController() {
		logger.info("<UserController>initialised");
	}

	public Response getUser(String username, boolean deleted, int group) {
		logger.info("getUser()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = userFactory.getUser(username, deleted, group);
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setData(responseError);
			logger.error(ex);
		}
		return response;
	}

	public Response getUsers(boolean deleted, int page, int limit) {
		logger.info("getUsers()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = userFactory.getUsers(deleted, page, limit);
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
