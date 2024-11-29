package com.rodrigofreund.salesmanager.customer.infra;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.rodrigofreund.salesmanager.customer.domain.entity.Customer;
import com.rodrigofreund.salesmanager.customer.gateway.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.repository.model.customer.CustomerMapper;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private CustomerRepositoryJpa repository;
    private CustomerMapper mappper;

    public CustomerRepositoryImpl(
            CustomerRepositoryJpa repository,
            CustomerMapper mapper) {
        this.repository = repository;
        this.mappper = mapper;
    }

    @Override
    public Customer persistCustomer(Customer customer) {
        //Convert from Customer to CustomerEntity
        return mappper.toCustomer(repository.save(mappper.toCustomerEntity(customer)));
    }

    @Override
    public Collection<Customer> listCustomer() {
        //return repository.findAll().stream().map(CustomerMapper::);
        return null;
    }

}
