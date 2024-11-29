package com.rodrigofreund.salesmanager.customer.usecase;

import com.rodrigofreund.salesmanager.customer.domain.entity.Customer;
import com.rodrigofreund.salesmanager.customer.gateway.CustomerRepository;

//Implementation of customer creation business process
public class CreateCustomerImpl implements CreateCustomer {

    private final CustomerRepository persistency;

    public CreateCustomerImpl(CustomerRepository persistency) {
        this.persistency = persistency;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return persistency.persistCustomer(customer);
    }

}
