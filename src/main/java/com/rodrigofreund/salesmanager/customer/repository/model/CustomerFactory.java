package com.rodrigofreund.salesmanager.customer.repository.model;

import org.springframework.stereotype.Component;

import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerData;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerRegister;

@Component
public class CustomerFactory {
    public CustomerEntity toCustomerEntity(CustomerRegister register) {
        return CustomerEntity.builder()
                .name(register.name())
                .socialName(register.socialName())
                .finantialNumber(register.finantialNumber())
                .socialNumber(register.socialNumber())
                .build();
    }
    public CustomerData toCustomerData(CustomerEntity entity) {
        return new CustomerData(
                entity.getName(),
                entity.getSocialName(),
                entity.getFinantialNumber(),
                entity.getSocialNumber());
    }
}
