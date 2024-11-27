package com.rodrigofreund.salesmanager.customer.gateway;

import java.util.Collection;

import com.rodrigofreund.salesmanager.customer.domain.entity.Customer;

public interface CustomerRepository {
    Customer persistCustomer(Customer customer);
    Collection<Customer> listCustomer();
}
