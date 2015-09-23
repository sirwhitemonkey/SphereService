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
	 * @param page , page
	 * @param limit, limit
	 * @return {Response}
	 */
	public Response getCustomers(int page,int limit);
}
