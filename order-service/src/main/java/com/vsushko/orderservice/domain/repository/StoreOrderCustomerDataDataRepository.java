package com.vsushko.orderservice.domain.repository;

import com.vsushko.orderservice.domain.model.StoreOrderCustomerData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreOrderCustomerDataDataRepository extends CrudRepository<StoreOrderCustomerData, Long> {
}
