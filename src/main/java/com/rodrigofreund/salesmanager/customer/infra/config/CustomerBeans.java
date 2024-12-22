package com.rodrigofreund.salesmanager.customer.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rodrigofreund.salesmanager.customer.application.usecase.CreateCustomer;
import com.rodrigofreund.salesmanager.customer.application.usecase.CreateCustomerImpl;
import com.rodrigofreund.salesmanager.customer.application.usecase.RetriveCustomer;
import com.rodrigofreund.salesmanager.customer.application.usecase.RetriveCustomerImpl;
import com.rodrigofreund.salesmanager.customer.application.usecase.UpdateCustomer;
import com.rodrigofreund.salesmanager.customer.application.usecase.UpdateCustomerImpl;
import com.rodrigofreund.salesmanager.customer.entity.gateway.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.infra.gateway.CustomerMapper;
import com.rodrigofreund.salesmanager.customer.infra.gateway.CustomerMapperImpl;
import com.rodrigofreund.salesmanager.customer.infra.gateway.CustomerRepositoryImpl;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerJpaRepository;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerSearchRepository;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerSearchRepositoryImpl;

/**
 * Class responsible for beans creation
 */

@Configuration
public class CustomerBeans {

    @Bean
    public CreateCustomer createCustomer(CustomerRepository repository) {
        return new CreateCustomerImpl(repository);
    }

    @Bean
    public CustomerRepository CustomerRepository(
            CustomerJpaRepository jpaRepository,
            CustomerSearchRepository searchRepository,
            CustomerMapper mapper) {
        return new CustomerRepositoryImpl(jpaRepository, searchRepository, mapper);
    }

    @Bean
    public CustomerMapper createCustomerMapper() {
        return new CustomerMapperImpl();
    }

    @Bean
    public RetriveCustomer createRetriveCustomer(CustomerRepository repository) {
        return new RetriveCustomerImpl(repository);
    }

    @Bean
    public UpdateCustomer createUpdateCustomer(CustomerRepository repository) {
        return new UpdateCustomerImpl(repository);
    }

    @Bean
    public CustomerSearchRepository createCustomerSearchRepository() {
        return new CustomerSearchRepositoryImpl();
    }

}
