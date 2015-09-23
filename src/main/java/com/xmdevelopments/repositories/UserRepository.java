package com.xmdevelopments.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xmdevelopments.model.entities.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	 Page<User> findByIsDeleted(@Param("isDeleted") boolean deleted, Pageable page);
	 User findOneByUsernameAndIsDeletedAndGroupId(@Param("username") String username, @Param("isDeleted") boolean deleted, @Param("groupId") int groupId);
}
