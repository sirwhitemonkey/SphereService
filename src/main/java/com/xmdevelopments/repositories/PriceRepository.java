package com.xmdevelopments.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xmdevelopments.model.entities.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
	  Page<Price> findAll(Pageable pagable);
}