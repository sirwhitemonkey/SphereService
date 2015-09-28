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
import com.xmdevelopments.model.entities.Price;
import com.xmdevelopments.pages.Pages;
import com.xmdevelopments.repositories.PriceRepository;
import com.xmdevelopments.services.PriceService;

/**
 * Price (EJB Bean)
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class PriceBean implements PriceService {

	final static Logger logger = Logger.getLogger(PriceBean.class);

	@Autowired
	PriceRepository priceRepository;

	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.PriceService#getPrices(java.lang.String, int, int)
	 */
	@Override
	public Response getPrices(String date_last_updated, int page, int limit) {
		String prefix = "getPrices()";
		logger.info(prefix + "->[params]:" +  date_last_updated + "," + page + "," + limit);

		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			Page<Price> prices = priceRepository.findAll(new PageRequest(page, limit));
			if (prices.getTotalElements() > 0) {
				response.setResponseCode(HttpStatus.OK.value());
			} else {
				response.setResponseCode(HttpStatus.NOT_FOUND.value());
			}
			response.setData(new Pages(prices));
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setData(responseError);
			logger.error(prefix , ex);
		}

		return response;
	}
}
