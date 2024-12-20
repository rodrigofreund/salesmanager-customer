package com.rodrigofreund.salesmanager.customer.application.dto;

public record CustomerDetail(
    Integer id,
    String name,
    String socialName,
    String finantialNumber,
    String socialNumber) {
}
