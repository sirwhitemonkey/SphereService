package com.xmdevelopments.services;

import javax.ejb.Local;

import com.xmdevelopments.model.Response;

/**
 *Product(EJB Service)
 *
 */
@Local
public interface ProductService {
	
	/**
	 * Get products that are active and in stocks
	 * @param date_last_updated, date last updated
	 * @param inActive, true if inactive, false otherwise 
	 * @param inStock, true if in stock, false otherwise
	 * @param page , page
	 * @param limit, limit
	 * @return {Response}
	 */
	public Response getProducts(String date_last_updated,boolean inActive, boolean inStock,int page,int limit);
}
