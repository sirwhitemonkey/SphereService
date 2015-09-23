package com.xmdevelopments.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xmdevelopments.model.entities.PriceList;

@Repository
public interface PriceListRepository extends CrudRepository<PriceList, Long> {
    Page<PriceList> findAll(Pageable pagable);
    Page<PriceList> findByPriceListCode(String priceListCode,Pageable pageable);
}