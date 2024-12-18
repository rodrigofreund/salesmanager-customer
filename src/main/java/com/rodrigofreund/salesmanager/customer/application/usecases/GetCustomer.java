package com.rodrigofreund.salesmanager.customer.application.usecases;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.rodrigofreund.salesmanager.customer.infra.controller.CustomerDetail;

public interface GetCustomer {
    List<CustomerDetail> listCustomer(Pageable pageable);
}
