package com.xmdevelopments.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xmdevelopments.model.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Page<Customer> findAll(Pageable pagable);
}