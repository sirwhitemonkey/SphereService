package com.xmdevelopments.factories;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.services.SettingService;

/**
 * Spring ejb setting service injection
 *
 */
@Service
public class SettingFactory {

	final static Logger logger = Logger.getLogger(SettingFactory.class);
	private static SettingService settingService;

	static {
		try {
			logger.info("initialise <Ejb-SettingService> started ...");
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
			props.put(Context.PROVIDER_URL, "localhost:1099");
			Context context = new InitialContext(props);
			settingService = (SettingService) context.lookup(
					"java:global/SphereEar/SphereService//SettingBean!com.xmdevelopments.services.SettingService");
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public Response getThemes() {
		logger.info("getThemes()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = settingService.getThemes();
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
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
			response = settingService.getDataDefaults();
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setData(responseError);
			logger.error(ex);
		}
		return response;
	}
	
	public Response checkConnection() {
		logger.info("checkConnection()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = settingService.checkConnection();
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
