package com.xmdevelopments.factories;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.services.AuthService;

/**
 * Spring ejb authentication service injection
 *
 */
@Service
public class AuthFactory {

	final static Logger logger = Logger.getLogger(AuthFactory.class);
	private static AuthService authService;

	static {
		try {
			logger.info("initialise <Ejb-AuthService> started ...");
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
			props.put(Context.PROVIDER_URL, "localhost:1099");
			Context context = new InitialContext(props);
			authService = (AuthService) context.lookup(
					"java:global/SphereEar/SphereService//AuthBean!com.xmdevelopments.services.AuthService");
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public Response submit() {
		logger.info("submit()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = authService.submit();
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
