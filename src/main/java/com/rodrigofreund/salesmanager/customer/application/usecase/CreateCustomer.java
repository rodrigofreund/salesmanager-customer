package com.rodrigofreund.salesmanager.customer.application.usecase;

import com.rodrigofreund.salesmanager.domain.Customer;

public interface CreateCustomer {
    Customer createCustomer(Customer newCustomer);
}
