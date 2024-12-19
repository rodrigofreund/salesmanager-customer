package com.rodrigofreund.salesmanager.customer.application.usecases;

import java.util.List;

import com.rodrigofreund.salesmanager.domain.Customer;

public interface RetriveCustomer {

    List<Customer> listCustomer(Integer page, Integer size, String sort);

}
