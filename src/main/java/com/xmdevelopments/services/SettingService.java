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
	*/
	public Response getThemes();
	
	/**
	 * Getting the data defaults
	 */
	public Response getDataDefaults();
	
}
