package com.rodrigofreund.salesmanager.customer.application.dto;

import jakarta.validation.constraints.NotBlank;

//Used to update an already created customer
public record UpdateCustomerDto(
        @NotBlank(message = "{customer.id.mandatory}")
        Integer id,
        String name,
        String socialName,
        String finantialNumber,
        String socialNumber) {
}
