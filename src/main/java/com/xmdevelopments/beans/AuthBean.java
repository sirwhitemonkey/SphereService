package com.xmdevelopments.beans;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.services.AuthService;

/**
 * Authentication (EJB Bean)
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class AuthBean implements AuthService {

	final static Logger logger = Logger.getLogger(AuthBean.class);

	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.AuthService#submit()
	 */
	@Override
	public Response submit() {
		String prefix = " submit()";
		logger.info(prefix + "->called");
		
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			// Assumed that passed the WSSE validation
			// TODO authentication procedure
			response.setResponseCode(HttpStatus.OK.value());
			response.setData("Authentication successful");
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setData(responseError);
			logger.error(prefix,ex);
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.AuthService#logout()
	 */
	@Override
	public Response logout() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.AuthService#forgotPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public Response forgotPassword(String userId, String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
