package com.rodrigofreund.salesmanager.customer.controller;

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

import com.rodrigofreund.salesmanager.customer.controller.dto.OrderData;
import com.rodrigofreund.salesmanager.customer.controller.dto.OrderDetail;
import com.rodrigofreund.salesmanager.customer.controller.dto.OrderUpdate;
import com.rodrigofreund.salesmanager.customer.repository.CustomerRepository;
import com.rodrigofreund.salesmanager.customer.repository.OrderRepository;
import com.rodrigofreund.salesmanager.customer.repository.model.order.OrderFactory;
import com.rodrigofreund.salesmanager.customer.repository.model.order.OrderRegister;

import jakarta.validation.Valid;

@RestController
@RequestMapping("salesmanager-order")
public class OrderController {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private OrderFactory orderFactory;

    public OrderController(
            OrderRepository orderRepository,
            OrderFactory orderFactory,
            CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.orderFactory = orderFactory;
        this.customerRepository = customerRepository;
    }
    
    @GetMapping
    public ResponseEntity<Page<OrderData>> list(Pageable pageable) {
        var page = orderRepository.findAll(pageable).map(orderFactory::toOrderData);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> detail(@PathVariable Integer id) {
        return ResponseEntity.ok(
                orderFactory.toOrderDetail(
                        orderRepository.getReferenceById(id))
                );
    }

    @PostMapping
    public ResponseEntity<OrderDetail> register(
            @RequestBody @Valid OrderRegister orderRegister,
            UriComponentsBuilder uriBuilder) {

        var customer = customerRepository.findById(orderRegister.idCustomer()).orElseThrow();
        var order = orderRepository.save(orderFactory.toOrderEntity(orderRegister, customer));

        var uri = uriBuilder.path("salesmanager-order/{id}")
                .buildAndExpand(order.getId()).toUri();

        return ResponseEntity.created(uri).body(orderFactory.toOrderDetail(order));
    }

    @PutMapping
    public ResponseEntity<OrderDetail> update(@Valid @RequestBody OrderUpdate orderUpdate) {

        var order = orderRepository.getReferenceById(orderUpdate.id());
        if(orderUpdate.hasDate()) {
            order.setDate(orderUpdate.date());
        }
        orderRepository.save(order);
        return ResponseEntity.ok(orderFactory.toOrderDetail(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> exclude(@PathVariable Integer id) {
        var order = orderRepository.getReferenceById(id);
        orderRepository.delete(order);
        return ResponseEntity.noContent().build();
    }
}
