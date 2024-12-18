package com.rodrigofreund.salesmanager.customer.infra.controller;

public record CustomerDetail(
    Integer id,
    String name,
    String socialName,
    String finantialNumber,
    String socialNumber) {
}
