package com.rodrigofreund.salesmanager.customer.infra.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rodrigofreund.salesmanager.customer.application.dto.CreateCustomerDto;
import com.rodrigofreund.salesmanager.customer.application.dto.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.application.usecase.CreateCustomer;
import com.rodrigofreund.salesmanager.customer.application.usecase.RetriveCustomer;
import com.rodrigofreund.salesmanager.customer.infra.gateway.CustomerMapper;

@RestController
@RequestMapping("/customer")
final class CustomerController {

    private final CreateCustomer createCustomer;
    private final RetriveCustomer retriveCustomer;
    private final CustomerMapper customerMapper;

    public CustomerController(
            CreateCustomer createCustomer,
            CustomerMapper customerMapper,
            RetriveCustomer retriveCustomer) {

        this.createCustomer = createCustomer;
        this.customerMapper = customerMapper;
        this.retriveCustomer = retriveCustomer;
    }

    @PostMapping
    public ResponseEntity<CustomerDetail> createCustomer(
            @RequestBody CreateCustomerDto newCustomer,
            UriComponentsBuilder uriBuilder) {

        var customerDetail =
                customerMapper.toCustomerDetail(
                        createCustomer.createCustomer(
                                customerMapper.toCustomer(newCustomer)));

        var uri = uriBuilder.path("/customer/{id}")
                .buildAndExpand(customerDetail.id()).toUri();

        return ResponseEntity.created(uri).body(customerDetail);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDetail>> getCustomerList(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "name") String sort) {
        
        var customerDetailList =
                this.retriveCustomer.listCustomer(page, size, sort)
                .stream().map(customerMapper::toCustomerDetail)
                .toList();

        return ResponseEntity.ok(customerDetailList);
    }

}
