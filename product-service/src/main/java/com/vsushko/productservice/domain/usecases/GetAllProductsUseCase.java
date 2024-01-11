package com.vsushko.productservice.domain.usecases;

import com.vsushko.productservice.domain.dao.ProductsRepository;
import com.vsushko.productservice.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetAllProductsUseCase {

    private final ProductsRepository product;

    public Iterable<Product> execute() {
        return product.findAll();
    }
}
