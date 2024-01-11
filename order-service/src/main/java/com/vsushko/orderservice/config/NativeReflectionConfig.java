package com.vsushko.orderservice.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.vsushko.orderservice.domain.dto.Customer;
import com.vsushko.orderservice.domain.dto.Order;
import com.vsushko.orderservice.domain.dto.OrderLine;
import com.vsushko.orderservice.domain.dto.Product;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;

/**
 * @author vsushko
 */
@Configuration
@RegisterReflectionForBinding({
        Customer.class, Order.class, OrderLine.class, Product.class,
        PropertyNamingStrategies.SnakeCaseStrategy.class,
        PropertyNamingStrategies.LowerCamelCaseStrategy.class
})
public class NativeReflectionConfig {

}