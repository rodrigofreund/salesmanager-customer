package com.rodrigofreund.salesmanager.customer.naousar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigofreund.salesmanager.customer.naousar.repository.model.order.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

}
