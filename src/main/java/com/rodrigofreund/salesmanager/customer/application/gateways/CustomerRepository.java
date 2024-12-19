package com.rodrigofreund.salesmanager.customer.application.gateways;

import java.util.List;

import com.rodrigofreund.salesmanager.domain.Customer;

/**
 * Gateway responsible for application persistence
 */
public interface CustomerRepository {

    Customer save(Customer newCustomer);

    List<Customer> list(Integer page, Integer size, String sort);

}
