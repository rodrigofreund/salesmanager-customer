package com.rodrigofreund.salesmanager.customer.test.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.rodrigofreund.salesmanager.customer.entity.model.CustomerImpl;

public class CustomerTestImpl implements CustomerTest {

    @Test
    void whenCreatingCustomer_thenSuccess() {

        var customer = createCustomer1();

        assertEquals(customer1name, customer.name());
        assertEquals(customer1socialName, customer.socialName());
        assertEquals(customer1finantialNumber, customer.finantialNumber());
        assertEquals(customer1socialNumber, customer.socialNumber());
    }

    @Test
    void whenCreatingCustomerWithoutFinantialNumber_thenFail() {
        assertThrows(IllegalArgumentException.class,
                () -> CustomerImpl.of(customer1name, customer1socialName, null, customer1socialNumber));
    }

    @Test
    void whenCreatingCustomerWithInvalidFinantialNumber_thenFail() {
        assertThrows(IllegalArgumentException.class,
                () -> CustomerImpl.of(customer1name, customer1socialName, "44334", customer1socialNumber));
    }

    @Test
    void whenCreatingCustomerWithBlankFinantialNumber_thenFail() {
        assertThrows(IllegalArgumentException.class,
                () -> CustomerImpl.of(customer1name, customer1socialName, "    ", customer1socialNumber));
    }

    @Test
    void whenCopyingCustomer_thenSuccess() {

        var customer = createCustomer1();

        var newCustomer = CustomerImpl.of(customer);

        assertThat(customer != newCustomer);
        assertNull(newCustomer.id());
        assertEquals(customer.name(), newCustomer.name());
        assertEquals(customer.socialName(), newCustomer.socialName());
        assertEquals(customer.finantialNumber(), newCustomer.finantialNumber());
        assertEquals(customer.socialNumber(), newCustomer.socialNumber());

    }
    
}
