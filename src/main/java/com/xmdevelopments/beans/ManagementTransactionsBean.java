package com.xmdevelopments.beans;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.model.Transaction;
import com.xmdevelopments.services.ManagementTransactionsService;
import com.xmdevelopments.utils.Utils;

/**
 * ManagementTransactions (EJB Bean)
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class ManagementTransactionsBean implements ManagementTransactionsService {

	final static Logger logger = Logger.getLogger(ManagementTransactionsBean.class);

	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.ManagementTransactionsService#submitTransactions()
	 */
	@Override
	public Response submit(Transaction transaction) {
		String prefix = " submit()";
		logger.info(prefix + "->called->[params]->" + Utils.toJson(transaction));
		
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			// TODO 
			response.setResponseCode(HttpStatus.OK.value());
			response.setData("Submit transactions successful");
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setData(responseError);
			logger.error(prefix,ex);
		}
		return response;
	}

	
	
}
