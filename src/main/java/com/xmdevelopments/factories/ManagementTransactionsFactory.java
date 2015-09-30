package com.xmdevelopments.factories;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.model.Transaction;
import com.xmdevelopments.services.ManagementTransactionsService;

/**
 * Spring ejb management transaction service injection
 *
 */
@Service
public class ManagementTransactionsFactory {

	final static Logger logger = Logger.getLogger(ManagementTransactionsFactory.class);
	private static ManagementTransactionsService managementTransactionsService;

	static {
		try {
			logger.info("initialise <Ejb-ManagementTransactionsService> started ...");
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
			props.put(Context.PROVIDER_URL, "localhost:1099");
			Context context = new InitialContext(props);
			managementTransactionsService = (ManagementTransactionsService) context.lookup(
					"java:global/SphereEar/SphereService//ManagementTransactionsBean!com.xmdevelopments.services.ManagementTransactionsService");
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public Response submit(Transaction transaction) {
		logger.info("submit()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = managementTransactionsService.submit(transaction);
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
