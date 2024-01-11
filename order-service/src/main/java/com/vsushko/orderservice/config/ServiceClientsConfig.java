package com.vsushko.orderservice.config;

import com.vsushko.orderservice.domain.port.CustomersRemoteService;
import com.vsushko.orderservice.domain.port.ProductsRemoteService;
import com.vsushko.orderservice.network.CustomersRemoteServiceApiClient;
import com.vsushko.orderservice.network.ProductsRemoteServiceApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.util.concurrent.Executors;

/**
 * @author vsushko
 */
@Slf4j
@Configuration
public class ServiceClientsConfig {
    @Value("${spring.threads.virtual.enabled}")
    private boolean isVirtualThreadEnabled;

    @Bean
    public CustomersRemoteService customersRemoteService(@Value("${order-service.customerServiceUrl}") String baseUrl) {
        return new CustomersRemoteServiceApiClient(buildRestClient(baseUrl));
    }

    @Bean
    public ProductsRemoteService productsRemoteService(@Value("${order-service.productServiceUrl}") String baseUrl) {
        return new ProductsRemoteServiceApiClient(buildRestClient(baseUrl));
    }

    private RestClient buildRestClient(String baseUrl) {
        log.info("Base url: {}", baseUrl);

        var builder = RestClient.builder().baseUrl(baseUrl);

        if (isVirtualThreadEnabled) {
            builder = builder.requestFactory(new JdkClientHttpRequestFactory(
                    HttpClient.newBuilder()
                            .executor(Executors.newVirtualThreadPerTaskExecutor())
                            .build()
            ));
            log.info("RestClient was initialized using ExecutorService which starts new virtual Thread for each task.");
        }
        return builder.build();
    }
}
