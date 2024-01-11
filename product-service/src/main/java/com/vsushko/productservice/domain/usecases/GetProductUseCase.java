package com.vsushko.productservice.domain.usecases;

import com.vsushko.productservice.domain.dao.ProductsRepository;
import com.vsushko.productservice.domain.exception.ProductNotFoundException;
import com.vsushko.productservice.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetProductUseCase {

    private final ProductsRepository productsRepository;

    public Product execute(long productId) {
        return productsRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }
}
