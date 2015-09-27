package com.xmdevelopments.services;

import javax.ejb.Local;

import com.xmdevelopments.model.Response;

/**
 *Setting (EJB Service)
 *
 */
@Local
public interface SettingService {
	
	/**
	 * Getting the themes
	 * @return {Response}
	 * 
	*/
	public Response getThemes();
	
	/**
	 * Getting the data defaults
	 * @return {Response}
	 */
	public Response getDataDefaults();
	
	/**
	 * Checking the connection
	 * @return {Response}
	 */
	public Response checkConnection();
	
}
