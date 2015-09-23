package com.xmdevelopments.services;

import javax.ejb.Local;

import com.xmdevelopments.model.Response;

/**
 *PriceList(EJB Service)
 *
 */
@Local
public interface PriceListService {
	
	/**
	 * Get price lists 
	 * @param page , page
	 * @param limit, limit
	 * @return {Response}
	 */
	public Response getPriceLists(int page,int limit);
	
	/**
	 * Get the price lists using price list code
	 * @param priceListCode
	 * @param page
	 * @param limit
	 * @return
	 */
	public Response getPriceLists(String priceListCode,int page,int limit);
}
