package com.xmdevelopments.factories;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.services.CustomerService;

/**
 * Spring ejb customer service injection
 *
 */
@Service
public class CustomerFactory {

	final static Logger logger = Logger.getLogger(CustomerFactory.class);
	private static CustomerService customerService;

	static {
		try {
			logger.info("initialise <Ejb-CustomerService> started ...");
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
			props.put(Context.PROVIDER_URL, "localhost:1099");
			Context context = new InitialContext(props);
			customerService = (CustomerService) context.lookup(
					"java:global/SphereEar/SphereService//CustomerBean!com.xmdevelopments.services.CustomerService");
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public Response getCustomers(int page, int limit) {
		logger.info("getCustomers()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = customerService.getCustomers(page, limit);
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
