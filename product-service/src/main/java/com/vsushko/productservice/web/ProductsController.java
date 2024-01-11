package com.vsushko.productservice.web;

import com.vsushko.productservice.domain.model.Product;
import com.vsushko.productservice.domain.usecases.GetAllProductsUseCase;
import com.vsushko.productservice.domain.usecases.GetProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/api/v1/products")
public class ProductsController {

    @Autowired
    private GetProductUseCase getProductUseCase;

    @Autowired
    private GetAllProductsUseCase getAllProductsUseCase;

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") long productId) {
        return getProductUseCase.execute(productId);
    }

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return getAllProductsUseCase.execute();
    }
}
