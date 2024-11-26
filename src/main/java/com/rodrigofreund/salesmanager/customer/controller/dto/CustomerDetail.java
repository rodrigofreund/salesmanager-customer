package com.rodrigofreund.salesmanager.customer.controller.dto;

public record CustomerDetail(
    Integer id,
    String name,
    String socialName,
    String finantialNumber,
    String socialNumber) {
}
