package com.rodrigofreund.salesmanager.customer.test.unit;

import com.rodrigofreund.salesmanager.customer.entity.model.CustomerImpl;
import com.rodrigofreund.salesmanager.domain.Customer;

public interface CustomerTest {

    final String customer1name = "Ana";
    final String customer1socialName = "Ana Afonso";
    final String customer1finantialNumber = "984930283930";
    final String customer1socialNumber = "38472838";

    default Customer createCustomer1() {
        return CustomerImpl.of(
                customer1name,
                customer1socialName,
                customer1finantialNumber,
                customer1socialNumber);
    }
}
