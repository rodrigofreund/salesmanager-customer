package com.rodrigofreund.salesmanager.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rodrigofreund.salesmanager.customer.application.gateways.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.application.usecases.CreateCustomer;
import com.rodrigofreund.salesmanager.customer.application.usecases.CreateCustomerImpl;
import com.rodrigofreund.salesmanager.customer.infra.gateways.CustomerMapperImpl;
import com.rodrigofreund.salesmanager.customer.infra.gateways.CustomerMapper;
import com.rodrigofreund.salesmanager.customer.infra.gateways.CustomerRepositoryImpl;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerJpaRepository;

@Configuration
public class CustomerBeans {

    @Bean
    public CreateCustomer createCustomer(CustomerRepository repository) {
        return new CreateCustomerImpl(repository);
    }

    @Bean
    public CustomerRepository CustomerRepository(CustomerJpaRepository repository, CustomerMapper factory) {
        return new CustomerRepositoryImpl(repository, factory);
    }

    @Bean
    public CustomerMapper createCustomerMapper() {
        return new CustomerMapperImpl();
    }
}
