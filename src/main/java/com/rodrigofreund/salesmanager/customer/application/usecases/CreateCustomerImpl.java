package com.rodrigofreund.salesmanager.customer.application.usecases;

import com.rodrigofreund.salesmanager.customer.application.gateways.CustomerRepository;
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
