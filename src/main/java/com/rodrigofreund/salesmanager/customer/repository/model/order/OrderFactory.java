package com.rodrigofreund.salesmanager.customer.repository.model.order;

import com.rodrigofreund.salesmanager.customer.controller.dto.OrderData;
import com.rodrigofreund.salesmanager.customer.controller.dto.OrderDetail;
import com.rodrigofreund.salesmanager.customer.repository.model.customer.CustomerEntity;

public interface OrderFactory {
    public OrderEntity toOrderEntity(OrderRegister orderRegister, CustomerEntity customer);

    public OrderDetail toOrderDetail(OrderEntity order);

    public OrderData toOrderData(OrderEntity order);
}
