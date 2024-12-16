package com.rodrigofreund.salesmanager.customer.naousar.controller.dto;

import jakarta.validation.constraints.NotNull;

public record CustomerUpdate(
        @NotNull
        Integer id,
        String name,
        String socialName,
        String socialNumber) {
    public boolean hasName() {
        return name != null;
    }
    public boolean hasSocialName() {
        return null != socialName;
    }
    public boolean hasSocialNumber() {
        return null != socialNumber;
    }
}
