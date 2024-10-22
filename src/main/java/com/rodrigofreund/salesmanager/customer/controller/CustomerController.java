package com.rodrigofreund.salesmanager.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerData;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerRegister;
import com.rodrigofreund.salesmanager.customer.repository.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.repository.model.CustomerFactory;

import jakarta.validation.Valid;

@RestController
@RequestMapping("salesmanager-customer")
public class CustomerController {

    private CustomerRepository customerRepository;
    private CustomerFactory customerFactory;

    @Autowired
    private CustomerController(
            CustomerFactory customerFactory,
            CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.customerFactory = customerFactory;
    }

    @GetMapping
    public Page<CustomerData> getCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable).map(customerFactory::toCustomerData);
    }

    @PostMapping
    public void register(@RequestBody @Valid CustomerRegister customerRegister) {
        customerRepository.save(customerFactory.toCustomerEntity(customerRegister));
    }
}
