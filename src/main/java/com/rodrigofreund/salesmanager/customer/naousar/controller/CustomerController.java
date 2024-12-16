package com.rodrigofreund.salesmanager.customer.naousar.controller;

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

import com.rodrigofreund.salesmanager.customer.naousar.controller.dto.CustomerData;
import com.rodrigofreund.salesmanager.customer.naousar.controller.dto.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.naousar.controller.dto.CustomerRegister;
import com.rodrigofreund.salesmanager.customer.naousar.controller.dto.CustomerUpdate;
import com.rodrigofreund.salesmanager.customer.naousar.repository.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.naousar.repository.model.customer.CustomerFactory;

import jakarta.validation.Valid;

@RestController
@RequestMapping("salesmanager-customer")
public class CustomerController {

    private CustomerRepository customerRepository;
    private CustomerFactory customerFactory;

    private CustomerController(
            CustomerFactory customerFactory,
            CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
        this.customerFactory = customerFactory;

    }

    @GetMapping
    public ResponseEntity<Page<CustomerData>> list(Pageable pageable) {
        var page = customerRepository.findAll(pageable).map(customerFactory::toCustomerData);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetail> detail(@PathVariable Integer id) {
        return ResponseEntity.ok(
                customerFactory.toCustomerDetail(
                        customerRepository.getReferenceById(id))
                );
    }

    @GetMapping("/check/{id}")
    public ResponseEntity<CustomerDetail> check(@PathVariable Integer id) {
        
        var customer = customerRepository.findById(id);
        
        if(customer.isPresent()) {
            customer.get().setName("new name");
        }
        
        return ResponseEntity.ok(
                customerFactory.toCustomerDetail(
                        customerRepository.getReferenceById(id))
                );
    }

    @PostMapping
    public ResponseEntity<CustomerDetail> register(
            @RequestBody @Valid CustomerRegister customerRegister,
            UriComponentsBuilder uriBuilder) {

        var medico = customerRepository.save(customerFactory.toCustomerEntity(customerRegister));

        var uri = uriBuilder.path("/salesmanager-customer/{id}")
                .buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(customerFactory.toCustomerDetail(medico));
    }

    @PutMapping
    public ResponseEntity<CustomerDetail> update(
            @Valid @RequestBody CustomerUpdate customerUpdate) {

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

        var newCustomer = customerRepository.save(customer);

        return ResponseEntity.ok(customerFactory.toCustomerDetail(newCustomer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> exclude(@PathVariable Integer id) {
        var customer = customerRepository.getReferenceById(id);
        customerRepository.delete(customer);
        return ResponseEntity.noContent().build();
    }
}
