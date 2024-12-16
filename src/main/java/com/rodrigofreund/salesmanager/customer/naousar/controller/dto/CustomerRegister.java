package com.rodrigofreund.salesmanager.customer.naousar.controller.dto;

import jakarta.validation.constraints.NotBlank;

//Used to create a new customer
public record CustomerRegister(
        @NotBlank(message = "{customer.name.mandatory}")
        String name,
        String socialName,
        @NotBlank(message = "{customer.finantialnumber.mandatory}")
        String finantialNumber,
        String socialNumber) {

}
