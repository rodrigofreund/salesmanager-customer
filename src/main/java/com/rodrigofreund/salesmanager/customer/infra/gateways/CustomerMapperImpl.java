package com.rodrigofreund.salesmanager.customer.infra.gateways;

import com.rodrigofreund.salesmanager.customer.domain.CustomerImpl;
import com.rodrigofreund.salesmanager.customer.infra.controller.CreateCustomerDto;
import com.rodrigofreund.salesmanager.customer.infra.controller.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerEntity;
import com.rodrigofreund.salesmanager.domain.Customer;

public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerEntity toCustomerEntity(CreateCustomerDto register) {
        return CustomerEntity.builder()
                .name(register.name())
                .socialName(register.socialName())
                .finantialNumber(register.finantialNumber())
                .socialNumber(register.socialNumber())
                .build();
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
                .name(customer.name())
                .socialName(customer.socialName())
                .finantialNumber(customer.finantialNumber())
                .socialNumber(customer.finantialNumber())
                .build();
    }

    @Override
    public Customer toCustomer(CustomerEntity entity) {
        return CustomerImpl.of(
                entity.getId(),
                entity.getName(),
                entity.getSocialName(),
                entity.getFinantialNumber(),
                entity.getSocialNumber());
    }
    
    @Override
    public CustomerDetail toCustomerDetail(Customer customer) {
        return new CustomerDetail(
                customer.id(),
                customer.name(),
                customer.socialName(),
                customer.finantialNumber(),
                customer.socialNumber());
    }

    @Override
    public Customer toCustomer(CreateCustomerDto entity) {
        return CustomerImpl.of(entity.name(), entity.socialName(), entity.finantialNumber(), entity.socialNumber());
    }
}
