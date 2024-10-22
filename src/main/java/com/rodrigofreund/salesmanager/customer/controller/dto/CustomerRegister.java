package com.rodrigofreund.salesmanager.customer.controller.dto;

import jakarta.validation.constraints.NotBlank;

//Used to create a new customer
public record CustomerRegister(
        @NotBlank
        String name,
        String socialName,
        @NotBlank
        String finantialNumber,
        String socialNumber) {

}
