package com.rodrigofreund.salesmanager.customer.infra.persistency;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigofreund.salesmanager.customer.infra.persistency.entity.CustomerEntity;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Integer> {

}
