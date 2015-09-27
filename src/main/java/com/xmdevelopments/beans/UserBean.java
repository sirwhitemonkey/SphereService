package com.xmdevelopments.beans;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.http.HttpStatus;

import com.xmdevelopments.model.Response;
import com.xmdevelopments.model.ResponseError;
import com.xmdevelopments.model.entities.User;
import com.xmdevelopments.pages.Pages;
import com.xmdevelopments.repositories.UserRepository;
import com.xmdevelopments.services.UserService;

/**
 * User (EJB Bean)
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class UserBean implements UserService {

	final static Logger logger = Logger.getLogger(UserBean.class);

	@Autowired
	UserRepository userRepository;

	
	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.UserService#getUser(java.lang.String, boolean, int)
	 */
	@Override
	public Response getUser(String username, boolean deleted, int group) {
		String prefix = "getUser()";
		logger.info( prefix +"->[params]:" + username + "," + deleted + "," + group);

		User user = null;
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			user = userRepository.findOneByUsernameAndIsDeletedAndGroupId(username, deleted, group);
			if (user != null) {
				response.setResponseCode(HttpStatus.OK.value());
			} else {
				response.setResponseCode(HttpStatus.NOT_FOUND.value());
			}
			response.setData(user);
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setData(responseError);
			logger.error(prefix , ex);
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * @see com.xmdevelopments.services.UserService#getUsers(boolean, int, int)
	 */
	@Override
	public Response getUsers(boolean deleted, int page, int limit) {
		String prefix = "getUsers()";
		logger.info(prefix +"->[params]:" + deleted + "," + page + "," + limit);

		
		Response response = new Response();
		ResponseError responseError = new ResponseError();
		try {
			Page<User> users = userRepository.findByIsDeleted(deleted, new PageRequest(page, limit));
			if (users.getTotalElements() > 0) {
				response.setResponseCode(HttpStatus.OK.value());
			} else {
				response.setResponseCode(HttpStatus.NOT_FOUND.value());
			}
			response.setData(new Pages(users));
		} catch (Exception ex) {
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseError.setMessage(ex.getMessage());
			responseError.setErrorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			response.setData(responseError);
			logger.error(prefix , ex);
		}
		return response;
	}
}
