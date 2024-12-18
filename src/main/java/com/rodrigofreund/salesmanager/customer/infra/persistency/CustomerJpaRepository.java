package com.rodrigofreund.salesmanager.customer.infra.persistency;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Integer> {

}
