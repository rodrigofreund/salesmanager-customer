package com.rodrigofreund.salesmanager.customer.naousar.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public record OrderUpdate(
        @NotNull
        Integer id,
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        LocalDateTime date) {
    public boolean hasDate() {
        return null != date;
    }
}
