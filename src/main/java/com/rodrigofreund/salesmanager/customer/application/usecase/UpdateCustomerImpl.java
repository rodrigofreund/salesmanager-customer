package com.rodrigofreund.salesmanager.customer.application.usecase;

import com.rodrigofreund.salesmanager.customer.entity.gateway.CustomerRepository;
import com.rodrigofreund.salesmanager.domain.Customer;

public class UpdateCustomerImpl implements UpdateCustomer {

    private final CustomerRepository repository;

    public UpdateCustomerImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer update(Customer customer) {
        return repository.update(customer);
    }

}
