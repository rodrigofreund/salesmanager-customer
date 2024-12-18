package com.rodrigofreund.salesmanager.customer.infra.gateways;

import com.rodrigofreund.salesmanager.customer.application.gateways.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerJpaRepository;
import com.rodrigofreund.salesmanager.domain.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {

    private CustomerJpaRepository repository;
    private CustomerMapper mapper;

    public CustomerRepositoryImpl(CustomerJpaRepository repository, CustomerMapper factory) {
        this.repository = repository;
        this.mapper = factory;
    }

    @Override
    public Customer save(Customer newCustomer) {
        return mapper.toCustomer(
                repository.save(
                        mapper.toCustomerEntity(newCustomer)));
    }

}
