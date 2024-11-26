package com.rodrigofreund.salesmanager.customer.repository.model.customer;

import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerData;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerRegister;

public interface CustomerFactory {

    CustomerEntity toCustomerEntity(CustomerRegister register);

    CustomerData toCustomerData(CustomerEntity entity);

    CustomerDetail toCustomerDetail(CustomerEntity customer);

}
