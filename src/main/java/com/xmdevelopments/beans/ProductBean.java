package com.xmdevelopments.beans;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.model.entities.Product;
import com.xmdevelopments.pages.Pages;
import com.xmdevelopments.repositories.ProductRepository;
import com.xmdevelopments.services.ProductService;

/**
 * Product (EJB Bean)
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class ProductBean implements ProductService {

	final static Logger logger = Logger.getLogger(ProductBean.class);

	@Autowired
	ProductRepository productRepository;
	
	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.ProductService#getProducts(java.lang.String, boolean, boolean, int, int)
	 */
	@Override
	public Response getProducts(String date_last_updated, boolean inActive, boolean inStock,
			int page, int limit) {
		String prefix = "getProducts()";
		logger.info(prefix + "->[params]:" + date_last_updated + "," + inActive + "," + inStock
				+ "," + page + "," + limit);

		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			Page<Product> products = productRepository.findByIsNotActiveAndIsInStock(inActive, inStock, new PageRequest(page, limit));
			response.setResponseCode(HttpStatus.OK.value());
			response.setData(new Pages(products));
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.EXPECTATION_FAILED.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.EXPECTATION_FAILED.value()));
			response.setData(responseError);
			logger.error(prefix , ex);
		}

		return response;
	}
}
