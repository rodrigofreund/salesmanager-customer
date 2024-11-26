package com.rodrigofreund.salesmanager.customer.repository.model.order;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public record OrderRegister(
        @NotNull
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        LocalDateTime date,
        @NotNull
        Integer idCustomer) {
}
