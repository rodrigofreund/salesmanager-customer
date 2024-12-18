package com.rodrigofreund.salesmanager.customer.infra.gateways;

import com.rodrigofreund.salesmanager.customer.infra.controller.CreateCustomerDto;
import com.rodrigofreund.salesmanager.customer.infra.controller.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerEntity;
import com.rodrigofreund.salesmanager.domain.Customer;

public interface CustomerMapper {

    CustomerEntity toCustomerEntity(CreateCustomerDto register);

    CustomerDetail toCustomerDetail(CustomerEntity customer);

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity entity);

    Customer toCustomer(CreateCustomerDto entity);

    CustomerDetail toCustomerDetail(Customer customer);


}
