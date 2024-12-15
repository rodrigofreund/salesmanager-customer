package com.rodrigofreund.salesmanager.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rodrigofreund.salesmanager.customer.gateway.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.usecase.CreateCustomer;
import com.rodrigofreund.salesmanager.customer.usecase.CreateCustomerImpl;

@Configuration
public class UserConfig {

    @Bean
    public CreateCustomer createCustomer(CustomerRepository repository) {
        return new CreateCustomerImpl(repository);
    }
}
