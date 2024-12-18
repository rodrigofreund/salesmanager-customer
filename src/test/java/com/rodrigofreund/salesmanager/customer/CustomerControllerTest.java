package com.rodrigofreund.salesmanager.customer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.rodrigofreund.salesmanager.customer.infra.controller.CreateCustomerDto;
import com.rodrigofreund.salesmanager.customer.infra.controller.CustomerDetail;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    /*
    

    @Test
    void getCustomerDetail() throws Exception {
        var code = this.restTemplate
                .getForEntity(
                        "/salesmanager-customer/1",
                        CustomerDetail.class).getStatusCode();
        assertTrue(code.is2xxSuccessful());
    }
    */
    
    @Test
    void getCustomerList() {
        var code = this.restTemplate.getForEntity("/customer", CustomerDetail.class).getStatusCode();
        assertTrue(code.is2xxSuccessful());
    }

    @Test
    void postCustomerRegister() throws Exception {

        CreateCustomerDto customerRegister =
            new CreateCustomerDto(
                "Rodrigo",
                "Rodrigo Moraes",
                "212214343523",
                "3423423423");

        var code = this.restTemplate.postForEntity(
                        "/customer",
                        customerRegister,
                        CustomerDetail.class).getStatusCode();

        assertTrue(code.is2xxSuccessful());
    }
    
    /*
    @Test
    void putCustomerUpdate() throws URISyntaxException {

        CustomerUpdate upd = new CustomerUpdate(1, null, "Frederico Gonçalves", null);

        RequestEntity<CustomerUpdate> requestEntity =
                RequestEntity.put(new URI("/salesmanager-customer")).accept(MediaType.APPLICATION_JSON).body(upd);

        var responseEntity = this.restTemplate.exchange(requestEntity, CustomerDetail.class);

        assertEquals("Rodrigo", responseEntity.getBody().name());
        assertEquals("Frederico Gonçalves", responseEntity.getBody().socialName());

    }
    */
}
