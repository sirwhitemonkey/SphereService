package com.xmdevelopments.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.factories.SettingFactory;
import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;

public class SettingController {

	final static Logger logger = Logger.getLogger(SettingController.class);
	private static SettingFactory settingFactory;
	
	static {
		try {
			logger.info("<SettingFactory>initialised");
			BeanFactoryLocator factoryLocator = ContextSingletonBeanFactoryLocator
					.getInstance("classpath:beanRefContext.xml");
			BeanFactoryReference ref = factoryLocator.useBeanFactory("SphereBean");
			BeanFactory factory = ref.getFactory();
			settingFactory = factory.getBean(SettingFactory.class);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public SettingController() {
		logger.info("<SettingController>initialised");
	}

	public Response getThemes() {
		logger.info("getThemes()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = settingFactory.getThemes();
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.EXPECTATION_FAILED.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.EXPECTATION_FAILED.value()));
			response.setData(responseError);
			logger.error(ex);
		}
		return response;
	}
	
	public Response getDataDefaults() {
		logger.info("getDataDefaults()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = settingFactory.getDataDefaults();
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.EXPECTATION_FAILED.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.EXPECTATION_FAILED.value()));
			response.setData(responseError);
			logger.error(ex);
		}
		return response;
	}

}
