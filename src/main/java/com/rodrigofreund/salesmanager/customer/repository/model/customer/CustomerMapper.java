package com.rodrigofreund.salesmanager.customer.repository.model.customer;

import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerData;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerRegister;
import com.rodrigofreund.salesmanager.customer.domain.entity.Customer;
import com.rodrigofreund.salesmanager.customer.infra.CustomerEntity;

public interface CustomerMapper {

    CustomerEntity toCustomerEntity(CustomerRegister register);
    CustomerEntity toCustomerEntity(Customer customer);
    CustomerData toCustomerData(CustomerEntity entity);
    CustomerDetail toCustomerDetail(CustomerEntity customer);


}
