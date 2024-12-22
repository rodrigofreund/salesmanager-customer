package com.rodrigofreund.salesmanager.customer.infra.gateway;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.rodrigofreund.salesmanager.customer.application.dto.SearchCriteria;
import com.rodrigofreund.salesmanager.customer.entity.gateway.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerJpaRepository;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerSearchRepository;
import com.rodrigofreund.salesmanager.customer.infra.persistency.entity.CustomerEntity;
import com.rodrigofreund.salesmanager.domain.Customer;

/**
 * Spring implementation of Gateway CustomerRepository
 * @author Moraes, Rodrigo
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    private CustomerJpaRepository repository;
    private CustomerSearchRepository searchRepository;
    private CustomerMapper mapper;

    public CustomerRepositoryImpl(
            CustomerJpaRepository repository,
            CustomerSearchRepository searchRepository,
            CustomerMapper factory) {

        this.repository = repository;
        this.searchRepository = searchRepository;
        this.mapper = factory;

    }

    @Override
    public Customer save(Customer newCustomer) {
        return mapper.toCustomer(
                repository.save(
                        mapper.toCustomerEntity(newCustomer)));
    }

    @Override
    public Customer update(Customer customer) {

        var currentCustomer = this.repository.findById(customer.id()).orElseThrow();

        var customerToPersist = CustomerEntity.builder()
                .id(currentCustomer.getId())
                .name(Strings.isBlank(customer.name()) ? currentCustomer.getName() : customer.name())
                .socialName(Strings.isBlank(customer.socialName()) ? currentCustomer.getSocialName() : customer.socialName())
                .socialNumber(Strings.isBlank(customer.socialNumber()) ? currentCustomer.getSocialNumber() : customer.socialNumber())
                .finantialNumber(Strings.isBlank(customer.finantialNumber()) ? currentCustomer.getFinantialNumber() : customer.finantialNumber())
                .build();

        return mapper.toCustomer(repository.save(customerToPersist));

    }

    @Override
    public List<Customer> list(Integer page, Integer size, String sort) {
        return repository.findAll(PageRequest.of(page, size, Sort.by(sort)))
                .map(mapper::toCustomer)
                .getContent();
    }

    @Override
    public List<Customer> search(String search) {
        return searchRepository.findByCriteria(SearchCriteria.from(search))
                .stream().map(mapper::toCustomer)
                .toList();
    }

}
