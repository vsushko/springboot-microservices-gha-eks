package com.vsushko.orderservice.domain.repository;

import com.vsushko.orderservice.domain.model.StoreOrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreOrderLineRepository extends CrudRepository<StoreOrderLine, Long> {
}
