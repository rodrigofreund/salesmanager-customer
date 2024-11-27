package com.rodrigofreund.salesmanager.customer.infra;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.rodrigofreund.salesmanager.customer.domain.entity.Customer;
import com.rodrigofreund.salesmanager.customer.gateway.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.repository.model.customer.CustomerMapper;

@Repository
public class CustomerRepositorySpring implements CustomerRepository {

    private CustomerRepositoryJpa repository;
    private CustomerMapper mappper;

    public CustomerRepositorySpring(CustomerRepositoryJpa repository) {
        this.repository = repository;
    }

    @Override
    public Customer persistCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Collection<Customer> listCustomer() {
        return repository.findAll().stream().map(CustomerMapper::);
    }

}
