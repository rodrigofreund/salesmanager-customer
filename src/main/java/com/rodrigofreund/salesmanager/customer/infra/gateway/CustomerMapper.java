package com.rodrigofreund.salesmanager.customer.infra.gateway;

import com.rodrigofreund.salesmanager.customer.application.dto.CreateCustomerDto;
import com.rodrigofreund.salesmanager.customer.application.dto.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.infra.persistency.entity.CustomerEntity;
import com.rodrigofreund.salesmanager.domain.Customer;

public interface CustomerMapper {

    CustomerEntity toCustomerEntity(CreateCustomerDto register);

    CustomerDetail toCustomerDetail(CustomerEntity customer);

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity entity);

    Customer toCustomer(CreateCustomerDto entity);

    CustomerDetail toCustomerDetail(Customer customer);


}
