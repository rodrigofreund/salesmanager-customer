package com.rodrigofreund.salesmanager.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigofreund.salesmanager.customer.repository.model.order.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

}
