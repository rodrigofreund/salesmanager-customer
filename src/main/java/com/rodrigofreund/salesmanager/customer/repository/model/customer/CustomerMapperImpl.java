package com.rodrigofreund.salesmanager.customer.repository.model.customer;

import org.springframework.stereotype.Component;

import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerData;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerRegister;
import com.rodrigofreund.salesmanager.customer.domain.entity.Customer;
import com.rodrigofreund.salesmanager.customer.infra.CustomerEntity;

@Component
public class CustomerMapperImpl implements CustomerMapper {
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
    @Override
    public CustomerEntity toCustomerEntity(Customer customer) {
        return CustomerEntity.builder()
                .name(customer.getName())
                .finantialNumber(customer.getFinantialNumber())
                .socialName(customer.getSocialName())
                .finantialNumber(customer.getFinantialNumber())
                .build();
    }

    @Override
    public Customer toCustomer(CustomerEntity customer) {
        return new Customer(customer.getName(), customer.getSocialName(), customer.getFinantialNumber());
    }
    @Override
    public Customer toCustomer(CustomerRegister customer) {
        return new Customer(customer.name(), customer.socialName(), customer.finantialNumber());
    }
}
