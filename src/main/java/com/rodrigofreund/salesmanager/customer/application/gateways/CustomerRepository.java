package com.rodrigofreund.salesmanager.customer.application.gateways;

import com.rodrigofreund.salesmanager.domain.Customer;

public interface CustomerRepository {

    Customer save(Customer newCustomer);

}
