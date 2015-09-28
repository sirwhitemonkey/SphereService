package com.xmdevelopments.services;

import javax.ejb.Local;

import com.xmdevelopments.model.Response;

/**
 *Customer(EJB Service)
 *
 */
@Local
public interface CustomerService {
	
	/**
	 * Get customers 
	 * @param date_last_updated, date last updated
	 * @param page , page
	 * @param limit, limit
	 * @return {Response}
	 */
	public Response getCustomers(String date_last_updated, int page, int limit);
}
