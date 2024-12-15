package com.rodrigofreund.salesmanager.customer.infra;

import java.util.Collection;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.rodrigofreund.salesmanager.customer.domain.entity.Customer;
import com.rodrigofreund.salesmanager.customer.gateway.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.repository.model.customer.CustomerMapper;

public final class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerRepositoryJpa repository;
    private final CustomerMapper mappper;

    public CustomerRepositoryImpl(
            CustomerRepositoryJpa repository,
            CustomerMapper mapper) {
        this.repository = repository;
        this.mappper = mapper;
    }

    @Override
    public Customer persistCustomer(Customer customer) {
        return mappper.toCustomer(repository.save(mappper.toCustomerEntity(customer)));
    }

    @Override
    public Collection<Customer> listCustomer(Pageable pageable) {
        return repository.findAll(pageable).stream().map(mappper::toCustomer).toList();
    }

}
