package com.rodrigofreund.salesmanager.customer.application.usecases;

import java.util.List;

import com.rodrigofreund.salesmanager.customer.application.gateways.CustomerRepository;
import com.rodrigofreund.salesmanager.domain.Customer;

public class RetriveCustomerImpl implements RetriveCustomer {

    private CustomerRepository repository;

    public RetriveCustomerImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> listCustomer(Integer page, Integer size, String sort) {
        return repository.list(page, size, sort);
    }

}
