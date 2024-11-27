package com.rodrigofreund.salesmanager.customer.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void doNotCreateCustomerWithNoName() {

        Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Customer("", "Rodrigo Freund", "213.654.434-32"));

    }

    @Test
    public void doNotCreateCustomerWithNullName() {

        Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Customer(null, "Rodrigo Freund", "213.654.434-32"));

    }

    @Test
    public void doNotCreateCustomerWithNullSocialName() {

        Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Customer("Rodrigo", null, "213.654.434-32"));

    }
    
    @Test
    public void doNotCreateCustomerWithInvalidFinantialNumber() {

        Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Customer("Rodrigo", "Rodrigo Freund", "213.654.43432"));

    }

    @Test
    public void doNotCreateCustomerWithEmptyFinantialNumber() {

        Assertions.assertThrows(IllegalArgumentException.class, 
                () -> new Customer("Rodrigo", "Rodrigo Freund", ""));

    }
}
