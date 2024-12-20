package com.rodrigofreund.salesmanager.customer.test.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rodrigofreund.salesmanager.customer.infra.controller.CustomerController;

@SpringBootTest
public class SmokeIntegrationTest {

    @Autowired
    private CustomerController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
