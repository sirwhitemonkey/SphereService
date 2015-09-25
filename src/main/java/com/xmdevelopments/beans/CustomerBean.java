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
import com.xmdevelopments.model.entities.Customer;
import com.xmdevelopments.pages.Pages;
import com.xmdevelopments.repositories.CustomerRepository;
import com.xmdevelopments.services.CustomerService;

/**
 * Customer (EJB Bean)
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class CustomerBean implements CustomerService {

	final static Logger logger = Logger.getLogger(CustomerBean.class);

	@Autowired
	CustomerRepository customerRepository;

	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.CustomerService#getCustomers(int, int)
	 */
	@Override
	public Response getCustomers(int page, int limit) {
		String prefix = "getCustomers()";
		logger.info(prefix + "->[params]:" + "," + page + "," + limit);

		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			Page<Customer> customers = customerRepository.findAll(new PageRequest(page, limit));
			if (customers.getTotalElements() > 0) {
				response.setResponseCode(HttpStatus.OK.value());
			} else {
				response.setResponseCode(HttpStatus.NOT_FOUND.value());
			}
			response.setData(new Pages(customers));
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
