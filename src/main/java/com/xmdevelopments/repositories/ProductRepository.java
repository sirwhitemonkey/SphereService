package com.xmdevelopments.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xmdevelopments.model.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	 Page<Product> findByIsNotActiveAndIsInStock(@Param("isInActive") boolean inActive, @Param("isInStock") boolean inStock, Pageable page);
}

