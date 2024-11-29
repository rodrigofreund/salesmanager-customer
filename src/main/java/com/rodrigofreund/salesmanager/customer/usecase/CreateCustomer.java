package com.rodrigofreund.salesmanager.customer.usecase;

import com.rodrigofreund.salesmanager.customer.domain.entity.Customer;

//Definition of Customer Creation business rules
public interface CreateCustomer {
    public Customer createCustomer(Customer customer);
}
