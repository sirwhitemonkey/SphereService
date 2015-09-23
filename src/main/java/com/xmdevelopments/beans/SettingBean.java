package com.xmdevelopments.beans;

import java.io.File;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.services.SettingService;

/**
 * Setting (EJB Bean)
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class SettingBean implements SettingService {

	final static Logger logger = Logger.getLogger(SettingBean.class);

	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.SettingService#getThemes()
	 */
	@Override
	public Response getThemes() {
		String prefix = " getThemes()";

		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response.setResponseCode(HttpStatus.OK.value());
			// TODO getting the themes
			JsonFactory factory = new JsonFactory();
			ObjectMapper mapper = new ObjectMapper(factory);
			JsonNode jsonNode = mapper.readTree( getClass().getResourceAsStream("/mock/themes.json"));
			response.setData(jsonNode);
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.EXPECTATION_FAILED.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.EXPECTATION_FAILED.value()));
			response.setData(responseError);
			logger.error(prefix + "->" + ex);
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.SettingService#getDataDefaults()
	 */
	@Override
	public Response getDataDefaults() {
		String prefix = " getDataDefaults()";

		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response.setResponseCode(HttpStatus.OK.value());
			// TODO getting the data defaults
			JsonFactory factory = new JsonFactory();
			ObjectMapper mapper = new ObjectMapper(factory);
			JsonNode jsonNode = mapper.readTree( getClass().getResourceAsStream("/mock/dataDefaults.json"));
			response.setData(jsonNode);
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.EXPECTATION_FAILED.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.EXPECTATION_FAILED.value()));
			response.setData(responseError);
			logger.error(prefix + "->" + ex);
		}
		return response;
	}

	
	
}
