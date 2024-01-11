package com.vsushko.productservice.domain.dao;

import com.vsushko.productservice.domain.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Long> {
}
