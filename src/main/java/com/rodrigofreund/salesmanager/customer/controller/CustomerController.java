package com.rodrigofreund.salesmanager.customer.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerData;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerRegister;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerUpdate;
import com.rodrigofreund.salesmanager.customer.domain.entity.Customer;
import com.rodrigofreund.salesmanager.customer.repository.model.customer.CustomerMapper;
import com.rodrigofreund.salesmanager.customer.usecase.CreateCustomer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("salesmanager-customer")
public final class CustomerController {

    private final CustomerMapper customerFactory;
    private final CreateCustomer createCustomer;

    private CustomerController(
            CreateCustomer createCustomer,
            CustomerMapper customerFactory) {

        this.customerFactory = customerFactory;
        this.createCustomer = createCustomer;
    }

    @PostMapping
    public ResponseEntity<CustomerDetail> register(
            @RequestBody @Valid CustomerRegister customerRegister,
            UriComponentsBuilder uriBuilder) {

        var newCustomer = createCustomer.createCustomer(customerFactory.toCustomer(customerRegister));

        //it lacks to persist

        var uri = createUri(uriBuilder, newCustomer);

        return ResponseEntity.created(uri).body(customerFactory.toCustomerDetail(newCustomer));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerData>> list(Pageable pageable) {

        //var page = customerRepository.findAll(pageable).map(customerFactory::toCustomerData);
        //return ResponseEntity.ok(page);
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetail> detail(@PathVariable Integer id) {
        /*
        return ResponseEntity.ok(
                customerFactory.toCustomerDetail(
                        customerRepository.getReferenceById(id))
                );
                */
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<CustomerDetail> update(
            @Valid @RequestBody CustomerUpdate customerUpdate) {
        
        /*

        var customer = customerRepository.getReferenceById(customerUpdate.id());

        if(customerUpdate.hasName()) {
            customer.setName(customerUpdate.name());
        }
        if(customerUpdate.hasSocialName()) {
            customer.setSocialName(customerUpdate.socialName());
        }
        if(customerUpdate.hasSocialNumber()) {
            customer.setSocialNumber(customerUpdate.socialNumber());
        }

        customerRepository.save(customer);
        
        return ResponseEntity.ok(customerFactory.toCustomerDetail(new Customer()));
        
        */

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> exclude(@PathVariable Integer id) {
        /*
        var customer = customerRepository.getReferenceById(id);
        customerRepository.delete(customer);
        return ResponseEntity.noContent().build();
        */
        return ResponseEntity.noContent().build();
    }
    
    private URI createUri(UriComponentsBuilder uriBuilder, Customer newCustomer) {
        return uriBuilder.path("/salesmanager-customer/{finantialNumber}")
                .buildAndExpand(newCustomer.getFinantialNumber()).toUri();
    }
}
