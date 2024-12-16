package com.rodrigofreund.salesmanager.customer.naousar.controller.dto;

import java.time.LocalDateTime;

public record OrderDetail(Integer id, LocalDateTime date, String customer) {

}
