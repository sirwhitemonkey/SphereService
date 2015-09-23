package com.xmdevelopments.services;

import javax.ejb.Local;

import com.xmdevelopments.model.Response;

/**
 *Authentication(EJB Service)
 *
 */
@Local
public interface AuthService {
	
	/**
	 * Submit credentials
	*/
	public Response submit();
	
	/**
	 * Logout credentials
	 */
	public Response logout();
	
	/**
	 * Forgot password
	 */
	public Response forgotPassword(String userId,String userEmail);
	
}
