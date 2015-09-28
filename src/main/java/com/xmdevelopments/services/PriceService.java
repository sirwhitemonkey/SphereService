package com.xmdevelopments.services;

import javax.ejb.Local;

import com.xmdevelopments.model.Response;

/**
 *Price(EJB Service)
 *
 */
@Local
public interface PriceService {
	
	/**
	 * Get prices 
	 * @param date_last_updated, date last updated
	 * @param page , page
	 * @param limit, limit
	 * @return {Response}
	 */
	public Response getPrices(String date_last_updated, int page, int limit);
}
