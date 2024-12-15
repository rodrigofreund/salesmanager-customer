package com.rodrigofreund.salesmanager.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;

import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerData;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerDetail;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerRegister;
import com.rodrigofreund.salesmanager.customer.controller.dto.CustomerUpdate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    void getCustomerList() {
        var code = this.restTemplate.getForEntity("/salesmanager-customer", CustomerData.class).getStatusCode();
        assertTrue(code.is2xxSuccessful());
    }

    @Test
    void getCustomerDetail() throws Exception {
        var code = this.restTemplate
                .getForEntity(
                        "/salesmanager-customer/1",
                        CustomerDetail.class).getStatusCode();
        assertTrue(code.is2xxSuccessful());
    }
    
    @Test
    void postCustomerRegister() throws Exception {

        CustomerRegister customerRegister =
            new CustomerRegister(
                "Rodrigo",
                "Rodrigo Moraes",
                "4343523",
                "3423423423");

        var code = this.restTemplate.postForEntity(
                        "/salesmanager-customer",
                        customerRegister,
                        CustomerDetail.class).getStatusCode();

        assertTrue(code.is2xxSuccessful());
    }
    
    @Test
    void putCustomerUpdate() throws URISyntaxException {

        CustomerUpdate upd = new CustomerUpdate(1, null, "Frederico Gonçalves", null);

        RequestEntity<CustomerUpdate> requestEntity =
                RequestEntity.put(new URI("/salesmanager-customer")).accept(MediaType.APPLICATION_JSON).body(upd);

        var responseEntity = this.restTemplate.exchange(requestEntity, CustomerDetail.class);

        assertEquals("Rodrigo", responseEntity.getBody().name());
        assertEquals("Frederico Gonçalves", responseEntity.getBody().socialName());

    }
}
