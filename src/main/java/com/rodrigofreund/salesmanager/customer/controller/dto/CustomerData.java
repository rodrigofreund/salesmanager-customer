package com.rodrigofreund.salesmanager.customer.controller.dto;

public record CustomerData(
        Integer id,
        String name,
        String socialName,
        String financialNumber,
        String socialNumber
        ) { }
