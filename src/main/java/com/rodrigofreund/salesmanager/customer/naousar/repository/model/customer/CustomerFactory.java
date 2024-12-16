package com.rodrigofreund.salesmanager.customer.naousar.repository.model.customer;

import com.rodrigofreund.salesmanager.customer.naousar.controller.dto.CustomerData;
import com.rodrigofreund.salesmanager.customer.naousar.controller.dto.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.naousar.controller.dto.CustomerRegister;

public interface CustomerFactory {

    CustomerEntity toCustomerEntity(CustomerRegister register);

    CustomerData toCustomerData(CustomerEntity entity);

    CustomerDetail toCustomerDetail(CustomerEntity customer);

}
