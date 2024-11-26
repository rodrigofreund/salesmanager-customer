package com.rodrigofreund.salesmanager.customer.controller.dto;

import java.time.LocalDateTime;

public record OrderDetail(Integer id, LocalDateTime date, String customer) {

}
