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
import com.xmdevelopments.model.entities.PriceList;
import com.xmdevelopments.pages.Pages;
import com.xmdevelopments.repositories.PriceListRepository;
import com.xmdevelopments.services.PriceListService;

/**
 * PriceList (EJB Bean)
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class PriceListBean implements PriceListService {

	final static Logger logger = Logger.getLogger(PriceListBean.class);

	@Autowired
	PriceListRepository priceListRepository;

	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.PriceListService#getPriceLists(int, int)
	 */
	@Override
	public Response getPriceLists(int page, int limit) {
		String prefix = "getPriceLists()";
		logger.info(prefix + "->[params]:" + "," + page + "," + limit);

		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			Page<PriceList> priceLists = priceListRepository.findAll(new PageRequest(page, limit));
			if (priceLists.getTotalElements() > 0) {
				response.setResponseCode(HttpStatus.OK.value());
			} else {
				response.setResponseCode(HttpStatus.NOT_FOUND.value());
			}
			response.setData(new Pages(priceLists));
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setData(responseError);
			logger.error(prefix , ex);
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.PriceListService#getPriceLists(int, int, int)
	 */
	@Override
	public Response getPriceLists(String code, int page, int limit) {
		String prefix = "getPriceLists()";
		logger.info(prefix + "->[params]:" + "," + code + "," + page + "," + limit);

		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			Page<PriceList> priceLists = priceListRepository.findByCode(code, new PageRequest(page, limit));
			if (priceLists.getTotalElements() > 0) {
				response.setResponseCode(HttpStatus.OK.value());
			} else {
				response.setResponseCode(HttpStatus.NOT_FOUND.value());
			}
			response.setData(new Pages(priceLists));
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
