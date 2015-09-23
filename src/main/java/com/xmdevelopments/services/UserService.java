package com.xmdevelopments.services;

import javax.ejb.Local;

import com.xmdevelopments.model.Response;

/**
 * UserService (EJB Service)
 *
 */
@Local
public interface UserService {
	/**
	 * Get user deleted/undeleted in a particular groups
	 * @param username, username
	 * @param deleted, true if deleted , false otherwise
	 * @param group, group
	 * @return {Response}
	 */
	public Response getUser(String username, boolean deleted, int group);
	
	/**
	 * Get users deleted/undeleted
	 * @param deleted, true if deleted, false otherwise
	 * @param page, page
	 * @param limit, limit
	 * @return {Response}
	 */
	public Response getUsers(boolean deleted,int page, int limit);
}
