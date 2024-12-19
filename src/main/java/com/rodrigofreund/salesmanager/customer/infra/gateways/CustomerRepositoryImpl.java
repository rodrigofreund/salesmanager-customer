package com.rodrigofreund.salesmanager.customer.infra.gateways;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.rodrigofreund.salesmanager.customer.application.gateways.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerJpaRepository;
import com.rodrigofreund.salesmanager.domain.Customer;

/**
 * Spring implementation of Gateway CustomerRepository
 * @author Moraes, Rodrigo
 */
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

    @Override
    public List<Customer> list(Integer page, Integer size, String sort) {

        return repository.findAll(PageRequest.of(page, size, Sort.by(sort)))
                .map(mapper::toCustomer)
                .getContent();

    }

}
