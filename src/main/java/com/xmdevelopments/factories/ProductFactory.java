package com.xmdevelopments.factories;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.services.ProductService;

/**
 * Spring ejb product service injection
 *
 */
@Service
public class ProductFactory {

	final static Logger logger = Logger.getLogger(ProductFactory.class);
	private static ProductService productService;

	static {
		try {
			logger.info("initialise <Ejb-ProductService> started ...");
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
			props.put(Context.PROVIDER_URL, "localhost:1099");
			Context context = new InitialContext(props);
			productService = (ProductService) context.lookup(
					"java:global/SphereEar/SphereService//ProductBean!com.xmdevelopments.services.ProductService");
			} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public Response getProducts(String date_last_updated, boolean inActive, boolean inStock,
			int page, int limit) {
		logger.info("getProducts()->called");
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			response = productService.getProducts(date_last_updated, inActive, inStock, page,
					limit);
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
