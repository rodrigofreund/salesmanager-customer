package com.rodrigofreund.salesmanager.customer.infra;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoryJpa extends JpaRepository<CustomerEntity, Integer> {


}
