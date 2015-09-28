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
	 * @param date_last_updated, date last updated
	 * @param page , page
	 * @param limit, limit
	 * @return {Response}
	 */
	public Response getPriceLists(String date_last_updated,int page,int limit);
	
	/**
	 * Get the price lists using price list code
	 * @param date_last_updated, date last updated
	 * @param priceListCode
	 * @param page
	 * @param limit
	 * @return
	 */
	public Response getPriceLists(String date_last_updated, String code,int page,int limit);
}
