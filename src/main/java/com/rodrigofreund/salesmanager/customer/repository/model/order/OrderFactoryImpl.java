package com.rodrigofreund.salesmanager.customer.repository.model.order;

import org.springframework.stereotype.Component;

import com.rodrigofreund.salesmanager.customer.controller.dto.OrderData;
import com.rodrigofreund.salesmanager.customer.controller.dto.OrderDetail;
import com.rodrigofreund.salesmanager.customer.infra.CustomerEntity;

@Component
public class OrderFactoryImpl implements OrderFactory {

    @Override
    public OrderEntity toOrderEntity(OrderRegister orderRegister, CustomerEntity customer) {
        return OrderEntity.builder()
                .date(orderRegister.date())
                .customer(customer)
                .build();
    }

    @Override
    public OrderDetail toOrderDetail(OrderEntity order) {
        return new OrderDetail(order.getId(), order.getDate(), order.getCustomer().getName());
    }

    @Override
    public OrderData toOrderData(OrderEntity order) {
        return new OrderData(order.getId(), order.getDate(), order.getCustomer().getName());
    }

}
