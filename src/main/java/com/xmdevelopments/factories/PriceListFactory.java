package com.xmdevelopments.factories;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.services.PriceListService;

/**
 * Spring ejb price list service injection
 *
 */
@Service
public class PriceListFactory {

	final static Logger logger = Logger.getLogger(PriceListFactory.class);
	private static PriceListService priceListService;

	static {
		try {
			logger.info("initialise <Ejb-PriceListService> started ...");
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
			props.put(Context.PROVIDER_URL, "localhost:1099");
			// props.put(Context.SECURITY_PRINCIPAL, "testuser");
			// props.put(Context.SECURITY_CREDENTIALS, "testpassword");
			Context context = new InitialContext(props);
			priceListService = (PriceListService) context.lookup(
					"java:global/SphereEar/SphereService//PriceListBean!com.xmdevelopments.services.PriceListService");
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public Response getPriceLists(int page, int limit) {
		logger.info("getPriceLists()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = priceListService.getPriceLists(page, limit);
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.EXPECTATION_FAILED.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.EXPECTATION_FAILED.value()));
			response.setData(responseError);
			logger.error(ex);
		}
		return response;
	}
	
	public Response getPriceLists(String priceListCode, int page, int limit) {
		logger.info("getPriceLists()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = priceListService.getPriceLists(priceListCode,page, limit);
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
