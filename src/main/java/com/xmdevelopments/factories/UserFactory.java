package com.xmdevelopments.factories;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.services.UserService;

/**
 * Spring ejb user service injection
 *
 */
@Service
public class UserFactory {

	final static Logger logger = Logger.getLogger(UserFactory.class);
	private static UserService userService;

	static {
		try {
			logger.info("initialise <Ejb-UserService> started ...");

			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
			props.put(Context.PROVIDER_URL, "localhost:1099");
			Context context = new InitialContext(props);
			userService = (UserService) context
					.lookup("java:global/SphereEar/SphereService//UserBean!com.xmdevelopments.services.UserService");
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public Response getUser(String username, boolean deleted, int group) {
		logger.info("getUser() called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = userService.getUser(username, deleted, group);
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
		logger.info("getUsers() called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = userService.getUsers(deleted, page, limit);
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
