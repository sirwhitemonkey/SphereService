package com.xmdevelopments.services;

import javax.ejb.Local;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.Transaction;

/**
 *ManagementTransaction(EJB Service)
 *
 */
@Local
public interface ManagementTransactionsService {
	
	/**
	 * Submit transactions
	*/
	public Response submit(Transaction transaction);

}
