package com.rodrigofreund.salesmanager.customer.naousar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigofreund.salesmanager.customer.naousar.repository.model.customer.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
