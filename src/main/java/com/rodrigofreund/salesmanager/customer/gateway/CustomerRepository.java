package com.rodrigofreund.salesmanager.customer.gateway;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import com.rodrigofreund.salesmanager.customer.domain.entity.Customer;

/**Definition of customer persistence functionality
 * to be implemented by a determined library
 * 
 */
public interface CustomerRepository {
    Customer persistCustomer(Customer customer);
    Collection<Customer> listCustomer(Pageable pageable);
}
