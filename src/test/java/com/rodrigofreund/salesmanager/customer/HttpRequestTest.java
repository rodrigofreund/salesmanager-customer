package com.rodrigofreund.salesmanager.customer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerRegister;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void gettingCustomerDetail() throws Exception {
        var code = this.restTemplate
                .getForEntity(
                        "http://localhost:" + port + "/salesmanager-customer/1",
                        CustomerDetail.class).getStatusCode();
        assertTrue(code.is2xxSuccessful());
    }
    
    @Test
    void postingCustomerRegister() throws Exception {

        CustomerRegister customerRegister =
            new CustomerRegister(
                "Rodrigo",
                "Rodrigo Moraes",
                "4343523",
                "3423423423");

        var code = this.restTemplate.postForEntity(
                        "http://localhost:" + port + "/salesmanager-customer",
                        customerRegister,
                        CustomerDetail.class).getStatusCode();

        assertTrue(code.is2xxSuccessful());
    }
    
    


}
