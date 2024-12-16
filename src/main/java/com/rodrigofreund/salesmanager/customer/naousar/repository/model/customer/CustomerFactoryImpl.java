package com.rodrigofreund.salesmanager.customer.naousar.repository.model.customer;

import org.springframework.stereotype.Component;

import com.rodrigofreund.salesmanager.customer.naousar.controller.dto.CustomerData;
import com.rodrigofreund.salesmanager.customer.naousar.controller.dto.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.naousar.controller.dto.CustomerRegister;

@Component
public class CustomerFactoryImpl implements CustomerFactory {
    @Override
    public CustomerEntity toCustomerEntity(CustomerRegister register) {
        return CustomerEntity.builder()
                .name(register.name())
                .socialName(register.socialName())
                .finantialNumber(register.finantialNumber())
                .socialNumber(register.socialNumber())
                .build();
    }
    @Override
    public CustomerData toCustomerData(CustomerEntity entity) {
        return new CustomerData(
                entity.getId(),
                entity.getName(),
                entity.getSocialName(),
                entity.getFinantialNumber(),
                entity.getSocialNumber());
    }
    @Override
    public CustomerDetail toCustomerDetail(CustomerEntity customer) {
        return new CustomerDetail(
                customer.getId(),
                customer.getName(),
                customer.getSocialName(),
                customer.getFinantialNumber(),
                customer.getSocialNumber());
    }
}
