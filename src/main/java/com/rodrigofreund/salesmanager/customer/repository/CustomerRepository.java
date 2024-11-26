package com.rodrigofreund.salesmanager.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigofreund.salesmanager.customer.repository.model.customer.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
