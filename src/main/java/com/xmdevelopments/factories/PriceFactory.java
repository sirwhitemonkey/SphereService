package com.xmdevelopments.factories;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.services.PriceService;

/**
 * Spring ejb price service injection
 *
 */
@Service
public class PriceFactory {

	final static Logger logger = Logger.getLogger(PriceFactory.class);
	private static PriceService priceService;

	static {
		try {
			logger.info("initialise <Ejb-PriceService> started ...");
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
			props.put(Context.PROVIDER_URL, "localhost:1099");
			Context context = new InitialContext(props);
			priceService = (PriceService) context.lookup(
					"java:global/SphereEar/SphereService//PriceBean!com.xmdevelopments.services.PriceService");
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public Response getPrices(String date_last_updated, int page, int limit) {
		logger.info("getPrices()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = priceService.getPrices(date_last_updated, page, limit);
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
