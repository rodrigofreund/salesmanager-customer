package com.rodrigofreund.salesmanager.customer.application.usecase;

import com.rodrigofreund.salesmanager.customer.entity.gateway.CustomerRepository;
import com.rodrigofreund.salesmanager.domain.Customer;

public final class CreateCustomerImpl implements CreateCustomer {

    private final CustomerRepository repository;

    public CreateCustomerImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer createCustomer(Customer newCustomer) {
        return repository.save(newCustomer);
    }

}
