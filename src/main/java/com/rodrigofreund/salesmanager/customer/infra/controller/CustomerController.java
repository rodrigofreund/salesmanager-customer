package com.rodrigofreund.salesmanager.customer.infra.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofreund.salesmanager.customer.application.usecases.CreateCustomer;
import com.rodrigofreund.salesmanager.customer.infra.gateways.CustomerMapper;

@RestController
@RequestMapping("/customer")
final class CustomerController {

    private final CreateCustomer createCustomer;
    private final CustomerMapper customerMapper;

    public CustomerController(CreateCustomer createCustomer, CustomerMapper customerMapper) {
        this.createCustomer = createCustomer;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<CustomerDetail> createCustomer(@RequestBody CreateCustomerDto newCustomer) {

        var customerDetail =
                customerMapper.toCustomerDetail(
                        createCustomer.createCustomer(
                                customerMapper.toCustomer(newCustomer)));

        return ResponseEntity.ok(customerDetail);
    }
    
    @GetMapping
    public ResponseEntity<Page<CustomerDetail>> getCustomerList(
            @PageableDefault(size = 10, sort = {"name"}) Pageable paginacao) {
        
        return null;
        
    }

}
