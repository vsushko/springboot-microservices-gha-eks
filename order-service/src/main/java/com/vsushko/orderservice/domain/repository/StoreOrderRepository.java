package com.vsushko.orderservice.domain.repository;

import com.vsushko.orderservice.domain.model.StoreOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreOrderRepository extends CrudRepository<StoreOrder, Long> {
}
